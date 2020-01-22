package com.zxcv.portal.web.sys;

import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.constants.SessionEnum;
import com.zxcv.api.commom.service.sys.SysUserInfoService;
import com.zxcv.api.commom.service.sys.dto.SysUserInfoDTO;
import com.zxcv.api.commom.service.sys.param.query.QuerySysUserInfoReq;
import com.zxcv.commom.annotation.SysOpLog;
import com.zxcv.portal.common.BaseController;
import com.zxcv.portal.common.vo.BizResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * Copyright: Copyright (c) 2019
 *
 * ClassName: SysAuthController
 * Description:
 * version: v1.0.0
 * author: wangfei
 * date: 2020-01-02   10:02:27
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2020-01-02      wangfei          v1.0.0          创建
 */
@Api(value = "用户登录登出", description = "用户登录登出")
@RestController
@RequestMapping("/sysAuth")
public class SysAuthController extends BaseController {
 private static final Logger logger = LoggerFactory.getLogger(SysAuthController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysUserInfoService sysUserInfoService;


    @SysOpLog(value = "用户登录",isOp = "0")
    @ApiOperation("用户登录")
    @PostMapping("/userLogin")
    public BizResultVO<SysUserInfoDTO> userLogin(@RequestBody QuerySysUserInfoReq req) {
        logger.info("begin查询用户表对象controller,入参={}", JSONObject.toJSON(req));
        BizResult<SysUserInfoDTO> result = sysUserInfoService.userLogin(req);
        logger.info("end查询用户表对象controller,结果={}", JSONObject.toJSON(result));
        if(!result.isSuccess()){
            return new BizResultVO<SysUserInfoDTO>(result);
        }
        String token = request.getSession().getId();
        logger.info("用户登录，生成token={}", token);
        request.getSession().setAttribute(SessionEnum.LOGIN_USER_TOKEN.key(), token);
        request.getSession().setAttribute(SessionEnum.USER_INFO.key(), result.getData());
        result.getData().setToken(token);
        return new BizResultVO<SysUserInfoDTO>(result);
    }


    @ApiOperation("用户退出登录")
    @PostMapping("/logout")
    public BizResultVO<SysUserInfoDTO> logout() {
        BizResult<SysUserInfoDTO> result = new BizResult<SysUserInfoDTO>();

        request.getSession().removeAttribute(SessionEnum.USER_INFO.key());
        request.getSession().removeAttribute(SessionEnum.LOGIN_USER_TOKEN.key());

        result.setErrorInfo(ErrorType.BIZ_SUCCESS, "注销成功");
        return new BizResultVO<SysUserInfoDTO>(result);
    }

    @ApiOperation("获取当前登录人信息")
    @PostMapping("/getUserLoginInfo")
    public BizResultVO<SysUserInfoDTO> getUserLoginInfo() {
        logger.info("begin获取当前登录人信息------------------");
        SysUserInfoDTO result = getLoginUserInfo();
        logger.info("end获取当前登录人信息------------------返回：{}",JSONObject.toJSON(result));
        return new BizResultVO<SysUserInfoDTO>(new BizResult<>(result));
    }
}

