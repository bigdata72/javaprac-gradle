package topic.designpatterns.book.hfdp.st.decorator.example.starbuzz;

public class Espresso extends Beverage{
	
	public Espresso(){
		description = "Espresso";
	}
	
	@Override
	public double cost() {
		return 3.2;
	}
}
