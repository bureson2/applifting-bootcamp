package bootcamp.soloproject.service;

import bootcamp.soloproject.interfaces.UserRepository;
import bootcamp.soloproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userDao;

    public List<User> getUsers(){
        return userDao.findAll();
    }

//    TODO POST - Create new user
//    TODO PUT - edit email
//    TODO PUT - edit acces_token
//    TODO DELETE user


//    TODO SECURITY ?


}
