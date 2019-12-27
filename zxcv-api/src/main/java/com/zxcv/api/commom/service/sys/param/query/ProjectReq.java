package com.zxcv.api.commom.service.sys.param.query;

import com.zxcv.api.commom.base.BaseReq;

/**
 * 项目查询类
 * Copyright: Copyright (c)
 * @ClassName: ProjectReq.java
 * @Description:
 * @version: v1.0.0
 * @author: zxcv
 * @date: 2019-12-08
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-12-08         zxcv         v1.0.0               创建
 */

public class ProjectReq extends  BaseReq {

private static final long serialVersionUID=1L;


    /**
     * 用户编号
     */
    private String userNo;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
