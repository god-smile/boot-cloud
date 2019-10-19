package com.zxcv.api.commom.service.sys.dto;

import java.util.List;

import com.zxcv.api.commom.bean.BaiscDTO;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: AuthUserInfoRes.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-05-31 19:59
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-05-31     wangfs              v1.0.0               创建
 */
public class AuthUserInfoRes  extends BaiscDTO {



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**用户信息.*/
    private  AuthUserInfo authUserInfo;

    /**资源.*/
    private List<AuthResInfo>  resList;

    /**停车场编码.*/
    private List<String> plNos;

    public List<AuthResInfo> getResList() {
        return resList;
    }

    public void setResList(List<AuthResInfo> resList) {
        this.resList = resList;
    }

    public List<String> getPlNos() {
        return plNos;
    }

    public void setPlNos(List<String> plNos) {
        this.plNos = plNos;
    }

    public AuthUserInfo getAuthUserInfo() {
        return authUserInfo;
    }

    public void setAuthUserInfo(AuthUserInfo authUserInfo) {
        this.authUserInfo = authUserInfo;
    }
}