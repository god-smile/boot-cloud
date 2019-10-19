package com.zxcv.api.commom.bean;


import com.zxcv.api.commom.base.ErrorType;

/**
 * 统一返回结果集
 * 
 * Copyright: Copyright (c) 2017  zteits
 * 
 * @ClassName: BizResult.java
 * @Description: 
 * @version: v1.0.0
 * @author: liuzl
 * @date: 2017年4月24日   下午6:17:24 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2017年4月24日      liuzl           v1.0.0               创建
 */
public class BizResult<T> extends ResultBean<ErrorType, T>{

	private static final long serialVersionUID = 1L;
	
	public BizResult() {
		super();
	}

	public BizResult(ErrorType errCode, String errMsg) {
		super(errCode, errMsg);
	}

	public BizResult(T data) {
		super(data);
		this.errCode=ErrorType.BIZ_SUCCESS;
		this.errMsg = ErrorType.BIZ_SUCCESS.getMsg();
		
	}

	public BizResult(ErrorType errType, String errMsg, T data) {
		super(errType, errMsg, data);
	}
	
	public void setErrorInfo(ErrorType errType, String errMsg){
		this.errCode = errType;
		this.errMsg = errMsg;
		if(null != errType && errType.getCode().equals(ErrorType.BIZ_SUCCESS.getCode())){
            this.success = true;
        }else{
            this.success = false;
        }

	}
	
}
