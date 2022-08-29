package bootcamp.soloproject;

import bootcamp.soloproject.service.MonitoredEndpointService;
import bootcamp.soloproject.service.MonitoringResultService;
import bootcamp.soloproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SoloprojectApplicationTest {

    @Test
    void contextLoads(){
        ApplicationContext applicationContext = SpringApplication.run(SoloprojectApplication.class);
        SpringApplicationBuilder app = new SpringApplicationBuilder(SoloprojectApplication.class)
                .properties("spring.config.location=classpath:application.yaml,classpath:application.yaml");
        app.run();

    }
}