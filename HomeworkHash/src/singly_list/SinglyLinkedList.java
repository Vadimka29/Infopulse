package singly_list;
import java.util.zip.Checksum;


public class SinglyLinkedList<E> {
	private SlNode<E> head, tail;
	//для учета длинны списка
	private int size;
	
	public SinglyLinkedList(){
		head = new SlNode<E>(null);
		tail = new SlNode<E>(null);
		head.setNext(tail);
	}
	public void addFirst(E e){
		SlNode<E> newOne = new SlNode<E>(e);
		SlNode<E> oldFirst = head.getNext();
		head.setNext(newOne);
		newOne.setNext(oldFirst);
		size ++;
	}
	public E removeFirst(){
		if(isEmpty())
			throw new RuntimeException("list is empty");
		SlNode<E> oldFirst = head.getNext();
		head.setNext(oldFirst.getNext());
		oldFirst.setNext(null);
		size --;
		return oldFirst.getElement();
	}
	public E removeLast(){
		if(isEmpty())
			throw new RuntimeException("list is empty");
		SlNode<E> current = head;
		while(current.getNext().getNext() != tail){
			current = current.getNext();
		}
		SlNode<E> oldLast = current;
		current.setNext(tail);
		oldLast.setNext(null);
		size --;
		return oldLast.getElement();
	}
	//add last element
	public void addLast(E e){
		SlNode<E> current = head;
		while(current.getNext()!= tail){
			current = current.getNext();
		}
		SlNode<E> newOne = new SlNode<E>(e);
		current.setNext(newOne);
		newOne.setNext(tail);
		size ++;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	public SlNode<E> first(){
		checkIfEmpty();
		return head.getNext();
	}
	public SlNode<E> last(){
		checkIfEmpty();
		SlNode<E> current = head.getNext();
		while(current.getNext() != tail){
			current = current.getNext();
		}
		return current;
	}
	public SlNode<E> next(SlNode<E> n){
		check(n);
		return (n.getNext() != tail) ? n.getNext() : null;
	}
	private void check(SlNode<E> nd){
		if(nd == head || nd == tail)
			throw new RuntimeException("Wrong List");
	}
	private void checkIfEmpty(){
		if(isEmpty())
			throw new RuntimeException("Empty List");
	}
	public String toString(){
		SlNode<E> current = head.getNext();
		String toReturn ="";
		while(current != tail){
			toReturn +=current.getElement() + ",";
			current = current.getNext();
		}
		return "SlList[" + toReturn + "]";
	}
}