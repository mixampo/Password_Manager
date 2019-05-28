package rest.repository;

import models.PasswordSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PasswordSetRepository implements IPasswordSetRepo, IPasswordSetContainerRepo {

    @Autowired
    private IPasswordSetJpaRepository repo;

    @Override
    public List<PasswordSet> getPasswordSets(int id){return repo.findAll();}

    @Override
    public void addPasswordSet(PasswordSet passwordSet){repo.save(passwordSet);}

    @Override
    public void updatePasswordSet(PasswordSet passwordSet){repo.save(passwordSet);}

    @Override
    public PasswordSet getPasswordSetById(int id){return repo.getOne(id);}

    @Override
    public void deletePasswordSet(PasswordSet passwordSet){repo.delete(passwordSet);}
}
