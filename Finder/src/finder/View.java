package finder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

public class View extends JFrame {
	private Container cnt;
	private JTextField keyField;
	private JLabel pathLabel;
	private JTextField pathField;
	private JButton bt;
	private JPanel panel;
	private JLabel keyLabel;
	private JProgressBar pb;

	private class MyThread extends Thread {
		private Controller controller;
		public MyThread(){
			controller = new Controller();
		}
		public void run() {
			String findKey = keyField.getText();
			String path = pathField.getText().trim();
			if (findKey.isEmpty() || path.isEmpty()) {
				String message = "Key is empty or path is empty. Please enter it!!";
				JOptionPane.showMessageDialog(new JFrame(), message, "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}// if findKey isn't empty
			else {
				pb.setVisible(true);
				ArrayList<File> list = controller.getFiles(path,
						new NameFileFilter(findKey));
				JList<Object> lst = null;
				try {
					if (list.isEmpty()) {
						pb.setVisible(false);
						String message = "There is no such files";
						JOptionPane.showMessageDialog(new JFrame(), message,
								"Find Result", JOptionPane.ERROR_MESSAGE);
					} else {
						lst = new JList<>(list.toArray());
						JDialog dialog = new JDialog();
						dialog.setBounds(400, 200, 500, 500);
						JScrollPane pane = new JScrollPane(lst);
						dialog.add(pane, BorderLayout.CENTER);
						pb.setVisible(false);
						dialog.setVisible(true);
					}
				} catch (NullPointerException exc) {
					pb.setVisible(false);
					String message = "Path is incorrect or directory is empty."
							+ " Please check your enter!!";
					JOptionPane.showMessageDialog(new JFrame(), message,
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private class AListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MyThread thread = new MyThread();
			thread.start();
		}

	}

	public View() {
		super();
		
		pb = new JProgressBar();
		pb.setIndeterminate(true);
		keyField = new JTextField();
		pathLabel = new JLabel("Write path: ");
		pathField = new JTextField();
		cnt = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 200, 500, 500);
		setVisible(true);
		setTitle("Finder");
		setLayout(new BorderLayout());
		cnt.setBackground(new Color(200, 170, 250));
		panel = new JPanel();
		panel.setBackground(new Color(200, 170, 250));
		keyLabel = new JLabel("Write find key: ");
		bt = new JButton("Find");
		bt.addActionListener(new AListener());
		cnt.setLayout(new GridLayout(3, 3));
		cnt.add(new JLabel());
		cnt.add(new JLabel());
		cnt.add(new JLabel());
		cnt.add(new JLabel());
		panel.setLayout(new GridLayout(5, 1));
		panel.setSize(100, 100);
		panel.setVisible(true);
		panel.add(keyLabel);
		panel.add(keyField);
		panel.add(pathLabel);
		panel.add(pathField);
		panel.add(bt);
		cnt.add(panel);
		pb.setVisible(false);
		JPanel progressPanel = new JPanel();
		progressPanel.setLayout(new GridLayout(4,1));
		progressPanel.add(new JLabel());
		progressPanel.add(pb);
		progressPanel.add(new JLabel());
		progressPanel.add(new JLabel());
		progressPanel.setBackground(new Color(200,170,250));
		cnt.add(new JLabel());
		cnt.add(new JLabel());
		cnt.add(progressPanel);
		cnt.add(new JLabel());
	}
}
