package lab02_morse;

import java.util.LinkedList;

public class Morse02 implements MorseInterface{

    // 1: .
    // 2: -
    // 3: =
    // 4: ===
    // 5: =======


    //OSAKA:
     //: -=-=-===.=.=.===.=-===-=.=-===.=-=======-=-=-===.=.=.===.=-===-=.=-===.=-


    String spaceCharacter; // = " ";
    int letterSpaceLength;
    int wordSpaceLength;


    /**
     * @param ls letter space length
     * @param ws word space length
     * @param sc character for space
     * @param s morse code string
     */
    public Morse02 (int ls, int ws, String sc, String s){
        this.letterSpaceLength = ls;
        this.wordSpaceLength = ws;
        this.spaceCharacter = sc;
        this.codes = s;
        this.plainText = decode(this.codes);
    }


    private String decode(String codeText){
        //String[] c = codeText.replaceAll("\\s+","").split("");

        //ilia
        String[] c = codeText.split("");

        // String[] to LinkedList
        LinkedList<String> codes = new LinkedList<>();
        for (int i=0; i<c.length; i++){
            codes.addLast(c[i]);
        }

        StringBuilder decodedText = new StringBuilder();
        LinkedList<String> queueLetter = new LinkedList<>();
        int letterSpaceCounter = 0;
        int wordSpaceCounter = 0;


        // analyse code
        while (!(codes.size()==0)){
            String code = codes.pollFirst();
            if (code.equals(spaceCharacter)){
                letterSpaceCounter++;
                wordSpaceCounter++;
            } else {
                letterSpaceCounter = 0;
                wordSpaceCounter = 0;
                queueLetter.addLast(code);
            }


            // letter
            if (letterSpaceCounter==letterSpaceLength){

                if (!codes.peek().equals(spaceCharacter)) {
                    letterSpaceCounter = 0;
                    wordSpaceCounter = 0;
                }

                StringBuilder l = new StringBuilder();
                while (!(queueLetter.size()==0)) {
                    l.append(queueLetter.pollFirst());
                    //System.out.println(l.toString());
                }
                decodedText.append(getAlphabet(l.toString()));
            }


            // word
            if (wordSpaceCounter==wordSpaceLength){
                wordSpaceCounter=0;
                letterSpaceCounter=0;
                decodedText.append(" ");
            }
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
    public Morse02(){}


    /**
     * @param plainText plaintext or codes
     */
    public Morse02(String plainText){
            this.plainText = plainText;
            codes = encode(plainText);
    }


    public String getCodes(){
        return codes;
    }


    public String getPlainText(){
        return plainText;
    }

}
