package com.satr;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动程序
 *
 * @author  聂建强
 */
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})  //禁用springSecurity的默认安全配置
public class HotelApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }
}
