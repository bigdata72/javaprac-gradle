package topic.designpatterns.book.hfdp.be.iterator.example.menu;

import java.util.ArrayList;

public class BreakfastMenu {
	private ArrayList<MenuItem> menuItems;
	
	public BreakfastMenu(){
		menuItems = new ArrayList<>();
		// create the menu
		addMenuItem("Protein Pancake", false, 10.99);
		addMenuItem("Veggie Omlette", true, 5.99);
		addMenuItem("Poached Egg with Bread", false, 4.99);
		addMenuItem("Protein Smoothie", true, 4.99);
		addMenuItem("Gluten free Oats", true, 6.99);
	}
	
	private void addMenuItem(String name, boolean veg, double price){
		MenuItem menuItem = new MenuItem(name, veg, price);
		menuItems.add(menuItem);
	}
	
	public void printMenu(){
		System.out.println(menuItems);
	}
	
	public Iterator<MenuItem> getIterator(){
		return new BreakfastMenuIterator<>(menuItems);
	}
}
