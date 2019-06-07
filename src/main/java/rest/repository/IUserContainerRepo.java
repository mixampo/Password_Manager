package rest.repository;

import models.User;

public interface IUserContainerRepo {
    User getUserByUsername(String username);
    User getUserById(int id);
}
