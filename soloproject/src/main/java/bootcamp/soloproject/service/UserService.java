package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userDao;

    public List<User> getUsers(){
        return userDao.findAll();
    }

    public Optional<User> createUser(User user){
        userDao.save(user);
        return userDao.findById(user.getId());
    }

    public Optional<User> changeEmail(String email, Long userId){
        Optional<User> user = userDao.findById(userId);
        if(user.isPresent()){
            user.get().setEmail(email);
            userDao.save(user.get());
        }
        return user;
    }

    public Optional<User> changeAccesToken(UUID accesToken, Long userId){
        Optional<bootcamp.soloproject.model.User> user = userDao.findById(userId);
        if(user.isPresent()){
            user.get().setAccesToken(accesToken);
            userDao.save(user.get());
        }
        return user;
    }

//    TODO void u vsech deletu
    public void deleteUser(Long userId){
        userDao.deleteById(userId);
    }


//    TODO SECURITY ?


}
