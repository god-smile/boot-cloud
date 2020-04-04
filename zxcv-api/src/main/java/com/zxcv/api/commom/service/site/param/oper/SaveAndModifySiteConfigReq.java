package com.zxcv.api.commom.service.site.param.oper;

import java.util.Date;
import com.zxcv.api.commom.base.BaseReq;

 /**
  * 用户配置表查询类
  * Copyright: Copyright (c) ${year}
  * @ClassName: SaveAndModifySiteConfigReq.java
  * @Description:
  * @version: v1.0.0
  * @author: zxcv
  * @date: 2020-04-04
  * Modification History:
  * Date             Author          Version            Description
  * ---------------------------------------------------------*
  * 2020-04-04         zxcv         v1.0.0               创建
  */

public class SaveAndModifySiteConfigReq extends  BaseReq {

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
     * 项目类型 
     */
    private Integer projectType;

    /**
     * 类型 作为key
     */
    private String type;

    /**
     * 名称 
     */
    private String name;

    /**
     * 值 
     */
    private String value;

    /**
     * 备用字段
     */
    private String valueAlias;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueAlias() {
        return valueAlias;
    }

    public void setValueAlias(String valueAlias) {
        this.valueAlias = valueAlias;
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
        return "SaveAndModifySiteConfigReq{" +
        "id=" + id +
        ", projectNo=" + projectNo +
        ", projectType=" + projectType +
        ", type=" + type +
        ", name=" + name +
        ", value=" + value +
        ", valueAlias=" + valueAlias +
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
