package com.zxcv.api.commom.service.site.param.oper;

import java.util.Date;
import com.zxcv.api.commom.base.BaseReq;

/**
 * 新闻表查询类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SaveAndModifySiteNewsInfoReq.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */

public class SaveAndModifySiteNewsInfoReq extends  BaseReq {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */

    private Long id;

    /**
     * 新闻编号
     */
    private String newsNo;

    /**
     * 新闻类型 1-新闻资讯 2-公告信息 3-招聘信息
     */
    private Integer newsType;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 内容
     */
    private String content;

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

    private String newsContent;

    public String getNewsContent()
    {
        return newsContent;
    }

    public void setNewsContent(String newsContent)
    {
        this.newsContent = newsContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewsNo() {
        return newsNo;
    }

    public void setNewsNo(String newsNo) {
        this.newsNo = newsNo;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "SaveAndModifySiteNewsInfoReq{" +
                "id=" + id +
                ", newsNo=" + newsNo +
                ", newsType=" + newsType +
                ", title=" + title +
                ", description=" + description +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", content=" + content +
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
