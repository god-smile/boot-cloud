package com.zxcv.api.commom.exception;


import com.zxcv.api.commom.base.ErrorCode;
import com.zxcv.api.commom.base.ErrorType;

/**
 * 
 * 
 * Copyright: Copyright (c) 2017  zteits
 * 
 * @ClassName: BizException.java
 * @Description: 
 * @version: v1.0.0
 * @author: liuzl
 * @date: 2017年4月24日   下午4:54:54 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2017年4月24日      liuzl           v1.0.0               创建
 * 
 * 业务异常
 */
public class BizException extends AppException{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 无参构造函数
	 */
	public BizException() {
		super();
	}

	public BizException(ErrorType errorType) {
		super(errorType);
	}

	public BizException(ErrorType errorType, boolean printExceptionMsg) {
		super(errorType,printExceptionMsg);
	}
	
	public BizException(ErrorCode errorCode, String ... errMsg) {
		super(errorCode, errMsg);
	}
	/**
	 * 封装异常
	 * @param errorCode
	 * @param errMsg
	 * @param isTransfer 是否转换异常信息，如果为false,则直接使用errMsg信息
	 */
	public BizException(ErrorCode errorCode, String errMsg, Boolean isTransfer) {
		super(errorCode, errMsg,isTransfer);
	}

	public BizException(ErrorCode errorCode, String errMsg, Boolean isTransfer, boolean printExceptionMsg) {
		super(errorCode, errMsg,isTransfer,printExceptionMsg);
	}
	
	public BizException(ErrorType errorType, String ... errMsg) {
		super(errorType, errMsg);
	}
	
	public BizException(ErrorType errCode, Throwable cause, String ... errMsg) {
		super(errCode,cause, errMsg);
	}
	
}
