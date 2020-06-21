package topic.designpatterns.book.hfdp.be.iterator.example.menu;

public class MenuIteratorMain {
	public static void main(String[] args) {
		BreakfastMenu bfast = new BreakfastMenu();
		DinnerMenu dinner = new DinnerMenu();
		bfast.printMenu();
		dinner.printMenu();
		
		System.out.println("iterating through Dinner menu ...");
		Iterator<MenuItem> dmItr = dinner.getIterator();
		while(dmItr.hasNext()){
			System.out.println(dmItr.next());
		}
		
		System.out.println("iterating through breakfast menu ...");
		Iterator<MenuItem> bmItr = bfast.getIterator();
		while(bmItr.hasNext()){
			System.out.println(bmItr.next());
		}
	}
}
