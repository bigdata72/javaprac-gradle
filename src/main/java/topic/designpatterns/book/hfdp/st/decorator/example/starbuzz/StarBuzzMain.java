package topic.designpatterns.book.hfdp.st.decorator.example.starbuzz;

public class StarBuzzMain {
	public static void main(String[] args) {
		// create a HouseBlend with Soy and steamed milk condiment
		Beverage houseblend = new HouseBlend();
		Beverage soy = new Soy(houseblend);
		Beverage sm = new SteamedMilk(soy);
		Beverage bev = new Mocha(new Mocha(sm)); //double mocha
		
		System.out.println(bev.getDescription());
		System.out.println("Cost ="+bev.cost());
	}
}
