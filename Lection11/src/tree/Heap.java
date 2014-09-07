package tree;

import java.util.Comparator;

import list.IContainer;

public class Heap<E> {
	protected CompleteBinTree<E> tree;
	protected Comparator<E> comp;
	
	public Heap(Comparator<E> c){
		comp = c;
		tree = new CompleteBinTree<>();
	}
	public void insert(E e){
		tree.add(e);
		upHeapBubbling();
	}
	protected void upHeapBubbling(){
		//взять последний элемент
		IContainer<E> cur = tree.last();
		//просеять наверх пока не дойдем до вершини
		//или пока не окажется элемента больше
		while(cur != tree.root()){
			IContainer<E> par = tree.parent(cur);
			E ep = par.getElement();
			E ec = cur.getElement();
			int cr = comp.compare(ec, ep);
			if(cr > 0){
				break;
			}
			else{
				swap(cur, par);
				cur = par;
			}
		}
	}
	protected void swap(IContainer<E> a, IContainer<E> b){
		E tmp = a.getElement();
		tree.check(a).setElement(b.getElement());
		tree.check(b).setElement(tmp);
	}
	
	public int size(){
		return tree.size();
	}
	public boolean isEmpty(){
		return tree.isEmpty();
	}
	public void print(){
		tree.print();
	}
	@Override
	public String toString(){
		return tree.toString();
	}
	
}
