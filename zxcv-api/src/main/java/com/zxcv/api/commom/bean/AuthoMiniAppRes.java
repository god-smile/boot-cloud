package com.zxcv.api.commom.bean;

import java.util.Date;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: AuthoMiniAppRes.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-08-01 09:15
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-08-01     wangfs              v1.0.0               创建
 */
public class AuthoMiniAppRes extends BaiscDTO {

    private static final long serialVersionUID=1L;


    /**
     * 客户id
     */
    private String custId;

    /**
     * 用户手机号码
     */
    private String userPhone;

    /**
     * 小程序用户openId
     */
    private String openId;

    /**
     * 昵称
     */
    private String custNickname;

    /**
     * 性别 1:男，2:女,3:未知
     */
    private Integer sex;

    /**
     * 头像地址
     */
    private String headPicUrl;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 服务点对应二级组织ID
     */
    private Long orgId;

    /**
     * 组织名称
     */
    private String orgName;

    /**
     * 是否开通小额免密支付 0-否 1-是
     */
    private Integer pettyPayState;

    /**
     * 小额免密支付密码
     */
    private String pettyPayPass;

    /**
     * 免密支付金额（描述）
     */
    private Integer pettyPayAmount;

    /**
     * 是否开通消息推送 0-否 1-是
     */
    private Integer msgPushState;

    /**
     * 是否开通自动扣款1-是，0-否
     */
    private Integer directDebitState;


    /**
     * 省份id
     */
    private String provId;

    /**
     * 地市
     */
    private String cityId;

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * 描述
     */
    private String remark;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCustNickname() {
        return custNickname;
    }

    public void setCustNickname(String custNickname) {
        this.custNickname = custNickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public String getOrgName() {
        return orgName;
    }

    @Override
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getPettyPayState() {
        return pettyPayState;
    }

    public void setPettyPayState(Integer pettyPayState) {
        this.pettyPayState = pettyPayState;
    }

    public String getPettyPayPass() {
        return pettyPayPass;
    }

    public void setPettyPayPass(String pettyPayPass) {
        this.pettyPayPass = pettyPayPass;
    }

    public Integer getPettyPayAmount() {
        return pettyPayAmount;
    }

    public void setPettyPayAmount(Integer pettyPayAmount) {
        this.pettyPayAmount = pettyPayAmount;
    }

    public Integer getMsgPushState() {
        return msgPushState;
    }

    public void setMsgPushState(Integer msgPushState) {
        this.msgPushState = msgPushState;
    }

    public Integer getDirectDebitState() {
        return directDebitState;
    }

    public void setDirectDebitState(Integer directDebitState) {
        this.directDebitState = directDebitState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AuthoMiniAppRes{" +
                "custId='" + custId + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", openId='" + openId + '\'' +
                ", custNickname='" + custNickname + '\'' +
                ", sex=" + sex +
                ", headPicUrl='" + headPicUrl + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", pettyPayState=" + pettyPayState +
                ", pettyPayPass='" + pettyPayPass + '\'' +
                ", pettyPayAmount=" + pettyPayAmount +
                ", msgPushState=" + msgPushState +
                ", directDebitState=" + directDebitState +
                ", remark='" + remark + '\'' +
                '}';
    }
}
