package topic.designpatterns.book.hfdp.st.decorator.example.starbuzz;

public class HouseBlend extends Beverage{
	
	public HouseBlend(){
		description = "HouseBlend";
	}
	
	@Override
	public double cost() {
		return 2.0;
	}
}
