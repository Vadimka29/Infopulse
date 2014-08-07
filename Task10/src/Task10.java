import java.io.File;


public class Task10 {
	public static void main(String[] args){
		//TASK1 (from prev lesson) Queue sorting
		System.out.println("__________TASK1: (from prev lesson) Queue sorting__________");
		MyQueue<Integer> q = new MyQueue<>();
		for(int i = 0; i < 20; i++){
			q.enqueue((int)(Math.random()*21));
		}
		System.out.println(q);
		Methods.queueSort(q);
		System.out.println(q);
		
		//TASK 2 UrkCoin
		System.out.println("__________TASK2: UkrCoin__________");
		System.out.println(UkrCoin.exchange(1, 78));
		
		//TASK3 Stack sort
		System.out.println("__________TASK3: STACK sort__________");
		QStack<Integer> st = new QStack<>();
		for(int i = 0; i < 20; i++){
			st.push((int)(Math.random()*21));
		}
		System.out.println(st);
		Methods.stackSort(st);
		System.out.println(st);
		//TASK 4: Get all files from directory without recursion
		//input your pass into brackets
		System.out.println("__________TASK4: Get all files from directory without recursion __________");
		DoublyLinkedList<File> dll = 
				Methods.getAllFiles("");
		for(File file: dll){
			System.out.println(file.getName());
		}
	}
}
