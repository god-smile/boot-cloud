package com.zxcv.api.commom.service.site.dto;

import java.util.Date;
import com.zxcv.api.commom.bean.BaiscDTO;

  /**
    * 用户产品表 DTO类
    * Copyright: Copyright (c) ${year}
    * @ClassName: SiteProductInfoDTO.java
    * @Description:
    * @version: v1.0.0
    * @author: zxcv
    * @date: 2019-12-21
    * Modification History:
    * Date             Author          Version            Description
    * ---------------------------------------------------------*
    * 2019-12-21         zxcv         v1.0.0               创建
    */

public class SiteProductInfoDTO extends BaiscDTO {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */

    private Long id;

    /**
     * 产品编号
     */
    private String productNo;

    /**
     * 封面图url
     */
    private String picUrl;

    /**
     * 封面图url
     */
    private String picUrl1;

    /**
     * 封面图url
     */
    private String picUrl2;

    /**
     * 标题
     */
    private String title;

    /**
    * 内容base64
    */
    private String content;

    /**
     * 正文内容url
     */
    private String contentUrl;

    /**
     * 描述
     */
    private String description;

    /**
     * 用户编号
     */
    private String userNo;

    /**
     * 项目编号
     */
    private String projectNo;

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


    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

      public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicUrl1() {
        return picUrl1;
    }

    public void setPicUrl1(String picUrl1) {
        this.picUrl1 = picUrl1;
    }

    public String getPicUrl2() {
        return picUrl2;
    }

    public void setPicUrl2(String picUrl2) {
        this.picUrl2 = picUrl2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
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
        return "SiteProductInfoDTO{" +
        "id=" + id +
        ", productNo=" + productNo +
        ", picUrl=" + picUrl +
        ", picUrl1=" + picUrl1 +
        ", picUrl2=" + picUrl2 +
        ", title=" + title +
        ", contentUrl=" + contentUrl +
        ", description=" + description +
        ", userNo=" + userNo +
        ", projectNo=" + projectNo +
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
