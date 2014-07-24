import java.io.File;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Lection4 {

	public static void main(String[] args) {
		//рисует звездочки
		Methods.printStars(5);
		System.out.println();
		
		//факториал
		//после десятка выходит за границы int
		System.out.println("factorial: " + Methods.factor(4));
		//рекурсивная проверка на полиндром
		String s = "lalal";
		System.out.println("isPolindrom: " + Methods.isPolindrom(s,0 , s.length()-1));
		
		//сумма элементов массива
		int[] array = {0,10,3,2,1, 15, 3 };
		
		//при достаточно большом размере массива - ошибка (переполнение стека)
		//Нужно хранить информацию для локальных переменных каждой ветки
		System.out.println("Summ: " + Methods.massSum(array,0));
		
		//сортировка массивов
		Methods.recFindSort(array, 0);
		System.out.println(Arrays.toString(array));
		
		File f = new File("/home/vadim/Загрузки");
		File f1 = new File("/media/vadim/12EAE1C3EAE1A369/Projects/untitled");
		//отображает все подкаталоги каталога рекурсивно
		//Methods.showDir(f);
		
		//Считает количество файлов на любом уровне вложености
		System.out.println("Count of Files: " + Methods.countFiles(f));
		
		//находит файл с максимальным размером в каталоге
		File temp = Methods.foundFile(f);
		System.out.println(temp.getName());
		System.out.println("File with max length in bytes: " + temp.length());
		
		//String.format
		//вывести с точностью до двух знаков после запятой
		//действует округление
		String str = String.format("%.2f",Math.PI);
		System.out.println(str);
		
		//Вывести на экран число 10 в трех разных системах счисления
		// %d - decimal, %0 - octal, %x = hexe decimak
		System.out.println("10 в разных системах: ");
		System.out.println(String.format("%d %o %x", 10, 10, 10 ));
		
		//другие команды форматирование %c - работа с символами %C - меняется регистр символа
		System.out.println(String.format("%c %C %d", 97, 97, 97));
		
		//работа со строками %S - поменяет регистр +  календарь
		//текущая дата в календаре
		GregorianCalendar g = new GregorianCalendar();
		System.out.println(String.format("%s %S", "Java", "Java"));
		//между командами форматирования можно писать все что угодно (эти вещи не поменяются
		//выведем время
		System.out.println(String.format("%tH:%tM:%tS",g,g,g));
		//выведем год дату и день
		//месяц выведет не с нуля, а нормально
		System.out.println(String.format("%tY %tm %td", g, g, g));
		//выведем это словами
		//последний параметр игнорируется (это не будет ошибкой)
		System.out.println(String.format("wday = %tA mon = %tB", g, g, g));
		//format - перегруженый метод, можем добавить параметр Locale
		System.out.println(String.format(Locale.FRANCE, "wday = %tA mon = %tB", g, g, g));
		//на укр языке
		System.out.println(String.format(new Locale("uk"), "wday = %tA mon = %tB", g, g, g));
		
		//есть возможность ещё указывать ширину колонки
		//её нужно указывать после процента, но перед латинской буквой
		
		//выведем на экран колонку ( массив строк ), где к каждой строке будет добавлятся определенное
		//количество пробелов
		String[] strArray = {"Java", "C#", "Pascal"};
		for (String t : strArray)
			System.out.println(String.format("%50S", t));
		for(int i = -5; i <= 5; i ++){
			System.out.println(String.format("%05d", i));

			//отридцательные числа пишет в скобках, положительные - плюс
			//это называются флагами - или выравнивание по краю или же знак числа
			//присутствует знак или нет, к примеру отридцательное число выводится в скобках
			System.out.println(String.format("%(+10d", i));
		}
		
		//вывести таблицу
		Methods.table();
	}
}