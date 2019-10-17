package lab01;

import java.math.BigInteger;

public class SecretMessage {
    byte[] encryptedText;
    byte[] key;


    public SecretMessage(String encryptedText, String key) {
        this.encryptedText = convertBinaryExpressionStringToByteArray(encryptedText);
        this.key = convertBinaryExpressionStringToByteArray(key);
    }


    private byte[] convertBinaryExpressionStringToByteArray(String s) {
        return new BigInteger(s, 2).toByteArray();
    }
}