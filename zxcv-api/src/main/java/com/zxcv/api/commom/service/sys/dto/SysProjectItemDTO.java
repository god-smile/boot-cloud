package com.zxcv.api.commom.service.sys.dto;

import java.util.Date;
import com.zxcv.api.commom.bean.BaiscDTO;

  /**
    * 项目类别 DTO类
    * Copyright: Copyright (c) ${year}
    * @ClassName: SysProjectItemDTO.java
    * @Description:
    * @version: v1.0.0
    * @author: zxcv
    * @date: 2019-12-08
    * Modification History:
    * Date             Author          Version            Description
    * ---------------------------------------------------------*
    * 2019-12-08         zxcv         v1.0.0               创建
    */

public class SysProjectItemDTO extends BaiscDTO {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */

    private Long id;

    /**
     * 项目类型 1：网站 2：公众号:3：web应用 4：APP 5：小程序
     */
    private Integer projectType;

    /**
     * 项目名称
     */
    private String projectTypeName;

    /**
     * 封面图url
     */
    private String picUrl;

    /**
     * 内容
     */
    private String content;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序 越大排序越靠前
     */
    private Integer order;

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

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
        return "SysProjectItemDTO{" +
        "id=" + id +
        ", projectType=" + projectType +
        ", projectTypeName=" + projectTypeName +
        ", picUrl=" + picUrl +
        ", content=" + content +
        ", description=" + description +
        ", order=" + order +
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
