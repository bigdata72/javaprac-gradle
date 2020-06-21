package topic.algorithms.sort;

import org.junit.Test;

import static org.hamcrest.collection.ArrayMatching.arrayContaining;
import static org.junit.Assert.assertThat;

public class FirstInsertionSortTest {
	
	@Test
	public void mySort() {
	}
	
	@Test
	public void cormenBookSort() {
		Integer[] arrToSort = {8, 7, 5, 2, 4, 6, 3};
		FirstInsertionSort.cormenBookInsertionSort(arrToSort);
		assertThat(arrToSort, arrayContaining(2,3,4,5,6,7,8));
		
	}
}