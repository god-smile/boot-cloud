package com.zxcv.busi.configs.xxljob;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: XxlJobCondition.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-09-06 11:26
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-09-06     wangfs              v1.0.0               创建
 */
public class XxlJobCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判断当前环境开关是否开启
        String isOnOff = context.getEnvironment().getProperty("xxl.job.switch.auto.XxlJobConfiguration");
        //当且仅当值为true时，返回true
        if(!StringUtils.isBlank(isOnOff) && isOnOff.equalsIgnoreCase("true")){
            return true;
        }
        return false;
    }

}

