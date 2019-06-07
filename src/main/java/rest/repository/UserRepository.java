package rest.repository;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements IUserRepo, IUserContainerRepo{

    //verder
    @Autowired
    private IUserJpaRepository repo;

    @Override
    public User getUserByUsername(String username) {
        return repo.findUserByUsername(username);
    }

    @Override
    public User getUserById(int id) {
        return repo.getOne(id);
    }
}
