package topic.designpatterns.book.hfdp.st.decorator.example.starbuzz;

public class Soy extends CondimentDecorator {
	
	public Soy(Beverage bev) {
		super(bev);
	}
	
	@Override
	public String getDescription(){
		return "Soy" + " " + super.getDescription();
	}
	
	@Override
	public double cost() {
		return 0.3 + super.cost();
	}
}
