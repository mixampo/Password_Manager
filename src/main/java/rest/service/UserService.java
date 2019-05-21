package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IUserRepo;

@Component
public class UserService implements IUserService {

    @Autowired
    private IUserRepo repo;
}
