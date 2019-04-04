package com.zxl.zboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.zxl.zboot.mapper")
@EnableCaching
public class ZBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZBootApplication.class, args);
    }


}

