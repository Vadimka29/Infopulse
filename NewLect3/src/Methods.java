import java.util.Arrays;


public class Methods {
	public static enum Langs{ EN, RU};
	public static enum Rank {Lientenant,Capitan, Major,Colonel};
	//метод, который суммирует любое количество элементов
	public static int sum(int ... args){
		//все параметры компилятор упаковывает в массив
		int s = 0;
		for(int i: args){
			s = s + i;
		}
		return s;
	}
	//метод, который считать какое количество вещественных чисел не содержат дробной части
	public static int calc(double ... arg){
		int counter = 0;
		for(double temp: arg){
			if(temp % 1 != 0){
				counter ++;
			}
		}
		return counter;
	}
	//сколько строк являются полиндромами
	public static int stringCalc(String ...s) {
		int counter = 0;
		for(String temp: s){
			if(Methods.isPolyndrom(temp))
				counter ++;
		}
		return counter;
	}
	private static boolean isPolyndrom(String temp){
		int counter = 0;
		//как получить реверс строки
		String sr = new StringBuffer(temp).reverse().toString();
		char[] t = temp.toCharArray();
		for(int i = 0; i < t.length; i ++){
			if(t[i] != t[t.length - i-1])
				return false;
		}
		if(counter != 0)
			return false;
		return true;
	}
	//метод, которому мы передаем любое количесво массивом целых чисел, а он их сортирует
	public static void megaSort(int[] ...arg){
		for(int[] temp: arg){
	//	for(int i = 0; i < arg.length; i ++){
			Arrays.sort(temp);
		}
	}
	//возвращать на разных языках день недели
	public static String getDayName(int p, Langs lang){
		String en[] = {"Mon", "Tue"};
		String ru[] = {"Понедельник", "Вторник"};
		return(lang == Langs.EN)? en[p]: ru[p];
	}
	//возвращает количество звезд на пагонах
	public static String milRank(Rank temp){
	switch (temp) {
	case Capitan:
		return "****";
	case Major:
		return "@";
	case Colonel:
		return "@@@";
	default:
		return "";
	}
	}
}

