package topic.designpatterns.book.hfdp.st.decorator.example.starbuzz;

public class Mocha extends CondimentDecorator {
	
	public Mocha(Beverage bev) {
		super(bev);
	}
	
	@Override
	public String getDescription(){
		return "Mocha" + " " + super.getDescription();
	}
	
	@Override
	public double cost(){
		return 0.4 + super.cost();
	}
}
