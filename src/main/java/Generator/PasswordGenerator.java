package Generator;

import rest.service.IPasswordSetService;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class PasswordGenerator implements IPasswordGenerator {

    public String generateHexKey() throws NoSuchAlgorithmException{

            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            return encodedKey;
    }

    public String generatePasswordByUserSpecification(){
        return "kek";
    }
}
