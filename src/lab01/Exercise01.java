package lab01;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise01 {

    static byte[] plainText = "PRENZLAUER".getBytes();
    static byte[] key = new byte[plainText.length];
    static byte[] encrypted = new byte[plainText.length];
    static byte[] decrypted = new byte[plainText.length];


    public static void main(String[] args) {
        printString("Plaintext: ", plainText);
        printBinary("Plaintext: ", plainText);

        //generate random key
        fillRandomKey();
        printBinary("Key      : ", key);

        //encryption
        encrypted = xor(plainText, key);
        printBinary("Encrypted: ", encrypted);

        //decryption
        decrypted = xor(encrypted, key);
        printBinary("Decrypted: ", decrypted);
        printString("Decrypted: ", decrypted);


        doExerciseFromOtherStudent();
    }

    public static void doExerciseFromOtherStudent() {

        byte[] key02 = new byte[plainText.length];
        byte[] encrypted02 = new byte[plainText.length];
        byte[] decrypted02 = new byte[plainText.length];

        //from moodle
        divideString(
                "00110011000001110010010000001111000001001101010100000001110111001010110011110011");
        System.out.println();
        divideString("01110100011100100101000001101010011010101001010001100011101110010100001010010111");

        encrypted02[0] = (byte)0b00110011;
        encrypted02[1] = (byte)0b00000111;
        encrypted02[2] = (byte)0b00100100;
        encrypted02[3] = (byte)0b00001111;
        encrypted02[4] = (byte)0b00000100;
        encrypted02[5] = (byte)0b11010101;
        encrypted02[6] = (byte)0b00000001;
        encrypted02[7] = (byte)0b11011100;
        encrypted02[8] = (byte)0b10101100;
        encrypted02[9] = (byte)0b11110011;
        printBinary("encrypted02     :", encrypted02);


        key02[0] = (byte)0b01110100;
        key02[1] = (byte)0b01110010;
        key02[2] = (byte)0b01010000;
        key02[3] = (byte)0b01101010;
        key02[4] = (byte)0b01101010;
        key02[5] = (byte)0b10010100;
        key02[6] = (byte)0b01100011;
        key02[7] = (byte)0b10111001;
        key02[8] = (byte)0b01000010;
        key02[9] = (byte)0b10010111;
        printBinary("key02     :", key02);

        decrypted02 = xor(encrypted02, key02);
        printBinary("Decrypted: ", decrypted02);
        printString("Decrypted: ", decrypted02);
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


    static void printBinary(String title, byte[] b){
        System.out.print(title);
        for(int i=0; i<b.length; i++) {
            int binary = Byte.toUnsignedInt(b[i]);
            String str = Integer.toBinaryString(binary);
            str = String.format("%8s", str).replace(' ', '0');
            System.out.print( i==b.length-1 ? str +"\n" : str +"-");
        }
    }


    static void printString(String title, byte[] b){
        System.out.println(title + new String(b));
    }


    static void divideString(String s){
        Matcher m = Pattern.compile("[\\s\\S]{1,8}").matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }




}
