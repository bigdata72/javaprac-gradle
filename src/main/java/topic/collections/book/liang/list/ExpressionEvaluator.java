package topic.collections.book.liang.list;

import java.util.Stack;

public class ExpressionEvaluator {
	public static void main(String[] args) {
		String exp = "51+(54*(3+2))"; //321
		int result = evaluate(exp);
		System.out.println(result);
	}
	
	public static int evaluate(String expression){
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		
		// insert blanks around (, ), +, -, /, and *
		expression = insertBlanks(expression);
		System.out.println(expression);
		
		// extract operands and operators
		String [] tokens = expression.split(" ");
		
		// Phase 1 - Scan tokens
		for(String token : tokens){
			if(token.length() == 0) // blank space
				continue; // back to for loop to extract next token
			else if(token.charAt(0) == '+' || token.charAt(0) == '-'){
				// process all +, -, *, / in the top of the operator stack
				while( !operatorStack.isEmpty() &&
					(operatorStack.peek() == '+' ||
					 operatorStack.peek() == '-' ||
					 operatorStack.peek() == '*' ||
					 operatorStack.peek() == '/')){
					processAnOperator(operandStack, operatorStack);
				}
				// push the + or - operator into the operator stack
				operatorStack.push(token.charAt(0));
			}
			else if(token.charAt(0) == '*' || token.charAt(0) == '/') {
				// process all *, / in the top of operator stack
				while (! operatorStack.isEmpty() &&
				(operatorStack.peek() == '*' ||
				 operatorStack.peek() == '/')){
					processAnOperator(operandStack, operatorStack);
				}
				// push the * or / operator into the operator stack
				operatorStack.push(token.charAt(0));
			}
			else if(token.trim().charAt(0) == '(') {
				operatorStack.push('(');
			}
			else if(token.trim().charAt(0) == ')') {
				// process all operators in stack until seeing '('
				while(operatorStack.peek() != '('){
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.pop(); // pop the '(' from the stack
			}
			else {
				// an operand scanned
				// push operand to the stack
				operandStack.push(new Integer(token));
			}
		}
		
		//Phase 2: process all remaining operators in the stack
		while(!operatorStack.isEmpty()){
			processAnOperator(operandStack, operatorStack);
		}
		
		// return the result
		return operandStack.pop();
	}
	
	private static void processAnOperator(Stack<Integer> opn, Stack<Character> opr){
		char op = opr.pop();
		int op1 = opn.pop();
		int op2 = opn.pop();
		if(op == '+'){
			opn.push(op2 + op1);
		}
		else if(op == '-'){
			opn.push(op2 - op1);
		}
		else if(op == '*'){
			opn.push(op2 * op1);
		}
		else if(op == '/'){
			opn.push(op2 / op1);
		}
		
	}
	private static String insertBlanks(String s){
		String result = "";
		for(int i=0; i< s.length(); i++){
			if(s.charAt(i) == '(' || s.charAt(i) == ')' ||
				s.charAt(i) == '+' || s.charAt(i) == '-' ||
				s.charAt(i) == '*' || s.charAt(i) == '/'){
				result += " " + s.charAt(i) + " ";
			}else{
				result += s.charAt(i);
			}
		}
		return result;
	}
}
