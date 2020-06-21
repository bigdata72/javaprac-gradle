package topic.designpatterns.book.hfdp.be.iterator.example.menu;

import java.util.StringJoiner;

public class MenuItem {
	private String name;
	private boolean veg;
	private double price;
	
	public MenuItem(String name, boolean veg, double price){
		this.name = name;
		this.veg = veg;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isVeg() {
		return veg;
	}
	
	public void setVeg(boolean veg) {
		this.veg = veg;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return new StringJoiner(", ", MenuItem.class.getSimpleName() + "[", "]")
		.add("name='" + name + "'")
		.add("veg=" + veg)
		.add("price=" + price)
		.toString();
	}
}
