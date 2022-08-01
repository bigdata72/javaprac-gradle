package topic.algorithms.sort;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SelectionSortImplTest {
	
	@Test
	public void selectionSort () {
		String word = "SORTEXAMPLE";
		String [] arr = word.split("");
		
		assertThat(SelectionSortImpl.isSorted(arr)).isFalse();
		
		SelectionSortImpl.selectionSort(arr);
		
		assertThat(SelectionSortImpl.isSorted(arr)).isTrue();
		
	}
	
	@Test
	public void exchange() {
		String word = "SELECTIONSORT";
		String [] arr = word.split("");
		
		assertThat(arr[0]).isEqualTo("S");
		assertThat(arr[1]).isEqualTo("E");
		
		SelectionSortImpl.exchange(arr, 0, 1);
		
		assertThat(arr[0]).isEqualTo("E");
		assertThat(arr[1]).isEqualTo("S");
	}
	
	@Test
	public void isSorted () {
		String word1 = "ABCDEFGHIJKLMNOPQRSTUVWXYA";
		String word2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Integer[] intArr1 = {1, 5, 9, 11, 14, 2};
		Integer[] intArr2 = {1, 5, 9, 11, 14, 19};
		
		assertThat(SelectionSortImpl.isSorted(word1.split(""))).isFalse();
		assertThat(SelectionSortImpl.isSorted(word2.split(""))).isTrue();
		assertThat(SelectionSortImpl.isSorted(intArr1)).isFalse();
		assertThat(SelectionSortImpl.isSorted(intArr2)).isTrue();
	}
}