package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.MonitoringResultRepository;
import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.MonitoringResult;
import bootcamp.soloproject.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MonitoringResultServiceTest {

    @Autowired
    private MonitoringResultService stu;

    @Autowired
    private MonitoredEndpointService monitoredEndpointService;

    @Autowired
    private UserService userService;

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
        userService.createUser(testUser);
        testUser2 = new User();
        testUser2.setId(Long.parseLong("1"));
        testUser2.setUsername("Username");
        testUser2.setEmail("email@email.com");
        testUser2.setAccesToken(UUID.randomUUID());
        userService.createUser(testUser2);
        testEndpoint = new MonitoredEndpoint();
        testEndpoint.setName("endpoint-name");
        testEndpoint.setUri("http://localhost:8080/users");
        testEndpoint.setMonitoredInterval(1);
        monitoredEndpointService.addMonitoredEndpoint(testEndpoint, testUser.getId());
        testEndpoint2 = new MonitoredEndpoint();
        testEndpoint2.setName("endpoint-name");
        testEndpoint2.setUri("http://localhost:8080/users");
        testEndpoint2.setMonitoredInterval(2);
        monitoredEndpointService.addMonitoredEndpoint(testEndpoint2, testUser2.getId());
        testResult.setReturnedPayload("json data");
        testResult.setReturnedHttpStatusCode(200);
    }

    @Test
    void shouldCreateMonitoringResult(){
        stu.saveMonitoringResult(testResult, testEndpoint.getId());
        assertEquals(
                testResult,
                resultDao.findById(testResult.getId()).get()
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
        stu.saveMonitoringResult(testResult, testEndpoint.getId());
        stu.deleteMonitoringResult(testResult.getId());
        assertNull(
          resultDao.findById(testResult.getId())
        );
    }



}