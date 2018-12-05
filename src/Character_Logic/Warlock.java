package Character_Logic;

public class Warlock extends Character{
	
	public Warlock(String name,int damage, int defend, int maxhealth, int mana) {
		super(name,damage,defend,maxhealth,mana);
	}
	
	@Override
	public boolean attack(Character target) {
		if(super.attack(target))
			this.getHeal(getDamage()*50/100);
		return false;
	}
}
