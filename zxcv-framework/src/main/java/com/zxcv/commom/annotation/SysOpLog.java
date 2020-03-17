package com.zxcv.commom.annotation;

import java.lang.annotation.*;

/**
 * Copyright: Copyright (c) 2019
 *
 * ClassName: SysLog
 * Description:
 * version: v1.0.0
 * author: wangfei
 * date: 2020-01-22   15:24
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2020-01-22      wangfei          v1.0.0          创建
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysOpLog {
    /**日志-接口名称*/
    String value() default "";
    /***是否操作标识-默认1操作日志 0-登录日志*/
    String isOp() default "1";
}
