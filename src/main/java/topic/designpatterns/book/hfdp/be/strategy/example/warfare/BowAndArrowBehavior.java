package topic.designpatterns.book.hfdp.be.strategy.example.warfare;

public class BowAndArrowBehavior implements WeaponBehavior{
	@Override
	public void useWeapon() {
		System.out.println("Shoot arrows with a bow");
	}
}
