import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;

public class MainDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private GameController controller = new GameController();
	private final int N = 3;
	MainButton[][] bmass = new MainButton[N][N];

	public MainDialog() {
		super();
		setBounds(400, 150, 500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(3,3));
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
}
