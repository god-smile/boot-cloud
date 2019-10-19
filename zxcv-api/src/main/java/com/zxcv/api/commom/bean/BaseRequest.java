package com.zxcv.api.commom.bean;

import java.io.Serializable;

/**
 * 所有入参数父类.<br/>
 *
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: BaseQuery.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2017年4月21日   上午10:56:03
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2017年4月21日      wangfs           v1.0.0               创建
 */
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = -189054095924156774L;
    /**
     * 基本信息，baseRequest中需要存放的公共基础信息全部放到BaseInfo中
     */
    private BaseInfo baseRequest = new BaseInfo();

	/**
	 * 操作人ID
	 */
	protected Long sOpId;
	/**
	 * 操作人名称
	 */
	protected String sOpName;



	public BaseRequest() {
		super();
	}
    

	public BaseRequest(String sysCode) {
		super();
	}


	public BaseRequest(BaseInfo baseRequest, String sysCode) {
		super();
		this.baseRequest = baseRequest;
	}

	public BaseRequest(BaseInfo baseRequest) {
		super();
		this.baseRequest = baseRequest;
	}

	public Long getsOpId() {
		return sOpId;
	}

	public void setsOpId(Long sOpId) {
		this.sOpId = sOpId;
	}

	public BaseInfo getBaseRequest() {
        if (baseRequest == null) {
            baseRequest = new BaseInfo();
        }
		return baseRequest;
    }

    public void setBaseRequest(BaseInfo baseRequest) {
        this.baseRequest = baseRequest;
    }

	public String getsOpName() {
		return sOpName;
	}

	public void setsOpName(String sOpName) {
		this.sOpName = sOpName;
	}

	@Override
	public String toString() {
		return "BaseRequest{" +
			"baseRequest=" + baseRequest +
			", " +
			'}';
	}
}
