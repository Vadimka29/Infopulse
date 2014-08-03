import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Lect3 {

	public static void main(String[] args) {
		GregorianCalendar cl = new GregorianCalendar();
		Methods.seDay13(cl);
		System.out.println("Date: " + cl.get(Calendar.DATE));
		
		int mass[] = new int[10];
		Methods.fillArray(mass, 5);
		for(int i: mass){
			System.out.print(" " + mass[i]);
		}
		//наращивание строки
		String s = "Java";
		s = Methods.incStr(s);
		System.out.println("\n" + s);
		//скопировать часть массива с начала
		int[] mass1 = {10,20,30,40,50,60};
		int temp1[] = Methods.copyOf(mass1, 3);
		for(int i = 0; i < temp1.length; i++)
			System.out.print(" " + temp1[i]);
		int a = 15, b = 10;
		double[] d = Methods.stat(a, b);
		System.out.println();
		System.out.println(Methods.stat(3,4)[2]);
		System.out.println();
		double[] f = Methods.quadEq(4, 1, 4);
		for(int i = 0; i < f.length; i ++){
			System.out.print(" " + f[i]);
		}
		System.out.println();
		System.out.println(Methods.max("a", "b"));
		System.out.println("a".compareTo("c"));
		GregorianCalendar a1 = new GregorianCalendar();
		GregorianCalendar a2 = new GregorianCalendar();
		System.out.println(Methods.max(new StringBuffer("Java"), new StringBuffer("Javaa")));
		File f1 = new File("/home/vadim/Dropbox/ILections/Lect2/1.png");
		File f2 = new File("/home/vadim/Dropbox/ILections/Lect2/2.png");
		File maxf = Methods.max(f1, f2);
		System.out.println(maxf.getName());
			
	}
}

