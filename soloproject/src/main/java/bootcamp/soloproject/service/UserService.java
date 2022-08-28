package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

//    TODO void u vsech deletu
    public void deleteUser(Long userId){
        userDao.deleteById(userId);
    }

//    TODO PUT - edit email
//    TODO PUT - edit acces_token


//    TODO SECURITY ?


}
