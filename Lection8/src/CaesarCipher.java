
public class CaesarCipher {
	private CircleList<Character> cl;
	//сдвиг
	private int shift;
	private char start;
	private char end;
	
	public CaesarCipher(int sh, char start, char end){
		shift = sh;
		this.start = start;
		this.end = end;
		cl = new CircleList<>();
		for(char temp = start; temp <= end; temp++){
			cl.addFirst(temp);
		}
	}
	public String encode(String s){
		String toReturn = "";
		for(char temp: s.toCharArray()){
			toReturn += encode(temp);
		}
		return toReturn;
	}
	public String decode(String s){
		String toReturn = "";
		for(char temp: s.toCharArray()){
			toReturn += decode(temp);
		}
		return toReturn;
	}
	private char decode(char c){
		int dif = c - start;
		return cl.getNode(dif - shift);
	}
	private char encode(char c){
		int dif = c - start;
		return cl.getNode(dif + shift);
	}
}