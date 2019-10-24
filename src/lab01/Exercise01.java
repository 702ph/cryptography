package lab01;

import java.util.ArrayList;
import java.util.Random;

public class Exercise01 {

    static byte[] plainText = "PRENZLAUER".getBytes();
    static byte[] key = new byte[plainText.length];
    static byte[] encrypted = new byte[plainText.length];
    static byte[] decrypted = new byte[plainText.length];

    public static void main(String[] args) {
        printAsString("Plaintext: ", plainText);
        printAsBinary("Plaintext: ", plainText);

        //generate random key
        fillRandomKey();
        printAsBinary("Key      : ", key);

        //encryption
        encrypted = xor(plainText, key);
        printAsBinary("Encrypted: ", encrypted);

        //decryption
        decrypted = xor(encrypted, key);
        printAsBinary("Decrypted: ", decrypted);
        printAsString("Decrypted: ", decrypted);

        // exercise from other students
        doExerciseFromOtherStudents();
    }


    public static void doExerciseFromOtherStudents() {

        // encrypted text from other students
        ArrayList<SecretMessage> secretMessages = new ArrayList<>();
        secretMessages.add(new SecretMessage("01000110100110110001110001100010101111001110010100101111011010110100001000110011", "00010101110011100101111000110001111010001010010001100001001111110000101101100101"));
        secretMessages.add(new SecretMessage("00110011000001110010010000001111000001001101010100000001110111001010110011110011", "01110100011100100101000001101010011010101001010001100011101110010100001010010111"));
        secretMessages.add(new SecretMessage("01110110001001110001111101010011100110100100110111001101001010001000001110100111","00001111010100110111011000100000111010000010100010111011010000011110110111110010"));
        secretMessages.add(new SecretMessage("00110010111111011111010111000111100001001011001011001111001010000101001101100010","01100010101011111011000010001001110111101111111010001110011111010001011000110000"));
        secretMessages.add(new SecretMessage("00110011000001110010010000001111000001001101010100000001110111000010110011110011","01110100011100100101000001101010011010101001010001100011101110010100001010010111"));

        // decryption
        for(SecretMessage message : secretMessages) {
            printAsBinary("encrypted :", message.encryptedText);
            printAsBinary("key       :", message.key);
            printAsBinary("decrypted :", xor(message.encryptedText, message.key));
            printAsString("PlainText :", xor(message.encryptedText, message.key));
        }

    }


    static void fillRandomKey() {
        Random random = new Random();
        random.nextBytes(key);
    }


    static byte[] xor(byte[] a, byte[] b) {
        byte[] result = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = (byte) (a[i] ^ b[i]);
        }
        return result;
    }


    static void printAsBinary(String title, byte[] b) {
        System.out.print(title);
        for (int i = 0; i < b.length; i++) {
            int binary = Byte.toUnsignedInt(b[i]);
            String str = Integer.toBinaryString(binary);
            str = String.format("%8s", str).replace(' ', '0');
            System.out.print(i == b.length - 1 ? str + "\n" : str + "-");
        }
    }


    static void printAsString(String title, byte[] b) {
        System.out.println(title + new String(b));
    }
}



