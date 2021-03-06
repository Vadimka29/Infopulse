
//Generic Class
//Singly - Link list
public class SlNode<E> {
	private E element;
	private SlNode<E> next;
	
	public SlNode(E inp){
		element = inp;
	}
	public E getElement(){
		return element;
	}
	public void setElement(E e){
		element = e;
	}
	public SlNode<E> getNext(){
		return next;
	}
	public void setNext(SlNode<E> n){
		next = n;
	}
}