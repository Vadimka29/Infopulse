import java.util.Arrays;
import java.util.GregorianCalendar;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.w3c.dom.css.Rect;


public class Lection5 {
	public static void main(String[] args) {
		//
		PosInt i = new PosInt(9);
		//проверка на четность
		System.out.println(i.isEven());
		System.out.println(i.isOdd());
		System.out.println(i.isSquare());
		i.allDivisors();
		System.out.println("\n______");
		//массив обьектов пользовательского типа
		PosInt[] m = {new PosInt(25), new PosInt(17), new PosInt(1)};
		//каждому обьекту задаем вопрос является ли он квадратом целого числа
		for(PosInt temp: m){
			System.out.println(temp.isSquare());
		}
		//чтобы вывести обьект пользовательского типа нужно 
		//переопределить метод toString()
		System.out.println(i);
		//пример неудачного вывода
		//System.out.println(new GregorianCalendar());
		for(int j = 1; j < 100; j ++){
			int z = j*j*j;
			System.out.println(Math.pow(z, 1.0/3.0));
		}
		PosInt p = new PosInt((int)Math.pow(73.0,5));
		System.out.println(p.isCube());
		
		//найти тройку пифагора
		PosInt p1 = new PosInt(100);
		System.out.print("Pythagoras Triple: ");
		System.out.println(Arrays.toString(p1.getPythagorasTriple()));
		
		Rectangle rec = new Rectangle(6);
		rec.draw(true);
		rec.draw(false);
		Test t = new Test();
		System.out.println(t);
		
		Rectangle[] rect = {
				new Rectangle(6),
				new Rectangle(4),
				new Rectangle(5)
		};
		Arrays.sort(rect);
		System.out.println(Arrays.toString(rect));
	}
}
