
public class Methods {
	public static void reverse(MyStack s){
		//number of elements, which will have been pushed before bottom will be pushed
		int counter = s.size() - 1;
		helpReverse(s, counter);
	}
	private static void helpReverse(MyStack s,int count){
		if(count == 0)
			return;
		MyStack temp = new MyStack();
		while(s.size() != 1){
			temp.push(s.pop());
		}
		String bottom = s.pop();
		//push 'count' elements in s from temp
		int c = count;
		while(c != 0){
			s.push(temp.pop());
			c--;
		}
		//then push bottom
		s.push(bottom);
		//then push other elements of temp to s
		while(!temp.empty())
			s.push(temp.pop());
		helpReverse(s, --count);
	}
}