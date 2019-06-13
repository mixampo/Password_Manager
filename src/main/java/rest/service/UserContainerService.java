package rest.service;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IUserContainerRepo;
import java.util.Optional;

@Component
public class UserContainerService implements IUserContainerService {

    @Autowired
    private IUserContainerRepo repo;

    @Override
    public Boolean addUser(User user){
        if (repo.getUserByUsername(user.getUsername()) == null){
            repo.addUser(user);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public User getUserByUsername(User user){return repo.getUserByUsername(user.getUsername());}
}
