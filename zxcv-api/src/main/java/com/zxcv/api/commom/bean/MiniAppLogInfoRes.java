package com.zxcv.api.commom.bean;

import com.zxcv.api.commom.bean.BaiscDTO;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: MiniAppLogInfoRes.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-07-31 10:17
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-07-31     wangfs              v1.0.0               创建
 */
public class MiniAppLogInfoRes extends BaiscDTO {

    private static final long serialVersionUID=1L;

    /**token.*/
    private String token;

    /**sessionKey.*/
    private String sessionKey;

   /**是否已经注册:1:已经注册；0:未注册*/
    private  Integer isRegister;

    /**openId*/
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getIsRegister() {
        return isRegister;
    }

    public void setIsRegister(Integer isRegister) {
        this.isRegister = isRegister;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
