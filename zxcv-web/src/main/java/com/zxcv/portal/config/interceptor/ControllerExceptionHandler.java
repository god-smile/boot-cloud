package com.zxcv.portal.config.interceptor;


import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import com.alibaba.fastjson.JSONObject;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.exception.AppException;
import com.zxcv.api.commom.exception.BizException;
import com.zxcv.commom.annotation.NoAuth;
import com.zxcv.commom.utils.BeanValidatorsUtils;
import com.zxcv.portal.common.vo.BizResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.fastjson.JSON;


/**
 * 通用错误处理器
 *
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: ControllerExceptionHandler.java
 * @Description:
 * @version: v1.0.0
 * @author: zhaowg
 * @date: 2017年5月8日   上午11:50:23
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2017年5月8日      zhaowg              v1.0.0               创建
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ControllerExceptionHandler extends AbstractErrorController {

    public ControllerExceptionHandler(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @Value("${server.error.path:${error.path:/error}}")
    private String errorPath = "/error";

    /**
     * 500错误.
     *
     * @param rsp
     * @param ex
     * @return
     * @throws Exception
     */
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @NoAuth
    public ResponseEntity<BizResultVO<?>> serverError(HttpServletRequest req, HttpServletResponse rsp, Exception ex) throws Exception {
        String uuid = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        log.error("\n############################   "+uuid+"，请求地址：{}，500错误	    #############################",req.getRequestURI());
        BizResultVO<?> BizResult = null;
        if(ex instanceof AppException) {
            AppException bizException = (AppException)ex;
            BizResult = new BizResultVO<>(bizException.getErrCode(),bizException.getErrMsg());
            log.error("\n############################   "+uuid+"，后场返回的错误信息为：         #############################\n"+bizException.getErrMsg());
        }else if(ex instanceof ConstraintViolationException){
            List<String> errMsgs = BeanValidatorsUtils.extractPropertyAndMessageAsList((ConstraintViolationException)ex, ": ");
            BizResult  = new BizResultVO<>(ErrorType.PARAM_NOT_VALID, JSON.toJSONString(errMsgs));
        }else if(ex instanceof RpcException){
            BizResult = new BizResultVO<>(ErrorType.SYSTEM_UPDATING);
            log.error("\n############################   "+uuid+"，前台报错堆栈信息为：         #############################",ex);
        }else{
            BizResult = new BizResultVO<>(ErrorType.SYSTEM_ERROR,ex);
            log.error("\n############################   "+uuid+"，前台报错堆栈信息为：         #############################",ex);
        }

        log.info("封装后的错误信息：\n"+ JSONObject.toJSON(BizResult));
        return new ResponseEntity<>(BizResult, HttpStatus.OK);
    }

    /**
     * 404的拦截.
     *
     * @param request
     * @param response
     * @param ex
     * @return
     * @throws Exception
     */
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    @NoAuth
    public ResponseEntity<?> notFound(HttpServletRequest request, HttpServletResponse response, Exception ex)
            throws Exception {
        log.error("请求地址：{}，404错误", request.getRequestURI());
        BizResultVO<?> BizResult = new BizResultVO<>(ErrorType.RESOURCE_NOT_EXISTS);
        log.info("封装后的错误信息：\n"+JSONObject.toJSON(BizResult));
        return new ResponseEntity<>(BizResult, HttpStatus.OK);
    }

    /**
     * 400 参数不完整错误.
     *
     * @param req
     * @param rsp
     * @param ex
     * @return
     * @throws Exception
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @NoAuth
    public ResponseEntity<?> methodArgumentNotValidException(HttpServletRequest req, HttpServletResponse rsp,
                                                             MethodArgumentNotValidException ex) throws Exception {
        log.error("请求地址：{}，400错误：", req.getRequestURI(),ex);

        BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        StringBuffer msg = new StringBuffer();
        msg.append("[");
        fieldErrors.stream().forEach(fieldError -> {
            msg.append(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        });
        msg.append("]");

        BizResultVO<?> BizResult = new BizResultVO<>(ErrorType.PARAM_NOT_VALID, msg.toString());
        log.info("封装后的错误信息：\n"+JSONObject.toJSON(BizResult));
        return new ResponseEntity<>(BizResult, HttpStatus.OK);
    }

    @RequestMapping
    @ResponseBody
    @NoAuth
    public ResponseEntity<?> handleErrors(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpStatus status = getStatus(request);
        if (status == HttpStatus.NOT_FOUND) {
            return notFound(request, response, new BizException(ErrorType.RESOURCE_NOT_EXISTS));
        }

        if (status == HttpStatus.BAD_REQUEST){
            return  new ResponseEntity<BizResultVO>( new BizResultVO<>(ErrorType.PARAM_NOT_VALID, "参数异常"),
                    HttpStatus.OK);
        }

        if (status == HttpStatus.INTERNAL_SERVER_ERROR){
            return serverError(request, response, new BizException(ErrorType.APP_ERROR));
        }


        return new ResponseEntity<BizResultVO>( new BizResultVO<>(ErrorType.APP_ERROR, "系统异常"),
                HttpStatus.OK);
    }

    @RequestMapping(produces = "text/html")
    @NoAuth
    public ModelAndView handleHtml(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }

    @Override
    @NoAuth
    public String getErrorPath() {
        return errorPath;
    }
}