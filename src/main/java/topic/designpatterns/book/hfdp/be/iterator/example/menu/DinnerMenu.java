package topic.designpatterns.book.hfdp.be.iterator.example.menu;

import java.util.Arrays;

public class DinnerMenu {
	private MenuItem[] menuItems;
	private final int MAX_ITEMS = 5;
	private int index;
	
	public DinnerMenu(){
		menuItems = new MenuItem[MAX_ITEMS];
		addMenuItem("Chilly Chicken", false, 17.99);
		addMenuItem("Chicken Chowmein", false, 12.99);
		addMenuItem("Chicken Friedrice", false, 12.99);
		addMenuItem("Goat Dopiaza", false, 18.99);
		addMenuItem("Chilly Paneer", true, 14.99);
	}
	
	private void addMenuItem(String name, boolean veg, double price){
		MenuItem menu = new MenuItem(name, veg, price);
		if(index == MAX_ITEMS){
			System.out.println("menutItems.length ="+menuItems.length);
			System.out.println("Max number of items reached");
		}else{
			menuItems[index] = menu;
			index++;
		}
	}
	
	public void printMenu(){
		System.out.println(Arrays.toString(menuItems));
	}
	
	public Iterator<MenuItem> getIterator(){
		return new DinnerMenuIterator<>(menuItems);
	}
	
}
