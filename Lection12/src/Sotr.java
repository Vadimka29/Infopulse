import java.io.Serializable;
import java.util.Arrays;


public class Sotr implements Serializable {
	private String name;
	transient private int[] s;
	
	public Sotr(String name, int[] s){
		this.name = name;
		this.s = s;
	}
	public String toString(){
		return "name = " + name + " s = " + Arrays.toString(s);
	}
}