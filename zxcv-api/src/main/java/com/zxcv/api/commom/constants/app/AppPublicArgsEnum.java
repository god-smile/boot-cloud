package com.zxcv.api.commom.constants.app;

/**
 * 
 * Copyright: Copyright (c) 2017  ZTE-ITS
 * 
 * @ClassName: IRainResultEnum.java
 * @Description: 
 * @version: v1.0.0
 * @author: wangbiao
 * @date: 2017年4月20日   下午2:30:53 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2017年4月20日      wangbiao           v1.0.0               创建
 */
public enum AppPublicArgsEnum {
	/**平台分配的app_id*/
	APP_ID("app_id"),
	/**随机数生成的盐值*/
	APP_SALT("salt"),
	/**设备唯一编号*/
	APP_DEVICENO("deviceInfo"),
	/**设备类型*/
	APP_DEVICETYPE("deivceType"),
	/**签名的摘要算法，可选值为：hmac，md5*/
	APP_SIGN_TYPE("sign_type"),
	/**签名*/
	APP_SIGN("sign"),
	/**手机号*/
	APP_PHONE("phone"),
	/**系统生成的token*/
	APP_TOKEN("token"),
	/**返回编码*/
	APP_RETURN_CODE("code"),
	/**返回信息*/
	APP_RETURN_MESSAGE("message"),
	/**验证码*/
	APP_RETURN_VERIFICODE("verificode");
	
	
    private String code;

    public String getCode() {
		return code;
	}

	private AppPublicArgsEnum(String code) {
        this.code = code;
    }
   
}
