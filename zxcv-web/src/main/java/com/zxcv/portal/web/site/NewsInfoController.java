package com.zxcv.portal.web.site;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import com.zxcv.api.commom.base.ErrorType;

import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.site.NewsInfoService;
import com.zxcv.api.commom.service.site.dto.NewsInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QueryNewsInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifyNewsInfoReq;
import com.zxcv.portal.common.vo.BizResultVO;
import com.zxcv.portal.utils.FastDFSClientWrapper;

import cn.hutool.http.HttpUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 新闻表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: NewsInfoController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2019-11-09
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2019-11-09         zxcv         v1.0.0               创建
  */
@Api(value = "新闻表管理", description = "新闻表管理")
@RestController
@RequestMapping("/newsInfo")
public class NewsInfoController extends BaseController {
 private static final Logger logger = LoggerFactory.getLogger(NewsInfoController.class);

    @Autowired
    private NewsInfoService newsInfoService;
    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;
    @Value("${fdfs.fdsurl}")
    private String fdsUrl;


    @ApiOperation("新增新闻表")
    @PostMapping("/saveNewsInfo")
    public BizResultVO<Integer> saveNewsInfo(@RequestBody SaveAndModifyNewsInfoReq req) {
        req.setCreateTime(new Date());
        logger.info("begin新增新闻表信息,入参={}", JSONObject.toJSON(req));
        String address;
		try {
			address = this.uploadNoticeToFastDFS(req.getNewsContent());
			req.setContent(address);
		} catch (UnsupportedEncodingException e) {
			logger.error(JSONObject.toJSONString(e));
			throw new BizException(ErrorType.BIZ_ERROR,"文件上传失败："+JSONObject.toJSONString(e));
			
		}
        BizResult<Integer> result = newsInfoService.saveNewsInfo(req);
        logger.info("end新增新闻表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    /**
     * 上传fastdfs富文本	文件
     * @param newsContent
     * @return
     * @throws UnsupportedEncodingException
     * 2019年11月10日 wangfei
     */
    private String uploadNoticeToFastDFS(String newsContent) throws UnsupportedEncodingException {
    	 newsContent = URLEncoder.encode(newsContent, "UTF-8");
         String address = fastDFSClientWrapper.uploadFile(newsContent, "txt");
         return fdsUrl +"/"+ address;
	}

	@ApiOperation("修改新闻表")
    @PostMapping("/updateNewsInfoById")
    public BizResultVO<Integer> updateNewsInfoById(@RequestBody SaveAndModifyNewsInfoReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin修改新闻表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = newsInfoService.updateNewsInfoById(req);
        logger.info("end修改新闻表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除新闻表")
    @PostMapping("/deleteNewsInfo")
    public BizResultVO<Integer> deleteNewsInfo(@RequestBody SaveAndModifyNewsInfoReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin删除新闻表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = newsInfoService.deleteNewsInfo(req);
        logger.info("end删除新闻表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询新闻表对象")
    @PostMapping("/selectNewsInfo")
    public BizResultVO<NewsInfoDTO> selectNewsInfo(@RequestBody QueryNewsInfoReq req) throws UnsupportedEncodingException {
        logger.info("begin查询新闻表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<NewsInfoDTO> result = newsInfoService.selectNewsInfo(req);
        logger.info("end查询新闻表对象controller,结果={}", JSONObject.toJSON(result));
        //加载文件信息
        if(result.getData() != null && !StringUtils.isBlank(result.getData().getContent())){
        	String content = HttpUtil.downloadString(result.getData().getContent(),"UTF-8");
            if(StringUtils.isNotEmpty(content)){
                logger.info("开始解析远程文本内容:"+result.getData().getContent());
                content = URLDecoder.decode(content,"UTF-8");
                result.getData().setContent(content);
            }
        }
        return new BizResultVO<NewsInfoDTO>(result);
    }

    @ApiOperation("分页-新闻表对象")
    @PostMapping("/queryNewsInfoForPage")
    public BizResultVO<PageBean<NewsInfoDTO>> queryNewsInfoForPage(@RequestBody QueryNewsInfoReq req) {
        logger.info("begin分页-查询新闻表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<NewsInfoDTO>> result = newsInfoService.queryNewsInfoForPage(req);
        logger.info("end分页查询新闻表controller,结果...");
        return new BizResultVO<PageBean<NewsInfoDTO>>(result);
    }
    
   

}

