package rest.repository;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginJpaRepository extends JpaRepository<User, Integer> {
    User findUserByUsernameAndPassword(String username, String password);
}
