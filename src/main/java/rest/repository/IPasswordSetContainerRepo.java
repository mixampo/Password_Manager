package rest.repository;

import models.PasswordSet;
import java.util.List;

public interface IPasswordSetContainerRepo {
    List<PasswordSet> getPasswordSets();
    void addPasswordSet(PasswordSet passwordSet);
    PasswordSet getPasswordSetById(int id);
    void deletePasswordSet(PasswordSet passwordSet);
}
