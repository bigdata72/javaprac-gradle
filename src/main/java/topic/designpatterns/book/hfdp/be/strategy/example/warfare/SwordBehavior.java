package topic.designpatterns.book.hfdp.be.strategy.example.warfare;

public class SwordBehavior implements WeaponBehavior{
	@Override
	public void useWeapon() {
		System.out.println("swings with a sword");
	}
}
