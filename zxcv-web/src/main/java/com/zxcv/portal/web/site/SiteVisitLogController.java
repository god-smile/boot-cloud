package com.zxcv.portal.web.site;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.site.SiteVisitLogService;
import com.zxcv.api.commom.service.site.dto.SiteVisitLogDTO;
import com.zxcv.api.commom.service.site.param.query.QuerySiteVisitLogReq;
import com.zxcv.api.commom.service.site.param.oper.SaveAndModifySiteVisitLogReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 访问记录日志表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SiteVisitLogController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2020-01-22
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2020-01-22         zxcv         v1.0.0               创建
  */
@Api(value = "访问记录日志表管理", description = "访问记录日志表管理")
@RestController
@RequestMapping("/siteVisitLog")
public class SiteVisitLogController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SiteVisitLogController.class);

    @Autowired
    private SiteVisitLogService siteVisitLogService;


    @ApiOperation("删除访问记录日志表")
    @PostMapping("/deleteSiteVisitLog")
    public BizResultVO<Integer> deleteSiteVisitLog(@RequestBody SaveAndModifySiteVisitLogReq req) {
        req.setModifyEmpId(getLoginUserNo());
        req.setModifyEmpName(getLoginUserName());
        req.setModifyTime(new Date());
        logger.info("begin删除访问记录日志表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = siteVisitLogService.deleteSiteVisitLog(req);
        logger.info("end删除访问记录日志表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询访问记录日志表对象")
    @PostMapping("/selectSiteVisitLog")
    public BizResultVO<SiteVisitLogDTO> selectSiteVisitLog(@RequestBody QuerySiteVisitLogReq req) {
        logger.info("begin查询访问记录日志表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SiteVisitLogDTO> result = siteVisitLogService.selectSiteVisitLog(req);
        logger.info("end查询访问记录日志表对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<SiteVisitLogDTO>(result);
    }

    @ApiOperation("分页-访问记录日志表对象")
    @PostMapping("/querySiteVisitLogForPage")
    public BizResultVO<PageBean<SiteVisitLogDTO>> querySiteVisitLogForPage(@RequestBody QuerySiteVisitLogReq req) {
        logger.info("begin分页-查询访问记录日志表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SiteVisitLogDTO>> result = siteVisitLogService.querySiteVisitLogForPage(req);
        logger.info("end分页查询访问记录日志表controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<PageBean<SiteVisitLogDTO>>(result);
    }

}

