import java.awt.Container;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class MainDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private GameController controller = new GameController();
	private static final int N = 3;
	static MainButton[][] bmass = new MainButton[N][N];

	public MainDialog() {
		super();
		setBounds(400, 150, 500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//for right font size
		if(MainDialog.getN() > 6)
			this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		setLayout(new GridLayout(N,N));
		Container contentPane = getContentPane();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++){
				bmass[i][j] = new MainButton(i,j);
				contentPane.add(bmass[i][j]);
				bmass[i][j].addMouseListener(new Listeners());
			}
		}
		setVisible(true);
	}

	//update Run status in title
	public void updateStatus() {
		if(GameController.getRunCounter() % 2 != 0)
			setTitle("STATUS: X Run...");
		else
			setTitle("STATUS: O Run...");
	}
	public GameController getController() {
		return controller;
	}
	//for getting button of bmass
	public static MainButton getButton(int i_temp, int j_temp) {
		return bmass[i_temp][j_temp];
	}
	
	//get size of field
	public static int getN(){
		return N;
	}
	//get Size of Button
	public static int getButtonSize(){
		MainButton bt = bmass[0][0];
		return  (int) bt.getSize().getHeight();
	}
}
