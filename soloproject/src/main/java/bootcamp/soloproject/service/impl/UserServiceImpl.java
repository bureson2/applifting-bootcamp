package bootcamp.soloproject.service.impl;

import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.User;
import bootcamp.soloproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl{

    private static final String EMAIL_REGEXP = "(?i)^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

    @Autowired
    private UserRepository userDao;

    public Optional<User> getUser(Long userId) {
        return userDao.findById(userId);
    }

    public List<User> getUsers() {
        return userDao.findAll();
    }

    public Optional<User> createUser(User user) {
        String normalizedEmail = user.getEmail().trim().toLowerCase(Locale.ROOT);
        Pattern pattern = Pattern.compile(EMAIL_REGEXP);
        if (pattern.matcher(normalizedEmail).find()) {
            userDao.save(user);
            return userDao.findById(user.getId());
        }
        return null; // TODO error handling
    }

    public Optional<User> changeEmail(String email, Long userId) {
        Optional<User> user = userDao.findById(userId);
        String normalizedEmail = email.trim().toLowerCase(Locale.ROOT);
        Pattern pattern = Pattern.compile(EMAIL_REGEXP);
        if (user.isPresent() && pattern.matcher(normalizedEmail).find()) {
            user.get().setEmail(email);
            userDao.save(user.get());
        } else {
            return Optional.empty(); // TODO acces denied
        }
        return user;
    }

    public void deleteUser(Long userId) {
        userDao.deleteById(userId);
    }
}
