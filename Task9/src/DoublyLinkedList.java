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
		String toReturn = "[";
		while(c != tail){
			 toReturn += c.getElement() + ",";
			 c = c.getNext();
		}
		toReturn += "]";
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
	/**
	 * bubble sorting
	 * @param dl - doublyLinkedList
	 */
	public void sort(){
		if(this.isEmpty())
			throw new RuntimeException("Double linked list is empty");
		int swapCounter = 0;
		for(int i = 0; i < this.size(); i++){
			//start from second element
			DlNode<E> cur = this.next(this.first());
			while(cur  != null){
				E first = this.prev(cur).getElement();
				Comparable a = (Comparable<E>) first;
				E second = cur.getElement();
				Comparable b = (Comparable<E>) second;
				if(a.compareTo(b) > 0){
					swap(this.prev(cur),cur);
					swapCounter ++;
				}
				cur = this.next(cur);
			}
			if(swapCounter == 0)
				return;
			else
				swapCounter = 0;
		}
	}
	private void swap(DlNode<E> a, DlNode<E> b){
		//if  a is the first element
		if(this.prev(a) == null){
			DlNode<E> next = this.next(b);
			head.setNext(b);
			b.setPrev(head);
			b.setNext(a);
			a.setPrev(b);
			a.setNext(next);
			next.setPrev(a);
		}
		//if b is the last element
		else if(this.next(b) == null){
			DlNode<E> prev = this.prev(a);
			prev.setNext(b);
			b.setPrev(prev);
			b.setNext(a);
			a.setPrev(b);
			a.setNext(tail);
			tail.setPrev(a);
		}
		//if a and b are in the middle
		else{
			DlNode<E> prev = this.prev(a);
			DlNode<E> next = this.next(b);
			prev.setNext(b);
			b.setPrev(prev);
			b.setNext(a);
			a.setPrev(b);
			a.setNext(next);
			next.setPrev(a);
		}
	}
}
