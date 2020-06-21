package topic.designpatterns.book.hfdp.be.strategy.example.duck;

public class MallardDuck extends Duck {
	
	MallardDuck(){
		flyBehavior = new FlyWithWings();
		quackBehavior = new QuackAway();
	}
	
	@Override
	public String getName() {
		return "Mallard Duck";
	}
}
