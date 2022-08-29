package bootcamp.soloproject.controller;

import bootcamp.soloproject.model.User;
import bootcamp.soloproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "/user/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/user/{userId}/email")
    public Optional<User> changeEmail(@RequestBody String email, @PathVariable Long userId){
        return userService.changeEmail(email, userId);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/user/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

}
