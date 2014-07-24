
public class CircleList<E> {
	private SlNode<E> cursor;
	private int size;
	
	public CircleList(){
		cursor = new SlNode<E>(null);
		cursor.setNext(cursor);
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	public void addFirst(E e){
		SlNode<E> newOne = new SlNode<E>(e);
		if(isEmpty()){
			cursor.setNext(newOne);
			newOne.setNext(cursor);
		}
		else {
			SlNode<E> oldFirst = cursor.getNext();
			newOne.setNext(oldFirst);
			cursor.setNext(newOne);
		}
		size ++;
	}
	public E removeFirst(){
		if(isEmpty())
			throw new RuntimeException("list is empty");
		SlNode<E> oldFirst = cursor.getNext();
		cursor.setNext(oldFirst.getNext());
		oldFirst.setNext(null);
		size --;
		return oldFirst.getElement();
	}
	public E getNode(int index){
		if(isEmpty())
			throw new RuntimeException("list is empty");
		//если индекс отридцательный
		if(index < 0)
			index = size() + index;
		SlNode<E> current = cursor.getNext();
		for(int i = 0; i < index; i++){
			current = current.getNext();
			//перепрыгиваем через курсор
			if(current == cursor)
				current = current.getNext();
		}
		return current.getElement();
	}
	public String toString(){
		String toReturn = "";
		SlNode<E> c = cursor.getNext();
		while(c != cursor){
			toReturn += c.getElement();
			c = c.getNext();
		}
		return toReturn;
	}
}
