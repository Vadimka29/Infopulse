import javax.swing.text.html.FormSubmitEvent.MethodType;

public class Tasks3 {

	public static void main(String[] args) {
		// ****** Task 1 ******
		//create nested subdirectories
		//Methods.Directory();
		// ****** Task 2 ******
		System.out.println(Methods.getStringNumericalCode("quarante deux"));

		System.out.println(Methods.getStringNumericalCode("L'Russe Besuhof"));
		
		System.out.println(Methods.getStringNumericalCode("L'Empereur Napoleon"));
		// ****** Task 3 *******
		String encoded =  Methods.code("vadim", Methods.Direction.RIGHT, 1);
		String decoded = Methods.decode(encoded, Methods.Direction.RIGHT, 1);
		System.out.println("Encoded string: " + encoded);
		System.out.println("Decoded string: " + decoded);
		//****** Task 4 ******
		//Direction.RIGHT, step = 17 - right answer
		String secret = "ardvj sfeu zj rsjvek ze cfeufe efn";
		for(int i = 0; i < 26; i ++){
			System.out.println(i + ": " + Methods.decode(secret, Methods.Direction.RIGHT, i));
		}
		
		// ****** Task 5 ******
		int N = 10;
		System.out.println("Binary code of " + N + " : " + Methods.getBinaryCode(N));
	}
}