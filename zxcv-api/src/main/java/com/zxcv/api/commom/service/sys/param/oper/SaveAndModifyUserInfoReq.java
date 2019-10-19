package com.zxcv.api.commom.service.sys.param.oper;

import com.zxcv.api.commom.base.BaseReq;
import java.util.Date;

/**
 * 操作员表(用户)查询类
 * Copyright: Copyright (c) ${year}
 * @ClassName: SaveAndModifyTsOpReq.java
 * @Description:
 * @version: v1.0.0
 * @author: lh
 * @date: 2019-10-14
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-10-14         lh         v1.0.0               创建
 */

public class SaveAndModifyUserInfoReq extends  BaseReq {

private static final long serialVersionUID=1L;

	/**
	 * 主键
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 登录密码
	 */
	private String userPassword;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 邮箱
	 */
	private String userEmail;

	/**
	 * 状态：1正常，2停用，3删除
	 */
	private Integer userState;

	/**
	 * 创建人
	 */
	//private String createEmpId;

	/**
	 * 创建人名称
	 */
	//private String createEmpName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改人
	 */
	//private String modifyEmpId;

	/**
	 * 修改人名称
	 */
	//private String modifyEmpName;

	/**
	 * 修改时间
	 */
	private Date modifyTime;

	public static long getSerialVersionUID()
	{
		return serialVersionUID;
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPassword()
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	public Integer getUserState()
	{
		return userState;
	}

	public void setUserState(Integer userState)
	{
		this.userState = userState;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getModifyTime()
	{
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime)
	{
		this.modifyTime = modifyTime;
	}

	@Override public String toString()
	{
		return "SaveAndModifyUserInfoReq{" + "userId=" + userId + ", userName='" + userName + '\'' + ", userPassword='"
				+ userPassword + '\'' + ", realName='" + realName + '\'' + ", userEmail='" + userEmail + '\''
				+ ", userState=" + userState + ", createTime=" + createTime + ", modifyTime=" + modifyTime + '}';
	}
}
