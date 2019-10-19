package com.zxcv.api.commom.service.sys.dto;

import com.zxcv.api.commom.bean.BaiscDTO;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: LoginOathRes.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-05-31 15:21
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-05-31     wangfs              v1.0.0               创建
 */
public class LoginOathRes  extends BaiscDTO {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 登陆用户id
     */
    private Long sysOpId;

    /**
     * 登陆账号.
     */
    private String loginCode;

    /**
     * 登陆用户token.
     */
    private String token;

    public Long getSysOpId() {
        return sysOpId;
    }

    public void setSysOpId(Long sysOpId) {
        this.sysOpId = sysOpId;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
