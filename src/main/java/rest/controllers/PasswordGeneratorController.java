package rest.controllers;

import Generator.IPasswordGenerator;
import Generator.PasswordGenerator;
import models.PasswordSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class PasswordGeneratorController {
    private IPasswordGenerator passwordGenerator = new PasswordGenerator();

    @GetMapping(value = "/generatepassword")
    public ResponseEntity<String> getGeneratedHexKey() throws NoSuchAlgorithmException {return new ResponseEntity<>(passwordGenerator.generateHexKey(), HttpStatus.OK);}

    @GetMapping(value = "/generatepassword/{id}")
    public ResponseEntity<String> getUserSpecifiedGeneratedPassword(@PathVariable("id") int id){ return new ResponseEntity<>(passwordGenerator.generatePasswordByUserSpecification(id), HttpStatus.OK);}
}
