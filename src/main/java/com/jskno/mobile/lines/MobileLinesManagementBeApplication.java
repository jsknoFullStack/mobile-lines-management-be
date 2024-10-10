package com.jskno.mobile.lines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MobileLinesManagementBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileLinesManagementBeApplication.class, args);
    }

}
