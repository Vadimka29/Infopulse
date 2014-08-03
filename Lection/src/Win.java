import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

//Если запустим таким образом приложение, тогда произойдет утечка памяти
//Если закроем окно, нажав на крестик, тогда закроется окно, но останется в памяти компьютера
public class Win extends JFrame implements ActionListener {
	private JButton button;
	private JButton bt;
	private Container cnt;
	public static void main(String[] args){
		Win w = new Win();
		w.setVisible(true);
	}
	public Win(){
		setBounds(10, 10, 500, 400);
		//для закрытия окна и извлечения его из памяти
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Вывести дату месяц и год вверху окна
		GregorianCalendar g = new GregorianCalendar();
		int y = g.get(Calendar.YEAR);
		int m = g.get(Calendar.MONTH);
		int d = g.get(Calendar.DATE);
		setTitle("Date: " + d  +" Month: " +  (m + 1)+ " Year: " + y);
		//открыть окно на весь экран
		setExtendedState(MAXIMIZED_BOTH);
		//закрасить форму
		//нужно правильно обратиться к окну, не трогая контекстное меню и заголовок
		cnt = getContentPane();
		//отключить менеджер компоновки для того чтоб кнопка не разлезлась на весь экран
		cnt.setLayout(null);
		cnt.setBackground(new Color(255, 200, 250));
		button = new JButton("Hello");
		cnt.add(button);
		button.setBounds(500, 300, 200, 100);
		button.addActionListener(this);
		bt = new JButton("Bye");
		bt.setBounds(100, 200, 200, 100);
		bt.addActionListener(this);
		cnt.add(bt);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//кто породил событие
		Object src = e.getSource();
		if(src == bt){
			cnt.setBackground(new Color(255, 200, 250));
		}
		else
			cnt.setBackground(Color.ORANGE);
	}
}