package Generator;

import java.security.NoSuchAlgorithmException;

public interface IPasswordGenerator {
    String generateHexKey() throws NoSuchAlgorithmException;
    String generatePasswordByUserSpecification();
}
