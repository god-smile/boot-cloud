package com.zxcv.commom.constants;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: com.zteits.oauth.portal.constants
 * @Description:
 * @version: v1.0.0
 * @author: atao
 * @date: 2017/5/9   下午4:19
 * Modification History:
 * Date         Author          Version      Description
 * ---------------------------------------------------------*
 * 2017/5/9      atao          v1.0.0          创建
 */
public class TimeConstants {

    /**
     * 1 小时 的秒数
     */
    public static final long SECOND_1_HOUR = 60 * 60L;

    /**
     * 12 小时 的秒数
     */
    public static final long SECOND_12_HOUR = 60 * 60 * 12L;

    /**
     * 1 天 的秒数
     */
    public static final long SECOND_1_DAY = SECOND_1_HOUR * 24;

    /**
     * 1 周 的秒数
     */
    public static final long SECOND_1_WEEK = SECOND_1_DAY * 7;

    /**
     * 1 月 的秒数,默认一月30天
     */
    public static final long SECOND_1_MONTH_DEFAULT_30DAYS = SECOND_1_DAY * 30;

    /**
     * 1 年 的秒数,默认一年365天
     */
    public static final long SECOND_1_YEAR_EFAULT_365DAYS = SECOND_1_DAY * 365;

    /**
     * 支付时，对订单锁定时间
     */
    public static final long ORDER_LOOK_SECOND_FOR_PAYING = 5L;

}
