package com.zxcv.api.commom.constants;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: com.zteits.clouds.api.apibase.constants
 * @Description:
 * @version: v1.0.0
 * @author: atao
 * @date: 2017/4/24   下午3:26
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2017/4/24      atao          v1.0.0          创建
 */
public enum DataStatusEnum implements IEnum<Integer>{

    USER_LEVEL_ADMIN(0, "管理员"),
    USER_LEVEL_TRUSTEESHIP_ONE(-1, "托管，一级用户"),
    USER_LEVEL_NORMAL_ONE(1, "一级用户"),
    USER_LEVEL_NORMAL_TWO(2, "二级用户"),
    USER_LEVEL_NORMAL_THREE(3, "三级用户"),
    USER_LEVEL_NORMAL_FOUR(4, "四级用户"),

    ENTRANCE_SITE(1, "官网入口"),
    ENTRANCE_USER_MANAGE(0, "用户管理"),
    ENTRANCE_USER_ADMIN(0, "管理员管理"),

    DATA_STATUS_VALID(1, "数据有效"),
    DATA_STATUS_NO_VALID(0, "数据无效"),
    DATA_STATUS_FROZEN(2, "冻结"),
    
    UP_SHELF(1, "上架"),
    DOWN_SHELF(2, "下架")
    ;

    @EnumValue
    private Integer value;
    private String desc;

    DataStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
