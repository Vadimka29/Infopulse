import java.io.File;
import java.util.Scanner;

public class Methods {
	static enum Direction {LEFT,RIGHT};
	//	create nested subdirectories
	public static void Directory(){
		StringBuilder path =  new StringBuilder();
		path.append("/media/vadim/12EAE1C3EAE1A369");
		for(int i = 0; i < 10; i ++){
			path.append("/" + i);
		}
		File f = new File(path.toString());
		//System.out.println(f.mkdirs());
		System.out.println(f.getPath());
		}
	
	public static int getStringNumericalCode(String str){
		String strLow = str.toLowerCase();
		int code = 0;
		for(int i = 0; i < strLow.length(); i++){
			System.out.println(strLow.charAt(i) +" : " + getCharCode(strLow.charAt(i)));
			code = code + getCharCode(strLow.charAt(i));
		}
		return code;
	}
	//get Code of one symbol
	private static int getCharCode(char symbol){
		if(symbol >= 'a' && symbol < 'j')
			return (symbol - 'a' + 1);
		if(symbol >'j' && symbol <= 'z')
			return (symbol - 'k' + 1)*10;
		return 0;
	}
	// Cezar coding
	 public static String code(String str,Direction dr, int step){
		 //check step
		 while(step < 0){
			 System.out.println("Step is < 0. Please enter step > 0 : ");
			 Scanner sc = new Scanner(System.in);
			 String temp = sc.next();
			 step = Integer.parseInt(temp);
			 if(step >= 0)
				 break;
		 }
		 
		 StringBuffer temp = new StringBuffer(str.toLowerCase());
		 int start = 'a';
		 int end = 'z';
		 //alphabet's power
		 int n = end - start + 1;
		for(int i = 0; i < temp.length(); i++){
			
			if(dr == Direction.RIGHT){
				//if it isn't space
				if(temp.charAt(i) != ' '){
				//relative position in alphabet
					int x = temp.charAt(i) - 'a';
					temp.setCharAt(i, (char) (start + (x + step) % n));
				}
			}
			else{
				//if it isn't space
				if(temp.charAt(i) != ' '){
					//relative position in alphabet
					int x = temp.charAt(i) - 'a';
					temp.setCharAt(i, (char) (start + (x - step) % n));
				}
			}
		}
		return temp.toString();
	}//relative position (counting from 0) of old symbol
	 //Cezar dencoding
	 public static String decode(String str,Direction dr, int step){
		//check step
		 while(step < 0){
			 System.out.println("Step is < 0. Please enter step > 0 : ");
			 Scanner sc = new Scanner(System.in);
			 String temp = sc.next();
			 step = Integer.parseInt(temp);
			 if(step >= 0)
				 break;
		 }
		 
		 StringBuffer temp = new StringBuffer(str.toLowerCase());
		 int start = 'a';
		 int end = 'z';
		 //alphabet power
		 int n = end - start + 1;
		for(int i = 0; i < temp.length(); i++){
			if(dr == Direction.RIGHT){
				//if it isn't space
				if(temp.charAt(i) != ' '){
				//relative position in alphabet
					int x = temp.charAt(i) - 'a';
					temp.setCharAt(i, (char) (start + (x - step + n) % n));
				}
			}
			else{
				//if it isn't space
				if(temp.charAt(i) != ' '){
				//relative position in alphabet
					int x = temp.charAt(i) - 'a';
					temp.setCharAt(i, (char) (start + (x - step + n) % n));
				}
			}
		}
		return temp.toString();
	}
	 //binary code
	 public static String getBinaryCode(int digit){
		 StringBuffer temp = new StringBuffer();
		 while(digit != 0){
			 temp.append(digit % 2);
			 digit = digit/2;
		 }
		 return temp.reverse().toString();
	 }
}
