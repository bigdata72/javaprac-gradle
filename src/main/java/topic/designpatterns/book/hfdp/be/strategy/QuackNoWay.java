package topic.designpatterns.book.hfdp.be.strategy;

public class QuackNoWay implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("QuackNoWay: this duck cannot quack");
	}
}
