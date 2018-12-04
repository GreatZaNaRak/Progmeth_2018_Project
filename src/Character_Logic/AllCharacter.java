package Character_Logic;

import java.util.ArrayList;

public class AllCharacter {
	
	private static ArrayList<Character> Characters = new ArrayList<>();
	private static ArrayList<Character> myHero = new ArrayList<>();

	public AllCharacter() {
		
		Character cloud = new Character("Cloud", 35, 15, 200, 100);
		cloud.addSkill("Slash", 25, "damage", 30, "-");
		cloud.addSkill("Warcry", 50, "buff", 30, "attack");
		
		Character tifa = new Character("Tifa", 20, 7, 120, 200);
		tifa.addSkill("Heal", 30, "heal", 40, "-");
		tifa.addSkill("Fear", 50, "debuff", 30, "defense");
		
		Character vincent = new Character("Vincent", 30, 10, 150, 150);
		vincent.addSkill("Tackle", 30, "damage", 50, "-");
		vincent.addSkill("Resist", 50, "debuff", 40, "defense");
		
		myHero.add(cloud);
		myHero.add(tifa);
		myHero.add(vincent);
		
		Character ogre = new Character("Ogre", 40, 20, 200, 100);
		Character pyro = new Pyromancer("Pyro", 30, 20, 120, 200);
		Character skeleton = new Skeleton("Skeleton", 0, 10, 200, 0);
		Character warlock = new Bat("Warlock", 60, 10, 120, 250);
		Character boss = new Boss("Boss", 100, 50, 400, 400);
		
		Characters.add(cloud);
		Characters.add(tifa);
		Characters.add(vincent);
		Characters.add(ogre);
		Characters.add(pyro);
		Characters.add(skeleton);
		Characters.add(warlock);
		Characters.add(boss);
		
	}

	public static ArrayList<Character> getCharacters() {
		return Characters;
	}

	public static ArrayList<Character> getMyHero() {
		return myHero;
	}
}
