package com.zxcv.api.commom.service.sys.dto;

import java.util.Date;

import com.zxcv.api.commom.bean.BaiscDTO;

/**
 * 用户表 DTO类
 * Copyright: Copyright (c) ${year}
 *
 * @ClassName: SysUserInfoDTO.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */

public class SysUserInfoDTO extends BaiscDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Long id;

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 登录名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 微信号
     */
    private String wechatNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String cardNo;

    /**
     * 性别：1男，2女，3保密
     */
    private Integer sex;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 用户星级:一、二、三
     */
    private Integer level;

    /**
     * 账号生效日期
     */
    private Date beginTime;

    /**
     * 账号失效日期
     */
    private Date endTime;

    /**
     * 用户状态：1正常， 0冻结
     */
    private Integer userState;

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


    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 前端路径
     */
    private String indexUrl;


    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "SysUserInfoDTO{" +
                "id=" + id +
                ", userNo='" + userNo + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", wechatNumber='" + wechatNumber + '\'' +
                ", email='" + email + '\'' +
                ", realName='" + realName + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", level=" + level +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", userState=" + userState +
                ", dataState=" + dataState +
                ", remark='" + remark + '\'' +
                ", createEmpId='" + createEmpId + '\'' +
                ", createEmpName='" + createEmpName + '\'' +
                ", createTime=" + createTime +
                ", modifyEmpId='" + modifyEmpId + '\'' +
                ", modifyEmpName='" + modifyEmpName + '\'' +
                ", modifyTime=" + modifyTime +
                ", projectNo='" + projectNo + '\'' +
                ", indexUrl='" + indexUrl + '\'' +
                '}';
    }
}
