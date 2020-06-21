package topic.designpatterns.book.hfdp.be.strategy.example.warfare;

public class WarfareMain {
	public static void main(String[] args) {
		Character character = new King();
		character.speak();
		character.setWeaponBehavior(new SwordBehavior());
		character.fight();
		
		character = new Minister();
		character.speak();
		character.setWeaponBehavior(new KnifeBehavior());
		character.fight();
		
		character = new Knight();
		character.speak();
		character.setWeaponBehavior(new BowAndArrowBehavior());
		character.fight();
		
	}
}
