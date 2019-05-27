package rest.repository;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginRepository implements ILoginContainerRepo {

    @Autowired
    private ILoginJpaRepository repo;

    public User loginAndAuthenticate(User user){return repo.findUserByUserNameAndLoginKey(user.getUserName(), user.getLoginKey());}
}
