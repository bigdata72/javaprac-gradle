package topic.j8lambdastream;

import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		Predicate<String> strLongStrings = (String s) -> s.length() > 5;
		filterLongStrings(strLongStrings, "Hello", "there", "verylong");
		
	}
	
	public static void filterLongStrings(Predicate<String> p, String ... s){
		for(String str : s) {
			if(p.test(str))
				System.out.println(str);
		}
	}
}
