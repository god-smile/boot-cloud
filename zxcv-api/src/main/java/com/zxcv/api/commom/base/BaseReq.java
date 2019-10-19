package com.zxcv.api.commom.base;


import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2019  zteits
 *
 * @ClassName: com.wx.miniapp.comm.req
 * @Description:请求基础类
 * @version: v1.0.0
 * @author: atao
 * @date: 2019-03-28   17:43
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2019-03-28      atao          v1.0.0          创建
 */
public class BaseReq implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseReq() {
    }

    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    /**
     * 分页请求信息
     */
    private PageReq pageReq = new PageReq();

    public PageReq getPageReq() {
        return pageReq;
    }

    public void setPageReq(PageReq pageReq) {
        this.pageReq = pageReq;
    }


}
