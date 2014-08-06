import java.util.Iterator;


public class Task9 {
	public static void main(String[] args){
		//********** Task 1: Bubble sort for doubly linked list **********
		System.out.println("__________Task 1: Bubble sort for doubly linked list__________");
		DoublyLinkedList<Integer> di = new DoublyLinkedList<>();
		for(int i = 10; i >= 0 ; i--){
			di.addLast(i);
		}
		DlNode<Integer> cur = di.first();
		System.out.println("List before sorting: " + di);
		di.sort();
		System.out.println("List after sorting" + di);
		//
		//********** Task 3: Stack with singly linked list **********
		System.out.println("__________Task 3: Stack with singly linked list__________");
		MyStack<Integer> stack = new MyStack<>();
		for(int i = 0; i < 10; i++){
			stack.push(i);
		}
		for (Integer integer : stack) {
			System.out.print(integer + ",");
		}
		System.out.println("\n" + "pop:" +  stack.pop());
		//********** Task 4: MyDate **********
		System.out.println("__________Task 4: MyDate__________");
		//MyDate d = new MyDate(System.currentTimeMillis());
		MyDate d = new MyDate(System.currentTimeMillis());
		System.out.println(d);
	}
}
