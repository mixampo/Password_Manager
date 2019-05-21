package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IUserContainerRepo;

@Component
public class UserContainerService implements IUserContainerService {

    @Autowired
    private IUserContainerRepo repo;
}
