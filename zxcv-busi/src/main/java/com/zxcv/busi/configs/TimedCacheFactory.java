package com.zxcv.busi.configs;

import cn.hutool.cache.impl.TimedCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定时缓存，对被缓存的对象定义一个过期时间，当对象超过过期时间会被清理。此缓存没有容量限制，对象只有在过期后才会被移除。.<br/>
 * 如果用户在超时前调用了get(key)方法，会重头计算起始时间。举个例子，用户设置key1的超时时间5s，用户在4s的时候调用了get("key1")，此时超时时间重新计算，再过4s调用get("key1")方法值依旧存在。如果想避开这个机制，请调用get("key1", false)方法。

 说明
 如果启动了定时器，那会定时清理缓存中的过期值，但是如果不起动，那只有在get这个值得时候才检查过期并清理。不起动定时器带来的问题是：有些值如果长时间不访问，会占用缓存的空间。
 *
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: TimedCacheFactory
 * @Description:
 * @version: v1.0.0
 * @author: zhaowg
 * @date: 2018/10/10 15:11
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2018/10/10      zhaowg           v1.0.0               创建
 */
public class TimedCacheFactory {
	private static final Logger logger = LoggerFactory.getLogger(TimedCacheFactory.class);

	private static TimedCache<String, String> timedCache;

	static{
		logger.info("timedCache未创建，创建TimedCache,缓存1分钟");
		//缓存1分钟
		timedCache = new TimedCache(1000*60);
		//启动定时任务，每1分钟检查一次过期
		timedCache.schedulePrune(1000*60*10);
	}
	private TimedCacheFactory() {
	}

	public static TimedCache<String, String> getTimedCache(){
		return timedCache;
	}

}
