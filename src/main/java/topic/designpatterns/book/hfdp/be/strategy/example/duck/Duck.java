package topic.designpatterns.book.hfdp.be.strategy.example.duck;

import topic.designpatterns.book.hfdp.be.strategy.QuackBehavior;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public void performFly(){
		flyBehavior.fly();
	}
	
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public abstract String getName();
	
	public void setQuackBehavior(QuackBehavior quackBehavior){
		this.quackBehavior = quackBehavior;
	}
	
	public void setFlyBehavior(FlyBehavior flyBehavior){
		this.flyBehavior = flyBehavior;
	}
	
	public void swim(){
		System.out.println(getName() + " can swim");
	}
}
