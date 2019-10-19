package com.zxcv.api.commom.constants;

import com.zxcv.api.commom.base.ErrorCode;

public enum AppErrorEnum implements ErrorCode {
	 /**登录失效,请重新登录*/
    APP_TOKEN_FAIL("-10000", "登录失效,请重新登录!"),
    /**更换设备,请重新登录*/
    APP_DEVICE_NO_FAIL("-10001", "更换设备,请重新登录!"),
    /**签名验证失败*/
    APP_SIGN_FAIL("-10002", "签名验证失败"),
    /**手机号格式不正确*/
    APP_PHONE_fAIL("-10003", "手机号格式不正确"),
    /**您的车牌已被绑定，请联系管理员*/
	APP_CARNUMBER_REPEAT("-10004", "您的车牌已被绑定，请联系管理员！"),
	/***同一个用户最大不能超过三个车牌*/
	APP_CARNUMBER_TOMACH("-10005", "同一用户不能超过3车牌"),
	/***同一个用户不能购买同一类型的会员卡*/
	APP_CARNUMBER_TO_MACH("-10006", "同一个用户不能购买同一类型的会员卡"),
	/***同一用户不能购买同一种卡*/
	APP_CARD_REPEAT("-10006", "同一用户不能购买同一种卡，请续费或者继续使用"),
	/**没有车牌 请帮定车牌*/
	APP_CARNUMBER_NULL("-10007", "请绑定车牌！"),
	APP_NO_BIND_USER("-10008","未绑定用户"),
	/**未查询到欠费或待支付的共享停车订单（-10009不可以修改，前台根据此来做判断的）*/
	APP_NOT_FOUND_UNPAY_ORDER("-10009","未查询到欠费或待支付的共享停车订单"),
	/**预约进场时间小于当前时间（-10010不可以修改，前台根据此来判断逻辑）*/
	APP_PRE_IN_TIME_BEFORE_NOW("-10010","预约入场时间需大于当前时间"),
    APP_NOT_FOUND_PRE_ACT_ORDER("-10011","未查询到担保费订单"),
    APP_BERTHS_NOT_BELONG_TO_YOU("-10012","该车位非您预订，无权操作"),
    /**购买的新的会员卡有效时间重复**/
    APP_CARNUMBER_TO_MACH_DUP("-10013", "亲，这段时间您已购买，请重新选择生效日期!"),  //购买会员卡有效时间重复,请重新购买
    ;
	
    private String code;
    private String msg;

    private AppErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }
    @Override
    public String getMsg() {
        return this.msg;
    }

}
