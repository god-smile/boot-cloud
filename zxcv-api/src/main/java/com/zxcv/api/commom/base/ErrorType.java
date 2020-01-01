package com.zxcv.api.commom.base;

public enum ErrorType implements ErrorCode {

    AUTH_PASS_ERROR("2000", "用户名或密码不正确"),
    AUTH_LOGIN_FREEZED("2001", "账号被冻结!"),
    AUTH_LOGIN_ENDTIME("2002", "账号已过期!"),

    AUTH_MULTIPLE_USER("2007","账号重复"),

    AUTH_TOKEN_NOT_EXISTS("2003", "验证码错误"),


    AUTH_PROJECT_EMPTY("2007","该账号未关联项目"),

    AUTH_TOKEN_ILLEGAL("2004", "授权令牌不合法"),
    AUTH_TOKEN_AUTH_FAIL("2005", "无此权限"),
    AUTH_PASS_WRONG_NUM_OVER("2006","密码输错次数超限,"),
    AUTH_RES_EMPTY("2007","账号无有效资源"),
    AUTH_ORG_EMPTY("2008","账号无有效在组织"),
    AUTH_PL_NOS_EMPTY("2010","用户没有关联停车场"),
    AUTH_STATE_ILLEGALITY("2009","账号状态异常"),
    SYSTEM_ERROR("1000", "抱歉，服务暂时不可用，请稍后重试。"),
    APP_ERROR("1001", "应用错误"),
    BIZ_ERROR("1002", "业务错误:%s"),
    PARAMM_NULL("1003", "入参不能为空:[%s]"),
    OBJECT_NOT_EXISTS("1004", "对象不存在:[%s]"),
    OBJECT_BELONG_ERROR("1005", "对象归属错误:[%s]"),
    RESOURCE_NOT_EXISTS("1006", "访问的资源不存在"),
    PARAM_NOT_VALID("1007", "参数校验失败:%s"),
    CREATE_PAY_ORDER_FAIL("1008","生成支付单信息失败"),
    CREATE_SIGIN_FAIL("1009","支付单签名失败"),
    CACHE_NOT_EXISTS("1010","在缓存中不存在[%s]"),
    SEND_MESSAGE_ERROR("1011","发送验证码失败"),
    URL_NOT_FOUND("1028","请求路径不存在"),
    /***验证码不匹配*/
    SEND_VERIFI_CODE_ERROR("1012","验证码不匹配"),
    /**验证码失效*/
    SEND_VERIFI_CODE_LESS("1013","验证码失效"),
    PARK_LOT_NOT_EXISTS("1014","停车场记录不存在：%s"),
    PARK_SEND_FAIL("1015","通知失败"),
    PASS_NOT_MATCH("1016","两次密码不一致"),
    CUST_INFO_HAS_EXISTS("1017","客户已存在"),
    UPDATE_ROLE_ORGID_ERROR("1017","跟新角色组织Id失败"),
    ADD_ROLE_ORG("1018","请在用户菜单 为用户分配组织，然后为用户分配角色"),
    ONLY_UPLOAD_EXCLE("1019","只能上传xlsx或者lsx格式文件"),
    NO_DATA_FOR_EXCLE("1020","请在excle添加数据后上传"),
    SAVE_EXCLE_FAIL("1021","批量导入excle失败"),
    EXCLE_COLM_ERROR("1022","excle模板错误"),
    SYSTEM_UPDATING("1023","抱歉，服务正在升级，请稍后重试！"),
    INTERFACE_NOT_SUPPORT("1024","抱歉，该功能已经更新，请升级至最新版本。"),
    CALL_THIRD_SERVICE_EXCEPTION("1025","调用第三方服务异常"),
    NOT_SUPPORT("1026","该接口暂不支持"),
    RESPONSE_NULL("1027","响应信息为空"),
    OBJECT_EXISTS("1028", "该角色已存在"),




