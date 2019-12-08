package com.zxcv.busi.domain.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 项目表
 * </p>
 *
 * @author zxcv
 * @since 2019-12-08
 */
public class SysProjectInfo extends Model<SysProjectInfo> {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目编号
     */
    @TableField("project_no")
    private String projectNo;

    /**
     * 项目类别
     */
    @TableField("project_type")
    private Integer projectType;

    /**
     * 项目的名称
     */
    @TableField("project_name")
    private String projectName;

    /**
     * 数据库的名称
     */
    @TableField("db_name")
    private String dbName;

    /**
     * 用户编号
     */
    @TableField("user_no")
    private String userNo;

    /**
     * 是否定制，1是，0不是
     */
    @TableField("special_type")
    private Integer specialType;

    /**
     * 项目入口地址
     */
    @TableField("index_url")
    private String indexUrl;

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

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Integer getSpecialType() {
        return specialType;
    }

    public void setSpecialType(Integer specialType) {
        this.specialType = specialType;
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
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
        return "SysProjectInfo{" +
        "id=" + id +
        ", projectNo=" + projectNo +
        ", projectType=" + projectType +
        ", projectName=" + projectName +
        ", dbName=" + dbName +
        ", userNo=" + userNo +
        ", specialType=" + specialType +
        ", indexUrl=" + indexUrl +
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
