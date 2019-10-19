package com.zxcv.api.commom.bean;

import java.io.Serializable;
import java.util.UUID;

public class BaseInfo implements Serializable {

    private static final long serialVersionUID = -189054095924156774L;

    /**
     * 请求编号，全局唯一，必须给
     */
    private String requestId;

    /**
     * 调用本次业务的请求编号，全局唯一，必须给
     */
    @SuppressWarnings("unused")
	private String preRequestId;

    /**
     * 当前页.
     */
    private int pageNum = 0;

    /**
     * 每页的数量.
     */
    private int pageSize = 10;
    
    /**动态排序 asc desc*/
    private String sortOrder;
    /**动态排序字段 */
    private String sortName;

    public BaseInfo() {
        super();
    }

    public BaseInfo(int pageNum, int pageSize) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getRequestId() {
        if (requestId == null || requestId == "") {
            requestId = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        }
        return requestId;

    }

    public void setPreRequestId(String preRequestId) {
        this.preRequestId = preRequestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
}
