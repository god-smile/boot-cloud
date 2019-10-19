package com.zxcv.portal.web.sys;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.sys.TsOpService;
import com.zxcv.api.commom.service.sys.dto.AuthUserInfo;
import com.zxcv.api.commom.service.sys.dto.TsOpDTO;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyTsOpReq;
import com.zxcv.api.commom.service.sys.param.query.QueryTsOpReq;
import com.zxcv.portal.common.BaseController;
import com.zxcv.portal.common.vo.BizResultVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
  * 操作员表(用户) 前端控制器
  * Copyright: Copyright (c) ${year}
  * @ClassName: TsOpController.java
  * @Description:
  * @version: v1.0.0
  * @author: wangfs
  * @date: 2019-06-04
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2019-06-04         wangfs         v1.0.0               创建
  */
@Api(value = "操作员表(用户)管理", description = "操作员表(用户)管理")
@RestController
@RequestMapping("/tsOp")
public class TsOpController extends BaseController {
 private static final Logger logger = LoggerFactory.getLogger(TsOpController.class);

    @Autowired
    private TsOpService tsOpService;


    @ApiOperation("新增操作员表(用户)")
    @PostMapping("/saveTsOp")
    public BizResultVO<Long> saveTsOp(@RequestBody SaveAndModifyTsOpReq req) {
        AuthUserInfo userInfo = this.getUserInfo();
        if(userInfo == null ){
        	throw new BizException(ErrorType.AUTH_TOKEN_NOT_EXISTS);
        }
        req.setCreateEmpId(userInfo.getId()+"");
        req.setCreateEmpName(userInfo.getOpName());
        logger.info("begin新增操作员表(用户)controller,入参={}", JSONObject.toJSON(req));
        BizResult<Long> result = tsOpService.saveTsOp(req);
        logger.info("end新增操作员表(用户) controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Long>(result);
    }

    @ApiOperation("修改操作员表(用户)")
    @PostMapping("/updateTsOpById")
    public BizResultVO<Integer> updateTsOpById(@RequestBody SaveAndModifyTsOpReq req) {
        AuthUserInfo userInfo = this.getUserInfo();
        if(userInfo == null || userInfo == null){
        	throw new BizException(ErrorType.AUTH_TOKEN_NOT_EXISTS);
        }
        req.setModifyEmpId(userInfo.getId()+"");
        req.setModifyEmpName(userInfo.getOpName());
        req.setModifyTime(new Date());
        logger.info("begin修改操作员表(用户)controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = tsOpService.updateTsOpById(req);
        logger.info("end修改操作员表(用户)controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("删除操作员表(用户)")
    @PostMapping("/deleteTsOp")
    public BizResultVO<Integer> deleteTsOp(@RequestBody SaveAndModifyTsOpReq req) {
        AuthUserInfo userInfo = this.getUserInfo();
        if(userInfo == null || userInfo == null){
        	throw new BizException(ErrorType.AUTH_TOKEN_NOT_EXISTS);
        }
        req.setModifyEmpId(userInfo.getId()+"");
        req.setModifyEmpName(userInfo.getOpName());
        req.setModifyTime(new Date());
        logger.info("begin删除操作员表(用户)controller,入参={}", JSONObject.toJSON(req));
        BizResult<Integer> result = tsOpService.deleteTsOp(req);
        logger.info("end删除操作员表(用户) controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<Integer>(result);
    }

    @ApiOperation("查询操作员表(用户)对象")
    @PostMapping("/selectTsOp")
    public BizResultVO<TsOpDTO> selectTsOp(@RequestBody QueryTsOpReq req) {
        logger.info("begin查询操作员表(用户)对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<TsOpDTO> result = tsOpService.selectTsOp(req);
        logger.info("end查询操作员表(用户)对象controller,结果={}", JSONObject.toJSON(result));
        return new BizResultVO<TsOpDTO>(result);
    }

    @ApiOperation("分页-操作员表(用户)对象")
    @PostMapping("/queryTsOpForPage")
    public BizResultVO<PageBean<TsOpDTO>> queryTsOpForPage(@RequestBody QueryTsOpReq req) {
        logger.info("begin分页-查询操作员表(用户)controller,入参={}", JSONObject.toJSON(req));
        BizResult<PageBean<TsOpDTO>> result = tsOpService.queryTsOpForPage(req);
        logger.info("end分页查询操作员表(用户)controller,结果...");
        return new BizResultVO<PageBean<TsOpDTO>>(result);
    }

     @ApiOperation("id校验组织是否已经被用户使用,使用则不容许删除")
     @PostMapping("/checkOrgIdIsUsed")
     public BizResultVO<Integer> checkOrgIdIsUsed(@RequestBody QueryTsOpReq  req) {
         logger.info("begin分页-查询操作员表(用户)controller,入参={}", JSONObject.toJSON(req));
         BizResult<Integer> result = tsOpService.checkOrgIdIsUsed(req);
         logger.info("end分页查询操作员表(用户)controller,结果={}", JSONObject.toJSON(result));
         return new BizResultVO<Integer>(result);
     }




}

