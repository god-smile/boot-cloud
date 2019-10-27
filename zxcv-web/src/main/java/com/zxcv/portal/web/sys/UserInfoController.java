package com.zxcv.portal.web.sys;

import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.bean.PageBean;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.sys.UserInfoService;
import com.zxcv.api.commom.service.sys.UserInfoService;
import com.zxcv.api.commom.service.sys.dto.AuthUserInfo;
import com.zxcv.api.commom.service.sys.dto.UserInfoDTO;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifyUserInfoReq;
import com.zxcv.api.commom.service.sys.param.query.QueryUserInfoReq;
import com.zxcv.portal.common.BaseController;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 操作员表(用户) 前端控制器
 * Copyright: Copyright (c) ${year}
 * @ClassName: UserInfoController.java
 * @Description:
 * @version: v1.0.0
 * @author: lh
 * @date: 2019-10-14
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-10-14         lh         v1.0.0               创建
 */
@Api(value = "操作员表(用户)管理", description = "操作员表(用户)管理")
@RestController
@RequestMapping("/user")
public class UserInfoController extends BaseController {
private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

   @Autowired
   private UserInfoService userInfoService;


   @ApiOperation("新增操作员表(用户)")
   @PostMapping("/saveUserInfo")
   public BizResultVO<Long> saveUserInfo(@RequestBody SaveAndModifyUserInfoReq req) {
	   AuthUserInfo userInfo = this.getUserInfo();
	   if(userInfo == null ){
		   throw new BizException(ErrorType.AUTH_TOKEN_NOT_EXISTS);
	   }
	   //req.setCreateEmpId(userInfo.getId()+"");
	   //req.setCreateEmpName(userInfo.getOpName());
	   logger.info("begin新增操作员表(用户)controller,入参={}", JSONObject.toJSON(req));
	   BizResult<Long> result = userInfoService.saveUserInfo(req);
	   logger.info("end新增操作员表(用户) controller,结果={}", JSONObject.toJSON(result));
	   return new BizResultVO<Long>(result);
   }

   @ApiOperation("修改操作员表(用户)")
   @PostMapping("/updateUserInfoById")
   public BizResultVO<Integer> updateUserInfoById(@RequestBody SaveAndModifyUserInfoReq req) {
	   AuthUserInfo userInfo = this.getUserInfo();
	   if(userInfo == null || userInfo == null){
		   throw new BizException(ErrorType.AUTH_TOKEN_NOT_EXISTS);
	   }
	   //req.setModifyEmpId(userInfo.getId()+"");
	   //req.setModifyEmpName(userInfo.getOpName());
	   req.setModifyTime(new Date());
	   logger.info("begin修改操作员表(用户)controller,入参={}", JSONObject.toJSON(req));
	   BizResult<Integer> result = userInfoService.updateUserInfoById(req);
	   logger.info("end修改操作员表(用户)controller,结果={}", JSONObject.toJSON(result));
	   return new BizResultVO<Integer>(result);
   }

   @ApiOperation("删除操作员表(用户)")
   @PostMapping("/deleteUserInfo")
   public BizResultVO<Integer> deleteUserInfo(@RequestBody SaveAndModifyUserInfoReq req) {
	   AuthUserInfo userInfo = this.getUserInfo();
	   if(userInfo == null || userInfo == null){
		   throw new BizException(ErrorType.AUTH_TOKEN_NOT_EXISTS);
	   }
	   //req.setModifyEmpId(userInfo.getId()+"");
	   //req.setModifyEmpName(userInfo.getOpName());
	   req.setModifyTime(new Date());
	   logger.info("begin删除操作员表(用户)controller,入参={}", JSONObject.toJSON(req));
	   BizResult<Integer> result = userInfoService.deleteUserInfo(req);
	   logger.info("end删除操作员表(用户) controller,结果={}", JSONObject.toJSON(result));
	   return new BizResultVO<Integer>(result);
   }

   @ApiOperation("查询操作员表(用户)对象")
   @PostMapping("/selectUserInfo")
   public BizResultVO<UserInfoDTO> selectUserInfo(@RequestBody QueryUserInfoReq req) {
	   logger.info("begin查询操作员表(用户)对象controller,入参={}", JSONObject.toJSON(req));
	   BizResult<UserInfoDTO> result = userInfoService.selectUserInfo(req);
	   logger.info("end查询操作员表(用户)对象controller,结果={}", JSONObject.toJSON(result));
	   return new BizResultVO<UserInfoDTO>(result);
   }

   @ApiOperation("分页-操作员表(用户)对象")
   @PostMapping("/queryUserInfoForPage")
   // @GetMapping("/queryUserInfoForPage")
   public BizResultVO<PageBean<UserInfoDTO>> queryUserInfoForPage(@RequestBody QueryUserInfoReq req) {
	   logger.info("begin分页-查询操作员表(用户)controller,入参={}", JSONObject.toJSON(req));
	   BizResult<PageBean<UserInfoDTO>> result = userInfoService.queryUserInfoForPage(req);
	   logger.info("end分页查询操作员表(用户)controller,结果...");
	   return new BizResultVO<PageBean<UserInfoDTO>>(result);
   }

	/*@ApiOperation("id校验组织是否已经被用户使用,使用则不容许删除")
	@PostMapping("/checkOrgIdIsUsed")
	public BizResultVO<Integer> checkOrgIdIsUsed(@RequestBody QueryUserInfoReq  req) {
		logger.info("begin分页-查询操作员表(用户)controller,入参={}", JSONObject.toJSON(req));
		BizResult<Integer> result = userInfoService.checkOrgIdIsUsed(req);
		logger.info("end分页查询操作员表(用户)controller,结果={}", JSONObject.toJSON(result));
		return new BizResultVO<Integer>(result);
	}*/
}

