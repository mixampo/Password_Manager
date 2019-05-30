package rest.controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.service.ILoginContainerService;

@RestController
public class LoginController {

    @Autowired
    private ILoginContainerService loginContainerService;

    @PostMapping(value = "/login", headers = "Accept=application/json")
    public ResponseEntity<String> loginAndAuthenticate(@RequestBody User user){
        HttpHeaders headers = new HttpHeaders();
        if (loginContainerService.loginAndAuthenticate(user)){
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
    }

}
