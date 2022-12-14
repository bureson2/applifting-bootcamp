package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.MonitoringResultRepository;
import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.MonitoringResult;
import bootcamp.soloproject.model.User;
import bootcamp.soloproject.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class MonitoringResultServiceTest {

    @Autowired
    private MonitoringResultService stu;

    @Autowired
    private MonitoredEndpointService monitoredEndpointService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private MonitoringResultRepository resultDao;

    private User testUser;
    private User testUser2;
    private MonitoredEndpoint testEndpoint;
    private MonitoredEndpoint testEndpoint2;

    private MonitoringResult testResult;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(Long.parseLong("1"));
        testUser.setUsername("Username");
        testUser.setEmail("email@email.com");
        testUser.setAccesToken(UUID.randomUUID());
        testUser = userServiceImpl.createUser(testUser).get();
        testUser2 = new User();
        testUser2.setId(Long.parseLong("1"));
        testUser2.setUsername("Username");
        testUser2.setEmail("email@email.com");
        testUser2.setAccesToken(UUID.randomUUID());
        testUser2 = userServiceImpl.createUser(testUser2).get();
        testEndpoint = new MonitoredEndpoint();
        testEndpoint.setName("endpoint-name");
        testEndpoint.setUri("http://localhost:8080/users");
        testEndpoint.setMonitoredInterval(1);
        testEndpoint = monitoredEndpointService.addMonitoredEndpoint(testEndpoint, testUser.getId()).get();
        testEndpoint2 = new MonitoredEndpoint();
        testEndpoint2.setName("endpoint-name");
        testEndpoint2.setUri("http://localhost:8080/users");
        testEndpoint2.setMonitoredInterval(2);
        testEndpoint2 = monitoredEndpointService.addMonitoredEndpoint(testEndpoint2, testUser2.getId()).get();
        testResult.setReturnedPayload("json data");
        testResult.setReturnedHttpStatusCode(200);
    }

    @Test
    void shouldCreateMonitoringResult(){
        MonitoringResult result = stu.saveMonitoringResult(testResult, testEndpoint.getId()).get();
        assertEquals(
                testResult,
                resultDao.findById(result.getId()).get()
        );
    }

    @Test
    void shouldReturnNotEmptyResults() throws InterruptedException {
        Thread.sleep(2000);
        assertNotEquals(
                0,
                resultDao.findAll().toArray().length
        );
        assertNotEquals(
                0,
                stu.getMonitoringResults().toArray().length
        );
        assertNotEquals(
                0,
                stu.getEndpointResults(testEndpoint.getId()).toArray().length
        );
        assertNotEquals(
                0,
                stu.getUserResults(testUser.getId()).toArray().length
        );
    }

    @Test
    void shouldNotHasSameCountOfResults() throws InterruptedException {
        Thread.sleep(3000);
        assertNotEquals(
                stu.getEndpointResults(testEndpoint.getId()).toArray().length,
                stu.getEndpointResults(testUser2.getId()).toArray().length
        );
    }

    @Test
    void shouldDeleteMonitoringResult(){
        MonitoringResult result = stu.saveMonitoringResult(testResult, testEndpoint.getId()).get();
        stu.deleteMonitoringResult(result.getId());
        assertNull(
          resultDao.findById(result.getId())
        );
    }



}