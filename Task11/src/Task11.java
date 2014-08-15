import java.util.Iterator;

import tree.LinkedBinTree;
import arraytree.*;


public class Task11 {
	public static void main(String[] args){
		//********** TASK 1: Node Height ***********
		System.out.println("__________TASK 1: Node Height__________");
		LinkedBinTree<Integer> lb = new LinkedBinTree<>(
				LinkedBinTree.Traversal.INORDER);
		IContainer<Integer> r = lb.addRoot(10);
		IContainer<Integer> i5 = lb.insertLeft(r, 5);
		IContainer<Integer> i6 = lb.insertRight(r, 15);
		lb.insertLeft(i5, 2);
		lb.insertRight(i5, 7);
		lb.insertLeft(i6, 12);
		lb.insertRight(i6, 30);
		lb.customPrint();
		System.out.println("height: " + lb.height(lb.root()));
		//********** TASK 2: ArrayBinTree **********
		System.out.println("__________TASK 2: ArrayBinTree__________");
		System.out.println();
		ArrayBinTree<Integer> tree = new ArrayBinTree<>(Integer.class);
		tree.addRoot(10);
		tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		tree.insert(15);
		tree.insert(12);
		tree.insert(16);
		tree.insert(7);
		Iterator<Integer> it = tree.iterator();
		System.out.println("preorder traverse");
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
	}
}