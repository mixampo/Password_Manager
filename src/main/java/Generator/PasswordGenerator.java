package Generator;

import org.apache.commons.lang3.RandomStringUtils;
import rest.service.IPasswordSetService;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class PasswordGenerator implements IPasswordGenerator {

    public String generateHexKey(int bitSize) throws NoSuchAlgorithmException{
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            keyGen.init(bitSize);
            SecretKey secretKey = keyGen.generateKey();
            //String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    public String generatePasswordByUserSpecification(boolean upperCase, boolean lowerCase, boolean special, boolean digits, int length){
        String possibleUpperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String possibleLowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
        String possibleSpecialCharacters = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String possibleDigits = "0123456789";
        String userSpecifiedCombination = "";

        if (upperCase){
            userSpecifiedCombination += possibleUpperCaseCharacters;
        }
        if (lowerCase){
            userSpecifiedCombination += possibleLowerCaseCharacters;
        }
        if (special){
            userSpecifiedCombination += possibleSpecialCharacters;
        }
        if (digits){
            userSpecifiedCombination += possibleDigits;
        }

        return RandomStringUtils.random(length, userSpecifiedCombination);
    }
}
