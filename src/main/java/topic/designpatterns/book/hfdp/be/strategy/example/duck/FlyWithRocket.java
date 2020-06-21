package topic.designpatterns.book.hfdp.be.strategy.example.duck;

public class FlyWithRocket implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("FlyWithRocket: jet powered flight");
	}
}
