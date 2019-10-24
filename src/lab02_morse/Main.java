package lab02_morse;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        //create instances
        //old version
//        ArrayList<Morse> morses = new ArrayList<>();
//        morses.add(new Morse("Berlin"));
//        morses.add(new Morse("Osa ka"));
//        morses.add(new Morse("- ..././.-./.-../../-."));
//        morses.add(new Morse("---/.../.-/-.-/.-"));



        // version 2
        ArrayList<Morse02> morses = new ArrayList<>();

        // my version 2
        morses.add(new Morse02(3, 7, "=", "-=-=-===.=.=.===.=-===-=.=-===.=-=======-=-=-===.=.=.===.=-===-=.=-===.=-"));

        // ilia
        morses.add(new Morse02(1,4," ","- .... .    --.- ..- .. -.-. -.-    -... .-. --- .-- -.    ..-. --- -..-    .--- ..- -- .--. ...    --- ...- . .-.    - .... .    .-.. .- --.. -.--    -.. --- --."));

        //aleks
        morses.add(new Morse02(3,7," ",". .       . - -   . .   . . .   . . . .       - . - -   - - -   . . -       . -   . - . .   . - . .       . -       - - .   - - -   - - -   - . .       . - -   .   .   - . -   .   - .   - . .       "));

        //print all
        morses.stream().map(m->m.getPlainText() + ":\n" + m.getCodes() + "\n").forEach(System.out::println);


    }
}
