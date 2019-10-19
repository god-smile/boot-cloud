package com.zxcv.commom.redis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * Copyright: Copyright (c) 2018  zteits
 *
 * @Description:
 * @version: v1.0.0
 * @author: xiejianpeng
 * @date: 2019/6/18 17:32
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2019/6/18     xiejianpeng         v1.0.0               创建
 */
@Component
public class RedisCacheFactory implements ApplicationContextAware {

	private static RedisUtils redisUtils;

	private RedisCacheFactory() {
	}

	public static RedisUtils getRedisUtils() {
		return redisUtils;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(redisUtils == null){
			redisUtils = applicationContext.getBean(RedisUtils.class);
		}
	}

}
