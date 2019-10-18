package lab02_morse;


import java.util.HashMap;

public class Morse {


    //interpret number as alphabet
    //String[][] codeTable00 = {{"a",".-"},{"b","-..."}};

    //String [] codeTable = {};

    HashMap<String,String> codeTable = new HashMap<>();

    public Morse(){
        codeTable.put("a",".-");
        codeTable.put("b","-...");
        codeTable.put("c","-.-.");
        codeTable.put("d","-..");
        codeTable.put("e",".");
        codeTable.put("f","..-.");
        codeTable.put("g","--.");
        codeTable.put("h","....");
        codeTable.put("i","..");
        codeTable.put("j",".---");
        codeTable.put("k","-.-");
        codeTable.put("l",".-..");
        codeTable.put("m","--");
        codeTable.put("n","-.");
        codeTable.put("o","---");
        codeTable.put("p",".--.");
        codeTable.put("q","--.-");
        codeTable.put("r",".-.");
        codeTable.put("s","...");
        codeTable.put("t","-");
        codeTable.put("u","..-");
        codeTable.put("v","...-");
        codeTable.put("w",".--");
        codeTable.put("x","-..-");
        codeTable.put("y","-.--");
        codeTable.put("z","--..");
        codeTable.put("A",".-");
        codeTable.put("B","-...");
        codeTable.put("C","-.-.");
        codeTable.put("D","-..");
        codeTable.put("E",".");
        codeTable.put("F","..-.");
        codeTable.put("G","--.");
        codeTable.put("H","....");
        codeTable.put("I","..");
        codeTable.put("J",".---");
        codeTable.put("K","-.-");
        codeTable.put("L",".-..");
        codeTable.put("M","--");
        codeTable.put("N","-.");
        codeTable.put("O","---");
        codeTable.put("P",".--.");
        codeTable.put("Q","--.-");
        codeTable.put("R",".-.");
        codeTable.put("S","...");
        codeTable.put("T","-");
        codeTable.put("U","..-");
        codeTable.put("V","...-");
        codeTable.put("W",".--");
        codeTable.put("X","-..-");
        codeTable.put("Y","-.--");
        codeTable.put("Z","--..");
        codeTable.put(" "," ");
        codeTable.put(",","--..--");
        codeTable.put(".",".-.-.-");
        codeTable.put("?","..--..");
    }




    public String encode(String s){

        return new String();
    }


    public String decode (String s){

    }

    public int getNumberForAlphabet(String s){

    }


}
