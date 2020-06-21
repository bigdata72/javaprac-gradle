package topic.j8lambdastream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class LambdaUtilTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	@Before
	public void setupStream(){
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStream(){
		System.setOut(originalOut);
	}
	
	@Test
	// tests predicate
	public void filter() {
		Predicate<String> nonEmptyStrings = (String s) -> !s.trim().isEmpty();
		
		List<String> result = LambdaUtil.filter(
									Arrays.asList("", " ", "non-empty", "hello"),
									nonEmptyStrings);
		
		assertThat(result, contains("non-empty", "hello"));
	}
	
	@Test
	// tests consumer
	public void forEach(){
		Consumer<Integer> ints = (Integer i) -> System.out.print(i +" ");
		LambdaUtil.forEach(Arrays.asList(1,2,3), ints);
		String actualStr = "1 2 3 ";
		assertThat(actualStr, is(outContent.toString()));
	}
	
	@Test
	// tests Supplier
	public void get(){
		Supplier<Double> s = () -> Math.random();
		Double d = LambdaUtil.get(s);
		assertThat(s, is(not(nullValue())));
	}
	
	@Test
	// tests Function
	public void map(){
		Function<String, Integer> strToLength = (String s) -> s.length();
		List<Integer> resultMap = LambdaUtil.map(Arrays.asList("map", "function"), strToLength);
		assertThat(resultMap, contains(3, 8));
	}
	
	
}