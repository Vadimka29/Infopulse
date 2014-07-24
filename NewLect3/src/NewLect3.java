import java.io.File;
import java.util.Arrays;

import javax.swing.text.html.FormSubmitEvent.MethodType;


public class NewLect3 {

	public static void main(String[] args) {
		//Arity methods ( метод с переменным количеством параметров)
		System.out.println(Methods.sum(1 + 2 + 3));
		System.out.println(Methods.calc(1.2,0,1,2,3.4));
		String[] s = { "шалаш", "лаала"};
		System.out.println(Methods.stringCalc(s));
		int[] mass1 = {1,2,3,4, 90,1,2,0};
		int[] mass2 = {3,10,5,1,0};
		Methods.megaSort(mass1, mass2);
		System.out.println(Arrays.toString(mass1));
		System.out.println(Arrays.toString(mass2));
		System.out.println(Methods.getDayName(1, Methods.Langs.EN));
		//перечисление воиских званий
		System.out.println(Methods.milRank(Methods.Rank.Capitan));
		//перечисление, которое написала фирма Sun
		//Thread.State
		File f1 = new File("/media/vadim/0484FD0484FCF8CE/a/b/c");
		System.out.println(f1.exists());
		try{
			System.out.println(f1.mkdirs());
		} catch(Exception e){
			System.out.println("");
		}
	}

}
