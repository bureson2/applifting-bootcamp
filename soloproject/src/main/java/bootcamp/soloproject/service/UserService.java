package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UserService {

    private static final String EMAIL_REGEXP = "(?i)^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

    @Autowired
    private UserRepository userDao;

    @Autowired
    private AuthorizedControlService controlService;

    public List<User> getUsers(){
        return userDao.findAll();
    }

    public Optional<User> createUser(User user){
        userDao.save(user);
        return userDao.findById(user.getId());
    }

    public Optional<User> changeEmail(String email, Long userId){
        Optional<User> user = userDao.findById(userId);
        String normalizedEmail = email.trim().toLowerCase(Locale.ROOT);
        Pattern pattern = Pattern.compile(EMAIL_REGEXP);

        if (user.isPresent() && pattern.matcher(normalizedEmail).find()) {
            if(controlService.hasAccesToEndpoint(user.get().getUsername())){
                user.get().setEmail(email);
                userDao.save(user.get());
            }
        } else {
            return Optional.empty();
        }
        return user;
    }

    public void deleteUser(Long userId){
        Optional<User> user = userDao.findById(userId);
        if(controlService.hasAccesToEndpoint(user.get().getUsername())){
            userDao.deleteById(userId);
        }
    }

//    TODO SECURITY ?
}
