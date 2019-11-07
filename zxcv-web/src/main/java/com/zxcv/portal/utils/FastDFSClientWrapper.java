package com.zxcv.portal.utils;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.tobato.fastdfs.FdfsClientConfig;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * FastDFS文件上传下载包装类
 * Copyright: Copyright (c) 2017  zxcv
 *
 * @ClassName: FastDFSClientWrapper.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfei
 * @date: 2019年11月6日   下午3:28:32
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2019年11月6日      wangfei          v1.0.0          创建
 */
@Component
@Configuration
@Import(FdfsClientConfig.class)
// 解决jmx重复注册bean的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastDFSClientWrapper {
    private final Logger logger = LoggerFactory.getLogger(FastDFSClientWrapper.class);

    @Autowired
    private FastFileStorageClient storageClient;

    //@Autowired
    //private AppConfig appConfig;   // 项目参数配置

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
            FilenameUtils.getExtension(file.getOriginalFilename()), null);
        //return getResAccessUrl(storePath);
        return storePath.getFullPath();
    }

    public String uploadFile(InputStream inputStream, String fileName, long fileSize) {
        StorePath storePath = storageClient.uploadFile(inputStream, fileSize, fileName, null);
        return storePath.getFullPath();
    }

    /**
     * 将一段字符串生成一个文件上传
     *
     * @param content       文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream, buff.length, fileExtension, null);
        //return getResAccessUrl(storePath);
        return storePath.getFullPath();
    }

    public String uploadFile(HSSFWorkbook workbook, String fileName) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        byte[] content = byteArrayOutputStream.toByteArray();
        InputStream inputStream = new ByteArrayInputStream(content);
        StorePath storePath = storageClient.uploadFile(inputStream, content.length, fileName, null);
        return storePath.getFullPath();
    }

    //
    //// 封装图片完整URL地址
    //private String getResAccessUrl(StorePath storePath) {
    //    String fileUrl = AppConstants.HTTP_PRODOCOL + appConfig.getResHost()
    //        + ":" + appConfig.getFdfsStoragePort() + "/" + storePath.getFullPath();
    //    return fileUrl;
    //}

    /**
     * 删除文件
     *
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            logger.warn(e.getMessage());
        }
    }
}
