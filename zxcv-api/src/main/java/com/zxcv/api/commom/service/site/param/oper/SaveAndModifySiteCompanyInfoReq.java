package com.zxcv.api.commom.service.site.param.oper;

import java.util.Date;
import com.zxcv.api.commom.base.BaseReq;

 /**
  * 分公司表查询类
  * Copyright: Copyright (c) ${year}
  * @ClassName: SaveAndModifySiteCompanyInfoReq.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2020-04-04
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2020-04-04         zxcv         v1.0.0               创建
  */

public class SaveAndModifySiteCompanyInfoReq extends  BaseReq {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */

    private Long id;

    /**
     * 分公司编号
     */
    private String companyNo;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 分公司名称
     */
    private String name;

    /**
     * 分公司地址
     */
    private String address;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 座机
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 排序等级
     */
    private Integer orderLevel;

    /**
     * 数据状态：1有效，0无效
     */
    private Integer dataState;

    /**
     * 描述
     */
    private String remark;

    /**
     * 创建人
     */
    private String createEmpId;

    /**
     * 创建人名称
     */
    private String createEmpName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String modifyEmpId;

    /**
     * 修改人名称
     */
    private String modifyEmpName;

    /**
     * 修改时间
     */
    private Date modifyTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(Integer orderLevel) {
        this.orderLevel = orderLevel;
    }

    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateEmpId() {
        return createEmpId;
    }

    public void setCreateEmpId(String createEmpId) {
        this.createEmpId = createEmpId;
    }

    public String getCreateEmpName() {
        return createEmpName;
    }

    public void setCreateEmpName(String createEmpName) {
        this.createEmpName = createEmpName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyEmpId() {
        return modifyEmpId;
    }

    public void setModifyEmpId(String modifyEmpId) {
        this.modifyEmpId = modifyEmpId;
    }

    public String getModifyEmpName() {
        return modifyEmpName;
    }

    public void setModifyEmpName(String modifyEmpName) {
        this.modifyEmpName = modifyEmpName;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

	
    @Override
    public String toString() {
        return "SaveAndModifySiteCompanyInfoReq{" +
        "id=" + id +
        ", companyNo=" + companyNo +
        ", projectNo=" + projectNo +
        ", name=" + name +
        ", address=" + address +
        ", mobile=" + mobile +
        ", phone=" + phone +
        ", fax=" + fax +
        ", email=" + email +
        ", postcode=" + postcode +
        ", orderLevel=" + orderLevel +
        ", dataState=" + dataState +
        ", remark=" + remark +
        ", createEmpId=" + createEmpId +
        ", createEmpName=" + createEmpName +
        ", createTime=" + createTime +
        ", modifyEmpId=" + modifyEmpId +
        ", modifyEmpName=" + modifyEmpName +
        ", modifyTime=" + modifyTime +
        "}";
    }

}
