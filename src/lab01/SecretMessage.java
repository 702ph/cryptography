package lab01;

import java.math.BigInteger;

public class SecretMessage {
    byte[] encryptedText;
    byte[] key;


    public SecretMessage(String encryptedText, String key) {
        this.encryptedText = convertBinaryExpressionOfStringToByteArray(encryptedText);
        this.key = convertBinaryExpressionOfStringToByteArray(key);
    }


    private byte[] convertBinaryExpressionOfStringToByteArray(String s) {
        return new BigInteger(s, 2).toByteArray();
    }
}