    /*********PARK域**********/
    SAVE_PARK_ERROR("3000","保存停车场信息错误！"),
    ALREADY_EXISTS("3001","当前编号[%s]在该停车场中已存在"),
    EQPNO_EXISTS("3002","当前设备编号已存在"),
    PDANO_EXISTS("3003","当前PDA编号已存在"),
    CHARGER_CODE_EXISTS("3004","该收费员账号已经存在，请重新输入"),
    NOT_ALLOW_DEL_BERTH("3005","泊位已经关联地磁或有在停车辆，不允许删除"),
    NOT_ALLOW_DEL_BERTH_AREA("3006","泊位区间下已经有泊位，请先删除泊位"),
    NOT_ALLOW_DEL_AREA_BLOCK("3007","该办事处下面有停车场，不允许删除"),
    NOT_ALLOW_DEL_PARK("3008","停车场下面已经有泊位区间，请先删除泊位区间"),
    NOT_ALLOW_DEL_EMPLOYEE_GROUP("3009","收费组下面有收费员，不允许删除"),
    BERTHS_ALREADY_RENT("3010","该车位已经被租用"),
    NOT_ALLOW_CANCEL("3011","该车位不允许取消"),
    GREATER_THEN_MAX_CANCEL_TIME("3012","超过最大取消次数"),
    DATA_ALREADY_MODIFYED("3013","数据已经被其他业务修改，请重新查询"),
    PARK_CARD_NOT_HAVE("3014","输入的充值卡编码有误,请重新输入"),
    PARK_CARD_FREEZE("3015","该充值卡已经被冻结,请联系客服"),
    PARK_CARD_HAS_RECHARGE("3016","该充值卡已使用"),
    PARK_CARD_IS_ERROR("3017","充值卡信息有问题,联系客服"),
    PARK_ORDER_NOT_FIND_ERROR("3018","未查找到订单信息"),

    /***********PARK域********/
    /*********PAY域**********/
    ACCOUNT_NO_RECRET_NOT("4000","个人账户没有开通免密支付！"),
    ACCOUNT_NO_MONEY("4001","个人账户余额不足！"),
    NOTFUND_CUSTID_BY_CARNO("4002","该车牌暂未被绑定，无法找到对应客户"),
    REFUND_FEE_FAIL("4003","退款失败"),
    ACCOUNT_NO_FIND("4004","未找到个人账户信息！"),
    NOTFUND_PAY_ORDER("4005","没有找到支付单信息"),
    CUST_SIGN_ERROR("4006","签到失败"),
    SYS_COMMON_ERROR("4007","码表查询失败"),
    NOTFOUND_COUPON("4008","根据卡劵编码[%s]没有获取到响应的卡劵信息！"),
    COUPON_NOTREST("4009","当前卡劵[%s]剩余数量不足！"),
    UPDATE_COUPON_FAIL("4010","修改卡劵[%s]信息失败！"),
    SAVE_COUPON_PERSON("4011","保存个人卡劵失败！"),
    CUST_CARD_NO_NUM("4012","卡券已经售完！"),
    PAY_ORDER_BACK("4013","补缴的单子为空！"),
    THIRDPART_APPID_NOT_EXISTS("4014","appId不存在"),
    PAY_TYPE_ERROR("4015","支付方式不正确"),
    CREAT_PAYORDER_ERROR("4016","支付方式不正确"),
    INVOICE_FEE_ERROR("4017","手机端开票金额计算有误"),
    NOT_PAYED_ORDER("4018","有未支付单"),
    ALREADY_OUT_PARK("4019","已经出场，无需重复操作"),
    ACCOUNT_NO_FULL_MONEY("4020","账户余额不足！"),
    REPEAT_OPERATE("4021","重复操作"),
    TO_PAY_ERROE("4022","发起支付异常"),
    /***********PAY域********/
    /***********ORDER域*************/
    NOT_FOUND_PAY_ORDER("5000","未找到支付单"),
    PARK_ORDER_NOT_ARREARAGE("5001","该订单已经补交，请重新查询"),
    QRCODE_NO_VALIDE("5002","二维码已经过期"),
    DECODE_ERROR("5003","解密失败"),
    MQSEND_FAIL("5004","MQ发送失败"),

    /**********Bill域***************/
    NOT_FOUND_VIP_CARD("6000","未根据个人卡券编码找到卡信息"),
    VIP_CARD_NO_MONEY("6001","卡余额不足"),
    VIP_CARD_ALREADY_BUY("6002","该会员卡已经有购买记录，不允许删除!"),
    /**********Bill域****************/

    /***********SYS******************/
    SYS_CODE_NOT_CONFIG("7001","字典表未配置"),
    /***********SYS******************/
    BIZ_SUCCESS("8888", "成功");

    private String code;
    private String msg;

    private ErrorType(String code, String msg) {
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
