package lab02_morse;

public class Morse {

    // would be better if sorted by frequency (in English)
    String [][] codeTableSS = {
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
            {"10","-----"}
    };


    public String decode(String codeText){
        String[] codes = codeText.replaceAll("\\s+","").toUpperCase().split("/");
        StringBuilder decodedText = new StringBuilder();

        for(int i=0; i<codes.length; i++){
            decodedText.append(getAlphabet(codes[i]));
        }
        return decodedText.toString();
    }


    public String encode (String s){
        return  new String();
    }


    // return alphabet or "?" if not found
    private String getAlphabet(String code){
        for (int i=0; i<codeTableSS.length; i++){
            if (codeTableSS[i][1].equals(code)) return codeTableSS[i][0];
        }
        return "?";
    }


    // return code or "?" if not found
    private String getCode(String alphabet){
        for (int i=0; i<codeTableSS.length; i++){
            if (codeTableSS[i][0].equals(alphabet)) return codeTableSS[i][1];
        }
        return "?";
    }
}
