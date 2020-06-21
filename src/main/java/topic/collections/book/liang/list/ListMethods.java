package topic.collections.book.liang.list;

import java.util.*;

public class ListMethods {
	
	public static void main(String[] args) {
		testListMethods();
		System.out.println();
		testArrayListAndLinkedList();
		System.out.println();
		testTwoList();
		Integer a1 = new Integer(2);
		comp(a1);
	}
	
	private static void test1(Integer a1, Integer a2){
		comp(a1);
	}
	
	private static void comp(int a){
		System.out.println(a);
	}
	
	private static void testTwoList(){
		List<String> l1 = Arrays.asList("red", "yellow", "green");
		List<String> l2 = Arrays.asList("red", "yellow", "blue");
	
		try{
			l1.addAll(l2);
		}catch(UnsupportedOperationException ex){
			System.out.println("the list returned from Arrays.asList() is fixed size and does not " +
			"override add(int, Object and it always throws this unsupported op exception");
		}
		l1 = new ArrayList<>();
		l1.add("red");
		l1.add("yellow");
		l1.add("green");

		l2 = new ArrayList<>();
		l2.add("red");
		l2.add("yellow");
		l2.add("blue");
		System.out.println("l1="+l1); // [red, yellow, green]
		System.out.println("l2="+l2); // [red, yellow, blue]
		List<String> l = new ArrayList<>(l1);
		l.addAll(l2);
		System.out.println(l); //[red, yellow, green, red, yellow, blue]
		l = new ArrayList<>(l1);
		
		l.removeAll(l2); // Set minus
		System.out.println(l); // [green]
		
		l = new ArrayList<>(l1);
		System.out.println(l.remove(l2)); // false
		System.out.println(l); //[red, yellow, green]
		
		l = new ArrayList<>(l1);
		l.retainAll(l2); // Set intersection
		System.out.println(l); // [red, yellow]
	}
	
	private static void testArrayListAndLinkedList(){
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		System.out.println(numbers); // [1, 2, 3, 4]
		numbers.add(0,-1); // [-1, 1, 2, 3, 4]
		System.out.println(numbers);
		numbers.add(1,-2); // [-1, -2, 1, 2, 3, 4]
		System.out.println(numbers);
		numbers.add(3,30); // [-1, -2, 1, 30, 2, 3, 4]
		System.out.println(numbers);
		
		// create a LinkedList from the ArrayList
		LinkedList<Object> ll = new LinkedList<>(numbers); // [-1, -2, 1, 30, 2, 3, 4]
		System.out.println(ll);
		
		ll.add(7); // adds at the end, similar to addLast();
		System.out.println(ll); //[-1, -2, 1, 30, 2, 3, 4, 7]
		
		ll.addLast(10);
		System.out.println(ll); // [-1, -2, 1, 30, 2, 3, 4, 7, 10]
		
		ll.add(1,"green"); // [-1, green, -2, 1, 30, 2, 3, 4, 7, 10]
		System.out.println(ll);
		
		ll.removeLast();
		System.out.println(ll); // [-1, green, -2, 1, 30, 2, 3, 4, 7]
		
		ll.removeFirst();
		System.out.println(ll); // [green, -2, 1, 30, 2, 3, 4, 7]
		
		System.out.println(ll.getFirst()); //green
		System.out.println(ll.getLast()); //7
		
		// display the ll forward using a ListIterator and StringJoiner
		ListIterator<Object> llitr = ll.listIterator();
		StringJoiner sj = new StringJoiner(" ", "[", "]");
		while(llitr.hasNext()){
			sj.add(llitr.next().toString());
		}
		System.out.println(sj.toString()); // [green -2 1 30 2 3 4 7]

		sj = new StringJoiner(",", "[", "]");
		
		// display the ll backwards
		llitr = ll.listIterator(ll.size());
		while(llitr.hasPrevious()){
			sj.add(llitr.previous().toString());
		}
		System.out.println(sj.toString()); // [7,4,3,2,30,1,-2,green]
		
		// Print the elements of the ll using a foreach loop
		sj = new StringJoiner(":", "[", "]");
		for (Object o: ll) {
			sj.add(o.toString());
		}
		System.out.println(sj.toString()); // [green:-2:1:30:2:3:4:7]
	}
	
	private static void testListMethods() {
		List<String> list = new ArrayList<>();
		addCities(list);
		List<String> subList = list.subList(2,3);
		System.out.println(subList);  // [New Jersey]
		System.out.println(list.indexOf("New Jersey")); //2
		System.out.println(list.lastIndexOf("Atlanta")); //5
		
		// test ListIterator. do one Add and then do a set
		// add(element E) - adds the specified object to the list
		// set(element E) - replaces the last element returned by previous or next
		//				    method with the specified element
		ListIterator<String> listItr = list.listIterator(3); // at Los Angeles.
		listItr.add("Florida");
		System.out.println(list);
		try{
			listItr.set("Boston");
		}catch(IllegalStateException ie){
			System.out.println("ListIterator throws IllegalStateException as there was no calls to next or previous " +
			"before the call to set(), lastRet = -1 ");
		}
		listItr.previous();
		listItr.set("Boston"); // try again, should replace Florida.
		System.out.println(list);
	}
	
	public static void addCities(List<String> list){
		list.add("New York");
		list.add("San Diego");
		list.add("New Jersey");
		list.add("Los Angeles");
		list.add("Atlanta");
		list.add("Atlanta");
	}
}
