package com.zxcv.portal.web.site;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.SiteCompanyInfoService;
import com.zxcv.api.commom.service.site.dto.SiteCompanyInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteCompanyInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteCompanyInfoReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 分公司表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SiteCompanyInfoController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2020-04-04
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2020-04-04         zxcv         v1.0.0               创建
  */
@Api(value = "分公司表管理", description = "分公司表管理")
@RestController
@RequestMapping("/siteCompanyInfo")
public class SiteCompanyInfoController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SiteCompanyInfoController.class);

    @Autowired
    private SiteCompanyInfoService siteCompanyInfoService;


    @ApiOperation("新增分公司表")
    @PostMapping("/saveSiteCompanyInfo")
    public BizResultVO<Integer> saveSiteCompanyInfo(@RequestBody SaveAndModifySiteCompanyInfoReq req) {
        req.setCreateTime(new Date());
        req.setCreateEmpId(getLoginUserNo());
        req.setCreateEmpName(getLoginUserName());
        logger.info("begin新增分公司表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteCompanyInfoService.saveSiteCompanyInfo(req);
        logger.info("end新增分公司表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改分公司表")
    @PostMapping("/updateSiteCompanyInfoById")
    public BizResultVO<Integer> updateSiteCompanyInfoById(@RequestBody SaveAndModifySiteCompanyInfoReq req) {
        req.setModifyEmpId(getLoginUserNo());
        req.setModifyEmpName(getLoginUserName());
        req.setModifyTime(new Date());
        logger.info("begin修改分公司表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteCompanyInfoService.updateSiteCompanyInfoById(req);
        logger.info("end修改分公司表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除分公司表")
    @PostMapping("/deleteSiteCompanyInfo")
    public BizResultVO<Integer> deleteSiteCompanyInfo(@RequestBody SaveAndModifySiteCompanyInfoReq req) {
        req.setModifyEmpId(getLoginUserNo());
        req.setModifyEmpName(getLoginUserName());
        req.setModifyTime(new Date());
        logger.info("begin删除分公司表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteCompanyInfoService.deleteSiteCompanyInfo(req);
        logger.info("end删除分公司表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询分公司表对象")
    @PostMapping("/selectSiteCompanyInfo")
    public BizResultVO<SiteCompanyInfoDTO> selectSiteCompanyInfo(@RequestBody QuerySiteCompanyInfoReq req) {
        logger.info("begin查询分公司表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SiteCompanyInfoDTO> result = siteCompanyInfoService.selectSiteCompanyInfo(req);
        logger.info("end查询分公司表对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<SiteCompanyInfoDTO>(result);
    }

    @ApiOperation("分页-分公司表对象")
    @PostMapping("/querySiteCompanyInfoForPage")
    public BizResultVO<PageBean<SiteCompanyInfoDTO>> querySiteCompanyInfoForPage(@RequestBody QuerySiteCompanyInfoReq req) {
        logger.info("begin分页-查询分公司表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SiteCompanyInfoDTO>> result = siteCompanyInfoService.querySiteCompanyInfoForPage(req);
        logger.info("end分页查询分公司表controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<PageBean<SiteCompanyInfoDTO>>(result);
    }

}

