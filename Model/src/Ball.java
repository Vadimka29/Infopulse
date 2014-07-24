
public class Ball {
	private Point center = new Point();
	private double radius;
	
	public Ball() {
		center.setPoint(0, 0);
		radius = 0;
	}
	public Ball(double x, double y, double r){
		center.setPoint(x, y);
		radius = r;
	}
	
	//getters and setters 
	public void setCenter(double x, double y){
		center.setPoint(x, y);
	}
	public double getXCenter() {
		return center.getX();
	}
	public void setXCenter(double xCenter) {
		center.setPoint(xCenter, center.getY());
	}
	public double getYCenter() {
		return center.getY();
	}
	public void setYCenter(double yCenter) {
		center.setPoint(center.getX(), yCenter);
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
