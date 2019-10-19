package com.zxcv.commom.annotation;


import java.lang.annotation.*;
/**
 * 将此注解标注到支付controller用于HandlerInterceptor 局部拦截放入对应配置信息
 * @Auther: wangfs
 * @param
 * @return
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface payAuth {
    /**
     * 描述
     * @return
     */
    String desc() default "";
}
