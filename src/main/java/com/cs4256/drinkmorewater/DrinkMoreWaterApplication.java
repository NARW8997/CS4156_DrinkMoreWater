package com.cs4256.drinkmorewater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DrinkMoreWaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrinkMoreWaterApplication.class, args);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<?> getByHello() {
        String res = "hello there";

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
