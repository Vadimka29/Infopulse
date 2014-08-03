import java.util.Stack;

public class Methods {
	public static double calcValue(String s){
		SyntaxAnalyzer sa = new SyntaxAnalyzer(s);
		if(!sa.isCorrectExpression())
			return Double.NaN;
		String opn = opn(s);
		System.out.println("Polish Notation of expression: " + opn);
		return stackMachine(opn);
	}
	/**
	 * Get postfix expression.
	 */
	private static String opn(String s){
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		char[] symbols = s.toCharArray();
		for(char temp: symbols){
			//if symbol is digit
			if(Character.isDigit(temp)){
				sb.append(temp);
				continue;
			}
			//if symbol is opening bracket
			if(temp == '('){
				stack.push(temp);
				continue;
			}
			//if symbol is closing bracket
			if(temp == ')'){
				while(stack.peek() != '('){
					sb.append(stack.pop());
				}
					stack.pop();
					continue;
			}
			//if symbol is operator
			if(isOperator(temp)){
				//if stack is empty or top of stack isn't operator
				if(stack.empty() || !isOperator(stack.peek())){
					stack.push(temp);
					continue;
				}
				//if top of stack is operator
				if(isOperator(stack.peek())){
					//if priority of operator is less than priority of top
					if(priority(temp) <= priority(stack.peek())){
						sb.append(stack.pop());
						stack.push(temp);
						continue;
					}
					else {
						stack.push(temp);
						continue;
					}
				}
			}
		}
		//pop all operators from stack
		if(!stack.empty()){
			while(!stack.empty())
				sb.append(stack.pop());
		}
		return sb.toString();
	}
	/**
	 * Verify operators.
	 */
	private static boolean isOperator(Character s){
		if(s == '+' || s == '-' || s == '/' || s == '*')
			return true;
		return false;
	}
	/**
	 * Return Priority of symbol.
	 */
	private static int priority(Character s){
		switch(s){
			case '+': return 1;
			case '-': return 1;
			case '*': return 2;
			case '/': return 2;
			default: return 0;
		}
	}
	/**
	 * Calculate expression (in postfix form).
	 * @param opn - String of reverse Polish notation.
	 */
	private static double stackMachine(String opn){
		Stack<Integer> stack = new Stack<>();
		char[] symbols = opn.toCharArray();
		for(char temp: symbols){
			//if temp is digit
			if(Character.isDigit(temp)){
				stack.push(Character.getNumericValue(temp));
				continue;
			}
			//if temp is operator
			if(isOperator(temp)){
				switch(temp){
					case '+':
						int valueAdd = stack.pop() + stack.pop();
						stack.push(valueAdd);
						break;
					case '-':
						int valueSubtract  = stack.pop() - stack.pop();
						stack.push(valueSubtract);
						break;
					case '*':
						int valueMultiply = stack.pop() * stack.pop();
						stack.push(valueMultiply);
						break;
					case '/':
						int valueDiv = stack.pop() / stack.pop();
						stack.push(valueDiv);
						break;
				}
				continue;
			}
		}
		return stack.pop();
	}
	/**
	 * Reverse stack
	 * @param st - stack of Integers.
	 */
	public static void stackReverse(Stack<Integer> st){
		int size = st.size();
		for(int i = 0; i < size; i++)
			st.add(i,st.pop());
	}
}
