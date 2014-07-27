import java.util.Iterator;

//реализации итератора
public class SimpleIter implements Iterator<Integer>,Iterable<Integer> {
	private int[] m = {1,2,3,4,5};
	private int index;
	
	public boolean hasNext(){
		return index < m.length;
	}
	public Integer next(){
		return m[index++];
	}
	public void remove(){/*зашлушка*/}
	
	public Iterator<Integer> iterator(){
		index  = 0;
		return this;
	}
}
