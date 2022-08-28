package bootcamp.soloproject.controller;

import bootcamp.soloproject.model.User;
import bootcamp.soloproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/user/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @PutMapping(value = "/user/{userId}/email")
    public Optional<User> changeEmail(@RequestBody String email, @PathVariable Long userId){
        return userService.changeEmail(email, userId);
    }

//    TODO - oprava
    @PutMapping(value = "/user/{userId}/token", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> changeEmail(@RequestBody UUID accesToken, @PathVariable Long userId){
        return userService.changeAccesToken(accesToken, userId);
    }

    @DeleteMapping(value = "/user/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

}
