package topic.core.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Factorial {
	private static final Logger LOGGER = LoggerFactory.getLogger(Factorial.class);
	public static void main(String[] args) {
		
		int result = new Factorial().factorial(20);
		LOGGER.debug("Factorial = "+result);
		
	}
	
	public static int factorial(int n){
		if(n ==0) return 0;
		if(n == 1) return 1;
		else return(n * factorial(n-1));
	}
	
	public static int factorialByLoop(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		int result = 1;
		for(int i=2; i <= n; i++){
			result = result * i;
		}
		return result;
	}
}

