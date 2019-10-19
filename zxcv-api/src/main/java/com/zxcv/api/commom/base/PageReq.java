package com.zxcv.api.commom.base;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2019  zteits
 *
 * @ClassName: com.wx.miniapp.comm.base
 * @Description: 分页查询请求类
 * @version: v1.0.0
 * @author: atao
 * @date: 2019-03-29   13:51
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2019-03-29      atao          v1.0.0          创建
 */
public class PageReq implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 当前页.
     */
    private int pageNum = 0;

    /**
     * 每页的数量.
     */
    private int pageSize = 10;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
