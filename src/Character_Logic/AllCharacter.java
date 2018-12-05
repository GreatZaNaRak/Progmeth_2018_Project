package Character_Logic;

import java.util.ArrayList;

public class AllCharacter {

	private static ArrayList<Character> Characters = new ArrayList<>();
	private static ArrayList<Character> myHero = new ArrayList<>();

	public AllCharacter() {

		Character Red = new Character("Red", 35, 15, 180, 100);
		Red.addSkill("Slash", 25, "damage", 50, "-");
		Red.addSkill("Warcry", 50, "buff", 30, "attack");

		Character Pearl = new Character("Pearl", 28, 7, 120, 200);
		Pearl.addSkill("Heal", 50, "heal", 40, "-");
		Pearl.addSkill("Fear", 70, "debuff", 35, "defense");

		Character Tommy = new Character("Tommy", 30, 10, 150, 150);
		Tommy.addSkill("Tackle", 50, "damage", 50, "-");
		Tommy.addSkill("Resist", 50, "debuff", 35, "defense");

		myHero.add(Red);
		myHero.add(Pearl);
		myHero.add(Tommy);

		Character ogre = new Character("Ogre", 60, 22, 200, 0);
		Character pyro = new Pyromancer("Pyro", 30, 10, 150, 0);
		Character skeleton = new Skeleton("Skeleton", 40, 10, 150, 0);
		Character warlock = new Warlock("Warlock", 40, 10, 150, 0);
		Character boss = new Boss("Boss", 20, 8, 5000, 0);

		Characters.add(Red);
		Characters.add(Pearl);
		Characters.add(Tommy);
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