import java.util.Stack;
import java.util.Queue;

import javax.sound.sampled.ReverbType;

public class Methods {
	/**
	 * show two dim. array.
	 */
	public static void showArray(int[][] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * fill two dim. array with random integers.
	 * @param array
	 */
	public static void fillArrayRandom(int[][] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				array[i][j] = (int) (Math.random()*10);
			}
		}
	}
	/**
	 * Sort MyQueue.
	 * @param q - MyQueue which will be sorted.
	 */
	public static void sort(MyQueue q){
		Stack<String> st = new Stack<>();
		int size = q.size();
		for(int i = 0; i < size; i++)
			findMax(q,st);
		while(!st.isEmpty())
			q.enqueue(st.pop());
	}
	private static String findMax(MyQueue q,Stack<String> st){
		if (!q.isEmpty()) {
			String max = q.front();
			int size = q.size();
			for (int i = 0; i < size; i++)
				if (max.compareTo(q.front()) < 0) {
					max = q.front();
					q.enqueue(q.dequeue());
				} else {
					q.enqueue(q.dequeue());
				}
			int maxCounter = getAndDeleteMaxFromQueue(q, max);
			for (int i = 0; i < maxCounter; i++)
				st.push(max);
			return max;
		} else
			return null;
	}
	/**
	 * Returns the count of max element in queue.
	 */
	private static int getAndDeleteMaxFromQueue(MyQueue q,String max){
		int counter = 0;
		int size = q.size();
		for(int i = 0; i < size; i++){
			if(q.front().equals(max)){
				q.dequeue();
				counter ++;
			}
			else
				q.enqueue(q.dequeue());
		}
		return counter;
	}
	public static int search(Stack<String> stack, String s){
		int counter = 0;
		MyQueue q = new MyQueue();
		while(!stack.isEmpty()){
			if(stack.peek().equals(s))
				counter ++;
			q.enqueue(stack.pop());
		}
		Methods.reverse(q);
		while(!q.isEmpty())
			stack.push(q.dequeue());
		return counter;
	}
	
	//reverse MyQueue
	private static void reverse(MyQueue q){
		Stack<String> st = new Stack<>();
		while(!q.isEmpty())
			st.push(q.dequeue());
		while(!st.isEmpty())
			q.enqueue(st.pop());
	}

	/**
	 * counting Game.
	 */
	public static String countingWinner(MyQueue q, final int k) {
		while (q.size() > 1) {
			for (int i = 1; i < k; i++) {
				q.enqueue(q.dequeue());
			}
			q.dequeue(); // удаление k - го элемента
		}
		String win = q.dequeue();
		q.enqueue(win);
		return win;
	}
}