package com.zxcv.portal.web.site;

import cn.hutool.http.HttpUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.site.SiteNewsInfoService;
import com.zxcv.api.commom.service.site.dto.SiteNewsInfoDTO;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteNewsInfoReq;
import com.zxcv.api.commom.service.site.param.query.QuerySiteNewsInfoReq;
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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;


/**
 * 新闻表 前端控制器
 * Copyright: Copyright (c) ${year}
 * @ClassName: SiteNewsInfoController.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */
@Api(value = "新闻表管理", description = "新闻表管理")
@RestController
@RequestMapping("/siteNewsInfo")
public class SiteNewsInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(SiteNewsInfoController.class);

	@Autowired
	private SiteNewsInfoService siteNewsInfoService;


	@ApiOperation("新增新闻表")
	@PostMapping("/saveSiteNewsInfo")
	public BizResultVO<Integer> saveSiteNewsInfo(@RequestBody SaveAndModifySiteNewsInfoReq req) {
	    req.setCreateEmpId("1");
	    req.setCreateEmpName("");
        req.setCreateTime(new Date());
        logger.info("begin新增新闻表信息,入参={}", JSONObject.toJSON(req));
        String address;
        try {
            address = this.uploadNoticeToFastDFS(req.getNewsContent(),"txt");
            req.setContent(address);
        } catch (UnsupportedEncodingException e) {
            logger.error(JSONObject.toJSONString(e));
            throw new BizException(ErrorType.BIZ_ERROR,"文件上传失败："+JSONObject.toJSONString(e));

        }
        BizResult<Integer> result = siteNewsInfoService.saveSiteNewsInfo(req);
        logger.info("end新增新闻表信息,结果={}", JSONObject.toJSON(result));
		return new BizResultVO<Integer>(result);
	}

	@ApiOperation("修改新闻表")
	@PostMapping("/updateSiteNewsInfoById")
	public BizResultVO<Integer> updateSiteNewsInfoById(@RequestBody SaveAndModifySiteNewsInfoReq req) {
		req.setModifyEmpId("");
		req.setModifyEmpName("");
		req.setModifyTime(new Date());
		logger.info("begin修改新闻表信息,入参={}", JSONObject.toJSON(req));
        String address;
        try {
            address = this.uploadNoticeToFastDFS(req.getNewsContent(),"txt");
            req.setContent(address);
        } catch (UnsupportedEncodingException e) {
            logger.error(JSONObject.toJSONString(e));
            throw new BizException(ErrorType.BIZ_ERROR,"文件上传失败："+JSONObject.toJSONString(e));

        }
		BizResult<Integer> result = siteNewsInfoService.updateSiteNewsInfoById(req);
		logger.info("end修改新闻表信息,结果={}", JSONObject.toJSON(result));
		return new BizResultVO<Integer>(result);
	}

	@ApiOperation("删除新闻表")
	@PostMapping("/deleteSiteNewsInfo")
	public BizResultVO<Integer> deleteSiteNewsInfo(@RequestBody SaveAndModifySiteNewsInfoReq req) {
		req.setModifyEmpId("");
		req.setModifyEmpName("");
		req.setModifyTime(new Date());
		logger.info("begin删除新闻表controller,入参={}", JSONObject.toJSON(req));
		BizResult<Integer> result = siteNewsInfoService.deleteSiteNewsInfo(req);
		logger.info("end删除新闻表 controller,结果={}", JSONObject.toJSON(result));
		return new BizResultVO<Integer>(result);
	}

	@ApiOperation("查询新闻表对象")
	@PostMapping("/selectSiteNewsInfo")
	public BizResultVO<SiteNewsInfoDTO> selectSiteNewsInfo(@RequestBody QuerySiteNewsInfoReq req)
			throws UnsupportedEncodingException
	{
		logger.info("begin查询新闻表对象controller,入参={}", JSONObject.toJSON(req));
		BizResult<SiteNewsInfoDTO> result = siteNewsInfoService.selectSiteNewsInfo(req);
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

		return new BizResultVO<SiteNewsInfoDTO>(result);
	}

	@ApiOperation("分页-新闻表对象")
	@PostMapping("/querySiteNewsInfoForPage")
	public BizResultVO<PageBean<SiteNewsInfoDTO>> querySiteNewsInfoForPage(@RequestBody QuerySiteNewsInfoReq req) {
		logger.info("begin分页-查询新闻表controller,入参={}", JSONObject.toJSON(req));
		BizResult<PageBean<SiteNewsInfoDTO>> result = siteNewsInfoService.querySiteNewsInfoForPage(req);
		logger.info("end分页查询新闻表controller,结果...");
		return new BizResultVO<PageBean<SiteNewsInfoDTO>>(result);
	}


//	@ApiOperation("新增新闻表")
//	@PostMapping("/saveNewsInfo")
//	public BizResultVO<Integer> saveNewsInfo(@RequestBody SaveAndModifySiteNewsInfoReq req) {
//		req.setCreateTime(new Date());
//		logger.info("begin新增新闻表信息,入参={}", JSONObject.toJSON(req));
//		String address;
//		try {
//			address = this.uploadNoticeToFastDFS(req.getNewsContent());
//			req.setContent(address);
//		} catch (UnsupportedEncodingException e) {
//			logger.error(JSONObject.toJSONString(e));
//			throw new BizException(ErrorType.BIZ_ERROR,"文件上传失败："+JSONObject.toJSONString(e));
//
//		}
//		BizResult<Integer> result = siteNewsInfoService.saveSiteNewsInfo(req);
//		logger.info("end新增新闻表信息,结果={}", JSONObject.toJSON(result));
//		return new BizResultVO<Integer>(result);
//	}


}

