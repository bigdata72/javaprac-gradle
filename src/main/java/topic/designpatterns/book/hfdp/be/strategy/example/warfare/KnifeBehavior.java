package topic.designpatterns.book.hfdp.be.strategy.example.warfare;

public class KnifeBehavior implements WeaponBehavior {
	@Override
	public void useWeapon() {
		System.out.println("Cut with a knife");
	}
}
