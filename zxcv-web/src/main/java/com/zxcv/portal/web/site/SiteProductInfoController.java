package com.zxcv.portal.web.site;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.SiteProductInfoService;
import com.zxcv.api.commom.service.site.dto.SiteProductInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteProductInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteProductInfoReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 产品表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SiteProductInfoController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2019-12-08
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2019-12-08         zxcv         v1.0.0               创建
  */
@Api(value = "产品表管理", description = "产品表管理")
@RestController
@RequestMapping("/siteProductInfo")
public class SiteProductInfoController extends BaseController {
 private static final Logger logger = LoggerFactory.getLogger(SiteProductInfoController.class);

    @Autowired
    private SiteProductInfoService siteProductInfoService;


    @ApiOperation("新增产品表")
    @PostMapping("/saveSiteProductInfo")
    public BizResultVO<Integer> saveSiteProductInfo(@RequestBody SaveAndModifySiteProductInfoReq req) {
        req.setCreateTime(new Date());
        logger.info("begin新增产品表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteProductInfoService.saveSiteProductInfo(req);
        logger.info("end新增产品表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改产品表")
    @PostMapping("/updateSiteProductInfoById")
    public BizResultVO<Integer> updateSiteProductInfoById(@RequestBody SaveAndModifySiteProductInfoReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin修改产品表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteProductInfoService.updateSiteProductInfoById(req);
        logger.info("end修改产品表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除产品表")
    @PostMapping("/deleteSiteProductInfo")
    public BizResultVO<Integer> deleteSiteProductInfo(@RequestBody SaveAndModifySiteProductInfoReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin删除产品表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteProductInfoService.deleteSiteProductInfo(req);
        logger.info("end删除产品表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询产品表对象")
    @PostMapping("/selectSiteProductInfo")
    public BizResultVO<SiteProductInfoDTO> selectSiteProductInfo(@RequestBody QuerySiteProductInfoReq req) {
        logger.info("begin查询产品表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SiteProductInfoDTO> result = siteProductInfoService.selectSiteProductInfo(req);
        logger.info("end查询产品表对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<SiteProductInfoDTO>(result);
    }

    @ApiOperation("分页-产品表对象")
    @PostMapping("/querySiteProductInfoForPage")
    public BizResultVO<PageBean<SiteProductInfoDTO>> querySiteProductInfoForPage(@RequestBody QuerySiteProductInfoReq req) {
        logger.info("begin分页-查询产品表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SiteProductInfoDTO>> result = siteProductInfoService.querySiteProductInfoForPage(req);
        logger.info("end分页查询产品表controller,结果...");
        return new BizResultVO<PageBean<SiteProductInfoDTO>>(result);
    }

}

