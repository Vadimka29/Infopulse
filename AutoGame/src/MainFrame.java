import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	static MainDialog dialog;

	public MainFrame() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		setTitle("Game");
		//to delete the object from memory after closing
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Container contentPane =  getContentPane();
		contentPane.setBackground(new Color(140,150,190));
		setBounds(400, 150, 500,500);
		//layout manager
		contentPane.setLayout(new GridLayout(3,3));
		JPanel jpanel = new JPanel();
		//JLabels are for correct placemnet
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		contentPane.add(jpanel);
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		
		jpanel.setLayout(new GridLayout(0,1));
		JButton bstart = new JButton("Start");
		JButton bsettings = new JButton("Settings");
		JButton babout = new JButton("About");
		JButton bexit = new JButton("Exit");
		jpanel.add(bstart);
		jpanel.add(bsettings);
		jpanel.add(babout);
		jpanel.add(bexit);
		bstart.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				dialogCreation();
			}
		});
		bexit.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				super.mousePressed(e);
				//remove from memory
				dispose();
			}
		});
		setVisible(true);
	}
	//create MainDialog object
	private void dialogCreation(){
		dialog = new MainDialog();
		dialog.setTitle("STATUS: O Run ...");
	}
}
