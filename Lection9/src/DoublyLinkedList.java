import java.util.Iterator;


public class DoublyLinkedList<E> implements Iterable<E> {
	private class InnerIter implements Iterator<E>{
		private DlNode<E> current;
		
		private InnerIter(){
			//всегда стает на начало
			current = head.getNext();
		}

		@Override
		public boolean hasNext() {
			return current != tail;
		}

		@Override
		public E next() {
			E toReturn = current.getElement();
			current = current.getNext();
			return toReturn;
		}

		@Override
		public void remove(){
			DoublyLinkedList.this.remove(current.getPrev());
		}	
	}
	private DlNode<E> head;
	private DlNode<E> tail;
	private int size;
	
	public DoublyLinkedList(){
		head = new DlNode<E>(null, this);
		tail = new DlNode<E>(null, this);
		head.setNext(tail);
		tail.setPrev(head);
	}
	
	public int size(){
		return size;
	}
	//необходим для операций удаления(для проверки есть ли вообще что удалять)
	public boolean isEmpty(){
		return size == 0;
	}
	public DlNode<E> addFirst(E e){
		DlNode<E> newOne = new DlNode<E>(e, this);
		DlNode<E> oldFirst = head.getNext();
		head.setNext(newOne);
		newOne.setPrev(head);
		newOne.setNext(oldFirst);
		oldFirst.setPrev(newOne);
		size ++;
		return newOne;
	}
	
	public DlNode<E> addLast(E e){
		DlNode<E> newOne = new DlNode<E>(e, this);
		DlNode<E> oldLast = tail.getPrev();
		oldLast.setNext(newOne);
		newOne.setPrev(oldLast);
		newOne.setNext(tail);
		tail.setPrev(newOne);
		size ++;
		return oldLast;
	}
	public Iterator<E> iterator(){
		return new InnerIter();
	}
	@Override
	public String toString(){
		DlNode<E> c = head.getNext();
		String toReturn = "";
		while(c != tail){
			 toReturn += c.getElement() + ",";
			 c = c.getNext();
		}
		return toReturn;
	}
	public E remove(DlNode<E> nd){
		check(nd);
		checkIfEmpty();
		DlNode<E> before = nd.getPrev();
		DlNode<E> after = nd.getNext();
		before.setNext(nd.getNext());
		after.setPrev(nd.getPrev());
		nd.setPrev(null);
		nd.setNext(null);
		nd.setOwner(null);
		size --;
		return nd.getElement();
	}
	public DlNode<E> first(){
		checkIfEmpty();
		return head.getNext();
	}
	public DlNode<E> last(){
		checkIfEmpty();
		return tail.getPrev();
	}
	public DlNode<E> next(DlNode<E> n){
		check(n);
		return (n.getNext() != tail) ? n.getNext() : null;
	}
	public DlNode<E> prev(DlNode<E> n){
		check(n);
		return (n.getPrev() != head) ? n.getPrev() : null;
	}
	//метод для страховки
	private void check(DlNode<E> nd){
		if(nd.getOwner() != this ||
				nd == head || nd == tail)
			throw new RuntimeException("Wrong List");
	}
	private void checkIfEmpty(){
		if(isEmpty())
			throw new RuntimeException("Empty List");
	}
}
