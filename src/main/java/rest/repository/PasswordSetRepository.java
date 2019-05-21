package rest.repository;

import models.PasswordSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PasswordSetRepository implements IPasswordSetRepo, IPasswordSetContainerRepo {

    @Autowired
    private IPasswordSetJpaRepository repo;

    public List<PasswordSet> getPasswordSets(){return repo.findAll();}

    public void addPasswordSet(PasswordSet passwordSet){repo.save(passwordSet);}

    public void updatePasswordSet(PasswordSet passwordSet){repo.save(passwordSet);}

    public PasswordSet getPasswordSetById(int id){return repo.getOne(id);}

    public void deletePasswordSet(PasswordSet passwordSet){repo.delete(passwordSet);}
}
