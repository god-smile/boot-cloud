package com.zxcv.busi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value={"classpath:dubbo/dubbo-busi-consumer.xml","classpath:dubbo/dubbo-busi-provider.xml"})
@ComponentScan(basePackages ={"com.zxcv.busi","com.zxcv.commom.redis"})
public class ZXCVBusiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZXCVBusiApplication.class, args);
    }

}
