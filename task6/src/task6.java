
public class task6 {
	public static void main(String[] args) {
		MyStack st = new MyStack();
		st.push("1");
		st.push("2");
		st.push("3");
		st.push("4");
		st.push("5");
		System.out.println("Stack before reversing: " + st);
		Methods.reverse(st);
		System.out.println("Stack after reversing" + st);
	}
}