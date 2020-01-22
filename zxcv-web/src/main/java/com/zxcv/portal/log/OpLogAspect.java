package com.zxcv.portal.log;

import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.api.commom.constants.SessionEnum;
import com.zxcv.api.commom.service.sys.SysOpLogService;
import com.zxcv.api.commom.service.sys.dto.SysUserInfoDTO;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysOpLogReq;
import com.zxcv.api.commom.service.sys.param.oper.SaveAndModifySysUserInfoReq;
import com.zxcv.api.commom.service.sys.param.query.QuerySysUserInfoReq;
import com.zxcv.commom.annotation.SysOpLog;
import com.zxcv.commom.utils.IPUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Copyright: Copyright (c) 2019
 *
 * ClassName: 操作日志切面
 * Description:
 * version: v1.0.0
 * author: wangfei
 * date: 2020-01-22   15:22
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2020-01-22      wangfei          v1.0.0          创建
 */
@Aspect
@Configuration
public class OpLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(OpLogAspect.class);

    @Autowired
    SysOpLogService sysOpLogService;

    @Pointcut("@annotation(com.zxcv.commom.annotation.SysOpLog)")
    public void sysLog() {
    }

    @Around(value = "sysLog()")
    public Object arround(ProceedingJoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        SysOpLog sysLog = method.getAnnotation(SysOpLog.class);
        SaveAndModifySysOpLogReq sysOpLogRequest = new SaveAndModifySysOpLogReq();
        SysUserInfoDTO userInfo = (SysUserInfoDTO) request.getSession().getAttribute(SessionEnum.USER_INFO.key());
        if(null != userInfo){
            sysOpLogRequest.setOpCode(userInfo.getUserNo());
            sysOpLogRequest.setOpName(userInfo.getUserName());
            sysOpLogRequest.setCreateEmpId(userInfo.getUserNo());
        	sysOpLogRequest.setCreateEmpName(userInfo.getUserName());
        }else{
            if(joinPoint.getArgs() != null && joinPoint.getArgs()[0] != null){
                if("0".equals(sysLog.isOp())){//登录
                    String str = JSONObject.toJSONString(joinPoint.getArgs()[0]);
                    SaveAndModifySysUserInfoReq req = JSONObject.parseObject(str,SaveAndModifySysUserInfoReq.class);
                    sysOpLogRequest.setOpCode(req.getUserName());
                    sysOpLogRequest.setOpName(req.getPassword());
                }

            }
            
            sysOpLogRequest.setCreateEmpId("-1");
            sysOpLogRequest.setCreateEmpName("系统");
        }

        sysOpLogRequest.setMethodDesc(sysLog.value());
        sysOpLogRequest.setLogType(Integer.valueOf(sysLog.isOp()));//0：登录日志 1：操作日志
        sysOpLogRequest.setMethod(joinPoint.getSignature().getName());
        sysOpLogRequest.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        sysOpLogRequest.setRequestIp(IPUtil.getRemoteIP(request));
        if(joinPoint.getArgs() != null && joinPoint.getArgs()[0] != null){
            sysOpLogRequest.setRequestArgs(JSONObject.toJSON(joinPoint.getArgs()[0])+"");
        }

        try {
            Object o = joinPoint.proceed();
            sysOpLogRequest.setResponseType(0);
            sysOpLogRequest.setResponseBody(JSONObject.toJSON(o)+"");
            logger.info("方法执行结果是 :" + o);
            return o;
        } catch (Throwable e) {
            logger.error("方法返回异常："+e.toString(),e);
            sysOpLogRequest.setResponseType(1);
            sysOpLogRequest.setResponseBody(e.toString());
            throw new RuntimeException(e);

        } finally {
            BizResult<Integer> result = sysOpLogService.saveSysOpLog(sysOpLogRequest);
//            logger.info("保存操作日志result：{}",JSONObject.toJSONString(request));
        }
    }
}
