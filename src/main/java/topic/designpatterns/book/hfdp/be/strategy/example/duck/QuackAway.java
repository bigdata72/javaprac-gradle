package topic.designpatterns.book.hfdp.be.strategy.example.duck;

import topic.designpatterns.book.hfdp.be.strategy.QuackBehavior;

public class QuackAway implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Quack");
	}
}
