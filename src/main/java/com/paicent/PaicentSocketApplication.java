package com.paicent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PaicentSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaicentSocketApplication.class, args);
    }

}
