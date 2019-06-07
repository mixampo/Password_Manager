package rest.repository;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginRepository implements ILoginContainerRepo {

    @Autowired
    private ILoginJpaRepository repo;

    @Override
    public User loginAndAuthenticate(User user){return repo.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());}
}
