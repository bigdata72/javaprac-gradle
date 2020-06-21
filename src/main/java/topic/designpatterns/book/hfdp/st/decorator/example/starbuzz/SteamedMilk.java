package topic.designpatterns.book.hfdp.st.decorator.example.starbuzz;

public class SteamedMilk extends CondimentDecorator {
	
	public SteamedMilk(Beverage soy) {
		super(soy);
	}
	
	@Override
	public String getDescription(){
		return "Steamed Milk" + " " + super.getDescription();
	}
	
	@Override
	public double cost(){
		return 0.1 + super.cost();
	}
}
