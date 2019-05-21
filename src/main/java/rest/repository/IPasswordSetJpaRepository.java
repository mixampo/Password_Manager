package rest.repository;

import models.PasswordSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPasswordSetJpaRepository extends JpaRepository<PasswordSet, Integer> {

}
