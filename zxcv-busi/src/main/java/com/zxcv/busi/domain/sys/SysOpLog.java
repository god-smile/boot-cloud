package com.zxcv.busi.domain.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 登录/操作日志表
 * </p>
 *
 * @author zxcv
 * @since 2020-01-22
 */
public class SysOpLog extends Model<SysOpLog> {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 操作员code
     */
    @TableField("op_code")
    private String opCode;

    /**
     * 操作员姓名
     */
    @TableField("op_name")
    private String opName;

    /**
     * 日志类型 0：登录日志 1：操作日志
     */
    @TableField("log_type")
    private Integer logType;

    /**
     * 方法
     */
    @TableField("method")
    private String method;

    /**
     * 方法
     */
    @TableField("method_desc")
    private String methodDesc;

    /**
     * 类方法
     */
    @TableField("class_method")
    private String classMethod;

    /**
     * ip地址
     */
    @TableField("request_ip")
    private String requestIp;

    /**
     * 请求入参
     */
    @TableField("request_args")
    private String requestArgs;

    /**
     * 响应类型 0 正常 1 异常
     */
    @TableField("response_type")
    private Integer responseType;

    /**
     * 响应原始数据-包含正常异常
     */
    @TableField("response_body")
    private String responseBody;

    /**
     * 数据状态：1有效，0无效
     */
    @TableField("data_state")
    @TableLogic
    private Integer dataState;

    /**
     * 描述
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建人
     */
    @TableField("create_emp_id")
    private String createEmpId;

    /**
     * 创建人名称
     */
    @TableField("create_emp_name")
    private String createEmpName;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改人
     */
    @TableField("modify_emp_id")
    private String modifyEmpId;

    /**
     * 修改人名称
     */
    @TableField("modify_emp_name")
    private String modifyEmpName;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getRequestArgs() {
        return requestArgs;
    }

    public void setRequestArgs(String requestArgs) {
        this.requestArgs = requestArgs;
    }

    public Integer getResponseType() {
        return responseType;
    }

    public void setResponseType(Integer responseType) {
        this.responseType = responseType;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateEmpId() {
        return createEmpId;
    }

    public void setCreateEmpId(String createEmpId) {
        this.createEmpId = createEmpId;
    }

    public String getCreateEmpName() {
        return createEmpName;
    }

    public void setCreateEmpName(String createEmpName) {
        this.createEmpName = createEmpName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyEmpId() {
        return modifyEmpId;
    }

    public void setModifyEmpId(String modifyEmpId) {
        this.modifyEmpId = modifyEmpId;
    }

    public String getModifyEmpName() {
        return modifyEmpName;
    }

    public void setModifyEmpName(String modifyEmpName) {
        this.modifyEmpName = modifyEmpName;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysOpLog{" +
        "id=" + id +
        ", opCode=" + opCode +
        ", opName=" + opName +
        ", logType=" + logType +
        ", method=" + method +
        ", methodDesc=" + methodDesc +
        ", classMethod=" + classMethod +
        ", requestIp=" + requestIp +
        ", requestArgs=" + requestArgs +
        ", responseType=" + responseType +
        ", responseBody=" + responseBody +
        ", dataState=" + dataState +
        ", remark=" + remark +
        ", createEmpId=" + createEmpId +
        ", createEmpName=" + createEmpName +
        ", createTime=" + createTime +
        ", modifyEmpId=" + modifyEmpId +
        ", modifyEmpName=" + modifyEmpName +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
