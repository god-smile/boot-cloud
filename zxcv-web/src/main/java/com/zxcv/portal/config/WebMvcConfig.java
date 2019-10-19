package com.zxcv.portal.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.zxcv.portal.config.interceptor.AuthInterceptor;

/**
 * @author atao
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;


    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加验证拦截器
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html/**")
                .excludePathPatterns("/oAuth/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/**")
        ;
    }

    /**
     * 添加资源拦截器.<br/>
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    /**
     * @Override public void addCorsMappings(CorsRegistry registry) {
     * registry.addMapping("/**")
     * .allowCredentials(true)
     * .allowedHeaders("*")
     * .allowedMethods("*")
     * .allowCredentials(true)
     * .allowedOrigins("*")
     * .maxAge(1800)
     * ;
     * }
     */

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig jsonConfig = new FastJsonConfig();
        jsonConfig.setCharset(Charset.forName("utf-8"));
        /**json禁用循环依赖:json串返回前端有：$ref.data格式数据.*/
        jsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
        //jsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonHttpMessageConverter.setFastJsonConfig(jsonConfig);
        List<MediaType> mediaTypes = new ArrayList();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        converters.add(fastJsonHttpMessageConverter);
    }

}
