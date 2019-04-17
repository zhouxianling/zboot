package com.zxl.zboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ZBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZBootApplication.class, args);
    }


}

