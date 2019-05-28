package rest.service;

import models.PasswordSet;
import java.util.List;

public interface IPasswordSetContainerService {
    List<PasswordSet> getPasswordSets(int id);
    void addPasswordSet(PasswordSet passwordSet);
    PasswordSet getPasswordSetById(int id);
    void deletePasswordSet(PasswordSet passwordSet);
}
