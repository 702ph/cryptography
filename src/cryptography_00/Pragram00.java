package cryptography_00;

public class Pragram00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("aaa");

		char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J', 'K', 'L', 'M'
				, 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '};

		System.out.println(alphabet.length);

		String encryptedOrig = "PME IMD EQTD XQUOTF LG QZFLURRQDZ";
		char[] encryptedChar = encryptedOrig.toCharArray();
		int shift = 0;

		for (int k=0; k<alphabet.length-1; k++) {
			shift = shift + 1;
			System.out.print(shift + ": ");
			
			for (int i=0; i<encryptedChar.length; i++) {

				char c = encryptedChar[i];
				int pos = 0;					
				for(int j=0; j<alphabet.length; j++) {	
					if (c==alphabet[j]) {

						pos = j+shift;
						if (pos>26) {
							pos = pos-26;
						}
						break;
					}
				}
				System.out.print(alphabet[pos]);	
			}

			System.out.println();
		}

	}

}


