import java.util.Stack;


public class Task6 {
	public static void main(String[] args) {
		//TASK1
		System.out.println("__________TASK1 CHECK CORECTNESS OF EXPRESSION_________");
		String exp = "{<(2+4)*(3+5)>}";
		String ex = "(2+3";
		SyntaxAnalyzer saExp = new SyntaxAnalyzer(exp);
		SyntaxAnalyzer saEx = new SyntaxAnalyzer(ex);
		System.out.println("Corectness of exp: " + saExp.isCorrectExpression());
		System.out.println("Corectness of ex: " + saEx.isCorrectExpression());
		
		//TASK2 Shunting-yard algorithm + stackMachine for value calculation
		System.out.println("__________TASK 2 CALCULATE VALUE__________");
		String exp1 = "2*(3+5)";
		System.out.println("Value of expression: " + exp1 + "is "+  Methods.calcValue(exp1));
		
		//TASK3 REVERSE STACK
		System.out.println("__________TASK 3 REVERSING STACK__________");
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		System.out.println("Stack: " + st);
		//reverse stack
		Methods.stackReverse(st);
		System.out.println("Stack after reversing: " + st);
	}

}
