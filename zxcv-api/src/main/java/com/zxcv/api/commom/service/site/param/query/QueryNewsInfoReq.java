package com.zxcv.api.commom.service.site.param.query;

import com.zxcv.api.commom.base.BaseReq;

/**
 *
 */

public class QueryNewsInfoReq extends  BaseReq {

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
     * 项目编号
     */
    private String projectNo;




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


    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }



}
