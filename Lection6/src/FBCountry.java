
//описывает футбольную команду
public class FBCountry implements Comparable{
	private int c;
	private String name;
	
	public FBCountry(String n, int c){
		name = n;
		this.c = c;
	}

	@Override
	public String toString() {
		return "" + name;
	}
	@Override
	public int compareTo(Object ob){
		//нужно явно преобразовать к типу данных FBCountry
		//если передаст кто-то другой тип данных, вернет ошибку
		FBCountry another = (FBCountry) ob;
		return this.c - another.c;
	}
}
