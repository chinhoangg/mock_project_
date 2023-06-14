package com.example.mock_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MockProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(MockProjectApplication.class, args);
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String rawPassword = "1211";
//        String encodedPassword = encoder.encode(rawPassword);
//        System.out.println(encodedPassword);
    }

}
