package com.zxcv.commom.web;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * Copyright: Copyright (c) 2017  ZTE-ITS
 * 
 * @ClassName: SpringContextUtil.java
 * @Description: 
 * @version: v1.0.0
 * @author: wangbiao
 * @date: 2017年5月19日   上午10:21:23 
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2017年5月19日      wangbiao           v1.0.0               创建
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringContextUtil.applicationContext == null) {
			SpringContextUtil.applicationContext = applicationContext;
		}
	}

	/**
	 * 获取applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 通过name获取 Bean.
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	/**
	 * 通过class获取Bean
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}
	
	/**
	 * 通过key获取系统已加载的property值
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return getApplicationContext().getEnvironment().getProperty(key);
	}
}
