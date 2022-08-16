package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithRestAndDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithRestAndDbApplication.class, args);
        System.out.println("Server is up and running");
    }

}
