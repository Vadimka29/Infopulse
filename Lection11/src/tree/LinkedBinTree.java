package tree;

import java.util.Iterator;

import list.DoublyLinkedList;
import list.IContainer;

public class LinkedBinTree<E> implements Iterable<E> {
	public static enum Traversal {PREORDER, POSTORDER, INORDER};
	private Traversal variant;
	protected BTNode<E> root;
	protected int size;
	
	public LinkedBinTree(){
		this(Traversal.INORDER);
	}
	
	public LinkedBinTree(Traversal variant){
		this.variant = variant;
	}
	
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	//конвертирует IContainer в BTNode, если это возможно,
	//иначе exception
	protected BTNode<E> check(IContainer<E> c){
		return (BTNode<E>) c;
	}
	
	public boolean hasLeft(IContainer<E> c){
		BTNode<E> n = check(c);
		return n.getLeft() != null;
	}
	public boolean hasRight(IContainer<E> c){
		BTNode<E> n = check(c);
		return n.getRight() != null;
	}
	public IContainer<E> left(IContainer<E> c){
		BTNode<E> n = check(c);
		return n.getLeft();
	}
	public IContainer<E> right(IContainer<E> c){
		BTNode<E> n = check(c);
		return n.getRight();
	}
	public IContainer<E> parent(IContainer<E> c){
		BTNode<E> n = check(c);
		return n.getParent();
	}
	public IContainer<E> root(){
		return root;
	}
	public boolean isInternal(IContainer<E> c){
		BTNode<E> n = check(c);
		return hasLeft(n) || hasRight(n);
	}
	public boolean isExternal(IContainer<E> c){
		return !isExternal(c);
	}
	public IContainer<E> addRoot(E e){
		if(!isEmpty())
			throw new RuntimeException("not empty");
		root = new BTNode<E>(e);
		size = 1;
		return root;
	}
	public IContainer<E> insertLeft(IContainer<E> c, E e){
		BTNode<E> n = check(c);
		if(hasLeft(c))
			throw new RuntimeException("has a left!");
		BTNode<E> newOne = new BTNode<E>(e);
		n.setLeft(newOne);
		newOne.setParent(n);
		size ++;
		return newOne;
	}
	//взяли узел и пока не дойдем до вершины продвигаемся к root
	private int depth(IContainer<E> c){
		BTNode<E> n = check(c);
		int dep = 0;
		while(n!= root){
			dep ++;
			n = n.getParent();
		}
		return dep;
	}
	public Iterator<IContainer<E>> containers(){
		DoublyLinkedList<IContainer<E>> list = new DoublyLinkedList<>();
		rightLeft(root, list);
		return list.iterator();
	}
	private void rightLeft(IContainer<E> c, DoublyLinkedList<IContainer<E>> list){
		if(hasRight(c))
			rightLeft(right(c), list);
		list.addLast(c);
		if(hasLeft(c))
			rightLeft(left(c), list);
			
	}
	public IContainer<E> insertRight(IContainer<E> c, E e){
		BTNode<E> n = check(c);
		if(hasRight(c))
			throw new RuntimeException("has a right!");
		BTNode<E> newOne = new BTNode<E>(e);
		n.setRight(newOne);
		newOne.setParent(n);
		size ++;
		return newOne;
	}
	public Iterator<E> iterator(){
		DoublyLinkedList<E> list = new DoublyLinkedList<>();
		switch (variant) {
		case PREORDER:
			preorder(root, list);
			break;
		case INORDER:
			inorder(root, list);
			break;
		case POSTORDER:
			postorder(root, list);
			break;
		default:
			inorder(root, list);
			break;
		}
		//inorder(root, list);
		return list.iterator();
	}
	//низходящий обход
	private void preorder(IContainer<E> c, DoublyLinkedList<E> list){
		if(c == null)
			return;
		list.addLast(c.getElement()); //сначало записать текущий узел
		if(hasLeft(c))
			preorder(left(c), list);
		if(hasRight(c)){
			preorder(right(c), list);
		}
	}
	private void postorder(IContainer<E> c, DoublyLinkedList<E> list){
		if(c == null)
			return;
		if(hasLeft(c))
			preorder(left(c), list);
		if(hasRight(c)){
			preorder(right(c), list);
		}
		list.addLast(c.getElement());
	}
	public String toString(){
		String toReturn = "";
		Iterator<E> it = iterator();
		while(it.hasNext()){
			toReturn += it.next() + ", ";
		}
		return "LinkedBinTree[" + toReturn + "] size = " + size;
	}
	
	//обход по возрастанию
	private void inorder(IContainer<E> c, DoublyLinkedList<E> list){
		if(c == null)
			return;
		if(hasLeft(c))
			inorder(left(c),list);
		list.addLast(c.getElement());
		if(hasRight(c))
			inorder(right(c), list);
	}
	//правильное ли дерево
	public boolean isProper(IContainer<E> c){
		boolean status = true;
		DoublyLinkedList<IContainer<E>> list = new DoublyLinkedList<>();
		rightLeft(c, list);
		Iterator<IContainer<E>> it = list.iterator();
		while(it.hasNext()){
			IContainer<E> temp = it.next();
			if(isInternal(temp)){
				if(! (hasLeft(temp) && hasRight(temp))){
					status = false;
				}
			}
		}
		return status;
	}
	public void print(){
		Iterator<IContainer<E>> it = containers();
		while(it.hasNext()){
			IContainer<E> c = it.next();
			int dep = depth(c);
			String offset = "";
			for(int i = 1; i <= dep; i++)
				offset += "\t";
			System.out.println(offset + c.getElement());
		}
	}
}
