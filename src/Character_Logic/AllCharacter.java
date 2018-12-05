package Character_Logic;

import java.util.ArrayList;

import scene.PlayScene;

public class AllCharacter {

	private static ArrayList<Character> Characters = new ArrayList<>();
	private static ArrayList<Character> myHero = new ArrayList<>();

	public AllCharacter() {

		Character cloud = new Character("Cloud", 35, 15, 180, 100);
		cloud.addSkill("Slash", 25, "damage", 50, "-");
		cloud.addSkill("Warcry", 50, "buff", 30, "attack");

		Character tifa = new Character("Tifa", 28, 7, 120, 200);
		tifa.addSkill("Heal", 50, "heal", 40, "-");
		tifa.addSkill("Fear", 70, "debuff", 35, "defense");

		Character vincent = new Character("Vincent", 30, 10, 150, 150);
		vincent.addSkill("Tackle", 50, "damage", 50, "-");
		vincent.addSkill("Resist", 50, "debuff", 35, "defense");

		myHero.add(cloud);
		myHero.add(tifa);
		myHero.add(vincent);

		Character ogre = new Character("Ogre", 60, 22, 200, 0);
		Character pyro = new Pyromancer("Pyro", 30, 10, 150, 0);
		Character skeleton = new Skeleton("Skeleton", 40, 10, 150, 0);
		Character warlock = new Bat("Warlock", 40, 10, 150, 0);
		Character boss = new Boss("Boss", 20, 8, 150, 0);

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