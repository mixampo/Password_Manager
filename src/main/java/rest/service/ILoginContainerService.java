package rest.service;

import models.User;

public interface ILoginContainerService {
    boolean loginAndAuthenticate(User user);
}
