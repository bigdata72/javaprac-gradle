package topic.collections.book.corejava;

import java.util.*;

public class CollectionMethods {
	public static void main(String[] args) {
		Collection<String> list = new ArrayList<>();
		list.add("Core java");
		list.add("Collection");
		list.add("ch13");
		list.add("bitset");
		
		String[] arr = list.toArray(new String[1]); // array of suitable size is created
		System.out.println(Arrays.toString(arr));
		
		//test iterator remove
		Iterator<String> itr = list.iterator();
		//itr.remove(); // IllegalStateException if remove() without first a next()
		
		// check the order of elements for list
		for(String s: list){
			System.out.print(s + " ");
		}
		System.out.println("---");
		
		// now check for a Set
		Collection<String> set = new HashSet<>();
		set.addAll(list);
		System.out.println("Set ="+set);
		
		// get iterator like before
		itr = set.iterator();
		for (String s : set) {
			System.out.println(s + " ");
		}
		System.out.println("---");
		
		Set<Stock> s1 = new HashSet<>();
		s1.add(new Stock("Tesla","TSLA"));
		s1.add(new Stock("Amazon","AMZN"));
		s1.add(new Stock("Apple","AAPL"));
		s1.add(new Stock("Google","GOOGL"));
		s1.add(new Stock("Illumina","ILMN"));
		s1.add(new Stock("Microsoft","MSFT"));
		s1.add(new Stock("Zoom","ZM"));
		s1.add(new Stock("Nvdia","NVDA"));
		
		System.out.println();
		System.out.println("using foreach ..");
		System.out.println();
		for (Stock s:s1) {
			System.out.println(s +" "); // random order
		}
		
		Iterator<Stock> i1 = s1.iterator();
		System.out.println();
		System.out.println("now using the iterator explicitly...");
		System.out.println();
		
		while(i1.hasNext()){
			System.out.println(i1.next());
		}
		
		// lets see what happens if we now use the set in LinkedList\
		
		// Constructs a list containing the elements of the specified collection,
		// in the order they are returned by the collection's iterator.
		LinkedList<Stock> ll = new LinkedList<>(s1);
		System.out.println();
		System.out.println("Linkedlist created from the Set"+s1);
		System.out.println();
		System.out.println(ll);
		
		// forEach
		System.out.println();
		forEach();
		
		// removeIf
		System.out.println();
		removeIf();
		
		// unaryOperator()
		System.out.println();
		unaryOperator();
		
	}
	
	private static void forEach(){
		System.out.println("forEach()...");
		
		List<Stock> stockList = Arrays.asList(new Stock("Tesla","TSLA"),
		new Stock("Aaple","AAPL"),
		new Stock("Amazon","AMZN"));
		
		stockList.forEach(stock ->
			System.out.printf("The ticker for the stock %s is %s \n" , stock.getName(), stock.getTicker()));
	}
	
	private static void removeIf(){
		System.out.println("removeIf()...");
		
		List<Stock> stockList = new ArrayList<>();
		stockList.add(new Stock("Tesla","TSLA"));
		stockList.add(new Stock("Aaple","AAPL"));
		stockList.add(new Stock("Amazon","AMZN"));
		
		// cannot use Arrays.asList as we need to modify the list
		
		stockList.removeIf((s)->("AAPL").equals(s.getTicker()));
		System.out.println(stockList);
		//[Stock[name='Tesla', ticker='TSLA'], Stock[name='Amazon', ticker='AMZN']]
	}
	
	private static void unaryOperator(){

		List<Integer> ints = Arrays.asList(1,2,3); // replaceAll does not remove any elements
		System.out.println(ints);
		ints.replaceAll((i)->i+1);
		System.out.println(ints);
	}
}

class Stock{
	String name;
	String ticker;
	public Stock(String n, String symbol){
		this.name = n;
		this.ticker = symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTicker() {
		return ticker;
	}
	
	@Override
	public String toString() {
		return new StringJoiner(", ", Stock.class.getSimpleName() + "[", "]")
		.add("name='" + name + "'")
		.add("ticker='" + ticker + "'")
		.toString();
	}
}
