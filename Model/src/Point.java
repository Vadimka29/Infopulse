
public class Point {
	private double x;
	private double y;
	
	public Point() {
		x = 0;
		y = 0;
	}
	public Point(double x_temp, double y_temp) {
		this.x = x_temp;
		this.y = y_temp;
	}
	
	public void setPoint(double x_temp, double y_temp) {
		this.x = x_temp;
		this.y = y_temp;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}	
}