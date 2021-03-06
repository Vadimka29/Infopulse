import java.util.Arrays;


public class Lection5 {
	public static void main(String[] args) {
		FBCountry[] m = {
				new FBCountry("Brazil", 5),
				new FBCountry("France", 1),
				new FBCountry("Italy", 4),
				new FBCountry("Urugavai", 2)
		};
		Arrays.sort(m);
		System.out.println(Arrays.toString(m));
		
		//применение Escape последовательностей
		// \t как пружина отжимает данные в следующую колонку
		//длина столбца не должна превышать 7 символов
		System.out.println("javaaaa\t1995");
		System.out.println("c++\t1983");
		System.out.println("Pascal\t1971");
		System.out.println("c:\\tmp\\b.txt");
		System.out.println("country \"Brasil\"");
		char ch = '\'';
		System.out.println(ch);
		//если знаем номер \n = 10 тогда можно так:D
		System.out.println("one" + (char) 10 + "two");
		char c = (char) 39;
		System.out.println(c);
		//посчитать сколько двойных и сколько одиночных кавычек
		int first_counter = 0;
		int second_counter = 0;
		String str = "abc\"1930\'\"abc";
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '\'')
				first_counter ++;
			if(str.charAt(i) == '\"')
				second_counter ++;
		}
		System.out.println("symbol \' : " + first_counter);
		System.out.println("symbol \" : " +  second_counter);
	}
}