package topic.designpatterns.book.hfdp.be.strategy.example.duck;

import topic.designpatterns.book.hfdp.be.strategy.QuackNoWay;

public class DuckClient {
	public static void main(String[] args) {
		Duck duck = new MallardDuck();
		System.out.println("we got a "+duck.getName());
		System.out.println("........");
		duck.performFly();;
		duck.performQuack();
		System.out.println("........");
		
		duck = new ModelDuck();
		System.out.println("we got a "+duck.getName());
		System.out.println("........");
		duck.performFly();
		duck.performQuack();
		System.out.println("........");
		
		System.out.println("Now change behavior on ModelDuck");
		
		duck.setFlyBehavior(new FlyWithRocket());
		duck.setQuackBehavior(new QuackNoWay());
		duck.performFly();
		duck.performQuack();
		System.out.println("........");
	}
}
