package com.zxcv.busi.configs;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 异步监听配置
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: ListenerAsyncConfiguration.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-08-16 09:33
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-08-16     wangfs              v1.0.0               创建
 */
@Configuration
@EnableAsync
public class ListenerAsyncConfiguration implements AsyncConfigurer {
    /**
     * 获取异步线程池执行对象
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        //使用Spring内置线程池任务对象
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置线程池参数
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
