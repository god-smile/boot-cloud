package com.zxcv.portal.common.vo;



import com.zxcv.api.commom.base.ErrorCode;
import com.zxcv.api.commom.base.ErrorType;
import com.zxcv.api.commom.bean.BizResult;
import com.zxcv.portal.utils.ExceptionUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * 前台统一返回vo
 *
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: BizResultVO.java
 * @Description:
 * @version: v1.0.0
 * @author: zhaowg
 * @date: 2017年5月8日   下午4:43:56
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2017年5月8日      zhaowg              v1.0.0               创建
 */
@ApiModel(value = "统一响应格式")
public class BizResultVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "状态码:8888(成功);1000(系统错误);1002(业务错误);1006(访问的url不存在),1007(请求参数不正确)", required = true)
    private String code;
    @ApiModelProperty(value = "错误信息")
    private String msg;
    @ApiModelProperty(value = "错误信息-任你停使用")
    private T data;
    @ApiModelProperty(value="错误堆栈信息")
    private String trace;

    public BizResultVO() {
        super();
    }

    public BizResultVO(BizResult<T> bizResult) {
        super();
        this.code = bizResult.getErrCode().getCode();
        this.msg = bizResult.getErrMsg();
        this.trace = bizResult.getHelpMsg();
        this.data = bizResult.getData();
    }

    public BizResultVO(ErrorCode errorCode, String msg) {
        super();
        this.code = errorCode.getCode();
        this.msg = msg;
        /*if (null != msg && msg.length > 0 && errorCode.getMsg().contains("%s")) {
            this.msg = String.format(errorCode.getMsg(), msg);
        } else {
            this.msg = errorCode.getMsg();
        }*/

    }
    public BizResultVO(ErrorCode errorCode) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public BizResultVO(ErrorCode errorCode, Throwable ex) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.trace = ExceptionUtil.getTrace(ex);
    }

    public BizResultVO<T> setData(T data) {
        this.data = data;
        if (StringUtils.isEmpty(code)) {
            this.code = ErrorType.BIZ_SUCCESS.getCode();
        }
        if (StringUtils.isEmpty(msg)) {
            this.msg = ErrorType.BIZ_SUCCESS.getMsg();
        }
        return this;
    }
    
	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }



}
