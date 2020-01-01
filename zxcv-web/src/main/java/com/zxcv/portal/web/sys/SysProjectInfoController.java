package com.zxcv.portal.web.sys;

import java.util.Date;
import java.util.List;

import com.zxcv.api.commom.service.sys.param.query.ProjectReq;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.SysProjectInfoService;
import com.zxcv.api.commom.service.sys.dto.SysProjectInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysProjectInfoReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysProjectInfoReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 项目表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SysProjectInfoController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2019-12-08
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2019-12-08         zxcv         v1.0.0               创建
  */
@Api(value = "项目表管理", description = "项目表管理")
@RestController
@RequestMapping("/sysProjectInfo")
public class SysProjectInfoController extends BaseController {
 private static final Logger logger = LoggerFactory.getLogger(SysProjectInfoController.class);

    @Autowired
    private SysProjectInfoService sysProjectInfoService;


    @ApiOperation("新增项目表")
    @PostMapping("/saveSysProjectInfo")
    public BizResultVO<Integer> saveSysProjectInfo(@RequestBody SaveAndModifySysProjectInfoReq req) {
        req.setCreateTime(new Date());
        logger.info("begin新增项目表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysProjectInfoService.saveSysProjectInfo(req);
        logger.info("end新增项目表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改项目表")
    @PostMapping("/updateSysProjectInfoById")
    public BizResultVO<Integer> updateSysProjectInfoById(@RequestBody SaveAndModifySysProjectInfoReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin修改项目表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysProjectInfoService.updateSysProjectInfoById(req);
        logger.info("end修改项目表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除项目表")
    @PostMapping("/deleteSysProjectInfo")
    public BizResultVO<Integer> deleteSysProjectInfo(@RequestBody SaveAndModifySysProjectInfoReq req) {
        req.setModifyEmpId("");
        req.setModifyEmpName("");
        req.setModifyTime(new Date());
        logger.info("begin删除项目表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysProjectInfoService.deleteSysProjectInfo(req);
        logger.info("end删除项目表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询项目表对象")
    @PostMapping("/selectSysProjectInfo")
    public BizResultVO<SysProjectInfoDTO> selectSysProjectInfo(@RequestBody QuerySysProjectInfoReq req) {
        logger.info("begin查询项目表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SysProjectInfoDTO> result = sysProjectInfoService.selectSysProjectInfo(req);
        logger.info("end查询项目表对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<SysProjectInfoDTO>(result);
    }

    @ApiOperation("分页-项目表对象")
    @PostMapping("/querySysProjectInfoForPage")
    public BizResultVO<PageBean<SysProjectInfoDTO>> querySysProjectInfoForPage(@RequestBody QuerySysProjectInfoReq req) {
        logger.info("begin分页-查询项目表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SysProjectInfoDTO>> result = sysProjectInfoService.querySysProjectInfoForPage(req);
        logger.info("end分页查询项目表controller,结果...");
        return new BizResultVO<PageBean<SysProjectInfoDTO>>(result);
    }

     @ApiOperation("根据用户编号查询用户下的项目")
     @PostMapping("/getSysProjectInfoByUserNo")
     public BizResultVO<List<SysProjectInfoDTO>> getSysProjectInfoByUserNo(@RequestBody ProjectReq req) {
         logger.info("begin-根据用户编号查询用户下的项目,入参={}", JSONObject.toJSON(req));
         BizResult<List<SysProjectInfoDTO>> result = sysProjectInfoService.getSysProjectInfoByUserNo(req);
         logger.info("end根据用户编号查询用户下的项目controller,结果={}", JSONObject.toJSON(result));
         return new BizResultVO<List<SysProjectInfoDTO>>(result);
     }
}

