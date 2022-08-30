package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.MonitoredEndpointRepository;
import bootcamp.soloproject.model.MonitoredEndpoint;
import bootcamp.soloproject.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MonitoredEndpointServiceTest {

    @Autowired
    private MonitoredEndpointService stu;

    @Autowired
    private UserService userService;

    @Autowired
    private MonitoredEndpointRepository endpointDao;

    private User testUser;
    private User testUser2;
    private MonitoredEndpoint testEndpoint;
    private MonitoredEndpoint testEndpoint2;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(Long.parseLong("1"));
        testUser.setUsername("Username");
        testUser.setEmail("email@email.com");
        testUser.setAccesToken(UUID.randomUUID());
        testUser = userService.createUser(testUser).get();
        testUser2 = new User();
        testUser2.setId(Long.parseLong("1"));
        testUser2.setUsername("Username");
        testUser2.setEmail("email@email.com");
        testUser2.setAccesToken(UUID.randomUUID());
        testUser2 = userService.createUser(testUser2).get();
        testEndpoint = new MonitoredEndpoint();
        testEndpoint.setName("endpoint-name");
        testEndpoint.setUri("http://localhost:8080/users");
        testEndpoint.setMonitoredInterval(5);
        testEndpoint2 = new MonitoredEndpoint();
        testEndpoint2.setName("endpoint-name");
        testEndpoint2.setUri("http://localhost:8080/users");
        testEndpoint2.setMonitoredInterval(5);
    }

    @Test
    void shouldCreateMonitoredEndpoint(){

        MonitoredEndpoint result = stu.addMonitoredEndpoint(testEndpoint, testUser.getId()).get();
        assertEquals(
                testEndpoint.getName(),
                endpointDao.findById(result.getId()).get().getName()
        );
        assertEquals(
                testEndpoint.getUri(),
                endpointDao.findById(result.getId()).get().getUri()
        );
        assertEquals(
                testEndpoint.getMonitoredInterval(),
                endpointDao.findById(result.getId()).get().getMonitoredInterval()
        );
    }

    @Test
    void shouldReturnTwoMonitoredEndpoint(){
        stu.addMonitoredEndpoint(testEndpoint, testUser.getId()).get();
        stu.addMonitoredEndpoint(testEndpoint2, testUser2.getId()).get();
        assertEquals(
                2,
                stu.getMonitoredEndpoints().toArray().length
        );
    }

    @Test
    void shouldReturnOneMonitoredEndpoint(){
        stu.addMonitoredEndpoint(testEndpoint, testUser.getId()).get();
        stu.addMonitoredEndpoint(testEndpoint2, testUser2.getId()).get();
        assertEquals(
                1,
                stu.getUsersMonitoredEndpoints(testUser.getId()).toArray().length
        );
    }

    @Test
    void shouldChangeOwner(){
        MonitoredEndpoint result = stu.addMonitoredEndpoint(testEndpoint, testUser.getId()).get();
        stu.changeOwner(result.getId(), testUser2.getId());
        assertEquals(
                testUser2,
                endpointDao.findById(result.getId()).get().getOwner()
        );
    }

    @Test
    void shouldDeleteEndpoint(){
        MonitoredEndpoint result = stu.addMonitoredEndpoint(testEndpoint, testUser.getId()).get();
        stu.deleteMonitoredEndpoint(result.getId());
        assertNull(
                endpointDao.findById(result.getId())
        );
    }
}