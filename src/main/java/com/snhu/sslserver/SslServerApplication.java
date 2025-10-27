package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jakarta.xml.bind.DatatypeConverter;


@SpringBootApplication
public class SslServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslServerApplication.class, args);
    }
}

@RestController
class ServerController{
    @RequestMapping("/hash")
    public String myHash(){
        String data = "Data for Artemis Financial from Dat Nguyen";
        String hashedOutput = "";
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Calculate the hash
            byte[] hash = md.digest(data.getBytes());

            // Convert the byte array to a hexadecimal string
            hashedOutput = DatatypeConverter.printHexBinary(hash).toUpperCase();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // Return the formatted string for display
        return "<p>data: " + data + "<p><p>Name of Cipher Algorithm Used: SHA-256<p><p>Checksum Value: " + hashedOutput;
    }
}
