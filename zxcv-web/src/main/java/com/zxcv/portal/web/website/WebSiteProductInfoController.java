package com.zxcv.portal.web.website;

import cn.hutool.http.HttpUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.site.SiteProductInfoService;
import com.zxcv.api.commom.service.site.SiteVisitLogService;
import com.zxcv.api.commom.service.site.dto.SiteProductInfoDTO;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteProductInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteVisitLogReq;
import com.zxcv.api.commom.service.site.param.query.QuerySiteProductInfoReq;
import com.zxcv.commom.utils.IPUtil;
import com.zxcv.portal.common.BaseController;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

/**
 * 用户产品表 前端控制器
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteProductInfoController.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-21
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-21         zxcv         v1.0.0               创建
 */
@Api(value = "用户产品表管理", description = "用户产品表管理")
@RestController
@RequestMapping("/webSiteProductInfo")
public class WebSiteProductInfoController extends BaseController {
   private static final Logger logger = LoggerFactory.getLogger(WebSiteProductInfoController.class);

   @Autowired
   private SiteProductInfoService siteProductInfoService;
   @Autowired
   private SiteVisitLogService siteVisitLogService;

   // 点击量，备用
   @ApiOperation("修改用户产品表")
   @PostMapping("/updateWebSiteProductInfoById")
   public BizResultVO<Integer> updateWebSiteProductInfoById(@RequestBody SaveAndModifySiteProductInfoReq req) {
	   req.setModifyEmpId(getLoginUserNo());
	   req.setModifyEmpName(getLoginUserName());
	   req.setModifyTime(new Date());
	   logger.info("begin修改用户产品表信息,入参={}", JSONObject.toJSON(req));
	   if(!StringUtils.isBlank(req.getContent())){
		   String address;
		   try {
			   address = this.uploadNoticeToFastDFS(req.getContent(),"txt");
			   req.setContent(address);
		   } catch (UnsupportedEncodingException e) {
			   logger.error(JSONObject.toJSONString(e));
			   throw new BizException(ErrorType.BIZ_ERROR,"文件上传失败："+JSONObject.toJSONString(e));

		   }
	   }
	   BizResult<Integer> result = siteProductInfoService.updateSiteProductInfoById(req);
	   logger.info("end修改用户产品表信息,结果={}", JSONObject.toJSON(result));
	   return new BizResultVO<Integer>(result);
   }

   @ApiOperation("查询用户产品表对象")
   @PostMapping("/selectWebSiteProductInfo")
   public BizResultVO<SiteProductInfoDTO> selectWebSiteProductInfo (HttpServletRequest httpServletRequest
           , @RequestBody QuerySiteProductInfoReq req)
		   throws UnsupportedEncodingException{
	   logger.info("begin查询用户产品表对象controller,入参={}", JSONObject.toJSON(req));
	   BizResult<SiteProductInfoDTO> result = siteProductInfoService.selectSiteProductInfo(req);
	   //加载文件信息
	   if(result.getData() != null && !StringUtils.isBlank(result.getData().getContentUrl())){
		   String content = HttpUtil.downloadString(result.getData().getContentUrl(),"UTF-8");
		   if(StringUtils.isNotEmpty(content)){
			   logger.info("开始解析远程文本内容:"+result.getData().getContentUrl());
			   content = URLDecoder.decode(content,"UTF-8");
			   result.getData().setContent(content);
		   }
	   }
	   logger.info("end查询用户产品表对象controller,结果={}", JSONObject.toJSON(result));
       if(result.getData() != null && result.getData().getProductNo() != null){//保存访问日志
           SaveAndModifySiteVisitLogReq logRequest = new SaveAndModifySiteVisitLogReq();
           logRequest.setItemNo(result.getData().getProductNo());
           logRequest.setItemType(1);
           logRequest.setProjectNo(result.getData().getProjectNo());
           logRequest.setCreateEmpId(IPUtil.getRemoteIP(httpServletRequest));
           logRequest.setRequestIp(IPUtil.getRemoteIP(httpServletRequest));
           logRequest.setUserAgent(IPUtil.getRemoteUserAgent(httpServletRequest));
           siteVisitLogService.saveSiteVisitLog(logRequest);
       }

	   return new BizResultVO<SiteProductInfoDTO>(result);
   }

   @ApiOperation("分页-用户产品表对象")
   @PostMapping("/queryWebSiteProductInfoForPage")
   public BizResultVO<PageBean<SiteProductInfoDTO>> queryWebSiteProductInfoForPage(@RequestBody QuerySiteProductInfoReq req) {
	   logger.info("begin分页-查询用户产品表controller,入参={}", JSONObject.toJSON(req));
	   BizResult<PageBean<SiteProductInfoDTO>> result = siteProductInfoService.querySiteProductInfoForPage(req);
	   logger.info("end分页查询用户产品表controller,结果...");
	   return new BizResultVO<PageBean<SiteProductInfoDTO>>(result);
   }



}

