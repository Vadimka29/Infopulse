
public class MyQueue<E> {
	private E[] m;
	int itemCounter;
	private int start, end;
	
	@SuppressWarnings("unchecked")
	public MyQueue(){
		m = (E[]) new Object[3];
	}
	
	public void clear(){
		int tempSize = size();
		for(int i = 0; i < tempSize; i++){
			dequeue();
			start = (start +1) % m.length;
			itemCounter --;
		}
	}
	public void enqueue(E s){
		if(isFull())
			resize();
		m[realIndex(end)] = s;
		end = (end +1) % m.length;
		itemCounter ++;
	}
	public E dequeue(){
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		E r = m[realIndex(start)];
		start = (start + 1) % m.length;
		itemCounter --;
		return r;
	}
	public String toString(){
		StringBuffer buff = new StringBuffer("[");
		for(int i = start; i < start + size(); i ++){
			buff.append(m[realIndex(i)]);
			buff.append(",");
		}
		buff.append("]");
		return buff.toString();
	}
	public int size(){
		return itemCounter;
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	public E front(){
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		return m[realIndex(start)];
	}
	//служебные методы
	private int realIndex(int index){
		return (index % m.length);
	}
	public boolean isFull(){
		if(itemCounter == m.length)
			return true;
		else
			return false;
	}
	private void resize(){
		@SuppressWarnings("unchecked")
		E[] n = (E[])new Object[m.length*2];
		int counter = 0;
		for(int i = start; i < start + size(); i++){
			n[counter ++] = m[realIndex(i)];
		}
		start = 0;
		end = counter;
		m = n;
	}
}