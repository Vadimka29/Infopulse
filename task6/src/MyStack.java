import java.util.Arrays;

public class MyStack {
	private String[] m;
	private int top;

	public MyStack() {
		m = new String[16];
	}

	public int size() {
		return top;
	}

	public boolean empty() {
		return top == 0;
	}

	public void push(String s) {
		if (top == m.length)
			resize();
		else {
			m[top++] = s;
		}
	}

	public String pop() {
		if (empty())
			throw new RuntimeException("Stack is empty");
		return m[--top];
	}

	private void resize() {
		m = Arrays.copyOf(m, m.length * 2);
	}

	public String peek() {
		if (empty())
			throw new RuntimeException("Stack is empty");
		return m[top - 1];
	}

	public String toString() {
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < top; i++) {
			bf.append(m[i] + " ");
		}
		return bf.toString();
	}
}
