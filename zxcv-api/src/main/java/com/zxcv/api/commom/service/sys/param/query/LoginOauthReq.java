package com.zxcv.api.commom.service.sys.param.query;

import com.zxcv.api.commom.base.BaseReq;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: LoginOauthReq.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-05-31 15:18
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-05-31     wangfs              v1.0.0               创建
 */
public class LoginOauthReq  extends BaseReq {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  String loginCode;

    private String loginPassword;

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
