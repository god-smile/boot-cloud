package com.zxcv.portal.web.site;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.SiteConfigService;
import com.zxcv.api.commom.service.site.dto.SiteConfigDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteConfigReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteConfigReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 用户配置表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SiteConfigController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2020-04-04
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2020-04-04         zxcv         v1.0.0               创建
  */
@Api(value = "用户配置表管理", description = "用户配置表管理")
@RestController
@RequestMapping("/siteConfig")
public class SiteConfigController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SiteConfigController.class);

    @Autowired
    private SiteConfigService siteConfigService;


    @ApiOperation("新增用户配置表")
    @PostMapping("/saveSiteConfig")
    public BizResultVO<Integer> saveSiteConfig(@RequestBody SaveAndModifySiteConfigReq req) {
        req.setCreateTime(new Date());
        req.setCreateEmpId(getLoginUserNo());
        req.setCreateEmpName(getLoginUserName());
        logger.info("begin新增用户配置表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteConfigService.saveSiteConfig(req);
        logger.info("end新增用户配置表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改用户配置表")
    @PostMapping("/updateSiteConfigById")
    public BizResultVO<Integer> updateSiteConfigById(@RequestBody SaveAndModifySiteConfigReq req) {
        req.setModifyEmpId(getLoginUserNo());
        req.setModifyEmpName(getLoginUserName());
        req.setModifyTime(new Date());
        logger.info("begin修改用户配置表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteConfigService.updateSiteConfigById(req);
        logger.info("end修改用户配置表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除用户配置表")
    @PostMapping("/deleteSiteConfig")
    public BizResultVO<Integer> deleteSiteConfig(@RequestBody SaveAndModifySiteConfigReq req) {
        req.setModifyEmpId(getLoginUserNo());
        req.setModifyEmpName(getLoginUserName());
        req.setModifyTime(new Date());
        logger.info("begin删除用户配置表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteConfigService.deleteSiteConfig(req);
        logger.info("end删除用户配置表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询用户配置表对象")
    @PostMapping("/selectSiteConfig")
    public BizResultVO<SiteConfigDTO> selectSiteConfig(@RequestBody QuerySiteConfigReq req) {
        logger.info("begin查询用户配置表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SiteConfigDTO> result = siteConfigService.selectSiteConfig(req);
        logger.info("end查询用户配置表对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<SiteConfigDTO>(result);
    }

    @ApiOperation("分页-用户配置表对象")
    @PostMapping("/querySiteConfigForPage")
    public BizResultVO<PageBean<SiteConfigDTO>> querySiteConfigForPage(@RequestBody QuerySiteConfigReq req) {
        logger.info("begin分页-查询用户配置表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SiteConfigDTO>> result = siteConfigService.querySiteConfigForPage(req);
        logger.info("end分页查询用户配置表controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<PageBean<SiteConfigDTO>>(result);
    }

}

