package rest.controllers;

import generator.IPasswordGenerator;
import generator.PasswordGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class PasswordGeneratorController {
    private IPasswordGenerator passwordGenerator = new PasswordGenerator();

    @GetMapping(value = "/generatepassword/{bitSize}")
    public ResponseEntity<String> getGeneratedHexKey(@PathVariable("bitSize") int bitSize) throws NoSuchAlgorithmException {return new ResponseEntity<>(passwordGenerator.generateHexKey(bitSize), HttpStatus.OK);}

    @GetMapping(value = "/generatepassword/userspecifiedchar/{length}")
    public ResponseEntity<String> getUserSpecifiedGeneratedPassword(@PathVariable("length") int length,
                                                                    @RequestParam(value = "uppercase", required = false, defaultValue = "false") boolean uppercase,
                                                                    @RequestParam(value = "lowercase", required = false, defaultValue = "false") boolean lowercase,
                                                                    @RequestParam(value = "special", required = false, defaultValue = "false") boolean special,
                                                                    @RequestParam(value = "digits", required = false, defaultValue = "false") boolean digits)

    { return new ResponseEntity<>(passwordGenerator.generatePasswordByUserSpecification(uppercase, lowercase, special, digits, length), HttpStatus.OK);}
}
