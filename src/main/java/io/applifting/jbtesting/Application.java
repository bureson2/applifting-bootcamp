package io.applifting.jbtesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

//    public static void main(String[] args) {
//       SpringApplication.run(Application.class, args);
//    }

    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class)
            .properties("spring.config.location=classpath:application.yaml,classpath:application.yaml");
        app.run(args);
    }
}
