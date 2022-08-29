package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/application.yaml")
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService stu;
//
    @Autowired
    private UserRepository userDao;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(Long.parseLong("1"));
        testUser.setUsername("Username");
        testUser.setEmail("email@email.com");
        testUser.setAccesToken(UUID.randomUUID());
    }

    @Test
    public void shouldCreateNewUser(){
        stu.createUser(testUser);
        assertEquals(
                testUser,
                userDao.findById(testUser.getId())
        );
    }

    @Test
    public void test(){
        assertTrue(true);
    }
}