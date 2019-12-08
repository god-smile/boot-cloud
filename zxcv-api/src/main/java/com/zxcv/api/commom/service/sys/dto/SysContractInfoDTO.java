package com.zxcv.api.commom.service.sys.dto;

import java.math.BigDecimal;
import java.util.Date;
import com.zxcv.api.commom.bean.BaiscDTO;

  /**
    * 用户合同信息表 DTO类
    * Copyright: Copyright (c) ${year}
    * @ClassName: SysContractInfoDTO.java
    * @Description:
    * @version: v1.0.0
    * @author: zxcv
    * @date: 2019-12-08
    * Modification History:
    * Date             Author          Version            Description
    * ---------------------------------------------------------*
    * 2019-12-08         zxcv         v1.0.0               创建
    */

public class SysContractInfoDTO extends BaiscDTO {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */

    private Long id;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 所属项目
     */
    private String projectNo;

    /**
     * 项目的名称
     */
    private String projectName;

    /**
     * 所属用户
     */
    private String userNo;

    /**
     * 合同标价
     */
    private BigDecimal totalMoney;

    /**
     * 折扣金额，优先级高于 折扣
     */
    private BigDecimal discountMoney;

    /**
     * 折扣
     */
    private BigDecimal discountValue;

    /**
     * 入账金额
     */
    private BigDecimal actMoney;

    /**
     * 合同有效期
     */
    private Integer validDays;

    /**
     * 合同开始时间
     */
    private Date startDate;

    /**
     * 合同结束时间
     */
    private Date endDate;

    /**
     * 是否完成交付,1是，0否
     */
    private Integer deliveryFinished;

    /**
     * 是否是立项合同，立项合同-1，续约合同-2
     */
    private Integer firstCommit;

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

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public BigDecimal getActMoney() {
        return actMoney;
    }

    public void setActMoney(BigDecimal actMoney) {
        this.actMoney = actMoney;
    }

    public Integer getValidDays() {
        return validDays;
    }

    public void setValidDays(Integer validDays) {
        this.validDays = validDays;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getDeliveryFinished() {
        return deliveryFinished;
    }

    public void setDeliveryFinished(Integer deliveryFinished) {
        this.deliveryFinished = deliveryFinished;
    }

    public Integer getFirstCommit() {
        return firstCommit;
    }

    public void setFirstCommit(Integer firstCommit) {
        this.firstCommit = firstCommit;
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
        return "SysContractInfoDTO{" +
        "id=" + id +
        ", contractNo=" + contractNo +
        ", projectNo=" + projectNo +
        ", projectName=" + projectName +
        ", userNo=" + userNo +
        ", totalMoney=" + totalMoney +
        ", discountMoney=" + discountMoney +
        ", discountValue=" + discountValue +
        ", actMoney=" + actMoney +
        ", validDays=" + validDays +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", deliveryFinished=" + deliveryFinished +
        ", firstCommit=" + firstCommit +
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
