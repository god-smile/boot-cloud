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
	private List<T> rows;
	/** 当前页. */
	private Integer pageNum = 1;
	/** 每页显示条数. */
	private Integer pageSize =10;
	/** 总条数. */
	private Integer total = 0;
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
	 * @param pageNum
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

	public List<T> getRows() {
		if(null == rows){
			rows = new ArrayList<>();
		}
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
		if (total == -1) {
			this.pages = 1;
			return;
		}
		if (this.pageSize > 0) {
			this.pages = (int) (total / this.pageSize + ((total % this.pageSize == 0) ? 0 : 1));
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
		return "PageBean [rows=" + rows + ", pageNum=" + pageNum + ", pageSize=" + pageSize + ", pageTotals="
				+ total + ", pages=" + pages + ", orderBy=" + orderBy + ", isCount=" + isCount + ", pageSizeZero="
				+ pageSizeZero + ", success=" + success + "]";
	}
	
}