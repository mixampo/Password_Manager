package generator;

import Generator.IPasswordGenerator;
import Generator.PasswordGenerator;
import org.junit.Assert;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class PasswordGeneratorTest {

    private IPasswordGenerator passwordGenerator;
    private String possibleSpecialCharacters;

    @Before
    public void TestInitialize() {
        this.passwordGenerator = new PasswordGenerator();
        possibleSpecialCharacters = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
    }

    @Test
    public void TestCreateHexKey128Bits() throws NoSuchAlgorithmException {
        String key = passwordGenerator.generateHexKey(128);

        assertEquals("The generated key does not have the character size that would be expected from the given bit size parameter", 24, key.getBytes().length);
    }

    @Test
    public void TestCreateHexKey192Bits() throws NoSuchAlgorithmException {
        String key = passwordGenerator.generateHexKey(192);

        assertEquals("The generated key does not have the character size that would be expected from the given bit size parameter", 32, key.getBytes().length);
    }

    @Test
    public void TestCreateHexKey256Bits() throws NoSuchAlgorithmException {
        String key = passwordGenerator.generateHexKey(256);

        assertEquals("The generated key does not have the character size that would be expected from the given bit size parameter", 44, key.getBytes().length);
    }

    @Test
            (expected = InvalidParameterException.class)
    public void TestCreateHexKeyWithInvalidParameter() throws NoSuchAlgorithmException {
        passwordGenerator.generateHexKey(800);
    }

    @Test
    public void TestGeneratePasswordWithSpecifiedLength() {
        String password = passwordGenerator.generatePasswordByUserSpecification(true, true, true, true, 10);

        assertEquals("The length of the password is not as long as expected", 10, password.length());
    }

    @Test
            (expected = IllegalArgumentException.class)
    public void TestGeneratePasswordWithNoSpecification(){
        String password = passwordGenerator.generatePasswordByUserSpecification(false, false, false, false, 8);
    }

    @Test
    public void TestGeneratePasswordWithAllPossibleCharacters() {
        String password = passwordGenerator.generatePasswordByUserSpecification(true, true, true, true, 8);

        char ch;
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean digitFlag = false;
        boolean specialFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            } else if (Character.isDigit(ch)) {
                digitFlag = true;
            } else {
                specialFlag = true;
            }
        }
        assertTrue(upperCaseFlag);
        assertTrue(lowerCaseFlag);
        assertTrue(specialFlag);
        assertTrue(digitFlag);
    }

    @Test
    public void TestGeneratePasswordWithUppercaseOnly() {
        String password = passwordGenerator.generatePasswordByUserSpecification(true, false, false, false, 8);

        char ch;
        boolean upperCaseFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            }
        }
        assertTrue(upperCaseFlag);
    }

    @Test
    public void TestGeneratePasswordWithLowercaseOnly() {
        String password = passwordGenerator.generatePasswordByUserSpecification(false, true, false, false, 8);

        char ch;
        boolean lowerCaseFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
        }
        assertTrue(lowerCaseFlag);
    }

    @Test
    public void TestGeneratePasswordWithSpecialCharsOnly() {
        String password = passwordGenerator.generatePasswordByUserSpecification(false, false, true, false, 8);

        char ch;
        boolean specialCharFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (possibleSpecialCharacters.contains(String.valueOf(ch))) {
                specialCharFlag = true;
            }
        }
        assertTrue(specialCharFlag);
    }

    @Test
    public void TestGeneratePasswordWithDigitsOnly() {
        String password = passwordGenerator.generatePasswordByUserSpecification(false, false, false, true, 8);

        char ch;
        boolean digitsFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                digitsFlag = true;
            }
        }
        assertTrue(digitsFlag);
    }

    @Test
    public void TestGeneratePasswordWithUppercaseAndLowercase() {
        String password = passwordGenerator.generatePasswordByUserSpecification(true, true, false, false, 8);

        char ch;
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
        }
        assertTrue(upperCaseFlag);
        assertTrue(lowerCaseFlag);
    }

    @Test
    public void TestGeneratePasswordWithUppercaseAndSpecialChars() {
        String password = passwordGenerator.generatePasswordByUserSpecification(true, false, true, false, 8);

        char ch;
        boolean upperCaseFlag = false;
        boolean specialCharflag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            } else {
                specialCharflag = true;
            }
        }
        assertTrue(upperCaseFlag);
        assertTrue(specialCharflag);
    }

    @Test
    public void TestGeneratePasswordWithUppercaseAndDigits() {
        String password = passwordGenerator.generatePasswordByUserSpecification(true, false, false, true, 8);

        char ch;
        boolean upperCaseFlag = false;
        boolean digitFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            } else if (Character.isDigit(ch)) {
                digitFlag = true;
            }
        }
        assertTrue(upperCaseFlag);
        assertTrue(digitFlag);
    }

    @Test
    public void TestGeneratePasswordWithLowerCaseAndSpecialChars() {
        String password = passwordGenerator.generatePasswordByUserSpecification(false, true, true, false, 8);

        char ch;
        boolean lowerCaseFlag = false;
        boolean specialCharFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            } else {
                specialCharFlag = true;
            }
        }
        assertTrue(lowerCaseFlag);
        assertTrue(specialCharFlag);
    }

    @Test
    public void TestGeneratePasswordWithLowerCaseAndDigits() {
        String password = passwordGenerator.generatePasswordByUserSpecification(false, true, false, true, 8);

        char ch;
        boolean lowerCaseFlag = false;
        boolean digitsFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            } else if (Character.isDigit(ch)) {
                digitsFlag = true;
            }
        }
        assertTrue(lowerCaseFlag);
        assertTrue(digitsFlag);
    }

    @Test
    public void TestGeneratePasswordWithSpecialCharsAndDigits() {
        String password = passwordGenerator.generatePasswordByUserSpecification(false, false, true, true, 8);

        char ch;
        boolean specialCharFlag = false;
        boolean digitsFlag = false;

        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (possibleSpecialCharacters.contains(String.valueOf(ch))) {
                specialCharFlag = true;
            } else {
                digitsFlag = true;
            }
        }

        assertTrue(specialCharFlag);
        assertTrue(digitsFlag);
    }

    @Test
    public void TestGeneratePasswordWithUppercaseAndLowercaseAndSpecialChars() {
        String password = passwordGenerator.generatePasswordByUserSpecification(true, true, true, false, 8);

        char ch;
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean specialFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            } else if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            } else {
                specialFlag = true;
            }
        }
        assertTrue(upperCaseFlag);
        assertTrue(lowerCaseFlag);
        assertTrue(specialFlag);
    }

    @Test
    public void TestGeneratePasswordWithUppercaseAndLowerCaseAndDigits() {
        String password = passwordGenerator.generatePasswordByUserSpecification(true, true, false, true, 8);

        char ch;
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean digitsFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            } else if (Character.isDigit(ch)) {
                digitsFlag = true;
            }
        }
        assertTrue(upperCaseFlag);
        assertTrue(lowerCaseFlag);
        assertTrue(digitsFlag);
    }

    @Test
    public void TestGeneratePasswordWithUppercaseAndSpecialCharsAndDigits() {
        String password = passwordGenerator.generatePasswordByUserSpecification(true, false, true, true, 8);

        char ch;
        boolean upperCaseFlag = false;
        boolean specialCharFlag = false;
        boolean digitsFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            } else if (Character.isDigit(ch)) {
                digitsFlag = true;
            } else {
                specialCharFlag = true;
            }
        }
        assertTrue(upperCaseFlag);
        assertTrue(specialCharFlag);
        assertTrue(digitsFlag);
    }

    @Test
    public void TestGeneratePasswordWithLowercaseAndSpecialCharsAndDigits() {
        String password = passwordGenerator.generatePasswordByUserSpecification(false, true, true, true, 8);

        char ch;
        boolean lowerCaseFlag = false;
        boolean specialCharFlag = false;
        boolean digitsFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            } else if (possibleSpecialCharacters.contains(String.valueOf(ch))) {
                specialCharFlag = true;
            } else {
                digitsFlag = true;
            }
        }
        assertTrue(lowerCaseFlag);
        assertTrue(specialCharFlag);
        assertTrue(digitsFlag);
    }
}
