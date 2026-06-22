package com.smallming.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SmallmingErpApplication
 * @Description TODO
 * @Author smallming
 * @Date 2026/4/26 21:00
 **/
@SpringBootApplication
@MapperScan("com.smallming.erp.mapper")
public class SmallmingErpApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmallmingErpApplication.class, args);
    }
}
