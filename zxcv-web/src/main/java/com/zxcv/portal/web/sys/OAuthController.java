package com.zxcv.portal.web.sys;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.constants.SessionEnum;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.api.commom.service.sys.TsOpService;
import com.zxcv.api.commom.service.sys.dto.AuthUserInfo;
import com.zxcv.api.commom.service.sys.dto.AuthUserInfoRes;
import com.zxcv.api.commom.service.sys.dto.LoginOathRes;
import com.zxcv.api.commom.service.sys.dto.TsOpDTO;
import com.zxcv.api.commom.service.sys.param.query.LoginOauthReq;
import com.zxcv.api.commom.service.sys.param.query.QueryTsOpReq;
import com.zxcv.commom.annotation.NoAuth;
import com.zxcv.commom.annotation.SysLog;
import com.zxcv.commom.utils.MD5Utils;
import com.zxcv.portal.common.BaseController;
import com.zxcv.portal.common.vo.BizResultVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: OAuthController.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-05-31 15:16
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-05-31     wangfs              v1.0.0               创建
 */
@Api(value = "登录授权", description = "登录授权")
@RestController
@RequestMapping("/oAuth")
@NoAuth
public class OAuthController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(OAuthController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TsOpService tsOpService;



    @ApiOperation("用户登录")
    @SysLog(value = "zxcv-web",desc = "用户登录")
    @PostMapping("/login")
    public BizResultVO<LoginOathRes> login(@RequestBody LoginOauthReq req) {
        logger.info("begin校验用户登录信息...入参={}", JSONObject.toJSON(req));
        BizResult<LoginOathRes> oathResult = new BizResult<LoginOathRes>();
        LoginOathRes LoginOathRes = new LoginOathRes();
        QueryTsOpReq queryTsOpReq = new QueryTsOpReq();
        queryTsOpReq.setLoginCode(req.getLoginCode());
        queryTsOpReq.setLoginPassword(MD5Utils.enMD5(req.getLoginPassword()));
        //查询数据
        BizResult<TsOpDTO> bizResult = tsOpService.selectTsOp(queryTsOpReq);
        if (null == bizResult || bizResult.getData() == null || bizResult.getData().getId() == null) {
            logger.info("账号密码不匹配");
            oathResult.setErrorInfo(ErrorType.AUTH_PASS_ERROR, "账号密码不匹配");
        } else {
            TsOpDTO tsOpDTO = bizResult.getData();
            if (new Date().getTime() >= tsOpDTO.getAcctEndDate().getTime()) {
                logger.info("登陆账号已失效");
                oathResult.setErrorInfo(ErrorType.AUTH_LOGIN_ENDTIME, "登陆账号已失效");
            } else {
                LoginOathRes.setSysOpId(tsOpDTO.getId());
                LoginOathRes.setLoginCode(tsOpDTO.getLoginCode());
                String token = request.getSession().getId();
                LoginOathRes.setToken(token);
                request.getSession().setAttribute(SessionEnum.LOGIN_USER_TOKEN.key(), LoginOathRes);
                oathResult.setErrorInfo(ErrorType.BIZ_SUCCESS, "登陆成功");
                oathResult.setData(LoginOathRes);
            }
        }

        logger.info("end校验用户登录信息...入参={}", JSONObject.toJSON(oathResult));
        return new BizResultVO<LoginOathRes>(oathResult);
    }


    @ApiOperation("获取登陆用户信息")
    @PostMapping("/getUserInfo")
    public BizResultVO<AuthUserInfoRes> getSysOpInfo(@RequestParam("token") String token) {
        logger.info("begin获取用信息(getUserInfo...)...token={}", token);
        BizResult<AuthUserInfoRes> result = new BizResult<AuthUserInfoRes>();
        AuthUserInfoRes authUserInfoRes = new AuthUserInfoRes();
        AuthUserInfo authUserInfo = new AuthUserInfo();
        LoginOathRes loginOath = getLoginOath();
        if (null == loginOath) {
            throw new BizException(ErrorType.PARAMM_NULL, "登陆人session信息为空!");
        }
        /************************************1.根据登陆id 获取用户信息*********************************/
        QueryTsOpReq req = new QueryTsOpReq();
        req.setId(loginOath.getSysOpId());
        BizResult<TsOpDTO> tsOpBizResult = tsOpService.selectTsOp(req);
        logger.info("getUserInfo()...通过用户id=【{}】获取用户信息为={}", loginOath.getSysOpId(), tsOpBizResult);
        if (null == tsOpBizResult || null == tsOpBizResult.getData() || null == tsOpBizResult.getData().getId()) {
            throw new BizException(ErrorType.PARAMM_NULL, "获取用户信息失败!");
        }
        TsOpDTO tsOpDTO = tsOpBizResult.getData();

        if (null != tsOpDTO) {
            BeanUtils.copyProperties(tsOpDTO,authUserInfo);
            authUserInfoRes.setAuthUserInfo(authUserInfo);
        }
        /************************************2.获取菜单*********************************/
        /**存入缓存.*/
        request.getSession().setAttribute(SessionEnum.USER_INFO.key(), authUserInfoRes);
        result.setErrCode(ErrorType.BIZ_SUCCESS);
        result.setErrMsg("getUsr成功");
        result.setData(authUserInfoRes);
        logger.info("end校验用户登录信息...");
        return new BizResultVO<AuthUserInfoRes>(result);
    }


    @SysLog(value = "zxcv-web",desc = "用户登出")
    @ApiOperation("获取登陆用户信息")
    @PostMapping("/logout")
    public BizResultVO<AuthUserInfoRes> logout() {
        BizResult<AuthUserInfoRes> result = new BizResult<AuthUserInfoRes>();
        request.getSession().removeAttribute(SessionEnum.LOGIN_USER_TOKEN.key());
        request.getSession().removeAttribute(SessionEnum.USER_INFO.key());
        result.setErrorInfo(ErrorType.BIZ_SUCCESS, "清理成功");
        return new BizResultVO<AuthUserInfoRes>(result);
    }









}
