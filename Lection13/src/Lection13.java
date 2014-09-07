
public class Lection13 {
	public static void main(String[] args){
		StringBuffer sb = new StringBuffer("");
		StringBuilder sl = new StringBuilder("");
		Thread s1 = new DStrTest(10_000, sl);
		Thread s2 = new DStrTest(10_000, sl);
		s1.start();
		s2.start();
		try{
			s1.join();
			s2.join();
		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println(sb.length());
		/*
		MyThread a = new MyThread();
		MyThread b = new MyThread();
		
		a.start();
		b.start();
		try{
			a.join();
			b.join();
		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println("a: " + a.getCounter() +"\n" + "b: " + b.getCounter() );
		/*
		/*Thread a = new T(10_000,"a");
		Thread b = new T(10_000,"\tb");
		a.start();
		b.start();
		try{
			a.join();
			b.join();
		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println("End! " + " " + a.getState());
	}*/
	}
}
class T extends Thread{
	int max;
	//каждому потоку можем давать имя
	public T(int mx, String name){
		max = mx;
		setName(name);
	}
	@Override
	public void run(){
		for(int i = 0; i < max; i++){
			System.out.println(getName() + " :" + i );
		}
	}
}
class MyThread extends Thread{
	int counter;
	
	public void run(){
		for(int i = 0; i < 1000; i++){
			int temp =(int) (Math.random()*1000);
			if(temp % 2 == 0)
				counter ++;
		}
	}
	public int getCounter(){
		return counter;
	}
}
