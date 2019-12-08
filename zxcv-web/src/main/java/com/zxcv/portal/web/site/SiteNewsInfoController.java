package com.zxcv.portal.web.site;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.SiteNewsInfoService;
import com.zxcv.api.commom.service.site.dto.SiteNewsInfoDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteNewsInfoReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteNewsInfoReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
        req.setCreateTime(new Date());
        logger.info("begin新增新闻表信息,入参={}", JSONObject.toJSON(req));
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
    public BizResultVO<SiteNewsInfoDTO> selectSiteNewsInfo(@RequestBody QuerySiteNewsInfoReq req) {
        logger.info("begin查询新闻表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SiteNewsInfoDTO> result = siteNewsInfoService.selectSiteNewsInfo(req);
        logger.info("end查询新闻表对象controller,结果={}", JSONObject.toJSON(result));
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

}

