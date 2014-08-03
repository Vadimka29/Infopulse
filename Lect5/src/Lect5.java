import java.io.*;

public class Lect5 {
	public static void main(String[] args){
		try{
			//нужно учитывать права доступа к папкам
			//можно добавить второй параметр (тогда режим дописывание)
			String path = "/media/vadim/12EAE1C3EAE1A369/n.txt";
			FileWriter fw = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Hello");
			//в разных операционных системах разные символы перевода на новую строку
			//поэтому нужно вызывать отдельно метод для перевода строки
			bw.newLine();
			bw.write("Second Line");
			bw.newLine();
			//в конце нужно закрыть писатель
			//если не закрыть - данные не поступят на жесткий диск
			bw.close();
			//как запусть другую программу
			//параметр exec - масссив строк , в котором первый элемент - название программы
			//второй - файл, который будем открывать
			Runtime.getRuntime().exec(new String[]{"gedit",path});
		
			//просто запустить что-то (Какуе-то программу)
			//Runtime.getRuntime().exec("eclipse");
		}
		catch(Exception e){
			System.out.println("error " + e);
		}
	}
}
