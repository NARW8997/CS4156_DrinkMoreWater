package com.cs4256.drinkmorewater;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cs4256.drinkmorewater.mapper")
public class DrinkMoreWaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrinkMoreWaterApplication.class, args);
    }
}
