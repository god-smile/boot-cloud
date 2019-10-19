package com.zxcv.portal.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2017  zteits
 * 
 * @ClassName: JqGridDisplayVO.java
 * @Description: JqGrid 对应前台数据传输格式
 * @version: v1.0.0
 * @author: zhaowg
 * @date: 2017年5月12日   上午11:20:33 
 * Modification History: 
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2017年5月12日      zhaowg              v1.0.0               创建
 */
public class JqGridDisplayVO<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	//总页数
	private Integer total;
	
	//当前页
	private Integer page;
	
	//总记录条数
	private Integer records;
	
	//包含实际数据的数组
	private List<T> rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
