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

public class PasswordGeneratorTest {

    private IPasswordGenerator passwordGenerator;

    @Before
    public void  TestInitialize(){this.passwordGenerator = new PasswordGenerator();}

    @Test
    public void TestCreateHexKey128Bits() throws NoSuchAlgorithmException {
        String key = passwordGenerator.generateHexKey(128);

        assertEquals("The generated key does not have the character size that would be expected from the given bit size parameter", 24,  key.getBytes().length);
    }

    @Test
    public void TestCreateHexKey192Bits() throws NoSuchAlgorithmException {
        String key = passwordGenerator.generateHexKey(192);

        assertEquals("The generated key does not have the character size that would be expected from the given bit size parameter", 32,  key.getBytes().length);
    }

    @Test
    public void TestCreateHexKey256Bits() throws NoSuchAlgorithmException {
        String key = passwordGenerator.generateHexKey(256);

        assertEquals("The generated key does not have the character size that would be expected from the given bit size parameter", 44,  key.getBytes().length);
    }

    @Test
            (expected = InvalidParameterException.class)
    public void TestCreateHexKeyWithInvalidParameter() throws NoSuchAlgorithmException{
        String key = passwordGenerator.generateHexKey(800);
    }

    @Test
    public void TestGeneratePasswordWithSpecifiedLength(){
        String password = passwordGenerator.generatePasswordByUserSpecification(true, true, true, true, 10);

        assertEquals("The length of the password is not as long as expected", 10, password.length());
    }

    @Test
    public void TestGeneratePasswordWithAllPossibleCharacters(){
        String password = passwordGenerator.generatePasswordByUserSpecification(true, true, true, true, 8);

        char ch;
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean digitFlag = false;
        boolean specialFlag = false;
        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if( Character.isDigit(ch)) {
                digitFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                upperCaseFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            } else {
                specialFlag = true;
            }
        }
        assertTrue(upperCaseFlag);
        assertTrue(lowerCaseFlag);
        assertTrue(specialFlag);
        assertTrue(digitFlag);
    }

}
