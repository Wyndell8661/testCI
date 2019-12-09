package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demo.mappers")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        Log logger = LogFactory.getLog(SpringApplication.class);
        logger.error("项目启动");
        SpringApplication.run(DemoApplication.class, args);
    }

}
