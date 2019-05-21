package rest.service;

import models.PasswordSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IPasswordSetContainerRepo;
import java.util.List;

@Component
public class PasswordSetContainerService implements IPasswordSetContainerService {

    @Autowired
    private IPasswordSetContainerRepo repo;

    public List<PasswordSet> getPasswordSets(){return repo.getPasswordSets();}

    public void addPasswordSet(PasswordSet passwordSet){repo.addPasswordSet(passwordSet);}

    public PasswordSet getPasswordSetById(int id){
        PasswordSet tmpPasswordSet = repo.getPasswordSetById(id);
        PasswordSet jsonObject = new PasswordSet(tmpPasswordSet.getId(), tmpPasswordSet.getPassword(), tmpPasswordSet.getTitle(),
                tmpPasswordSet.getWebsiteUrl(), tmpPasswordSet.getDescription(), tmpPasswordSet.getUser());
        return jsonObject;
    }

    public void deletePasswordSet(PasswordSet passwordSet){repo.deletePasswordSet(passwordSet);}
}
