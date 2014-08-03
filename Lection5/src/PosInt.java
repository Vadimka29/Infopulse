/*
 * положительные числа
 */
public class PosInt {
	private int x;
	
	public PosInt(int a){
		//нужно сказать, что введены неправильные данные
		//если введено отридцательное число, тогда выкинем ошибку
		if(a <= 0)
			throw new RuntimeException("negative value!");
		x = a;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	//четное число или нет
	public boolean isEven(){
		return x % 2 == 0;
	}
	
	//x - нечетное число ? 
	public boolean isOdd(){
		return !isEven();
	}
	//x - квадрат целого числа  ?
	public boolean isSquare(){
		double d  = Math.sqrt(x);
		return d == (int) d;
	}
	public void allDivisors(){
		System.out.print("Divisors: ");
		for(int i = 1; i <= x; i++)
			if(x % i == 0){
				if( i != x)
					System.out.print(i + ", ");
				else
					System.out.print(i);
			}
	}
	public String toString(){
		return "x = " + x;
	}
	//кубический корень вычисляется с погрешностью
	public boolean isCube(){
		double c = Math.pow(x,1.0/5.0);
		int first = (int)c;
		int second = (int)c + 1;
		if(Math.pow(first, 5) == x || Math.pow(second, 5) == x)
			return true;
		return false;
	}
	//наше число шло до другого числа ? 
	//обращаться к a.x мы может так как обращаемся из этого же класса
	public boolean before(PosInt a){
		return x  < a.x;
	}
	public boolean after(PosInt a){
		return x > a.x;
	}
	
	//метод возвращает тройку Пифагора
	public int[] getPythagorasTriple(){
		int a,b,c;
		if(isSquare()){
			c = (int) Math.sqrt(x);
			for(int i = 1; i < c; i++){
				for(int j = 1; j < c; j ++){
					if(Math.pow(i, 2) + Math.pow(j, 2) == x){
						a = i;
						b = j;
						return new int[]{a,b,c};
					}
				}
			}
		}
		return null;
	}
}