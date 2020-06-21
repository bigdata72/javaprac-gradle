package topic.designpatterns.book.hfdp.st.decorator.example.starbuzz;

public class CondimentDecorator extends Beverage{
	private Beverage beverage;
	
	public CondimentDecorator(Beverage bev){
		this.beverage = bev;
	}
	
	@Override
	public String getDescription(){
		return beverage.getDescription();
	}
	
	@Override
	public double cost() {
		return beverage.cost();
	}
}
