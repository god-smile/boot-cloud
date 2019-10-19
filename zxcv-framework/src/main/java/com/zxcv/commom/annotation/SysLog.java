package com.zxcv.commom.annotation;

import java.lang.annotation.*;

/**
 * Copyright: Copyright (c) 2019  ZTE-ITS
 *
 * @Description:
 * @ProjectName: park-clouds
 * @Package: com.zxcv.commom.annotation
 * @ClassName: SysLog
 * Modification History:
 * Date         Author          Version         Description
 * ---------------------------------------------------------*
 * 2019-06-19      wb        v1.0.0          创建
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    /**日志显示值*/
    String value() default "";
    /***日志描述*/
    String desc() default "";
}
