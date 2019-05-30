package Generator;

import org.apache.commons.lang3.RandomStringUtils;
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

    public String generatePasswordByUserSpecification(int generateId){
        String possibleUpperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String possibleLowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
        String possibleSpecialCharacters = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String possibleDigits = "0123456789";
        String userSpecifiedCombination = "";
        int firstDigit = Integer.parseInt(Integer.toString(generateId).substring(0, 1));
        int secondDigit = Integer.parseInt(Integer.toString(generateId).substring(1, 2));
        int thirdDigit = Integer.parseInt(Integer.toString(generateId).substring(2, 3));
        int fourthDigit = Integer.parseInt(Integer.toString(generateId).substring(3, 4));

        if (firstDigit == 1){
            userSpecifiedCombination += possibleUpperCaseCharacters;
        }
        else if (firstDigit == 2){
            userSpecifiedCombination += possibleLowerCaseCharacters;
        }
        else if (firstDigit == 3){
            userSpecifiedCombination += possibleSpecialCharacters;
        }
        else {
            userSpecifiedCombination += possibleDigits;
        }

        if (secondDigit == 2){
            userSpecifiedCombination += possibleLowerCaseCharacters;
        }
        else if (secondDigit == 3){
            userSpecifiedCombination += possibleSpecialCharacters;
        }
        else if (secondDigit == 4){
            userSpecifiedCombination += possibleDigits;
        }

        if (thirdDigit == 3){
            userSpecifiedCombination += possibleSpecialCharacters;
        }
        else if (thirdDigit == 4){
            userSpecifiedCombination += possibleDigits;
        }

        if (fourthDigit == 4){
            userSpecifiedCombination += possibleDigits;
        }
        String password = RandomStringUtils.random(15, userSpecifiedCombination);
        return password;
    }
}
