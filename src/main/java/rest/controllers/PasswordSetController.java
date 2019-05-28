package rest.controllers;

import models.PasswordSet;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rest.service.IPasswordSetContainerService;
import rest.service.IPasswordSetService;
import java.util.List;

@RestController
public class PasswordSetController {

    @Autowired
    private IPasswordSetService passwordSetService;

    @Autowired
    private IPasswordSetContainerService passwordSetContainerService;

    @GetMapping(value = "/passwordsets/{id}")
    public List<PasswordSet> getPasswordSets(@PathVariable("id") int id){return passwordSetContainerService.getPasswordSets(id);}

    @PostMapping(value = "/passwordsets/",
            headers = "Accept=application/json")
    public ResponseEntity<Void> addPasswordSet(@RequestBody PasswordSet passwordSet, UriComponentsBuilder ucBuilder){
        passwordSetContainerService.addPasswordSet(passwordSet);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/passwordset/{id}").buildAndExpand(passwordSet.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/passwordsets/{id}")
    public ResponseEntity<String> updatePasswordSet(@PathVariable("id") int id, @RequestBody PasswordSet currentPasswordSet){
        passwordSetService.updatePasswordSet(currentPasswordSet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/passwordsets/{id}")
    public ResponseEntity deletePasswordSet(@PathVariable("id") int id){
        PasswordSet passwordSet = passwordSetContainerService.getPasswordSetById(id);
        if (passwordSet == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        passwordSetContainerService.deletePasswordSet(passwordSet);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

