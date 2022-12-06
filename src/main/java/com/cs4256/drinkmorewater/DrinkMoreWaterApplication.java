package com.cs4256.drinkmorewater;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.cs4256.drinkmorewater.mapper")
public class DrinkMoreWaterApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DrinkMoreWaterApplication.class, args);
    }
}
