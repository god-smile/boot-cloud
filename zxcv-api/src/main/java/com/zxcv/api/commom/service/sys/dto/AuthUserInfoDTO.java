package com.zxcv.api.commom.service.sys.dto;

import com.zxcv.api.commom.bean.BaiscDTO;

import java.util.List;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: AuthUserInfoDTO.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-06-15 09:28
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-06-15     wangfs              v1.0.0               创建
 */
public class AuthUserInfoDTO  extends BaiscDTO {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

    private String avatar;

    private String introduction;

    private List<String> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
