package rest.service;

import models.PasswordSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IPasswordSetRepo;

@Component
public class PasswordSetService implements IPasswordSetService {

    @Autowired
    private IPasswordSetRepo repo;

    public void updatePasswordSet(PasswordSet passwordSet){repo.updatePasswordSet(passwordSet);}
}
