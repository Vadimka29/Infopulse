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
	public IContainer<E> addFirst(E e){
		DlNode<E> newOne = new DlNode<E>(e, this);
		DlNode<E> oldFirst = head.getNext();
		head.setNext(newOne);
		newOne.setPrev(head);
		newOne.setNext(oldFirst);
		oldFirst.setPrev(newOne);
		size ++;
		return newOne;
	}
	
	public IContainer<E> addLast(E e){
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
		String toReturn = "[";
		while(c != tail){
			 toReturn += c.getElement() + ",";
			 c = c.getNext();
		}
		toReturn += "]";
		return toReturn;
	}
	public E remove(IContainer<E> nd){
		checkIfEmpty();
		DlNode<E> node = check(nd);
		DlNode<E> before = node.getPrev();
		DlNode<E> after = node.getNext();
		before.setNext(node.getNext());
		after.setPrev(node.getPrev());
		node.setPrev(null);
		node.setNext(null);
		node.setOwner(null);
		size --;
		return nd.getElement();
	}
	//добавление узла после указаного
	public void addAfter(IContainer<E> cont, E e){
		DlNode<E> node = check(cont);
		DlNode<E> newOne = new DlNode<E>(e, this);
		DlNode<E> after = node.getNext();
		
		newOne.setPrev(node);
		node.setNext(newOne);
		newOne.setNext(after);
		after.setPrev(newOne);
		
		size++;
	}
	public IContainer<E> first(){
		checkIfEmpty();
		return head.getNext();
	}
	public IContainer<E> last(){
		checkIfEmpty();
		return tail.getPrev();
	}
	public IContainer<E> next(IContainer<E> n){
		DlNode<E> node =  check(n);
		return (node.getNext() != tail) ? node.getNext() : null;
	}
	public IContainer<E> prev(IContainer<E> n){
		DlNode<E> node = check(n);
		return (node.getPrev() != head) ? node.getPrev() : null;
	}
	//метод для страховки
	private DlNode<E> check(IContainer<E> cont){
		//nd.getOwner() != this ||
		if(!(cont instanceof DlNode))
			throw new RuntimeException("wrong node type");
		if(cont == head || cont == tail)
			throw new RuntimeException("Wrong List");
		DlNode<E> toReturn = (DlNode<E>) cont;
		if(toReturn.getOwner() != this)
			throw new RuntimeException("wrong owner!");
		return toReturn;
	}
	private void checkIfEmpty(){
		if(isEmpty())
			throw new RuntimeException("Empty List");
	}
}
