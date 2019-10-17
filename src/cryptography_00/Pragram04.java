package cryptography_00;

public class Pragram04 {

	//static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	static final String ENCRYPTED_TEXT = "XUQYU SKEMG FTLNB EAUAU MXQEE FQRKA FYMZA DIPWJ QTLVA YQNXR VIQXB KKLBE";
	static final String KEYWORD = "enigma";
	static final int ALPHABET_LENGTH = 26; //0 to 25 = 26

	
	public static void main(String[] args) {

		System.out.println(convertToNumber('A'));
		System.out.println(convertToNumber('Z'));
		
		char[] encrypted = prepareText(ENCRYPTED_TEXT);
		char[] keys = prepareText(KEYWORD); 
		char[] decrypted = new char[encrypted.length];
		
		int keyPos = 0;
		int pos = 0;
		
		while (pos<encrypted.length) {
			// PlainText = (Cipher - Key) % 26
			int num = (convertToNumber(encrypted[pos])) - convertToNumber(keys[keyPos]) % ALPHABET_LENGTH;

			// if negative, add ALPHABET_LENGTH
			num = (num<0) ? ALPHABET_LENGTH + num : num;			
			
			//decrypted text
			decrypted[pos] = convertToChar(num);
			
			//Increment position
			pos++;			
			keyPos++;
			
			//reset position 
			if (keyPos == keys.length) keyPos = 0;
		}	
		printText(decrypted);	
	}

	
	// get number for alphabet, 0 to 25
	private static int convertToNumber(char c) {
		return c-65;
	}
	
	
	private static char convertToChar(int n) {
		return (char)(n+65);
	}
	
	
	// delete space, convert to upper case, convert to char[]
	private static char[] prepareText(String s) {
		return s.replaceAll("\\s+","").toUpperCase().toCharArray();
	}
	
	
	private static void printText(char[] c) {
		for(int i=0; i<c.length; i++) {
			System.out.print(c[i]);
		}
		System.out.print("");
	}

}


