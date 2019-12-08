package com.zxcv.busi.domain.sys;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户合同信息表
 * </p>
 *
 * @author zxcv
 * @since 2019-12-08
 */
public class SysContractInfo extends Model<SysContractInfo> {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 合同编号
     */
    @TableField("contract_no")
    private String contractNo;

    /**
     * 所属项目
     */
    @TableField("project_no")
    private String projectNo;

    /**
     * 项目的名称
     */
    @TableField("project_name")
    private String projectName;

    /**
     * 所属用户
     */
    @TableField("user_no")
    private String userNo;

    /**
     * 合同标价
     */
    @TableField("total_money")
    private BigDecimal totalMoney;

    /**
     * 折扣金额，优先级高于 折扣
     */
    @TableField("discount_money")
    private BigDecimal discountMoney;

    /**
     * 折扣
     */
    @TableField("discount_value")
    private BigDecimal discountValue;

    /**
     * 入账金额
     */
    @TableField("act_money")
    private BigDecimal actMoney;

    /**
     * 合同有效期
     */
    @TableField("valid_days")
    private Integer validDays;

    /**
     * 合同开始时间
     */
    @TableField("start_date")
    private Date startDate;

    /**
     * 合同结束时间
     */
    @TableField("end_date")
    private Date endDate;

    /**
     * 是否完成交付,1是，0否
     */
    @TableField("delivery_finished")
    private Integer deliveryFinished;

    /**
     * 是否是立项合同，立项合同-1，续约合同-2
     */
    @TableField("first_commit")
    private Integer firstCommit;

    /**
     * 数据状态：1有效，0无效
     */
    @TableField("data_state")
    @TableLogic
    private Integer dataState;

    /**
     * 描述
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建人
     */
    @TableField("create_emp_id")
    private String createEmpId;

    /**
     * 创建人名称
     */
    @TableField("create_emp_name")
    private String createEmpName;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改人
     */
    @TableField("modify_emp_id")
    private String modifyEmpId;

    /**
     * 修改人名称
     */
    @TableField("modify_emp_name")
    private String modifyEmpName;

    /**
     * 修改时间
     */
    @TableField("modify_time")
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
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysContractInfo{" +
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
