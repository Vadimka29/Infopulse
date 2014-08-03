
public class Test {
	//default values
	//начальная инициализация полей в Java
	//мы можем быть уверены, что если мы забыли инициализировать какое-то поле, то
	// она получит значение по умолчанию
	//все числовые значение получит 0
	private int i; //0
	private double d; //0.0
	private double d1 = Math.PI;
	private String s; //null
	private int[] mi;  //null
	private boolean b; //false
	public Test(){}
	public String toString(){
		return "i = " + i + " d = " + d + " d1 = " + d1 + " s = " + s + " mi = " + mi + " b = " + b;
	}
}
