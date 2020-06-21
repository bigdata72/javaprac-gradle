package topic.collections.book.liang;

import java.util.*;

// tests methods of collection
public class CollectionTest {
	public static void main(String[] args) {
		
		System.out.println("-------------------------------------------");
		System.out.println("test collection using ArrayList<String> .....");
		testCollection(new ArrayList<>(), new ArrayList<>());
		System.out.println("-------------------------------------------");
		
		System.out.println("test collection using HashSet<String> ......");
		testCollection(new HashSet<>(), new HashSet<>());
		System.out.println("-------------------------------------------");
		
		System.out.println("test collection using LinkedList<String> ......");
		testCollection(new LinkedList<>(), new LinkedList<>());
		System.out.println("-------------------------------------------");
		
		System.out.println("test collection using TreeSet<String> ......");
		testCollection(new TreeSet<>(), new TreeSet<>());
		System.out.println("-------------------------------------------");
		
		System.out.println("test collection using LinkedHashSet<String> ......");
		testCollection(new LinkedHashSet<>(), new LinkedHashSet<>());
		System.out.println("-------------------------------------------");
		
		System.out.println("test collection using Vector<String> ......");
		testCollection(new Vector<>(), new Vector<>());
		System.out.println("-------------------------------------------");
		
		System.out.println("test collection using Stack<String> ......");
		testCollection(new Stack<>(), new Stack<>());
		System.out.println("-------------------------------------------");
		
		
	}
	
	private static void testCollection(Collection<String> coll1, Collection<String> coll2) {
		System.out.println(">>>> Using "+coll1.getClass() +" <<<<<");
		coll1.add("New York");
		coll1.add("Atlanta");
		coll1.add("Dallas");
		coll1.add("Boston");
		
		
		
		// test printing out
		System.out.print("Cities in coll1:");
		System.out.println(coll1); //[New York, Atlanta, Dallas, Boston]
		
		// check if an object is in collection
		System.out.println("Is Dallas in coll1?"+coll1.contains("Dallas")); //Is Dallas in collection?true
		
		// remove Dallas
		System.out.println("removing Dallas ..");
		coll1.remove("Dallas");
		System.out.print(coll1.size() + " cities in coll1 now  :"); //3 cities in coll1 now
		System.out.println(coll1);
		// 2nd collection
		coll2.add("Seattle");
		coll2.add("Atlanta");
		coll2.add("Los Angeles");
		coll2.add("San Diego");
		
		// print coll2
		System.out.print("Cities in coll2:");
		System.out.println(coll2); //[Seattle, Atlanta, Los Angeles, San Diego]
		
		// clone collection1
		Collection<String> c1 = null;
		c1 = getCollection(coll1, c1);
		
		// addAll() Set union
		if(c1 != null) {
			c1.addAll(coll2);
			System.out.println("Cities in coll1 1 and coll2, after coll1.addAll(coll2):");
			System.out.println(c1); //[New York, Atlanta, Boston, Seattle, Atlanta, Los Angeles, San Diego]
			System.out.println(c1.toArray()); //[Ljava.lang.Object;@15db9742
			System.out.println(Arrays.toString(c1.toArray())); //[New York, Atlanta, Boston, Seattle, Atlanta, Los Angeles, San Diego]
			
			// retainAll (Set Intersection)
			System.out.println("c1.retainAll(coll2)...");
			System.out.println(c1.retainAll(coll2)); //true
			System.out.println("after coll1.retailAll(coll2) : "+c1);
			// [Atlanta, Seattle, Atlanta, Los Angeles, San Diego]
		}else{
			System.out.println("coll1 could not be cloned ...");
		}
		
		c1 = getCollection(coll1, c1);
		if(c1 != null) {
			System.out.println("coll1 = "+c1);    // c1 = [New York, Atlanta, Boston]
			System.out.println("coll2 = "+coll2);  //coll2 = [Seattle, Atlanta, Los Angeles, San Diego]
			System.out.println("call1.retainAll(coll2)...");
			c1.retainAll(coll2);
			System.out.println("after coll1.retainAll(coll2) ="+c1); //[Atlanta]
		}else{
			System.out.println("coll1 could not be cloned ...");
		}
		
		// removeAll (Set minus)
		c1 = getCollection(coll1, c1);
		if(c1 != null) {
			System.out.println("call1 = "+c1);    // c1 = [New York, Atlanta, Boston]
			System.out.println("call2 = "+coll2);  //coll2 = [Seattle, Atlanta, Los Angeles, San Diego]
			System.out.println("call1.removeAll(coll2)...");
			c1.removeAll(coll2);
			System.out.println("after call1.removeAll(coll2) =" +c1); //[New York, Boston]
		}else{
			System.out.println("coll1 could not be cloned ...");
		}
	}
	
	private static Collection<String> getCollection(Collection<String> coll1, Collection<String> c1) {
		if (coll1 instanceof ArrayList) {
			c1 = (Collection<String>) ((ArrayList<String>) coll1).clone();
		}else if(coll1 instanceof HashSet){
			c1 = (Collection<String>) ((HashSet<String>) coll1).clone();
		}else if(coll1 instanceof LinkedHashSet){
			c1 = (Collection<String>) ((LinkedHashSet<String>) coll1).clone();
		}else if(coll1 instanceof Vector){
			c1 = (Collection<String>) ((Vector<String>) coll1).clone();
		}else if(coll1 instanceof Stack){
			c1 = (Collection<String>) ((Stack<String>) coll1).clone();
		}else if(coll1 instanceof LinkedList){
			c1 = (Collection<String>) ((LinkedList<String>) coll1).clone();
		}else if(coll1 instanceof TreeSet){
			c1 = (Collection<String>) ((TreeSet<String>) coll1).clone();
		}
		return c1;
	}
}
