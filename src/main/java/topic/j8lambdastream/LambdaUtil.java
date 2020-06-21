package topic.j8lambdastream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaUtil {
	
	// Use of Predicate
	// Function descriptor : (T) -> boolean
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T t : list){
			if(p.test(t))
				result.add(t);
		}
		return result;
	}
	
	// Use of Consumer
	// Function Descriptor : (T) -> void
	public static <T> void forEach(List<T> list, Consumer<T> c){
		for(T t : list)
			c.accept(t);
	}
	
	
	// Use of Supplier
	// Function descriptor : () -> T
	public static <T> T get(Supplier<T> s){
		return s.get();
	}
	
	// Use of Function
	// Function descriptor : (T) -> R
	public static <T, R> List<R> map(List<T> list, Function<T, R> f){
		List<R> result = new ArrayList<>();
		for(T t : list){
			result.add(f.apply(t));
		}
		return result;
		
	}
	// Use of UnaryOperator,
	
	// Use of IntPredicate
	
	// Use of LongPredicate
	
	// Use of DoublePredicate
	
	// Use of IntConsumer
	
	// Use of IntFunction<R>
	
	// Use of IntToDoubleFunction
	
	// Use of ToIntFunction<T>
	
	// Use of BooleanSupplier
	
	// Use of IntUnaryOperator
	
	// Use of BinaryOperator<T>
	
	// Use of IntBinaryOperator
	
	// Use of BiPredicate<L,R>
	
	// Use of BiConsumer<T, U>
	
	// Use of BiFunction<T, U, R>
	
	
}
