package com.zxcv.api.commom.service.sys.dto;

import com.zxcv.api.commom.bean.BaiscDTO;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: AuthResInfo.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-06-14 17:20
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-06-14     wangfs              v1.0.0               创建
 */
public class AuthResInfo extends BaiscDTO {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 主键
     */

    private Long id;
    /**
     * 资源编号
     */
    private String resCode;

    /**
     * 资源类型 1:目录，2：菜单,3:按钮,
     */
    private Integer resType;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResType() {
        return resType;
    }

    public void setResType(Integer resType) {
        this.resType = resType;
    }
}
