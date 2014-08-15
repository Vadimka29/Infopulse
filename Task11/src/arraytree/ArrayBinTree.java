package arraytree;

import java.util.Arrays;
import java.util.Iterator;
import java.lang.reflect.Array;

public class ArrayBinTree<E extends Comparable<E>> implements Iterable<E>{
	private int size;
	private E[] array;
	
	@SuppressWarnings("unchecked")
	public ArrayBinTree(Class<E> c){
		array = (E[]) Array.newInstance(c, 10);
	}
	@SuppressWarnings("unchecked")
	public ArrayBinTree(Class<E> c, int s){
		array = (E[]) Array.newInstance(c, s);
	}
	public void addRoot(E e){
		if(array[0] != null){
			throw new RuntimeException("Root is already exists!");
		}
		array[0] = e;
		size ++;
	}
	public E find(E key) {
		int index = 0;
		E current = array[index];
		while (current.compareTo(key) != 0) {
			if (current.compareTo(key) > 0) {
				current = array[index * 2 + 1];
				index = index*2 + 1;
			} else {
				current = array[index * 2 + 2];
				index = index * 2 + 2;
			}
			if(current == null)
				return null;
		}
		return current;
	}
	private void resize(){
		array = Arrays.copyOf(array, array.length * 3);
	}
	public void insert(E e){
		if(size >= array.length/3)
			resize();
		int index = 0;
		int parentIndex = 0;
		//if root doesn't exist
		if(array[0] == null){
			array[0] = e;
			size ++;
		}
		else {
			E current = array[index];
			while(true){
				parentIndex = index;
				if(e.compareTo(current) < 0){
					current = array[index*2 + 1];
					index = index*2 + 1;
					if(current == null){
						array[parentIndex*2 + 1] = e;
						size ++;
						return;
					}
				}
				else{
					current = array[index*2 + 2];
					index = index*2 + 2;
					if(current == null){
						array[parentIndex*2 + 2] = e;
						size ++;
						return;
					}
				}
			}
		}
	}
	public void traverse(){
		
	}
	@Override
	public Iterator<E> iterator() {
		DoublyLinkedList<E> list = new DoublyLinkedList<>();
		preorder(0, list);
		return list.iterator();
	}
	private void preorder(int index, DoublyLinkedList<E> lst){
		if(array[index] == null)
			return;
		lst.addLast(array[index]);
		if(array[index*2 + 1] != null)
			preorder(index*2 + 1,lst);
		if(array[index*2 + 2] != null)
			preorder(index*2 + 2, lst);
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
}
