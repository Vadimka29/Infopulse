import java.util.Arrays;
import java.util.Stack;


public class Task7 {
	public static void main(String[] args) {
		//**********TASK 1 Sort one dim. arrays in two dim. array *********
		System.out.println("__________TASK 1 Sort one dim. arrays in two dim. array" +
				"__________");
		int[][] array = new int[10][10];
		//fill array with random integers
		Methods.fillArrayRandom(array);
		System.out.println("Array before sorting: ");
		Methods.showArray(array);
		//sort array
		Arrays.sort(array,new ArrayCmp());
		// show array after sorting
		System.out.println("\n" + "Array after sorting: ");
		Methods.showArray(array);
		
		//TASK 2 Sorting MyQueue
		System.out.println("__________TASK 2 Sorting MyQueue__________");
		MyQueue q = new MyQueue();
		q.enqueue("4");
		q.enqueue("3");
		q.enqueue("5");
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("1");
		System.out.println("Queue before sorting: " + q);
		Methods.sort(q);
		System.out.println("Queue after sorting: " + q);
		//**********TASK 3 Stack searching**********
		System.out.println("__________TASK 3 Stack searching__________");
		Stack<String> st = new Stack<>();
		st.push("one");
		st.push("two");
		st.push("one");
		st.push("one");
		System.out.println("Stack before searching: " + st);
		String s = "one";
		System.out.println("Counts of \"one\": " + Methods.search(st, s));
		System.out.println("Stack after searching: " + st);
		//********** TASK4 COUNTING GAME **********
		//change k for making MyQueue bigger
		int k = 10;
		MyQueue p = new MyQueue();
		for(int i = 1; i <= Math.pow(2.0, k); i++){
			p.enqueue(i + "");
		}
		System.out.println("Winner: " + Methods.countingWinner(p, 2));
	}
}