package topic.core.math;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class FactorialTest {
	
	@Test
	public void factorialByLoop() {
		int [] result = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
		for(int i = 0; i<= 10; i++){
			System.out.println(i);
			int fact = Factorial.factorialByLoop(i);
			assertThat(fact, is(equalTo(result[i])));
		}
	}
	
	@Test
	public void factorialByRecursion() {
		int [] result = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
		for(int i = 0; i<= 10; i++){
			int fact = Factorial.factorial(i);//
			assertThat(fact, is(equalTo(result[i])));
		}
	}
}