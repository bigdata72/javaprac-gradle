package topic.algorithms.book.algs4ed.main;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
//import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

//import edu.princeton.cs.algs4.Stack;

public class ReadIntsFromFile {
	private static final String FILE = "C:\\algs4\\test files\\ints.txt";
	public static void main(String[] args) {
		readInts(FILE);
	}
	
	public static void readInts(String name) {
		//readIntsWithQueue(name);
		//System.out.println("-------------------");
		//readIntsWithStack(name);
		//System.out.println("-------------------");
		testJavaStack();
	}
	
	private static void testJavaStack(){
		System.out.println("-----------------");
		Stack<Integer> juStack = new Stack<Integer>();
		juStack.push(1);
		juStack.push(2);
		System.out.println(juStack);
		Iterator<Integer> itr = juStack.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		System.out.println(juStack.peek());
		System.out.println(juStack.peek());
	}
	public static void readIntsWithStack(){
		Stack<Integer> stack = new Stack<>();
		while(!StdIn.isEmpty()){
			stack.push(StdIn.readInt());
		}
		
		for (int i: stack) {
			System.out.println(i);
		}
	}
	
	public static void readIntsWithStack(String name){
		//Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack = new Stack<Integer>();
		//Deque<Integer> stack = new ArrayDeque<>();
		In in = new In(name);
		while(!in.isEmpty()){
			stack.push(in.readInt());
		}
		System.out.println(stack);
		for (int i : stack) {
			System.out.println(i);
		}
	}
	
	public static void readIntsWithQueue(String name) {
		In in = new In(name);
		Queue<Integer> q = new Queue<>();
		while (!in.isEmpty()) {
			q.enqueue(in.readInt());
		}
		int N = q.size();
		System.out.println("Number of elements read and inserted to Queue =" + N);
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = q.dequeue();
		}
		System.out.println(Arrays.toString(a));
		System.out.println("Sorting the array ..");
		Arrays.sort(a);
		System.out.println("Sorted array =" + Arrays.toString(a));
		System.out.println(BinarySearch.binarySearch(a, 75));
	}
	
}
