import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class SyntaxAnalyzer {
	private String expression;
	private boolean isCorrect;
	private Stack<Character> st = new Stack<>();
	//map of brackets
	private Map<Character,Character> mapBrackets = new HashMap<>();
	
	public SyntaxAnalyzer(String expression){
		//fill all sets with brackets
		fillMap();
		this.expression = expression;
		char[] symbols = this.expression.toCharArray();
		//add all opening brackets in stack
		for(char temp: symbols){
			//if temp is opening bracket
			if(isOpeningBracket(temp)){
				st.push(temp);
			}
			//if temp is closing bracket
			if(isClosingBracket(temp)){
				//if closingBracket is value of mapBrackets[openingBracket]
				if(mapBrackets.get(st.peek()).equals(temp))
					st.pop();
				else
					break;
			}
		}
		//check expression for correctness
		validChecking();
	}
	/**
	 * Check expression for correctness.
	 */
	public void validChecking(){
		isCorrect = st.empty()? true : false;
	}
	/**
	 * Get the correctness of expression.
	 */
	public boolean isCorrectExpression(){
		return isCorrect;
	}
	/**
	 * Fill the set of opening brackets.
	 */
	private void fillMap(){
		mapBrackets.put('(', ')');
		mapBrackets.put('<', '>');
		mapBrackets.put('{', '}');
		mapBrackets.put('[', ']');
	}
	
	/**
	 * Check for opening brackets.
	 * @param s - character which will be checked.
	 */
	private boolean isOpeningBracket(Character s){
		return mapBrackets.containsKey(s);
	}
	/**
	 * Check for closing brackets.
	 * @param s - character which will be checked.
	 */
	private boolean isClosingBracket(Character s) {
		return mapBrackets.containsValue(s);
	}
	/**
	 * Shows all elements in stack.
	 */
	public void getStack(){
		for(int i = 0; i < st.size(); i++){
			System.out.println(st.get(i));
		}
	}
}
