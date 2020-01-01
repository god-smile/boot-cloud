package com.zxcv.portal.web.sys;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.portal.common.BaseController;
import com.zxcv.portal.common.vo.BizResultVO;
import com.zxcv.portal.utils.FastDFSClientWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Copyright: Copyright (c) 2019
 *
 * ClassName: 公共接口
 * Description:
 * version: v1.0.0
 * author: wangfei
 * date: 2019-12-21   17:40:32
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2019-12-21      wangfei          v1.0.0          创建
 */
@Api(value = "公共接口", description = "公共接口")
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController {
private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;
    @Value("${fdfs.fdsurl}")
    private String fdsUrl;


    @ApiOperation("上传图片")
    @PostMapping("/uploadPicture")
    @ResponseBody
    public BizResultVO<String> uploadPicture(
            @RequestParam(required = false, name = "pictureFile") MultipartFile pictureFile) throws IOException {
        if(null == (pictureFile)){
            throw  new BizException(ErrorType.PARAMM_NULL,"图片文件");
        }
        String result = "";
        try {
            String url = fastDFSClientWrapper.uploadFile(pictureFile);
            result = fdsUrl +"/"+ url;
        } catch (Exception e) {
            logger.info(JSONObject.toJSONString(e));
            throw new BizException(ErrorType.BIZ_ERROR,"上传图片失败！");
        }

        logger.info("上传图片返回地址：",result);
        return new BizResultVO<>(new BizResult<>(result));
    }

    @ApiOperation("批量上传图片")
    @PostMapping("/uploadPictures")
    @ResponseBody
    public BizResultVO<List<String>> uploadPictures(
            @RequestParam(required = false, name = "pictureFiles") List<MultipartFile> pictureFiles) throws IOException {
        List<String> results = new ArrayList<>();
        if(CollectionUtils.isEmpty(pictureFiles)){
            throw  new BizException(ErrorType.PARAMM_NULL,"图片文件");
        }
        for(MultipartFile pictureFile: pictureFiles) {
            String result = "";
            if (pictureFile != null) {
                try {
                    String url = fastDFSClientWrapper.uploadFile(pictureFile);
                    result = fdsUrl +"/"+ url;
                } catch (Exception e) {
                    logger.info(JSONObject.toJSONString(e));
                    throw new BizException(ErrorType.BIZ_ERROR,"上传图片失败！");
                }

            }
            results.add(result);
            logger.info("上传图片返回地址：",result);
        }

        return new BizResultVO<>(new BizResult<>(results));
    }


    public static void main(String[] args) {
        System.out.println(1);
    }
}

