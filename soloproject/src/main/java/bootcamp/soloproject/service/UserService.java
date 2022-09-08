package bootcamp.soloproject.service;

import bootcamp.soloproject.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public List<User> getUsers();

    Optional<User> createUser(User user);

    public Optional<User> changeEmail(String email, Long userId);

    public void deleteUser(Long userId);
}
