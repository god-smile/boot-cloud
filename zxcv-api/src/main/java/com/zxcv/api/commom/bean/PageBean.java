package com.zxcv.api.commom.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询结果分装PageInfo<T>.<br/>
 * 
 * @author wangfs
 * @param <T>
 */
public class PageBean<T> implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8295317993394764660L;
	/** 数据. */
	private List<T> dataList;
	/** 当前页. */
	private Integer pageNum = 1;
	/** 每页显示条数. */
	private Integer pageSize =10;
	/** 总条数. */
	private Integer pageTotals = 0;
	/** 总页页数. */
	private Integer pages;
	/** 排序. */
	private String orderBy;
	/** 是否查询总条数 true:查询，false:不查询. */
	private boolean isCount;
	/** 当设置为true的时候，如果pagesize设置为0，就不执行分页，返回全部结果. */
	private boolean pageSizeZero;
	/** 是否查询成功. */
	private boolean success;

	public PageBean() {

	}

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 */
	public PageBean(Integer pageNum, Integer pageSize) {
		if (pageNum == 1 && pageSize.equals(Integer.MAX_VALUE)) {
			pageSize = 0;
		}
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public boolean getPageSizeZero() {
		return pageSizeZero;
	}

	public void setPageSizeZero(boolean pageSizeZero) {
		this.pageSizeZero = pageSizeZero;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<T> getDataList() {
		if(null == dataList){
			dataList = new ArrayList<>();
		}
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public boolean getIsCount() {
		return isCount;
	}

	public void setIsCount(boolean isCount) {
		this.isCount = isCount;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		if (pageNum < 0 || pageNum > Integer.MAX_VALUE) {
			this.pageNum = 1;
		}
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageTotals() {
		return pageTotals;
	}

	public void setPageTotals(Integer pageTotals) {
		this.pageTotals = pageTotals;
		if (pageTotals == -1) {
			this.pages = 1;
			return;
		}
		if (this.pageSize > 0) {
			this.pages = (int) (pageTotals / this.pageSize + ((pageTotals % this.pageSize == 0) ? 0 : 1));
		} else {
			this.pages = 0;
		}
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "PageBean [dataList=" + dataList + ", pageNum=" + pageNum + ", pageSize=" + pageSize + ", pageTotals="
				+ pageTotals + ", pages=" + pages + ", orderBy=" + orderBy + ", isCount=" + isCount + ", pageSizeZero="
				+ pageSizeZero + ", success=" + success + "]";
	}
	
}