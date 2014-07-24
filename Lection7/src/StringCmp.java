import java.util.Comparator;

public class StringCmp implements Comparator<String> {
	private char symbol;
	public StringCmp(char symbol){
		this.symbol = symbol;
	}
	public int compare(String o1, String o2){
		return counter(o1) - counter(o2);
	}
	
	private int counter(String t){
		int counter = 0;
		char[] array = t.toCharArray();
		for(char temp: array)
			if(temp == symbol)
				counter ++;
		return counter;
	}
}
