package game;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import game.View.StartFrame.MyButton;

public class Controller implements Serializable {
	private int fieldSize;
	private int minesCount;
	private long time;
	private MyButton[][] field;
	private int neutralizeCounter;
	private Color defaultColor;

	public Controller() {
		fieldSize = 8;
		minesCount = 10;
		time = 20;
		// getDefaultColor
		JButton bt = new JButton();
		defaultColor = bt.getBackground();
	}

	// generate field with mines
	public void generateMinerField(MyButton[][] buttonArray, MyButton current) {
		field = buttonArray;
		int i = getIndexOf(current)[0];
		int j = getIndexOf(current)[1];
		// set mine status
		for (int temp = 0; temp < minesCount; temp++) {
			int[] array = generateTwoDigits(0, field.length);
			while (array[0] == i && array[1] == j)
				array = generateTwoDigits(0, field.length);
			int i_final = array[0];
			int j_final = array[1];
			field[i_final][j_final].setMineStatus(true);
		}
	}

	// main algorithm
	public void checkButton(MyButton button, JFrame frame, Timer timer) {
		if (button.getBackground().equals(new Color(0, 255, 0))) {
			neutralizeCounter--;
		}
		// if it is mine
		if (button.isMine()) {
			button.setBackground(new Color(255, 0, 0));
			button.setNeutralized(true);
			JLabel label = new JLabel("Game Over");
			frame.setTitle("Game Over!");
			View.setStartFrameExist(false);
			String message = "BOOOOOMM!!! Game Over!!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Game Over!",
					JOptionPane.INFORMATION_MESSAGE);
			neutralizeCounter = 0;
			timer.stop();
			frame.dispose();
		}
		// if isn't mine
		else {
			button.setNeutralized(true);
			button.setCount(mineCounter(button));
			button.setBackground(new Color(255, 255, 255));
			button.setText(button.getCount() + "");
			button.setEnabled(false);
			// if all fields is neutralized
			if (isWin()) {
				frame.setTitle("You win!");
				frame.setEnabled(false);
				String message = new String("You win!");
				View.setStartFrameExist(false);
				JOptionPane.showMessageDialog(new JFrame(), message,
						"You win!", JOptionPane.INFORMATION_MESSAGE);
				neutralizeCounter = 0;
				timer.stop();
				frame.dispose();
			}
			// if there is no bomb around
			if (button.getCount() == 0) {
				int i_final = getIndexOf(button)[0];
				int j_final = getIndexOf(button)[1];
				for (int i = 0; i < field.length; i++) {
					for (int j = 0; j < field[i].length; j++) {
						if ((i >= i_final - 1) && (i <= i_final + 1)
								&& (j >= j_final - 1) && (j <= j_final + 1)
								&& !(field[i][j].isNeutralized())) {
							checkButton(field[i][j], frame, timer);
						}
					}
				}
			}
		}
	}

	// neutralize mines
	public void neutralize(MyButton button, JFrame frame, Timer timer) {
		Color neutralize = new Color(0, 255, 0);
		// if has already disabled
		if (!button.isEnabled()) {
			return;
		}
		// if there are a lot of neutralize field
		if (neutralizeCounter >= minesCount) {
			if (button.getBackground().equals(neutralize)) {
				button.setBackground(defaultColor);
				button.setNeutralized(!button.isNeutralized());
				neutralizeCounter--;
				return;
			} else {
				return;
			}
		}
		if (!button.isNeutralized()) {
			button.setBackground(neutralize);
			neutralizeCounter++;
		} else {
			button.setBackground(defaultColor);
			neutralizeCounter--;
		}
		button.setNeutralized(!button.isNeutralized());
		if (isWin()) {
			frame.setTitle("You win!");
			frame.setEnabled(false);
			String message = new String("You win!");
			View.setStartFrameExist(false);
			JOptionPane.showMessageDialog(new JFrame(), message, "You win!",
					JOptionPane.INFORMATION_MESSAGE);
			neutralizeCounter = 0;

			timer.stop();
			frame.dispose();
			return;
		}
	}

	// win check
	private boolean isWin() {
		int counter = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (!field[i][j].isNeutralized()) {
					counter++;
				}
			}
		}
		return counter == 0;
	}

	// the number of mines around of current field
	private int mineCounter(MyButton button) {
		int counter = 0;
		int i = getIndexOf(button)[0];
		int j = getIndexOf(button)[1];
		for (int t = 0; t < field.length; t++) {
			for (int k = 0; k < field[t].length; k++) {
				if (t >= i - 1 && t <= i + 1 && k >= j - 1 && k <= j + 1
						&& field[t][k].isMine())
					counter++;
			}
		}
		return counter;
	}

	// generate index of field with mine
	private int[] generateTwoDigits(int from, int to) {
		int i = (int) (Math.random() * to + from);
		int j = (int) (Math.random() * to + from);
		return new int[] { i, j };

	}

	// get index of button in field
	private int[] getIndexOf(MyButton button) {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j].equals(button)) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	// getters and setters
	public int getFieldSize() {
		return fieldSize;
	}

	public void setFieldSize(int fieldSize) {
		this.fieldSize = fieldSize;
	}

	public int getMinesCount() {
		return minesCount;
	}

	public void setMinesCount(int minesCount) {
		this.minesCount = minesCount;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getNeutralizeCounter() {
		return neutralizeCounter;
	}

	public void setNeutralizeCounter(int neutralizeCounter) {
		this.neutralizeCounter = neutralizeCounter;
	}
}
