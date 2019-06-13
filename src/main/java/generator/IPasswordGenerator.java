package generator;

import java.security.NoSuchAlgorithmException;

public interface IPasswordGenerator {
    String generateHexKey(int bitSize) throws NoSuchAlgorithmException;
    String generatePasswordByUserSpecification(boolean upperCase, boolean lowerCase, boolean special, boolean digits, int length);
}
