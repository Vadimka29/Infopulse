import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextLayout;

import javax.swing.JButton;
import javax.swing.JLabel;


public class Listeners extends MouseAdapter {
	public void mousePressed(MouseEvent e){
		super.mousePressed(e);
		//runCounter isn't pair. It means human run
		if(GameController.getRunCounter() % 2 != 0) {
			MainButton bt = (MainButton) e.getSource();
			Font font = new Font("Verdana", Font.BOLD,90);
			//if cell is free - then put the symbol
			if(GameController.isFree(bt.getI(), bt.getJ())){
				bt.setFont(font);
				bt.setText("O");
				GameController.humanRun(bt.getI(), bt.getJ());
				GameController.incrementCount();
				MainFrame.dialog.setTitle("STATUS: X Run ...");
				if(GameController.isWinner() != '_') {
					MainFrame.dialog.setTitle(GameController.isWinner() + " is WINNER");
					//waiting
					MainFrame.dialog.setEnabled(false);
				}
			}
		}
		//runCounter isn't pair. It means computer run
		else {
			MainButton bt = (MainButton) e.getSource();
			Font font = new Font("Verdana", Font.BOLD,90);
			//if cell is free
			if(GameController.isFree(bt.getI(), bt.getJ())){ 
				bt.setFont(font);
				bt.setText("X");
				GameController.computerRun(bt.getI(), bt.getJ());
				GameController.incrementCount();
				MainFrame.dialog.setTitle("STATUS: O Run ...");
				if(GameController.isWinner() != '_') {
					MainFrame.dialog.setTitle(GameController.isWinner() + " is WINNER");
					MainFrame.dialog.setEnabled(false);
				}
			}
		}
		//if there are no free cells
		if(GameController.isOverRun()) {
			MainFrame.dialog.setTitle("Result: No Winners");
			MainFrame.dialog.setEnabled(false);
		}
		
	}
}
