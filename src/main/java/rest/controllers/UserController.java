package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import rest.service.IUserContainerService;
import rest.service.IUserService;

@RestController
public class UserController {

    @Autowired
    private IUserContainerService userContainerService;

    @Autowired
    private IUserService userService;
}
