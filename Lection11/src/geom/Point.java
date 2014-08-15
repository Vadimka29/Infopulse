package geom;

public class Point {
	protected int x,y;
	
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	public double dist(){
		return Math.sqrt(x*x + y*y);
	}
	
	public void print(){
		System.out.println(toString() + "dist = " + dist());
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
