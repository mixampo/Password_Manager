package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("Models")
public class PasswordManagerRestServer {
    public static void main(String[] args) {
            SpringApplication.run(PasswordManagerRestServer.class, args);
        }
}
