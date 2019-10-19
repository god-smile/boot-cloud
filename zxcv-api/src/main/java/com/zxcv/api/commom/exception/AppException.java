package com.zxcv.api.commom.exception;

import com.zxcv.api.commom.base.ErrorCode;
import com.zxcv.api.commom.base.ErrorType;


/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: AppException.java
 * @Description:
 * @version: v1.0.0
 * @author: liuzl
 * @date: 2017年4月24日   下午4:51:41
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2017年4月24日      liuzl           v1.0.0               创建
 *
 *
 * 应用级异常
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    /**
     * 错误编码
     */
    protected ErrorCode errCode;

    /**
     * 错误信息
     */
    protected String errMsg;

    /**
     * 是否需要打印异常信息
     */
    protected boolean printExceptionMsg = true;
    /**
     * 无参构造函数
     */
    public AppException() {
        super();
    }

    public AppException(ErrorCode errCode, String... errMsg) {
        super(errCode.getMsg());
        this.errCode = errCode;
        setErrMsg(errMsg,true);
    }

    public AppException(ErrorCode errCode, Boolean printExceptionMsg) {
        super(errCode.getMsg());
        this.errCode = errCode;
        this.printExceptionMsg = printExceptionMsg;
        setErrMsg(null,true);
    }

    public AppException setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }



    public AppException(ErrorCode errCode, String errMsg, Boolean isTransfer) {
        super(errMsg);
        this.errCode = errCode;
        setErrMsg(new String[]{errMsg},isTransfer);
    }

    public AppException(ErrorCode errCode, String errMsg, Boolean isTransfer,Boolean printExceptionMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.printExceptionMsg = printExceptionMsg;
        setErrMsg(new String[]{errMsg},isTransfer);
    }
    
    public AppException(Throwable cause) {
        super(cause);
        this.errCode = ErrorType.SYSTEM_ERROR;
        this.errMsg = cause.getMessage();
    }

    /**
     * 构造函数
     *
     * @param cause 异常
     */
    public AppException(ErrorCode errCode, Throwable cause, String... errMsg) {
        super(errCode.getCode() + errCode.getMsg(), cause);
        this.errCode = errCode;
        setErrMsg(errMsg,true);
    }
    public boolean isPrintExceptionMsg() {
        return printExceptionMsg;
    }

    public AppException setPrintExceptionMsg(boolean printExceptionMsg) {
        this.printExceptionMsg = printExceptionMsg;
        return this;
    }
    public ErrorCode getErrCode() {
        return errCode;
    }

    public void setErrCode(ErrorCode errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String[] errMsg,Boolean isTransfer) {

        if (null != errMsg &&errMsg.length>0) {
        	if(errCode.getMsg().contains("%s") && isTransfer){
//        		this.errMsg = String.format(errCode.getMsg(), errMsg);
        		this.errMsg = String.format(errCode.getMsg());
        	}else{
        		StringBuffer sf = new StringBuffer();
        		for (String msg : errMsg) {
					sf.append(msg);
				}
        		this.errMsg = sf.toString();
        	}
        }else{
        	this.errMsg = errCode.getMsg();
        }

    }

    public static void main(String[] args) {
        String str = "ERRCode:1004--对象不存在:[%s]";
        if (str.contains("%s")){
         System.out.println("包含");
        }
    }

}
