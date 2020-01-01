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

    USER_LEVEL_USER(1, "普通用户"),
    USER_LEVEL_ADMIN(2, "管理员"),

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
