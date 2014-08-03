import java.util.Stack;

public class Methods {
	
	//считает сумму элементов стека
	static int sum(Stack<Integer> si){
		if(si.isEmpty())
			return 0;
		return si.pop() + sum(si);
	}
	//реверс массива
	static void reverse(int[] m){
		Stack<Integer> si = new Stack<Integer>();
		for(int t: m){
			si.push(t);
		}
		//извлечь данные в обратном порядке
		for(int i = 0; i < m.length; i++){
			m[i] = si.pop();
		}
	}
	//метод для синтаксического анализа
	//проверяет правильно ли расставлены скобки в выражении
	//с помощью стека
	static boolean isValidExp(String ex){
		Stack<Character> st = new Stack<Character>();
		char[] array = ex.toCharArray();
		for(char t: array){
			if(t == '(')
				st.push(t);
			if(t == ')'){
				if(st.empty())
					return false;
				st.pop();
			}
		}
		boolean res = (st.empty()) ? true : false;
		return res;
	}
}