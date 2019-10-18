package lab02_morse;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //create instances
        ArrayList<Morse> morses = new ArrayList<>();
        morses.add(new Morse("Berlin"));
        morses.add(new Morse("Osa ka"));
        morses.add(new Morse("-..././.-./.-../../-."));
        morses.add(new Morse("---/.../.-/-.-/.-"));

        // print all
        for (Morse morse: morses) {
            System.out.println(morse.getPlainText() + ":\n" + morse.getCodes());
        }

    }
}
