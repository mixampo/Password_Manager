package rest.repository;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserJpaRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
    //Optional<User> findUsersByUsernameMatches(String username);
}
