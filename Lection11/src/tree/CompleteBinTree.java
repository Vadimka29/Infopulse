package tree;

import list.IContainer;

public class CompleteBinTree<E> extends LinkedBinTree<E> {
	protected IContainer<E>  parentNode;
	//0 или 1
	protected char charForLastMove;
	protected final char iS_ROOT = 'R';
	
	@Override
	public IContainer<E> insertLeft(IContainer<E> c, E e){
		return null;
	}
	@Override
	public IContainer<E> insertRight(IContainer<E> c, E e){
		return null;
	}
	//метод работает в двух режимах
	protected void prepareFields(boolean forAdd){
		int nSize = (forAdd) ? size() + 1 : size();
		//без страшего бита (как нам и нужно)
		String binRep = Integer.toBinaryString(nSize).substring(1);
		parentNode = root;
		for(int i = 0; i < binRep.length() - 1; i++){
			parentNode = (binRep.charAt(i) == '0')? left(parentNode):
				right(parentNode);
		}
		charForLastMove = (binRep.isEmpty()) ? iS_ROOT : 
			binRep.charAt(binRep.length() - 1);
	}
	public IContainer<E> add(E e){
		if(isEmpty())
			return addRoot(e);
		BTNode<E> newOne = new BTNode<E>(e);
		prepareFields(true);
		if(charForLastMove == '0'){
			check(parentNode).setLeft(newOne);
		}
		else{
			check(parentNode).setRight(newOne);
		}
		newOne.setParent(check(parentNode));
		size ++;
		return newOne;
	}
	protected void checkIfEmpty(){
		if(isEmpty()){
			throw new RuntimeException("tree is empty");
		}
	}
	public E remove(){
		checkIfEmpty();
		E toReturn = null;
		prepareFields(false);
		//если это корневой узел
		if(charForLastMove == iS_ROOT){
			toReturn = root.getElement();
			root = null;
		}
		else{
			if(charForLastMove == '0'){
				toReturn =  check(parentNode).getLeft().getElement();
				check(parentNode).getLeft().setParent(null);
				check(parentNode).setLeft(null);
			}
			else{
			 	toReturn = check(parentNode).getRight().getElement();
				check(parentNode).getRight().setParent(null);
				check(parentNode).setRight(null);
			}
		}
		size --;
		return toReturn;
	}
	public IContainer<E> last(){
		checkIfEmpty();
		prepareFields(false);
		if(charForLastMove == iS_ROOT)
			return root;
		
		return (charForLastMove == '0') ? 
				left(parentNode):
					right(parentNode);
	}
}