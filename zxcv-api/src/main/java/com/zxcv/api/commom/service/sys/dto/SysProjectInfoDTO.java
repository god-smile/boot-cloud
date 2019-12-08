package com.zxcv.api.commom.service.sys.dto;

import java.util.Date;
import com.zxcv.api.commom.bean.BaiscDTO;

  /**
    * 项目表 DTO类
    * Copyright: Copyright (c) ${year}
    * @ClassName: SysProjectInfoDTO.java
    * @Description:
    * @version: v1.0.0
    * @author: zxcv
    * @date: 2019-12-08
    * Modification History:
    * Date             Author          Version            Description
    * ---------------------------------------------------------*
    * 2019-12-08         zxcv         v1.0.0               创建
    */

public class SysProjectInfoDTO extends BaiscDTO {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */

    private Long id;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 项目类别
     */
    private Integer projectType;

    /**
     * 项目的名称
     */
    private String projectName;

    /**
     * 数据库的名称
     */
    private String dbName;

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 是否定制，1是，0不是
     */
    private Integer specialType;

    /**
     * 项目入口地址
     */
    private String indexUrl;

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
    public String toString() {
        return "SysProjectInfoDTO{" +
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
