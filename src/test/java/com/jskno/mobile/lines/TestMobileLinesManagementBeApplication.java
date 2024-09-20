package com.jskno.mobile.lines;

import org.springframework.boot.SpringApplication;

public class TestMobileLinesManagementBeApplication {

    public static void main(String[] args) {
        SpringApplication.from(MobileLinesManagementBeApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
