package com.zxcv.api.commom.constants;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: com.clouds.common.constants
 * @Description: 存在session里面变量
 * @version: v1.0.0
 * @author: atao
 * @date: 2017/6/21   上午11:08
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2017/6/21      atao          v1.0.0          创建
 */
public enum SessionEnum {

    USER_ID("userId"),
    USER_NAME("userName"),
    USER_NO("userNo"),
    PROJECT_NO("projectNo"),
    INDEX_URL("indexUrl"),


    //小程序用户对象
    USER_MINI_INFO("login:usermini:info"),
    //user 对象
    USER_INFO("login:user:info"),
    /**登陆用户token信息.*/
    LOGIN_USER_TOKEN("login:user:token");



    private String key;

    SessionEnum(String key) {
        this.key = key;
    }

    public String key() {
        return this.key;
    }

}
