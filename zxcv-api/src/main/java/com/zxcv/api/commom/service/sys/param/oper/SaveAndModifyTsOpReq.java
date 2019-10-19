package com.zxcv.api.commom.service.sys.param.oper;

import java.util.Date;
import java.util.List;

import com.zxcv.api.commom.base.BaseReq;

 /**
  * 操作员表(用户)查询类
  * Copyright: Copyright (c) ${year}
  * @ClassName: SaveAndModifyTsOpReq.java
  * @Description:
  * @version: v1.0.0
  * @author: wangfs
  * @date: 2019-06-04
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2019-06-04         wangfs         v1.0.0               创建
  */

public class SaveAndModifyTsOpReq extends  BaseReq {

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
     * 年龄
     */
    private Integer age;

    /**
     * 登陆账户类型:1:超级管理员;2:普通用户
     */
    private Integer loginCodeType;

    /**
     * 职能id
     */
    private Long jobfuncId;

    /**
     * 操作员头像地址
     */
    private String imgPath;

    /**
     * 联系地址
     */
    private String contactAddress;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 证件类型 1:身份证,2:护照
     */
    private Integer cardTypeId;

    /**
     * 证件号码
     */
    private String cardNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 登录尝试次数
     */
    private Integer tryTimes;

    /**
     * 账号生效时间
     */
    private Date acctStartDate;

    /**
     * 账号失效时间
     */
    private Date acctEndDate;

    /**
     * 最后一次登录时间
     */
    private Date lastLoginTime;

    /**
     * 邮件开关 1:开启,0:关闭
     */
    private Integer emailSwitch;

    /**
     * 短信开关 1:开启,0:关闭
     */
    private Integer smsSwitch;

    /**
     * 数据状态：1有效，0无效,2:锁定
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
     * 角色Ids
     */
    private List<Long> roleIds;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getLoginCodeType() {
        return loginCodeType;
    }

    public void setLoginCodeType(Integer loginCodeType) {
        this.loginCodeType = loginCodeType;
    }

    public Long getJobfuncId() {
        return jobfuncId;
    }

    public void setJobfuncId(Long jobfuncId) {
        this.jobfuncId = jobfuncId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(Integer cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTryTimes() {
        return tryTimes;
    }

    public void setTryTimes(Integer tryTimes) {
        this.tryTimes = tryTimes;
    }

    public Date getAcctStartDate() {
        return acctStartDate;
    }

    public void setAcctStartDate(Date acctStartDate) {
        this.acctStartDate = acctStartDate;
    }

    public Date getAcctEndDate() {
        return acctEndDate;
    }

    public void setAcctEndDate(Date acctEndDate) {
        this.acctEndDate = acctEndDate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getEmailSwitch() {
        return emailSwitch;
    }

    public void setEmailSwitch(Integer emailSwitch) {
        this.emailSwitch = emailSwitch;
    }

    public Integer getSmsSwitch() {
        return smsSwitch;
    }

    public void setSmsSwitch(Integer smsSwitch) {
        this.smsSwitch = smsSwitch;
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
        return "SaveAndModifyTsOpReq{" +
        "id=" + id +
        ", orgId=" + orgId +
        ", loginCode=" + loginCode +
        ", loginPassword=" + loginPassword +
        ", opCode=" + opCode +
        ", opName=" + opName +
        ", sex=" + sex +
        ", age=" + age +
        ", loginCodeType=" + loginCodeType +
        ", jobfuncId=" + jobfuncId +
        ", imgPath=" + imgPath +
        ", contactAddress=" + contactAddress +
        ", telephone=" + telephone +
        ", cardTypeId=" + cardTypeId +
        ", cardNo=" + cardNo +
        ", email=" + email +
        ", tryTimes=" + tryTimes +
        ", acctStartDate=" + acctStartDate +
        ", acctEndDate=" + acctEndDate +
        ", lastLoginTime=" + lastLoginTime +
        ", emailSwitch=" + emailSwitch +
        ", smsSwitch=" + smsSwitch +
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

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}
}
