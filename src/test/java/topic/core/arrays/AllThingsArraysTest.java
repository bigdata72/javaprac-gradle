package topic.core.arrays;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.ArrayMatching.arrayContaining;
import static org.hamcrest.collection.ArrayMatching.arrayContainingInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AllThingsArraysTest {
	
	@Test
	public void testMaxInArray(){
		int [] a1 = {2, 5, 5, 3, 5};
		assertThat(AllThingsArrays.lowIndexMaxValue(a1), is(equalTo(1)));
		int[] a2 = {5, 2, 5, 3, 5};
		assertThat(AllThingsArrays.lowIndexMaxValue(a2), is(equalTo(0)));
		int [] a3 = {2, 5, 5, 3, 6};
		assertThat(AllThingsArrays.lowIndexMaxValue(a3), is(equalTo(4)));
	}
	
	@Test
	public void testShuffle(){
		int [] a1 = {2, 5, 5, 3, 5};
		AllThingsArrays.shuffle(a1);
		Integer[] a11 = ArrayUtils.toObject(a1);
		List<Integer> actual = Arrays.asList(a11);
		assertThat(actual, containsInAnyOrder(2,5,5,3,5));
		
		int [] a2 = {2, 5, 5, 3, 5, 19, 31, 22, 77, 0, 88};
		AllThingsArrays.shuffle(a2);
		Integer[] a22 = ArrayUtils.toObject(a2);
		assertThat(a22, arrayContainingInAnyOrder(2,5,5,3,5,19,31,22,77,0,88));
	}
	
	@Test
	public void testShiftLeftOne(){
		int [] a1 = {1,1,2,3,5,8,13,21,34,55};
		AllThingsArrays.shiftLeftOne(a1);
		Integer[] a11 = ArrayUtils.toObject(a1);
		assertThat(a11, arrayContaining(1,2,3,5,8,13,21,34,55,1));
	}
	
	@Test
	public void toIntegerArrayNaive(){
		int [] a1 = {1,1,2,3,5,8,13};
		Integer [] a11 = AllThingsArrays.toIntegerArrayNaive(a1);
		assertThat(a11, arrayContaining(1,1,2,3,5,8,13) );
	}
	
	@Test
	public void toIntegerArrayStreams(){
		int [] a1 = {1,1,2,3,5};
		Integer [] a11 = AllThingsArrays.toIntegerArrStream(a1);
		assertThat(a11, arrayContaining(1,1,2,3,5));
	}
	
	@Test
	public void arrayCopyTest(){
		int [] src = {1,2,3,4,5};
		int [] tgt = {5,6,7,8,9};
		int srcPos = 1;
		int tgtPos = 2;
		int len = 1;
		AllThingsArrays.arrayCopy(src, srcPos, tgt, tgtPos, len );
		Integer[] result = AllThingsArrays.toIntegerArrStream(tgt);
		assertThat(result, arrayContaining(5,6,2,8,9));
	}
	
	@Test
	public void reverseArray(){
		int [] arr = {1,1,2,3,5}; // odd numbers
		int [] rev = AllThingsArrays.reverse(arr);
		Integer [] result = AllThingsArrays.toIntegerArrStream(rev);
		assertThat(result, arrayContaining(5,3,2,1,1));
		
		int [] arr2 = {1,1,2,3,5,8}; // odd numbers
		int [] rev2 = AllThingsArrays.reverse(arr2);
		Integer [] result2 = AllThingsArrays.toIntegerArrStream(rev2);
		assertThat(result2, arrayContaining(8,5,3,2,1,1));
	}
	
	@Test
	public void palindromeTest(){
		String s1 = "Not a palindrome";
		assertThat(AllThingsArrays.palidrome(s1), is(false));
		
		s1 = "madam";
		assertThat(AllThingsArrays.palidrome(s1), is(true));
		
		s1 = "abccbA";
		assertThat(AllThingsArrays.palidrome(s1), is(true));
	}
	
	@Test
	public void maxInArray(){
		int [] a = {1,1,2,3,5};
		assertThat(AllThingsArrays.max(a), is(equalTo(5)));
		
		int [] a1 = {6,1,2,3,5};
		assertThat(AllThingsArrays.max(a1), is(equalTo(6)));
	}
	
	@Test
	public void minInArray(){
		int [] a = {1,1,2,3,5};
		assertThat(AllThingsArrays.min(a), is(equalTo(1)));
		
		int [] a1 = {6,1,2,3,0,-1};
		assertThat(AllThingsArrays.min(a1), is(equalTo(-1)));
	}
}