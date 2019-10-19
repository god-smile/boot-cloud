package com.zxcv.api.commom.base;

import com.zxcv.api.commom.bean.BizResult;

/**
 * Copyright: Copyright (c) 2019  zteits
 *
 * @ClassName: com.wx.miniapp.comm.res
 * @Description:
 * @version: v1.0.0
 * @author: atao
 * @date: 2019-03-28   17:43
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2019-03-28      atao          v1.0.0          创建
 */
public class Result<T> {
    /**
     * 响应编码
     */
    private ErrorCode code;

    /**
     * 返回的数据信息
     */
    private T data;

    /**
     * 自定义提示消息
     */
    private String msg;

    public Result(ErrorCode code) {
        this.code = code;
    }

    public Result(BizResult<T> bizResult) {
        this.code = bizResult.getErrCode();
        this.msg = bizResult.getErrMsg();
        this.data = bizResult.getData();

    }

    public Result(ErrorCode code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(ErrorCode code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(ErrorCode code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Result(T data) {
        this.data = data;

        this.code = new ErrorCode() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public String getCode() {
                return "8888";
            }

            @Override
            public String getMsg() {
                return "成功";
            }
        };
    }

    public String getCode() {
        return code.getCode();
    }

    public String getMsg() {
        return (msg == null || msg.isEmpty()) ? code.getMsg() : msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
