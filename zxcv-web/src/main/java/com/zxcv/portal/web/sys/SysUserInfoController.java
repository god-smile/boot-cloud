package com.zxcv.portal.web.sys;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.SysUserInfoService;
import com.zxcv.api.commom.service.sys.dto.SysUserInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysUserInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysUserInfoReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 用户表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SysUserInfoController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2019-12-08
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2019-12-08         zxcv         v1.0.0               创建
  */
@Api(value = "用户表管理", description = "用户表管理")
@RestController
@RequestMapping("/sysUserInfo")
public class SysUserInfoController extends BaseController {
 private static final Logger logger = LoggerFactory.getLogger(SysUserInfoController.class);

    @Autowired
    private SysUserInfoService sysUserInfoService;


    @ApiOperation("新增用户表")
    @PostMapping("/saveSysUserInfo")
    public BizResultVO<Integer> saveSysUserInfo(@RequestBody SaveAndModifySysUserInfoReq req) {
        req.setCreateTime(new Date());
        logger.info("begin新增用户表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysUserInfoService.saveSysUserInfo(req);
        logger.info("end新增用户表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改用户表")
    @PostMapping("/updateSysUserInfoById")
    public BizResultVO<Integer> updateSysUserInfoById(@RequestBody SaveAndModifySysUserInfoReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin修改用户表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysUserInfoService.updateSysUserInfoById(req);
        logger.info("end修改用户表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除用户表")
    @PostMapping("/deleteSysUserInfo")
    public BizResultVO<Integer> deleteSysUserInfo(@RequestBody SaveAndModifySysUserInfoReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin删除用户表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysUserInfoService.deleteSysUserInfo(req);
        logger.info("end删除用户表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询用户表对象")
    @PostMapping("/selectSysUserInfo")
    public BizResultVO<SysUserInfoDTO> selectSysUserInfo(@RequestBody QuerySysUserInfoReq req) {
        logger.info("begin查询用户表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SysUserInfoDTO> result = sysUserInfoService.selectSysUserInfo(req);
        logger.info("end查询用户表对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<SysUserInfoDTO>(result);
    }

    @ApiOperation("分页-用户表对象")
    @PostMapping("/querySysUserInfoForPage")
    public BizResultVO<PageBean<SysUserInfoDTO>> querySysUserInfoForPage(@RequestBody QuerySysUserInfoReq req) {
        logger.info("begin分页-查询用户表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SysUserInfoDTO>> result = sysUserInfoService.querySysUserInfoForPage(req);
        logger.info("end分页查询用户表controller,结果...");
        return new BizResultVO<PageBean<SysUserInfoDTO>>(result);
    }

}

