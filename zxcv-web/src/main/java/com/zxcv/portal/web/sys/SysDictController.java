package com.zxcv.portal.web.sys;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.zxcv.portal.common.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.service.sys.SysDictService;
import com.zxcv.api.commom.service.sys.dto.SysDictDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysDictReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysDictReq;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


 /**
  * 系统字典表 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: SysDictController.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2020-04-04
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2020-04-04         zxcv         v1.0.0               创建
  */
@Api(value = "系统字典表管理", description = "系统字典表管理")
@RestController
@RequestMapping("/sysDict")
public class SysDictController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SysDictController.class);

    @Autowired
    private SysDictService sysDictService;


    @ApiOperation("新增系统字典表")
    @PostMapping("/saveSysDict")
    public BizResultVO<Integer> saveSysDict(@RequestBody SaveAndModifySysDictReq req) {
        req.setCreateTime(new Date());
        req.setCreateEmpId(getLoginUserNo());
        req.setCreateEmpName(getLoginUserName());
        logger.info("begin新增系统字典表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysDictService.saveSysDict(req);
        logger.info("end新增系统字典表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("修改系统字典表")
    @PostMapping("/updateSysDictById")
    public BizResultVO<Integer> updateSysDictById(@RequestBody SaveAndModifySysDictReq req) {
        req.setModifyEmpId(getLoginUserNo());
        req.setModifyEmpName(getLoginUserName());
        req.setModifyTime(new Date());
        logger.info("begin修改系统字典表信息,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysDictService.updateSysDictById(req);
        logger.info("end修改系统字典表信息,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除系统字典表")
    @PostMapping("/deleteSysDict")
    public BizResultVO<Integer> deleteSysDict(@RequestBody SaveAndModifySysDictReq req) {
        req.setModifyEmpId(getLoginUserNo());
        req.setModifyEmpName(getLoginUserName());
        req.setModifyTime(new Date());
        logger.info("begin删除系统字典表controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = sysDictService.deleteSysDict(req);
        logger.info("end删除系统字典表 controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询系统字典表对象")
    @PostMapping("/selectSysDict")
    public BizResultVO<SysDictDTO> selectSysDict(@RequestBody QuerySysDictReq req) {
        logger.info("begin查询系统字典表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SysDictDTO> result = sysDictService.selectSysDict(req);
        logger.info("end查询系统字典表对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<SysDictDTO>(result);
    }

    @ApiOperation("分页-系统字典表对象")
    @PostMapping("/querySysDictForPage")
    public BizResultVO<PageBean<SysDictDTO>> querySysDictForPage(@RequestBody QuerySysDictReq req) {
        logger.info("begin分页-查询系统字典表controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<SysDictDTO>> result = sysDictService.querySysDictForPage(req);
        logger.info("end分页查询系统字典表controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<PageBean<SysDictDTO>>(result);
    }

}

