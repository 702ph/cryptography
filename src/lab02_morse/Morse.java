package lab02_morse;

public class Morse implements MorseInterface {

    // would be better if sorted by frequency (in English)
    private String [][] codeTable = {
            {"A",".-"},
            {"B","-..."},
            {"C","-.-."},
            {"D","-.."},
            {"E","."},
            {"F","..-."},
            {"G","--."},
            {"H","...."},
            {"I",".."},
            {"J",".---"},
            {"K","-.-"},
            {"L",".-.."},
            {"M","--"},
            {"N","-."},
            {"O","---"},
            {"P",".--."},
            {"Q","--.-"},
            {"R",".-."},
            {"S","..."},
            {"T","-"},
            {"U","..-"},
            {"V","...-"},
            {"W",".--"},
            {"X","-..-"},
            {"Y","-.--"},
            {"Z","--.."},
            {",","--..--"},
            {".",".-.-.-"},
            {"?","..--.."},
            {"1",".----"},
            {"2","..---"},
            {"3","...--"},
            {"4","....-"},
            {"5","....."},
            {"6","-...."},
            {"7","--..."},
            {"8","---.."},
            {"9","----."},
            {"0","-----"}
    };

    private String plainText;
    private String codes;

    // for debug
    public Morse(){}


    /**
     * @param s plaintext or codes
     */
    public Morse(String s){
        if (s.contains("-")||s.contains(".")) {
            plainText = decode(s);
            codes = s;
        } else {
            plainText = s;
            codes = encode(s);
        }
    }


    public String getCodes(){
        return codes;
    }


    public String getPlainText(){
        return plainText;
    }


    private String decode(String codeText){
        String[] codes = codeText.replaceAll("\\s+","").toUpperCase().split("/");
        StringBuilder decodedText = new StringBuilder();

        for(int i=0; i<codes.length; i++){
            decodedText.append(getAlphabet(codes[i]));
        }
        return decodedText.toString();
    }


    private String encode(String plainText){
        String[] alphabets = plainText.replaceAll("\\s+","").toUpperCase().split("");
        StringBuilder codes = new StringBuilder();

        for(int i=0; i<alphabets.length; i++){
            codes.append(getCode(alphabets[i]));
            if (i != alphabets.length-1) codes.append("/");
        }
        return codes.toString();
    }


    // return alphabet or "?" if not found
    private String getAlphabet(String code){
        for (int i = 0; i< codeTable.length; i++){
            if (codeTable[i][1].equals(code)) return codeTable[i][0];
        }
        return "?";
    }


    // return code or "?" if not found
    private String getCode(String alphabet){
        for (int i = 0; i< codeTable.length; i++){
            if (codeTable[i][0].equals(alphabet)) return codeTable[i][1];
        }
        return "?";
    }
}
