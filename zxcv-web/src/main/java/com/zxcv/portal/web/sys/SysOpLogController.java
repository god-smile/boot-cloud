package com.zxcv.portal.web.sys;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.SysOpLogService;
import com.zxcv.api.commom.service.sys.dto.SysOpLogDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysOpLogReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysOpLogReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 登录/操作日志表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SysOpLogController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2020-01-22
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2020-01-22         zxcv         v1.0.0               创建
  */
@Api(value = "登录/操作日志表管理", description = "登录/操作日志表管理")
@RestController
@RequestMapping("/sysOpLog")
public class SysOpLogController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SysOpLogController.class);

    @Autowired
    private SysOpLogService sysOpLogService;


    @ApiOperation("新增登录/操作日志表")
    @PostMapping("/saveSysOpLog")
    public BizResultVO<Integer> saveSysOpLog(@RequestBody SaveAndModifySysOpLogReq req) {
        req.setCreateTime(new Date());
        req.setCreateEmpId(getLoginUserNo());
        req.setCreateEmpName(getLoginUserName());
        logger.info("begin新增登录/操作日志表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysOpLogService.saveSysOpLog(req);
        logger.info("end新增登录/操作日志表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }


    @ApiOperation("分页-登录/操作日志表对象")
    @PostMapping("/querySysOpLogForPage")
    public BizResultVO<PageBean<SysOpLogDTO>> querySysOpLogForPage(@RequestBody QuerySysOpLogReq req) {
        logger.info("begin分页-查询登录/操作日志表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SysOpLogDTO>> result = sysOpLogService.querySysOpLogForPage(req);
        logger.info("end分页查询登录/操作日志表controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<PageBean<SysOpLogDTO>>(result);
    }

}

