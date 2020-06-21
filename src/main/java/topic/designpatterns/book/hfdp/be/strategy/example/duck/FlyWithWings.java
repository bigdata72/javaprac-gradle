package topic.designpatterns.book.hfdp.be.strategy.example.duck;

public class FlyWithWings implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("FlyWithWings, this duck can fly");
	}
}
