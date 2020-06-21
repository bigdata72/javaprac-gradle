package topic.designpatterns.book.hfdp.be.strategy.example.warfare;

public abstract class Character {
	WeaponBehavior weaponBehavior;
	
	void fight(){
		weaponBehavior.useWeapon();
	}
	
	public void setWeaponBehavior(WeaponBehavior weaponBehavior){
		this.weaponBehavior = weaponBehavior;
	}
	
	abstract String getName();

	@Override
	public String toString(){
		return getName();
	}
	
	void speak(){
		System.out.println("-----------------------");
		System.out.println(this +" created");
	}
}
