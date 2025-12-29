package com.example.examplemember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ExampleMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleMemberApplication.class, args);
    }

}
