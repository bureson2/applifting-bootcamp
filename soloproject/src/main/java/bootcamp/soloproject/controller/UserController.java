package bootcamp.soloproject.controller;

import bootcamp.soloproject.model.User;
import bootcamp.soloproject.security.AuthorizedControlService;
import bootcamp.soloproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorizedControlService controlService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        if (controlService.hasAcces()) {
            return userService.getUsers();
        }
        return new ArrayList<>(); // TODO acces denied
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(value = "/public/user/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/user/{userId}/email")
    public Optional<User> changeEmail(@RequestBody String email, @PathVariable Long userId) {
        User user = userService.getUser(userId).get(); // TODO KONTROLA
        if (controlService.hasAcces(user.getUsername())) {
            return userService.changeEmail(email, userId);
        }
        return null; // TODO acces denied
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        User user = userService.getUser(userId).get();
        if (controlService.hasAcces(user.getUsername())) {
            userService.deleteUser(userId);
        }
    }

    @GetMapping("/public/current/user")
    public Object getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
