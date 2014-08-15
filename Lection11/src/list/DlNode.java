package list;

public class DlNode<E> implements IContainer<E> {
	private Object owner;
	private E element;
	private DlNode<E> next;
	private DlNode<E> prev;
	public DlNode(E e){
		element = e;
	}
	public DlNode(E e, Object o){
		this(e);
		owner = o;
	}
	
	public void setOwner(Object o){
		owner = o;
	}
	public Object getOwner(){
		return owner;
	}
	//getters and setters
	public E getElement(){
		return element; 
	}
	public void setElement(E e){
		element = e;
	}
	public DlNode<E> getNext() {
		return next;
	}
	public void setNext(DlNode<E> next) {
		this.next = next;
	}
	public DlNode<E> getPrev() {
		return prev;
	}
	public void setPrev(DlNode<E> prev) {
		this.prev = prev;
	}
	
}
