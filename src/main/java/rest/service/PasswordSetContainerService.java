package rest.service;

import javafx.scene.Parent;
import models.PasswordSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IPasswordSetContainerRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class PasswordSetContainerService implements IPasswordSetContainerService {

    @Autowired
    private IPasswordSetContainerRepo repo;

    @Override
    public List<PasswordSet> getPasswordSets(int id){

        List<PasswordSet> passwordSets = repo.getPasswordSets(id);
        List<PasswordSet> filteredPasswordSets = new ArrayList<>();

        for (PasswordSet passwordSet : passwordSets){
            if (passwordSet.getUser().getId() == id){
                filteredPasswordSets.add(passwordSet);
            }
        }
        return filteredPasswordSets;
    }

    @Override
    public void addPasswordSet(PasswordSet passwordSet){repo.addPasswordSet(passwordSet);}

    @Override
    public PasswordSet getPasswordSetById(int id){
        PasswordSet tmpPasswordSet = repo.getPasswordSetById(id);
        PasswordSet jsonObject = new PasswordSet(tmpPasswordSet.getId(), tmpPasswordSet.getPassword(), tmpPasswordSet.getTitle(),
                tmpPasswordSet.getWebsiteUrl(), tmpPasswordSet.getDescription(), tmpPasswordSet.getUser());
        return jsonObject;
    }

    @Override
    public void deletePasswordSet(PasswordSet passwordSet){repo.deletePasswordSet(passwordSet);}
}
