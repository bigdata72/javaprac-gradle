package topic.algorithms.book.algs4ed.ch1.bqs;

import edu.princeton.cs.algs4.StdIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpressionEvaluator {
	private ResizableStack<String> operator;
	private ResizableStack<Integer> operands;
	
	public ExpressionEvaluator(){
		operator = new ResizableStack<>();
		operands = new ResizableStack<>();
	}
	
	public void process(String s){
		Integer result = null;
		
//		Deque<String> operator = new ArrayDeque<>();
//		Deque<Integer> operands = new ArrayDeque<>();
		if(s.equals("(")){
			// ignore
		}else if(s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")){
			operator.push(s);
		}else if(s.equals(")")){
			String op = operator.pop();
			Integer num = operands.pop();
			
			if(op.equals("+")) result = num + operands.pop();
			else if(op.equals("*")) result = num * operands.pop();
			else if(op.equals("/")) result = num / operands.pop();
			else if(op.equals("-")) result = num - operands.pop();
			operands.push(result);
		}else{
			operands.push(Integer.parseInt(s));
		}
	}
	
	private void readInputAndEval(){
		while(!StdIn.isEmpty()) {
			String str = StdIn.readString();
			LOGGER.debug(str);
			process(str);
		}
		LOGGER.debug("Expression value="+operands.pop());	// potential ArrayIndex
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionEvaluator.class);
	public static void main(String[] args) {
		ExpressionEvaluator eval = new ExpressionEvaluator();
		eval.readInputAndEval();
		String exp = "( ( 1 + 5 * ( 4 * 5 ) ) )";
	}
	
	
}
