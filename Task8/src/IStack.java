
public interface IStack<E> {
		E pop();
		void push(E s);
		E peek();
		int size();
		boolean isEmpty();
	}