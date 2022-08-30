package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
 class UserServiceTest {

    @Autowired
    private UserService stu;

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
        User result = stu.createUser(testUser).get();
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
        User resultUser = stu.createUser(testUser).get();
        String email = "newemail@email.com";
        stu.changeEmail(email, resultUser.getId());
        assertEquals(
                email,
                userDao.findById(resultUser.getId()).get().getEmail()
        );
    }

    @Test
    void shouldNotChangeEmail(){
        User resultUser = stu.createUser(testUser).get();
        String email = "newemail@.com";
        assertNull(
                stu.changeEmail(email, resultUser.getId())
        );
    }

    @Test
    void shouldDeleteUser(){
        User resultUser = stu.createUser(testUser).get();
        stu.deleteUser(resultUser.getId());
        assertNull(
                userDao.findById(resultUser.getId())
        );
    }

    @Test
    void shouldReturnOneUser(){
        stu.createUser(testUser);
        List<User> users = stu.getUsers();
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