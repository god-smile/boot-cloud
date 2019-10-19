package com.zxcv.api.commom.service.sys.param.query;

import com.zxcv.api.commom.base.BaseReq;

/**
 * 操作员表(用户)查询类
 * Copyright: Copyright (c)
 * @ClassName: QueryTsOpReq.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-06-04
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-06-04         wangfs         v1.0.0               创建
 */

public class QueryTsOpReq extends  BaseReq {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */

    private Long id;

    /**
     * 操作员归属顶级组织
     */
    private Long orgId;

    /**
     * 登录工号
     */
    private String loginCode;

    /**
     * 登录密码
     */
    private String loginPassword;

    /**
     * 操作员code
     */
    private String opCode;

    /**
     * 操作员姓名
     */
    private String opName;

    /**
     * 性别：1男，2女，3保密
     */
    private Integer sex;

    /**
     * 登陆账户类型:1:超级管理员;2:普通用户
     */
    private Integer loginCodeType;

    /**
     * 数据状态：1有效，0无效,2:锁定
     */
    private Integer dataState;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

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

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getLoginCodeType() {
        return loginCodeType;
    }

    public void setLoginCodeType(Integer loginCodeType) {
        this.loginCodeType = loginCodeType;
    }


    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }


    @Override
    public String toString() {
        return "QueryTsOpReq{" +
        "id=" + id +
        ", orgId=" + orgId +
        ", loginCode=" + loginCode +
        ", loginPassword=" + loginPassword +
        ", opCode=" + opCode +
        ", opName=" + opName +
        ", sex=" + sex +
        ", loginCodeType=" + loginCodeType +
        ", dataState=" + dataState +
        "}";
    }
}
