import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextLayout;

import javax.swing.JButton;
import javax.swing.JLabel;


public class Listeners extends MouseAdapter {
	public void mousePressed(MouseEvent e){
		super.mousePressed(e);
		//human run
		MainButton btHum = (MainButton) e.getSource();
		//You should change for different size of fields
		Font font = new Font("Verdana", Font.BOLD,MainDialog.getButtonSize()/2);
		if(GameController.isFree(btHum.getI(), btHum.getJ()) && 
				GameController.getRunCounter() % 2 == 0){
			btHum.setFont(font);
			btHum.setText("O");
			GameController.humanRun(btHum.getI(), btHum.getJ());
			GameController.incrementCount();
			MainFrame.dialog.setTitle("STATUS: X Run ...");
		}
		if(GameController.winner() != '_') {
			MainFrame.dialog.setTitle(GameController.winner() + " is WINNER");
			GameController.cleanRunCounter();
			MainFrame.dialog.setEnabled(false);
			return;
		}
		if(GameController.getRunCounter() % 2 != 0){
		// make human run and predict the run of computer
		for(int i = 0; i < GameController.massGame.length; i ++){
			for(int j = 0; j < GameController.massGame[i].length; j ++){
				if(GameController.isFree(i, j) && 
						GameController.predictComputerWin(i,j)){
					MainButton btComp = MainDialog.getButton(i, j);
					btComp.setFont(font);
					btComp.setText("X");
					GameController.computerRun(i, j);
					GameController.incrementCount();
					MainFrame.dialog.setTitle("STATUS: O Run ...");
					if(GameController.winner() != '_') {
						MainFrame.dialog.setTitle(GameController.winner() + " is WINNER");
						GameController.cleanRunCounter();
						//waiting
						MainFrame.dialog.setEnabled(false);
						return;
					}
					return;
				}
			}
		}	
	}
		//if there are no free cells
		if(GameController.isOverRun()) {
			MainFrame.dialog.setTitle("Result: No Winners");
			GameController.cleanRunCounter();
			MainFrame.dialog.setEnabled(false);
		}	
	}
}
