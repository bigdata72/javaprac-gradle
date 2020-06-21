package topic.designpatterns.book.hfdp.be.strategy.example.duck;

public class ModelDuck extends Duck {
	
	ModelDuck(){
		flyBehavior = new FlyWithWings();
		quackBehavior = new Squeak();
	}
	
	@Override
	public String getName() {
		return "Model Duck";
	}
}
