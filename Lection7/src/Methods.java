import java.util.*;

public class Methods {
	//reverse queue
	public static void reverse(MyQueue q){
		Stack<String> st = new Stack<>();
		while(!q.isEmpty())
			st.push(q.dequeue());
		while(!st.empty())
			q.enqueue(st.pop());
	}
	
	//игра с выбыванием
	public static String countingWinner(MyQueue q,final int k){
		while(q.size() > 1){
			for(int i = 1; i < k; i++){
				q.enqueue(q.dequeue());
			}
			q.dequeue(); // удаление k - го элемента
		}
		String win = q.dequeue();
		q.enqueue(win);
		return win;
	}
}