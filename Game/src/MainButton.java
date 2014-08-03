import javax.swing.JButton;


public class MainButton extends JButton {
	private int i;
	private int j;
	
	public MainButton(){
		super();
	}
	public MainButton(int i_temp, int j_temp){
		super();
		setI(i_temp);
		setJ(j_temp);
	}
	public MainButton(String temp, int i_temp, int j_temp){
		super(temp);
		setI(i_temp);
		setJ(j_temp);
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
}
