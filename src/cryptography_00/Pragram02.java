package cryptography_00;

import java.util.LinkedList;

public class Pragram02 {

	public static void main(String[] args) {
		
		String encryptedOrig = "DOICSNMEUHLTAFCHEFETVLNWSFHEHATEEÜNAIETIRCHXRSIHSNLNEHOTSSCRTSIEIEDZCEH";
		char[] encryptedChar = encryptedOrig.toCharArray();
		
		int modStart = 2;
		int modMax = 14;
		int offset = 1;
		
		// try modulo from modStart to modMax
		for (int j=modStart; j<modMax; j++) {
			System.out.println("mod: " + j);
			
			// iteration through characters
			for (int i=offset; i<encryptedChar.length+offset; i++) {
				System.out.print(encryptedChar[i-offset]);
				
				// line break, if it can be divided
				if (i%j == 0) {
					System.out.println(""); // line break
				}
			}

			System.out.println(""); // line break for next modulo
		}

	}
	
	
	
}


