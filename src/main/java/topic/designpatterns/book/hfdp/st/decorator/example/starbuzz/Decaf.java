package topic.designpatterns.book.hfdp.st.decorator.example.starbuzz;

public class Decaf extends Beverage{
	
	public Decaf(){
		description = "Decaf";
	}
	
	@Override
	public double cost() {
		return 0;
	}
}
