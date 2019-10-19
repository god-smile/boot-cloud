package com.zxcv.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableSwagger2
@ImportResource(value = {"classpath:dubbo/dubbo-web-consumer.xml"})
@ComponentScan(basePackages={"com.zxcv.portal","com.zxcv.commom.redis"})

public class ZXCVWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZXCVWebApplication.class, args);
    }

}
