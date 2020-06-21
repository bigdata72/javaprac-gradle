package topic.collections.book.liang.list;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Vector;

public class StackJavaUtilTest {
	public static void main(String[] args) {
		testVector();
		testJavaStack();
		testSystemArrayCopy();
		testJavaStackSearch();
	}
	
	public static void testJavaStackSearch(){
		Stack<Integer> js = new Stack<>();
		js.push(1);
		js.push(2);
		js.push(33);
		js.push(35);
		js.push(41);
		// vector impl of stack
		// 1   2   33  35  41
		// 0   1   2   3   4
		//___ ___ ___ ___ ___
		// js.search(41) should return 5 (distance from 1-based top)
		assert js.search(41) == 1; // 41 is returned by pop() or peek and is at top of stack
		System.out.println(js.search(41));
	}
	
	public static void testSystemArrayCopy(){
		int [] src = {1,3,5};
		int [] dst = {2,4,6};
		System.arraycopy(src, 2, src, 1, 1  );
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dst));
		
	}
	
	public static void testVector(){
		Vector<Integer> v = new Vector<>();
		v.add(1);
		v.add(2);
		v.add(5);
		v.remove(1); // calls System.arrayCopy to move the elements up when the non-last element is removed
	}
	
	public static void testJavaStack(){
		Stack<Integer> js = new Stack<>();
		System.out.println("Stack size="+js.size());
		System.out.println("Stack empty?"+js.empty());
		
		try {
			System.out.println(js.peek());
		} catch (EmptyStackException e) {
			System.out.println(e.getClass() + " caught");
		}
		
		// add elements and check for peek() and size()
		js.push(1);
		js.push(2);
		js.push(5);
		System.out.println("Stack peek:"+js.peek()); // peek returns the last element added
		System.out.println("Stack size="+js.size());
		
		// remove the last element added
		System.out.println("Stack pop()"+js.pop());
		
		
	}
}
