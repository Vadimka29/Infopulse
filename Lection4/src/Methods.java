import java.io.File;

public class Methods {

	//выводит ряд звездочек (рекурсия)
	public static void printStars(int count){
		if(count == 0)
			return;
		System.out.print("* ");
		printStars(count - 1);
	}
	//вычисление факториала
	public static int factor(int n){
		if(n == 1)
			return 1;
		return n*factor(n-1);
	}
	//рекурсивная проверка на полиндром 
	public static boolean isPolindrom(String temp, int i, int j){
		//если все слово проанализировано
		if(i == j)
			return true;
		//если какие-то буквы не совпали, сразу возвращаем false
		if(temp.charAt(i) != temp.charAt(j))
			return false;
		return isPolindrom(temp, i+1, j-1);
	}
	//рекурсивно считает сумму массива
	public static int massSum(int[] mass,int counter){
		if(counter <= mass.length - 1)
			return mass[counter] + massSum(mass, ++ counter);
		return 0;
	}
	
	//сортировка поиском
	//Selection Sort
	public static void findSort(int[] m){
		for(int i = 0; i < m.length; i ++){
			int min = i;
			for(int j = i + 1; j < m.length; j ++){
				if(m[j] < m[i]){
					min = j;
				}
			}
			if(min > i){
				int t = m[min];
				m[min] = m[i];
				m[i] = t;
			}
		}
	}
	//рекурсивная сортировка
	public static void recFindSort(int[] m, int index) {
		if (index >= m.length)
			return;

		int min = index;
		for (int j = index + 1; j < m.length; j++) {
			if (m[j] < m[min])
				min = j;
		}
		
		if (min > index) {
			int t = m[min];
			m[min] = m[index];
			m[index] = t;
		}
		recFindSort(m, ++index);
	}
	
	//метод, который может обшарить весь каталог и вывести все подкаталоги
	public static void showDir(File dir){
		System.out.println(dir.getName());
		//Особенность: папки в массиве будут отсортированы по именам
		File[] fds = dir.listFiles();
		//каталог не дает возможности залезть к нему внутрь(права доступа)
		//тогда возвращает null
		if(fds == null)
			return;
		for(File t: fds){
			if(t.isDirectory())
				showDir(t);
		}
	}
	
	//количество файлов посчитать в каталоге определенном на каждом уровне вложенности
	public static int countFiles(File dir){
		int count = 0;
		File[] fds = dir.listFiles();
		if(fds == null) //"спецкаталог"
			return 0;
		for(File t: fds){
			if(t.isFile()){
				count += 1;
				}
			if(t.isDirectory())
				 count += countFiles(t);
		}
		return count;
	}
	
	//найти самый большой файл в каталоге на всех уровнях вложености
	public static File foundFile(File dir){
		//может не всегда сработать, лучше присвоить туда первый попавшийся файл
		File f = new File("");
		File[] fds = dir.listFiles();
		if(fds == null) //"спецкаталог"
			return null;
		for(File t: fds){
			if(t.isFile()){
				if(t.length() > f.length())
					f = t;
				}
			if(t.isDirectory()){
				if(foundFile(t).length() > f.length())
					f = foundFile(t);
				}
			}
		return f;
	}
	
	//**************Доделать в тетрадке записать
	//форматирование вывести две колонки, в одной число ,в другой корень из него
	// точность до 2 - го знака после запятой, и ширина второй колонки 10 символов
	public static void table(){
		for(int i = 1; i < 11; i ++){
			System.out.println(String.format("%-10d %.2f", i,Math.sqrt(i)));
		}
	}
}