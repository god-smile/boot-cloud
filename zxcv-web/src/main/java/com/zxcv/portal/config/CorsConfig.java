package com.zxcv.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Copyright: Copyright (c) 2017  zteits
 *
 * @ClassName: CorsConfig.java
 * @Description:
 * @version: v1.0.0
 * @author: wangfs
 * @date: 2019-04-15 13:28
 * Modification History:
 * Date             Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-04-15     wangfs              v1.0.0               创建
 */
@Configuration
public class CorsConfig  {

    private CorsConfiguration buildConfig() {
        System.out.println("进入跨域拦截请求....");
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1 设置访问源地址
        corsConfiguration.addAllowedHeader("*"); // 2 设置访问源请求头
        corsConfiguration.addAllowedMethod("*"); // 3 设置访问源请求方法
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(1800L);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }

}
