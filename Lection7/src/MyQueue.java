
public class MyQueue {
	private String[] m;
	private int start, end; //end >= start
	
	public MyQueue(){
		m = new String[8];
	}
	
	public void enqueue(String s){
		if(size() >= m.length)
			resize();
		m[realIndex(end)] = s;
		end ++;
	}
	public String dequeue(){
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		String r = m[realIndex(start)];
		start ++;
		return r;
	}
	public String toString(){
		StringBuffer buff = new StringBuffer();
		for(int i = start; i < end; i ++){
			buff.append(m[realIndex(i)]);
			buff.append(", ");
		}
		return buff.toString();
	}
	public int size(){
		return end - start;
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	public String front(){
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		return m[realIndex(start)];
	}
	
	//служебные методы
	private int realIndex(int index){
		return (index % m.length);
	}
	private int realIndex(int index, int N){
		return (index % N);
	}
	private void resize(){
		String[] n = new String[m.length*2];
		for(int i = start; i < end; i++){
			n[realIndex(i,n.length)] = m[realIndex(i)];
		}
		m = n;
	}
}