package rest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements IUserRepo, IUserContainerRepo{

    //verder
    @Autowired
    private IUserJpaRepository repo;
}
