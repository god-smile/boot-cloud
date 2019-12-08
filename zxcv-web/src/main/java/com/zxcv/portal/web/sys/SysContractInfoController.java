package com.zxcv.portal.web.sys;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.SysContractInfoService;
import com.zxcv.api.commom.service.sys.dto.SysContractInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysContractInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysContractInfoReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 用户合同信息表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SysContractInfoController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2019-12-08
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2019-12-08         zxcv         v1.0.0               创建
  */
@Api(value = "用户合同信息表管理", description = "用户合同信息表管理")
@RestController
@RequestMapping("/sysContractInfo")
public class SysContractInfoController extends BaseController {
 private static final Logger logger = LoggerFactory.getLogger(SysContractInfoController.class);

    @Autowired
    private SysContractInfoService sysContractInfoService;


    @ApiOperation("新增用户合同信息表")
    @PostMapping("/saveSysContractInfo")
    public BizResultVO<Integer> saveSysContractInfo(@RequestBody SaveAndModifySysContractInfoReq req) {
        req.setCreateTime(new Date());
        logger.info("begin新增用户合同信息表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysContractInfoService.saveSysContractInfo(req);
        logger.info("end新增用户合同信息表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改用户合同信息表")
    @PostMapping("/updateSysContractInfoById")
    public BizResultVO<Integer> updateSysContractInfoById(@RequestBody SaveAndModifySysContractInfoReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin修改用户合同信息表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysContractInfoService.updateSysContractInfoById(req);
        logger.info("end修改用户合同信息表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除用户合同信息表")
    @PostMapping("/deleteSysContractInfo")
    public BizResultVO<Integer> deleteSysContractInfo(@RequestBody SaveAndModifySysContractInfoReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin删除用户合同信息表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysContractInfoService.deleteSysContractInfo(req);
        logger.info("end删除用户合同信息表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询用户合同信息表对象")
    @PostMapping("/selectSysContractInfo")
    public BizResultVO<SysContractInfoDTO> selectSysContractInfo(@RequestBody QuerySysContractInfoReq req) {
        logger.info("begin查询用户合同信息表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SysContractInfoDTO> result = sysContractInfoService.selectSysContractInfo(req);
        logger.info("end查询用户合同信息表对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<SysContractInfoDTO>(result);
    }

    @ApiOperation("分页-用户合同信息表对象")
    @PostMapping("/querySysContractInfoForPage")
    public BizResultVO<PageBean<SysContractInfoDTO>> querySysContractInfoForPage(@RequestBody QuerySysContractInfoReq req) {
        logger.info("begin分页-查询用户合同信息表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SysContractInfoDTO>> result = sysContractInfoService.querySysContractInfoForPage(req);
        logger.info("end分页查询用户合同信息表controller,结果...");
        return new BizResultVO<PageBean<SysContractInfoDTO>>(result);
    }

}

