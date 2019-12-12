package com.zxcv.api.commom.constants;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * Copyright: Copyright (c) 2019  zxcv
 *
 * @ClassName: 编号起始
 * @Description:
 * @version: v1.0.0
 * @author: wangfei
 * @date: 2019-12-12   17:12:05
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2019-12-12      wangfei          v1.0.0          创建
 */
public enum NoInitEnum implements IEnum<String>{

    USER_NO("U100000001", "用户编号"),



    ;

    @EnumValue
    private String value;
    private String desc;

    NoInitEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
