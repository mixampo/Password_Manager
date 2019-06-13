package rest.repository;

import models.User;

import java.util.Optional;

public interface IUserContainerRepo {
    void addUser(User user);
    User getUserByUsername(String username);
    User getUserById(int id);
}
