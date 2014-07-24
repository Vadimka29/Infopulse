import java.util.Arrays;


public class MyStack implements IStack {
	private String[] m;
	//поле класса для отслеживания вершины стека
	//default value = 0
	private int top;
	//инициализация массива
	public MyStack() {	
		m = new String[16];
	}
	public int size(){
		return top;
	}
	public boolean empty(){
		return top == 0;
	}
	public void push(String s){
		if(top == m.length)
			resize();
		else{
			m[top++] = s;
		}
	}
	public String pop(){
		if(empty())
			throw new RuntimeException("Stack is empty");
		return m[--top];
	}
	//никто не должен случайно изменить размер стека
	//это внутренний механизм стека
	private void resize(){
		//копирование массива и выделение в два раза больше памяти
		m = Arrays.copyOf(m, m.length*2);
	}
	public String peek(){
		if(empty())
			throw new RuntimeException("Stack is empty");
		return m[top - 1];
	}
	public String toString(){
		StringBuffer bf = new StringBuffer();
		for(int i = 0; i < top; i++){
			bf.append(m[i] + "\n");
		}
		return bf.toString();
	}
}
