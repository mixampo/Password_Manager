package Generator;

import java.security.NoSuchAlgorithmException;

public interface IPasswordGenerator {
    String generateHexKey(int bitSize) throws NoSuchAlgorithmException;
    String generatePasswordByUserSpecification(int generateId);
}
