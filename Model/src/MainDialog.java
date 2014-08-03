import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JDialog;

public class MainDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private Ball ball = new Ball(10,10,10);
	
	public MainDialog() {
		super();
		setBounds(400, 150, 500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Container contentPane = getContentPane();
		setVisible(true);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		double x =  ball.getXCenter();
		double y = ball.getYCenter();
		double r = ball.getRadius();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawOval((int) ball.getXCenter(), (int) ball.getYCenter(),
				(int) ball.getRadius(),(int) ball.getRadius());
		for(int i = 0; i < 1000; i ++){
			Ellipse2D.Double ell = new Ellipse2D.Double(++x,y,r,r);
			g2d.draw(ell);
		}
	}
	public void updateDialog(double x, double y) {
		ball.setCenter(x, y);
		this.update(getGraphics());
	}
	public Ball getBall(){
		return ball;
	}
}
