package com.zxcv.busi.domain.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * <p>
 * 操作员表(用户)
 * </p>
 *
 * @author lh
 * @since 2019-10-14
 */
public class UserInfo extends Model<UserInfo> {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
        return "UserInfo{" + "userId=" + userId + ", userName='" + userName + '\'' + ", userPassword='" + userPassword
                + '\'' + ", realName='" + realName + '\'' + ", userEmail='" + userEmail + '\'' + ", userState="
                + userState + ", createTime=" + createTime + ", modifyTime=" + modifyTime + '}';
    }
}
