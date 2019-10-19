package com.zxcv.api.commom.bean;

import java.io.Serializable;

public class BaiscDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5502485571704282738L;
	
	
	/**组织名称*/
	private String orgName;


	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}
