package tree;

import arraytree.IContainer;


public class BTNode<E> implements IContainer<E> {
	private E element;
	private BTNode<E> left, right, parent;
	
	public BTNode(E e){
		element = e;
	}
	public E getElement(){
		return element;
	}
	public void setElement(E e){
		element = e;
	}
	public BTNode<E> getLeft() {
		return left;
	}
	public void setLeft(BTNode<E> left) {
		this.left = left;
	}
	public BTNode<E> getRight() {
		return right;
	}
	public void setRight(BTNode<E> right) {
		this.right = right;
	}
	public BTNode<E> getParent() {
		return parent;
	}
	public void setParent(BTNode<E> parent) {
		this.parent = parent;
	}
	
}
