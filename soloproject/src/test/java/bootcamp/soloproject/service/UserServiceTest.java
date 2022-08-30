package bootcamp.soloproject.service;

import bootcamp.soloproject.SoloprojectApplication;
import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.UUID;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource(locations = "classpath:resources/application-test.properties")
@ComponentScan
@SpringBootTest
//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SoloprojectApplication.class)
 class UserServiceTest {

    @Autowired
    private UserService stu;

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
    void shouldCreateNewUser(){
        stu.createUser(testUser);
        assertEquals(
                testUser,
                userDao.findById(testUser.getId()).get()
        );
    }

    @Test
    void shouldChangeEmail(){
        stu.createUser(testUser);
        String email = "newemail@email.com";
        stu.changeEmail(email, testUser.getId());
        assertEquals(
                email,
                userDao.findById(testUser.getId()).get().getEmail()
        );
    }

    @Test
    void shouldNotChangeEmail(){
        stu.createUser(testUser);
        String email = "newemail@.com";
        assertNull(
                stu.changeEmail(email, testUser.getId())
        );
    }

    @Test
    void shouldDeleteUser(){
        stu.createUser(testUser);
        stu.deleteUser(testUser.getId());
        assertNull(
                userDao.findById(testUser.getId())
        );
    }

    @Test
    void shouldReturnOneUser(){
        stu.createUser(testUser);
        List<User> users = userDao.findAll();
        assertEquals(
                1,
                users.toArray().length
        );
    }

    @Test
    void test(){
        assertTrue(true);
    }
}