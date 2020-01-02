package com.zxcv.portal.web.site;

import cn.hutool.http.HttpUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.site.SiteProductInfoService;
import com.zxcv.api.commom.service.site.dto.SiteProductInfoDTO;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteProductInfoReq;
import com.zxcv.api.commom.service.site.param.query.QuerySiteProductInfoReq;
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
@RequestMapping("/siteProductInfo")
public class SiteProductInfoController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SiteProductInfoController.class);

    @Autowired
    private SiteProductInfoService siteProductInfoService;

    @ApiOperation("新增用户产品表")
    @PostMapping("/saveSiteProductInfo")
    public BizResultVO<Integer> saveSiteProductInfo(@RequestBody SaveAndModifySiteProductInfoReq req) {
        req.setCreateTime(new Date());
        req.setCreateEmpId(getLoginUserNo());
        req.setCreateEmpName(getLoginUserName());
        logger.info("begin新增用户产品表信息,入参={}", JSONObject.toJSON(req));
        req.setUserNo("U10001");
        if(!StringUtils.isBlank(req.getContent())) {
            String address;
            try {
                address = this.uploadNoticeToFastDFS(req.getContent(),"txt");
                req.setContentUrl(address);
            } catch (UnsupportedEncodingException e) {
                logger.error(JSONObject.toJSONString(e));
                throw new BizException(ErrorType.BIZ_ERROR, "文件上传失败：" + JSONObject.toJSONString(e));

            }
        }
        BizResult<Integer> result = siteProductInfoService.saveSiteProductInfo(req);
        logger.info("end新增用户产品表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改用户产品表")
    @PostMapping("/updateSiteProductInfoById")
    public BizResultVO<Integer> updateSiteProductInfoById(@RequestBody SaveAndModifySiteProductInfoReq req) {
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

    @ApiOperation("删除用户产品表")
    @PostMapping("/deleteSiteProductInfo")
    public BizResultVO<Integer> deleteSiteProductInfo(@RequestBody SaveAndModifySiteProductInfoReq req) {
        req.setModifyEmpId(getLoginUserNo());
        req.setModifyEmpName(getLoginUserName());
        req.setModifyTime(new Date());
        logger.info("begin删除用户产品表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteProductInfoService.deleteSiteProductInfo(req);
        logger.info("end删除用户产品表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询用户产品表对象")
    @PostMapping("/selectSiteProductInfo")
    public BizResultVO<SiteProductInfoDTO> selectSiteProductInfo (@RequestBody QuerySiteProductInfoReq req)
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
        return new BizResultVO<SiteProductInfoDTO>(result);
    }

    @ApiOperation("分页-用户产品表对象")
    @PostMapping("/querySiteProductInfoForPage")
    public BizResultVO<PageBean<SiteProductInfoDTO>> querySiteProductInfoForPage(@RequestBody QuerySiteProductInfoReq req) {
        logger.info("begin分页-查询用户产品表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SiteProductInfoDTO>> result = siteProductInfoService.querySiteProductInfoForPage(req);
        logger.info("end分页查询用户产品表controller,结果...");
        return new BizResultVO<PageBean<SiteProductInfoDTO>>(result);
    }



}

