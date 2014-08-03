
public class Methods {
	//using binary representation of counter from 0 to 2^n -1.
	public static void subsets(int n){
		MyQueue<Integer> q = new MyQueue<>();
		QStack<String> st = new QStack<>();
		for(int i = 1; i <= n; i++){
			q.enqueue(i);
		}
		for(int i = (int) (Math.pow(2.0, n)-1); i >=0; i--){
			StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
			//fill with zeros to n symbols
			while(sb.length() < n){
				sb = sb.reverse();
				sb.append("0");
				sb = sb.reverse();
			}
			st.push(sb.toString());
		}
		while(!st.isEmpty()){
			StringBuilder sb = new StringBuilder("[");
			for(int i = st.peek().length() - 1; i >= 0 ; i--){
				if(st.peek().charAt(i) == '1'){
					Integer temp = q.dequeue();
					q.enqueue(temp);
					sb.append(temp + ", ");
				}
				else
					q.enqueue(q.dequeue());
			}
			st.pop();
			sb.append("]");
			System.out.println(sb.toString());
		}
	}
}
