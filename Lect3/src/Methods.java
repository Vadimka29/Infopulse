import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Methods {
	//принимает на вход григорианский календарь и меняет дату на 13
	public static void seDay13(GregorianCalendar calendar){
		calendar.set(Calendar.DATE, 13);
		//Calendar.DATE и Calendar.DAY_OF_MONTH - одно и тоже
		}
	//Заполнить массив любым нужным значением
	public static void fillArray(int[] mass, int temp){
		//Arrays.fill(mass, temp);
		for(int i = 0; i < mass.length; i++) {
			mass[i] = temp;
		}
	}
	//внутри обменивает a на b и b на a
	//такой метод написать нельзя, можно сделать массив, поменять в нем элементы местами
	//и потом скопировать обратно
	public static void swap(int a, int b){
		
	}
	//теперь метод вернет строку новую, строку S + "a"
	public static String incStr(String s) {
		s = s + "a";
		return s;
	}
	//
	public static void change(int[] z){
		//еще один способ инициализации
		z = new int[] {1,2,3};
	}
	//копирует диапозон некоторый в массиве
		public static int[] copyOf(int[] mass,int count){
			int temp[] = new int[count];
			for(int i = 0; i < count; i ++){
				temp[i] = mass[i];
			}
			return temp;
		}
		//возвращает массив double
		public static double[] stat(int a, int b){
			//вариант инициализации
			double st[] = {a+b, a*b, (a+b)/2.0};
			return st;
		}
		//решение квадратных уравнений
		public static double[] quadEq(int a, int b, int c){
			int d = (int) Math.pow(b, 2.0) - 4*a*c;
				double temp[] = {(-b + Math.sqrt(d))/(2*a),(-b - Math.sqrt(d))/(2*a) };
				return temp;
			}
		//перегрузка методов
		public static int max(int a, int b) {
			return (a > b )? a: b;
		}
		//возвращает максимальное их 3 методов
		public static int max(int a, int b, int c){
		int temp = Methods.max(a, b);
		temp = Methods.max(temp, c);
		return temp;
		}
		public static String max(String a, String b) {
			int n = a.compareTo(b);
			if(n >= 0)
				return a;
			return b;
		}
		//сравнение календарей
		public static GregorianCalendar max(GregorianCalendar a, GregorianCalendar b){
			int n = a.compareTo(b);
			if(n <= 0)
				return b;
			return a;
		}
		public static StringBuffer max(StringBuffer a, StringBuffer b){
			int first_count = 0;
			int second_count = 0;
			for(int i = 0; i < a.length(); i ++){
				if(a.charAt(i) == 'a')
					first_count ++;
			}
			for(int i = 0; i < b.length(); i ++){
				if(b.charAt(i) == 'a')
					second_count ++;
			}
			if(first_count > second_count)
				return a;
			else
				return b;
		}
		public static File max(File f1, File f2){
			long time1 = f1.lastModified();
			long time2 = f2.lastModified();
			if(time1 > time2)
				return f1;
			return f2;
		}
	}