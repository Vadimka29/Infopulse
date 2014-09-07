package game;

import game.View.StartFrame.MyButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;

public class View extends JFrame {
	private Container contentPane;
	private JPanel jpanel;
	private JButton bstart;
	private JButton bcontinue;
	private JButton bsettings;
	private JButton babout;
	private JButton bexit;
	private Controller controller;
	private StartFrame sframe;
	private static boolean ViewExist;
	private static boolean startFrameExist;

	public View() {
		super();
		controller = new Controller();

		setTitle("Miner");
		// to delete the object from memory after closing
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setBackground(new Color(140, 150, 190));
		setBounds(400, 150, 500, 500);
		// layout manager
		contentPane.setLayout(new GridLayout(3, 3));
		jpanel = new JPanel();
		// JLabels are for correct placemnet
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		contentPane.add(jpanel);
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());

		jpanel.setLayout(new GridLayout(0, 1));
		bstart = new JButton("Start");
		bstart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				sframe = new StartFrame();
				View.setStartFrameExist(true);
			}
		});
		bcontinue = new JButton("Continue");
		bcontinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);

				// Part 1 serialization
				File file = new File("start.bin");
				try (FileInputStream fis = new FileInputStream(file);
						ObjectInputStream ois = new ObjectInputStream(fis);) {
					Controller c = (Controller) ois.readObject();
					View.this.setController(c);
					sframe = (StartFrame) ois.readObject();
					sframe.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							super.windowClosing(e);
							makeWindowsAdapterAction(e);
						}
					});
					MyButton array[][] = sframe.getButtonArray();
					MyMouseAdapter adapter = new MyMouseAdapter();
					for (int i = 0; i < array.length; i++) {
						for (int j = 0; j < array[i].length; j++) {
							array[i][j].addMouseListener(adapter);
						}
					}
					sframe.reflesh();
					View.setStartFrameExist(true);
					sframe.setVisible(true);
				} catch (Exception e2) {
					String error = "There is no save!!";
					JOptionPane.showMessageDialog(new JFrame(), error, "About",
							JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}
			}
		});
		bsettings = new JButton("Settings");
		bsettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SettingsFrame sf = new SettingsFrame();
			}
		});
		babout = new JButton("About");
		babout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String message = new String(
						"This is mines game. Created by Vadym Akymov.");
				JOptionPane.showMessageDialog(new JFrame(), message, "About",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		bexit = new JButton("Exit");
		bexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				setViewExist(false);
				// remove from memory
				dispose();
				System.exit(0);
			}
		});
		jpanel.add(bstart);
		jpanel.add(bcontinue);
		jpanel.add(bsettings);
		jpanel.add(babout);
		jpanel.add(bexit);
		setVisible(true);
	}

	// make actions of MouseAdapter for button clicks
	public void makeListenerAction(MouseEvent e) {
		MyButton button = (MyButton) e.getSource();
		StartFrame start = View.this.getStartFrame();
		// if left key of mouse was clicked
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (start.getStepCounter() == 0) {
				controller.generateMinerField(start.getButtonArray(), button);
				controller.checkButton(button, start, start.getTimer());
				start.setStepCounter(start.getStepCounter() + 1);
			} else {
				// get button and make algorithm
				// add my code here!!!
				controller.checkButton(button, start, start.getTimer());
			}
		}
		// if right key of mouse was clicked
		if (e.getButton() == MouseEvent.BUTTON3) {
			if (start.getStepCounter() == 0) {
				controller.generateMinerField(start.getButtonArray(), button);
				controller.neutralize(button, start, start.getTimer());
				start.getFlagCounter().setText(
						"Flags: " + controller.getNeutralizeCounter());
			} else {
				controller.neutralize(button, start, start.getTimer());
				start.getFlagCounter().setText(
						"Flags: " + controller.getNeutralizeCounter());
			}
		}

	}

	// make actions of windows adapter for window closing
	public void makeWindowsAdapterAction(WindowEvent e) {
		StartFrame start = getStartFrame();
		controller.setNeutralizeCounter(0);
		start.setSecond(0);
		start.getTimer().stop();
		setStartFrameExist(false);
		start.dispose();
	}

	// getters and setters
	public StartFrame getStartFrame() {
		return sframe;
	}

	public void setStartFrame(StartFrame frame) {
		sframe = frame;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller cntr) {
		controller = cntr;
	}

	public static boolean isStartFrameExist() {
		return startFrameExist;
	}

	public static void setStartFrameExist(boolean startFrameExist) {
		View.startFrameExist = startFrameExist;
	}

	public static boolean isViewExist() {
		return ViewExist;
	}

	public static void setViewExist(boolean viewExist) {
		ViewExist = viewExist;
	}

	// Start Frame of game
	class StartFrame extends JFrame implements ActionListener, Serializable {
		int stepCounter;
		MyButton but;
		private Container cnt;
		private JPanel gamePanel;
		private MyButton[][] buttonArray;
		private Timer timer;
		JLabel time;
		JLabel flagCounter;
		JLabel mines;
		private JPanel statusPanel;
		private long second;

		// button for miner
		class MyButton extends JButton implements Serializable {
			private boolean mineStatus;
			private int count;
			private boolean neutralized;

			public MyButton() {
				super();
			}

			public boolean isMine() {
				return mineStatus;
			}

			public void setMineStatus(boolean mineStatus) {
				this.mineStatus = mineStatus;
			}

			public int getCount() {
				return count;
			}

			public void setCount(int count) {
				this.count = count;
			}

			@Override
			public String toString() {
				return "MyButton [mineStatus=" + mineStatus + ", count="
						+ count + "]";
			}

			public boolean isNeutralized() {
				return neutralized;
			}

			public void setNeutralized(boolean neutralized) {
				this.neutralized = neutralized;
			}
		}

		public StartFrame() {
			super();
			contentPane.setBackground(new Color(140, 150, 190));
			setBounds(400, 150, 500, 500);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			cnt = getContentPane();
			cnt.setLayout(new BorderLayout());
			gamePanel = new JPanel();
			statusPanel = new JPanel();
			statusPanel.setLayout(new GridLayout(1, 3));
			time = new JLabel();
			mines = new JLabel();
			mines.setText("Mines: " + controller.getMinesCount());
			flagCounter = new JLabel();
			flagCounter.setText("Flags: " + controller.getNeutralizeCounter());
			statusPanel.add(mines);
			statusPanel.add(time);
			statusPanel.add(flagCounter);
			int size = controller.getFieldSize();
			// create field
			buttonArray = new MyButton[size][size];
			gamePanel.setLayout(new GridLayout(size, size));
			// add all buttons
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					but = new MyButton();
					buttonArray[i][j] = but;
					but.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							makeListenerAction(e);
						}
					});
					gamePanel.add(but);
				}
			}
			cnt.add(gamePanel, BorderLayout.CENTER);
			cnt.add(statusPanel, BorderLayout.NORTH);
			// add Timer
			timer = new Timer(1000, this);
			timer.start();
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					super.windowClosing(e);
					// Serialization Part 2
					File f = new File("start.bin");
					try (FileOutputStream fos = new FileOutputStream(f);
							ObjectOutputStream oos = new ObjectOutputStream(fos)) {
						oos.writeObject(controller);
						oos.writeObject(View.StartFrame.this);
					} catch (Exception exc) {
						exc.printStackTrace();
					}
					makeWindowsAdapterAction(e);
				}
			});
			setVisible(true);
		}

		public JLabel getFlagCounter() {
			return flagCounter;
		}

		public void setFlagCounter(JLabel flagCounter) {
			this.flagCounter = flagCounter;
		}

		public Timer getTimer() {
			return timer;
		}

		public void setTimer(Timer timer) {
			this.timer = timer;
		}

		public void reset() {
			timer.stop();
			second = 0;
		}

		public void reflesh() {
			timer.start();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (isStartFrameExist()) {
				if (second > controller.getTime()) {
					second = 0;
					timer.stop();
					StartFrame.this.setTitle("Game Over!");
					String message = "Game Over!! Time is over!";
					JOptionPane.showMessageDialog(new JFrame(), message,
							"Game Over!", JOptionPane.INFORMATION_MESSAGE);
					StartFrame.this.dispose();
					if (!View.isViewExist())
						System.exit(0);
				}
				time.setText("Time: " + second);
				second++;
			}
		}

		// getters and setters
		public MyButton[][] getButtonArray() {
			return buttonArray;
		}

		public void setButtonArray(MyButton[][] buttonArray) {
			this.buttonArray = buttonArray;
		}

		public int getStepCounter() {
			return stepCounter;
		}

		public void setStepCounter(int stepCounter) {
			this.stepCounter = stepCounter;
		}

		public long getSecond() {
			return second;
		}

		public void setSecond(long second) {
			this.second = second;
		}
	}

	class MyMouseAdapter extends MouseAdapter implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			makeListenerAction(e);
		}
	}

	// settings field
	private class SettingsFrame extends JFrame {
		private Container cnt;
		private JPanel settingsPanel;
		private JLabel fieldSizeLabel;
		private JTextField fieldSize;
		private JLabel minesCountLabel;
		private JTextField minesCountField;
		private JLabel timeLabel;
		private JTextField timeField;
		private JButton apply;
		private JButton cancel;
		private JPanel applyPanel;
		private JPanel cancelPanel;

		public SettingsFrame() {
			super();
			setTitle("Settings");
			setLayout(new GridLayout(3, 3));
			// to delete the object from memory after closing
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			cnt = getContentPane();
			cnt.setBackground(new Color(140, 150, 190));
			setBounds(400, 150, 500, 500);
			// layout manager
			cnt.setLayout(new GridLayout(3, 3));
			settingsPanel = new JPanel();
			settingsPanel.setBackground(new Color(140, 150, 190));
			settingsPanel.setLayout(new GridLayout(6, 1));
			fieldSizeLabel = new JLabel("Enter size of field: ");
			fieldSize = new JTextField();
			minesCountLabel = new JLabel("Enter count of mines: ");
			minesCountField = new JTextField();
			timeLabel = new JLabel("Enter time in seconds: ");
			timeField = new JTextField();
			settingsPanel.add(fieldSizeLabel);
			settingsPanel.add(fieldSize);
			settingsPanel.add(minesCountLabel);
			settingsPanel.add(minesCountField);
			settingsPanel.add(timeLabel);
			settingsPanel.add(timeField);

			// apply and cancel panel
			apply = new JButton("Apply");
			cancel = new JButton("Cancel");
			applyPanel = new JPanel();
			applyPanel.setBackground(new Color(140, 150, 190));
			applyPanel.setLayout(new GridLayout(3, 1));
			addJLabels(applyPanel, 1);
			applyPanel.add(apply);
			addJLabels(applyPanel, 1);
			cancelPanel = new JPanel();
			cancelPanel.setBackground(new Color(140, 150, 190));
			cancelPanel.setLayout(new GridLayout(3, 1));
			addJLabels(cancelPanel, 1);
			cancelPanel.add(cancel);
			addJLabels(cancelPanel, 1);

			// add listener for apply
			apply.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					// if some field is empty
					if (fieldSize.getText().isEmpty()
							|| minesCountField.getText().isEmpty()
							|| timeField.getText().isEmpty()) {
						String message = "Some field is empty. Please enter it!!";
						JOptionPane.showMessageDialog(new JFrame(), message,
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						String fieldsize = fieldSize.getText();
						String minesCount = minesCountField.getText();
						String time = timeField.getText();
						// if inputs are digit
						try {
							int fs = Integer.parseInt(fieldsize);
							int mc = Integer.parseInt(minesCount);
							long t = Long.parseLong(time);
							controller.setFieldSize(fs);
							controller.setMinesCount(mc);
							controller.setTime(t);
							dispose();
						} catch (Exception exc) {
							String message = "Invalid input! Check once more!";
							JOptionPane
									.showMessageDialog(new JFrame(), message,
											"ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			// add listener for cancel
			cancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					dispose();
				}
			});
			addJLabels(cnt, 4);
			cnt.add(settingsPanel);
			addJLabels(cnt, 1);
			cnt.add(applyPanel);
			addJLabels(cnt, 1);
			cnt.add(cancelPanel);
			setVisible(true);
		}

		private void addJLabels(Container container, int count) {
			for (int i = 0; i < count; i++) {
				container.add(new JLabel());
			}
		}
	}
}