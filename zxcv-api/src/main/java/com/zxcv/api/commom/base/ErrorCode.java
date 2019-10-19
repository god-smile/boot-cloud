package com.zxcv.api.commom.base;

import java.io.Serializable;

/**
 * 错误编码公共接口
 * 
 * Copyright: Copyright (c) 2017  zteits
 * 
 * @ClassName: ErrorCode.java
 * @Description: 
 * @version: v1.0.0
 * @author: liuzl
 * @date: 2017年4月24日   下午6:30:43 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2017年4月24日      liuzl           v1.0.0               创建
 */
public interface ErrorCode extends Serializable{
	/**
	 * 错误码
	 * @return
	 */
	String getCode();
	/**
	 * 错误信息
	 * @return
	 */
	String getMsg();

    /**
     * 获取成功默认信息
     * @return
     */
	default  ErrorCode getDefaultSuccessInfo(){
	    return new ErrorCode() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public String getCode() {
                return "8888";
            }

            @Override
            public String getMsg() {
                return "成功";
            }
        };
    };
}
