package bootcamp.soloproject;

import bootcamp.soloproject.service.MonitoredEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SoloprojectApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(SoloprojectApplication.class, args);
//    }

    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(SoloprojectApplication.class)
                .properties("spring.config.location=classpath:application.yaml,classpath:application.yaml");
        app.run(args);

    }

}
