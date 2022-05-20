package n3exercici1;

import javax.crypto.BadPaddingException;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("n3exercici1/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SecretKey secretKey = Encryptor.keygenKeyGeneration(256);

        //File encryption
        File readFile = new File(properties.getProperty("sourceDir"), properties.getProperty("readFileName"));
        File encryptedFile = new File(properties.getProperty("destinationDir"), properties.getProperty("encryptedFileName"));
        try {
            Encryptor.encryptFile(secretKey, readFile, encryptedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //File decryption
        File readEncryptedFile = new File(properties.getProperty("destinationDir"), properties.getProperty("encryptedFileName"));
        File decryptedFile = new File(properties.getProperty("destinationDir"), properties.getProperty("decryptedFileName"));
        try {
            Encryptor.decryptFile(secretKey, readEncryptedFile, decryptedFile);
        } catch (IOException | BadPaddingException e) {
            e.printStackTrace();
        }
    }
}
