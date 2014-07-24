
public class Exercises {
	public static void first() {
		//поменять значения переменных
		int a = 3;
		int b = 5;
		/*a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a + "\nb = " + b);*/

//второй способ
		a = a^b;
		b = b^a;
		a = a^b;
		System.out.println("a = " + a + "\nb = " + b);
	}
	//супермаркет
	public static void second(float oldPrice) {
		float newPrice = oldPrice;
		float discount = 0;
		switch((int) oldPrice/200){
		case 0: 
			newPrice = oldPrice;
			break;
		case 1:
			discount = (oldPrice/100)*3;
			newPrice = oldPrice - discount;
			break;
		case 2:
			discount = (oldPrice/100)*3;
			newPrice = oldPrice - discount;
			break;
		case 3:
			discount = (oldPrice/100)*5;
			newPrice = oldPrice - discount;
			break;
		case 4:
			discount = (oldPrice/100)*7;
			newPrice = oldPrice - discount;
			break;
		}
		System.out.println("discount: " + discount);
		System.out.println("newPrice: " + newPrice);
	}
	
	//рисует квадрат 4x4
	public static void squarePaint(int l) {
		if(l <= 0){
			System.out.println("Error");
			return;
		}
		char mass[][] = new char [l][l];
		//если 1, выведем массив из одной решетки
		if(l == 1){
			mass[0][0] = '#';
			System.out.println(mass[0][0]);
			return;
		}
		for(int i = 0; i < l; i ++){
			for(int j = 0; j < l; j ++) {
				if(i % (l-1) == 0 || j % (l-1) == 0)
					mass[i][j] = '#';
				else
					mass[i][j] = ' ';
				System.out.print(mass[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
	//рисует множество квадратов
	public static void setPaint(int l) {
		char[][] mass = new char[l][l];
		int counter = 0;
		while(l - counter > 1) {
			for(int i = counter; i < l - counter; i ++)
				for(int j = counter; j < l - counter; j ++){
					if(((i - counter) % (l - counter - 1) == 0 || (j - counter) % (l-counter - 1) == 0)
							||(i % (l - counter - 1) == 0 || j % (l-counter - 1) == 0))
						mass[i][j] = '#';
					else {
						if(mass[i][j] != '#')
							mass[i][j] = '_';
					}
				}
			counter += 2;
		}
		//вывод массива
		for(int i = 0; i < mass.length; i ++) {
			for(int j = 0; j < mass[i].length; j ++){ 
				System.out.print(mass[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void count(){
		String s = "Java";
		String[] a = s.split("a");
		System.out.println("Count of 'a': " + a.length);
	}
	//является ли число 5 - ой степенью другого числа
	public static void check(double l) {
		double epselon = Math.pow(10, -8);
		double n = Math.pow(l, 1.0/5.0);
		if(Math.abs(n - (int) n) < epselon)
			System.out.println(l + " является 5 - ой степенью числа " + (int) n);
		else
			System.out.println(l + " не является 5-ой степенью какого-то числа");
	}
	//Вычисление числа в последовательности Фибоначчи
	public static double fib(int n) {
		if(n <= 1)
			return n;
		return fib(n-1)+fib(n-2);
	}
}
