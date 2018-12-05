package Character_Logic;

import java.util.ArrayList;

public class Character {
	private String name;
	private int health;
	private int MAXHEALTH;
	private int damage, default_damage;
	private int defend, default_defense;
	private ArrayList<Skill> allSkill;
	private boolean isAlive;
	private int mana;
	private int MAXMANA;

	public Character(String name, int damage, int defend, int maxHealth, int mana) {
		allSkill = new ArrayList<>();
		this.name = name;
		this.MAXHEALTH = maxHealth;
		this.health = MAXHEALTH;
		this.defend = defend;
		this.default_damage = damage;
		this.damage = damage;
		this.default_defense = defend;
		this.mana = mana;
		MAXMANA = mana;
		this.isAlive = true;
	}

	public boolean takeDamage(int damage) {
		int totaldamage = damage - defend;
		if (totaldamage < 0)
			return false;
		if (totaldamage > this.health) {
			this.health = 0;
			isAlive = false;
		} else
			this.health -= totaldamage;
		return true;
	}

	public boolean attack(Character target) {
		if (target.isAlive() == false)
			return false;
		target.takeDamage(this.damage);
		return true;
	}

	public void addSkill(String name, int consuming, String type, int special, String specialType) {
		if (type.equalsIgnoreCase("damage")) {
			Skill skill = new DamageSkill(name, consuming, special);
			allSkill.add(skill);
		}
		if (type.equalsIgnoreCase("heal")) {
			Skill skill = new HealSkill(name, consuming, special);
			allSkill.add(skill);
		}
		if (type.equalsIgnoreCase("buff")) {
			Skill skill = new BuffSkill(name, consuming, specialType, special);
			allSkill.add(skill);
		}
		if (type.equalsIgnoreCase("debuff")) {
			Skill skill = new DebuffSkill(name, consuming, specialType, special);
			allSkill.add(skill);
		}
	}

	public void useSkill(int number, Character target) throws InsufficientManaException {
		if (allSkill.get(number).getConsuming() <= this.mana) {
			allSkill.get(number).skillTo(target);
			this.mana -= allSkill.get(number).getConsuming();
		} else {
			int need = allSkill.get(number).getConsuming() - mana;
			throw new InsufficientManaException(need);
		}
	}

	public String getName() {
		return name;
	}

	public void getHeal(int heal) {
		if (this.isAlive == true) {
			if (heal + this.health > MAXHEALTH)
				this.setHealth(MAXHEALTH);
			else
				this.setHealth(health+heal);
		}
	}

	public int getHealth() {
		return health;
	}

	public int getDamage() {
		return damage;
	}

	public int getMAXHEALTH() {
		return MAXHEALTH;
	}

	public int getMAXMANA() {
		return MAXMANA;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean alive) {
		this.isAlive = alive;
	}

	public void setMAXHEALTH(int mAXHEALTH) {
		MAXHEALTH = mAXHEALTH;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setDefend(int defend) {
		this.defend = defend;
	}

	public int getDefend() {
		return defend;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getDefault_damage() {
		return default_damage;
	}

	public int getDefault_defense() {
		return default_defense;
	}

}