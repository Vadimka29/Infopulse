
public class Rectangle implements Comparable {
	private int height;
	private int width;
	
	public Rectangle(int h, int w){
		if(h < 0 || w < 0)
			throw new RuntimeException("height or width < 0");
		height = h;
		width = w;
	}
	public Rectangle(int size ){
		//вызов конструктора другого
		this(size, size);
	}
	
	public int area(){
		return (height*width);
	}
	
	//hollow - пустой
	//доделать
	public void draw(boolean hollow){
		if(hollow == true){
			for(int i = 0; i < height; i++){
				for(int j = 0; j < width; j++)
					System.out.print("* ");
				System.out.println(" ");
			}
			System.out.println();
		}
		else{
			for(int i = 0; i < height; i++){
				for(int j = 0; j < width; j ++){
					if(j % (width - 1) == 0 || i % (height - 1) == 0){
						System.out.print("* ");
						continue;
					}
					System.out.print("  ");
				}
				System.out.println();
			}
		}
	}
	
	
	//getters and setters
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public int compareTo(Object ob){
		Rectangle another = (Rectangle) ob;
		return this.area() - another.area();
	}
	public String toString(){
		return "" + this.area();
	}
}
