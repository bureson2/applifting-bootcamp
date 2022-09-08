package bootcamp.soloproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SoloprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloprojectApplication.class, args);
    }

//    public static void main(String[] args) {
//        SpringApplicationBuilder app = new SpringApplicationBuilder(SoloprojectApplication.class)
//                .properties("spring.config.location=classpath:application.yaml,classpath:application.yaml");
//        app.run(args);
//    }
}
