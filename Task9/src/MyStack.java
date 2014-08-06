import java.util.Iterator;

public class MyStack<E> implements Iterable<E>{
	private class InnerIter implements Iterator<E>{
		private SlNode<E> current;
		public InnerIter(){
			current = sl.first();
		}
		@Override
		public boolean hasNext() {
			return sl.next(current) != null;
		}

		@Override
		public E next() {
			E temp = current.getElement();
			current = sl.next(current);
			return temp;
		}

		@Override
		public void remove() {
			//заглушка
		}
		
	}
	private SinglyLinkedList<E> sl;
	
	public MyStack(){
		sl = new SinglyLinkedList<>();
	}
	
	public boolean isEmpty(){
		return sl.isEmpty();
	}
	public int size(){
		return sl.size();
	}
	public void push(E element){
		sl.addFirst(element);
	}
	public E pop(){
		return sl.removeFirst();
	}
	@Override
	public String toString(){
		String toRemove = "[";
		SlNode<E> cur = sl.first();
		while(cur != null){
			toRemove += cur.getElement();
			toRemove += ",";
			cur = sl.next(cur);
		}
		toRemove += "]";
		return toRemove;
	}

	@Override
	public Iterator<E> iterator() {
		return new InnerIter();
	}
	
}
