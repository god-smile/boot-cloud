package com.zxcv.portal.config.interceptor;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.base.Result;
import com.zxcv.api.commom.constants.SessionEnum;
import com.zxcv.commom.annotation.NoAuth;

/**
 * Copyright: Copyright (c) 2019  zteits
 *
 * @ClassName: com.wx.miniapp.config.interceptor
 * @Description:
 * @version: v1.0.0
 * @author: atao
 * @date: 2019-03-28   20:21
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2019-03-28      atao          v1.0.0          创建
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

    private static final String MIME_JSON = "application/json;charset=UTF-8";

    private static Set noAuthFilter = new HashSet<String>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("待鉴权URL={}#{}", request.getMethod(), request.getRequestURI());

        HttpSession session = request.getSession();
        System.out.println(request.getRequestURI());
        System.out.println("获取到的session=" + session.getId());
        //如果是options请求，放行
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
            log.info("==跨域options请求,放行");
            return true;
        }
        if (!isNeedAuth(handler)) {
            log.info("===不需要进行权限校验");
            return true;
        }else{
            Object object = session.getAttribute(SessionEnum.USER_INFO.key());
            if (null == object) {
                log.info("===权限校验,用户未登陆!");
                setErrorResult(response, ErrorType.AUTH_TOKEN_NOT_EXISTS);
                return false;
            }
        }


        return true;
    }

    /**
     * 返回错误结果
     *
     * @param response
     * @param errortype 错误类型
     * @throws Exception
     */
    private void setErrorResult(HttpServletResponse response, ErrorType errortype) throws Exception {
        log.info("===校验用户权限  校验失败: ErrorType:errorCode={},errMsg={}", errortype.getCode(), errortype.getMsg());
        PrintWriter writer = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", MIME_JSON);
        response.setContentType(MIME_JSON);
        Result bizResult = new Result<>(errortype);
        response.setStatus(HttpStatus.OK.value());
        writer.write(JSONObject.toJSON(bizResult).toString());
        writer.close();
    }

    /**
     * 判断此次请求是否需要进行鉴权
     *
     * @param handler
     * @return true 需要权限校验 false 不需要权限校验
     */
    private boolean isNeedAuth(Object handler) {
        log.info("==权限校验 判断是否需要进行权限校验");
        boolean authFlag = true;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            log.info("===访问的Controller 为{}，请求的方法为{}", handlerMethod.getBeanType().getName(), handlerMethod.getMethod().getName());
            String filterStr = handlerMethod.getBeanType().toString() + "#" + handlerMethod.getMethod().getName();
            log.info("===权限过滤字符串:{}", filterStr);
            //如果
            if (noAuthFilter.contains(filterStr)) {
                authFlag = false;
            } else {
                authFlag = !handlerMethod.hasMethodAnnotation(NoAuth.class);
            }
        }
        log.info("==权限校验 判断是否需要进行权限校验 flag={}", authFlag);
        return authFlag;
    }

}


