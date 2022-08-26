package com.example.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Demo01Application {

//    public static void main(String[] args) {
//        SpringApplication.run(Demo01Application.class, args);
//    }

    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(Demo01Application.class)
                .properties("spring.config.location=classpath:application.yaml,classpath:application.yaml");
        app.run(args);

    }

}
