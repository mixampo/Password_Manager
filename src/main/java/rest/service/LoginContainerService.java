package rest.service;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.ILoginContainerRepo;

@Component
public class LoginContainerService implements ILoginContainerService {

    @Autowired
    private ILoginContainerRepo repo;

    public boolean loginAndAuthenticate(User user){
        if (user.getUserName().equals(repo.loginAndAuthenticate(user).getUserName())){
            if (user.getPassword().equals(repo.loginAndAuthenticate(user).getPassword())){
                return true;
            }
        }
        return false;
    }
}