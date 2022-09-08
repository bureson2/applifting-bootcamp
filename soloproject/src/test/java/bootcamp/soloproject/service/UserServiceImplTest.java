package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.User;
import bootcamp.soloproject.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userDao;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setUsername("Username");
        testUser.setEmail("email@email.com");
        testUser.setAccesToken(UUID.randomUUID());
    }

    @Test
    void shouldCreateNewUser(){
        User result = userService.createUser(testUser).get();
        assertEquals(
                testUser.getUsername(),
                result.getUsername()
        );
        assertEquals(
                testUser.getEmail(),
                result.getEmail()
        );
        assertEquals(
                testUser.getAccesToken(),
                result.getAccesToken()
        );
    }

    @Test
    void shouldChangeEmail(){
        User resultUser = userService.createUser(testUser).get();
        String email = "newemail@email.com";
        userService.changeEmail(email, resultUser.getId());
        assertEquals(
                email,
                userDao.findById(resultUser.getId()).get().getEmail()
        );
    }

    @Test
    void shouldNotChangeEmail(){
        User resultUser = userService.createUser(testUser).get();
        String email = "newemail@.com";
        assertNull(
                userService.changeEmail(email, resultUser.getId())
        );
    }

    @Test
    void shouldDeleteUser(){
        User resultUser = userService.createUser(testUser).get();
        userService.deleteUser(resultUser.getId());
        assertNull(
                userDao.findById(resultUser.getId())
        );
    }

    @Test
    void shouldReturnOneUser(){
        userService.createUser(testUser);
        List<User> users = userService.getUsers();
        assertEquals(
                1,
                users.toArray().length
        );
    }
}