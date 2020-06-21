package topic.collections.book.liang;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

//import static org.hamcrest.MatcherAssert.assertThat;

public class CollectionsUtilTest {
	
	/**
	 * Test the usage of the following static methods in Collections
	 * sort(list: List) : void
	 * sort(list: List, c: Comparator) ; void
	 * binarySearch(list: List, key: Object) : int
	 * binarySearch(list: List, key: Object, c:Comparator) : int
	 * reverse(list: List) : void
	 * reverseOrder() : Comparator
	 * shuffle() and shuffle with a Random object
	 * copy(des: List, src: List)
	 * nCopies(n: int, o: Object)
	 * fill(list: List, o: Object)
	 * max(c: Collection) : Object
	 * max with Comparator
	 * min(c: Collection) : Object
	 * min with Comparator
	 * disJoint(c1: Collection, c2: Collection) : boolean
	 * frequency(c: Collection, o: Object) : int
	 */
	
	@Test
	public void testHamcrestExample(){
		// ref: https://mkyong.com/unittest/junit-how-to-test-a-list/
		

		
		List<String> actual = Arrays.asList("b", "a", "c");
		List<String> expected = Arrays.asList("a", "b", "c");
		
		Collections.sort(actual);
		System.out.println(actual);
		
		//1. Test equal.
		assertThat(actual, is(expected));
		
		//2. If List has this value?
		assertThat(actual, hasItems("b"));
		
		//3. Check List Size
		assertThat(actual, hasSize(3));
		
		assertThat(actual.size(), is(3));
		
		//4.  List order
		
		// Ensure Correct order
		assertThat(actual, contains("a", "b", "c"));
		
		// Can be any order
		assertThat(actual, containsInAnyOrder("c", "b", "a"));
		
		//5. check empty list
		assertThat(actual, not(IsEmptyCollection.empty()));
		
		assertThat(new ArrayList<>(), IsEmptyCollection.empty());
	}
	
	@Test
	public void testListSort(){
		List<String> actual = Arrays.asList("red", "green", "blue");
		System.out.println("unsorted:"+actual);

		Collections.sort(actual);
		System.out.println("sorted:"+actual);
		
		assertThat(actual, contains("blue", "green", "red"));
	}
	
	@Test
	public void testSortReverseOrder(){
		// use Collections.reverseOrder to return a Comparator that orders
		// the elements in reverse of their natural order
		List<String> actual = Arrays.asList("yellow", "green", "red", "blue");
		Collections.sort(actual, Collections.reverseOrder());
		System.out.println(actual);
		assertThat(actual, contains("yellow", "red", "green", "blue"));
	}
}
