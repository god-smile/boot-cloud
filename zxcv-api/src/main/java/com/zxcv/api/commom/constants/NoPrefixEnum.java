package com.zxcv.api.commom.constants;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * Copyright: Copyright (c) 2019  zxcv
 *
 * @ClassName:
 * @Description:
 * @version: v1.0.0
 * @author: atao
 * @date:  2019/11/09  下午3:26
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2019/11/09      wangfei          v1.0.0          创建
 */
public enum NoPrefixEnum implements IEnum<String>{

    USER_NO("U", "用户编号"),
    PROJECT_NO("PJ", "项目编号"),
    NEWS_NO("NW", "新闻编号")


    ;

    @EnumValue
    private String value;
    private String desc;

    NoPrefixEnum(String value, String desc) {
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
