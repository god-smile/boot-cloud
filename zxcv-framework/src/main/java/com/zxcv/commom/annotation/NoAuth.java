package com.zxcv.commom.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: com.clouds.common.annotation
 * @Description: 此注解为不进行权限校验的注解，标注到方法上
 * @version: v1.0.0
 * @author: atao
 * @date: 2017/7/10   下午7:07
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2017/7/10      atao          v1.0.0          创建
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface NoAuth {
    /**
     * 描述
     * @return
     */
     String desc() default "";

    /**
     * 测试环境下是否需要权限认证 默认不需要
     * @return
     */
     boolean dev() default false;

    /**
     * 生产环境下是否需要权限认证 默认需要
     * @return
     */
     boolean pro() default true;


}
