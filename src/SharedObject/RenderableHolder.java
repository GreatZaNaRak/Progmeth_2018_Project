package SharedObject;

import javafx.scene.image.Image;

public class RenderableHolder {
	

	public static Image char1, char2, char3, char4;
	public static Image charII1, charII2, charII3, charII4;
	public static Image charIII1, charIII2, charIII3, charIII4;
	public static Image enemy1, enemy2, enemy3, enemy4, boss;
	public static Image exclamation, battle, background1, background2, gameIcon;
	public static Image char1Image, char2Image, char3Image;
	public static Image char1Dead, char2Dead, char3Dead;
	public static Image wasd, enemyFound, back, arrowNext, arrowPrev, nextLevel, fightPic;

	static {
		loadResource();
	}

	public static void loadResource() {
		
		background1 = new Image(ClassLoader.getSystemResource("bg.png").toString());
		background2 = new Image(ClassLoader.getSystemResource("evil-castle.jpg").toString());
		gameIcon = new Image(ClassLoader.getSystemResource("FFII_PSP_Logo.jpg").toString());
		
		char1Image = new Image(ClassLoader.getSystemResource("Great.jpg").toString());
		char2Image = new Image(ClassLoader.getSystemResource("Jiji.jpg").toString());
		char3Image = new Image(ClassLoader.getSystemResource("SoSo.jpg").toString());
		
		char1Dead = new Image(ClassLoader.getSystemResource("war_dead.png").toString());
		char2Dead = new Image(ClassLoader.getSystemResource("priest_dead.png").toString());
		char3Dead = new Image(ClassLoader.getSystemResource("berserk_dead.png").toString());
		
		char1 = new Image(ClassLoader.getSystemResource("warrior_walking.gif").toString());
		char2 = new Image(ClassLoader.getSystemResource("warrior_walk_left.gif").toString());
		char3 = new Image(ClassLoader.getSystemResource("warrior_walk_down.gif").toString());
		char4 = new Image(ClassLoader.getSystemResource("warrior_walk_up.gif").toString());
		
		charII1 = new Image(ClassLoader.getSystemResource("priest_walk_right.gif").toString());
		charII2 = new Image(ClassLoader.getSystemResource("priest_walk_left.gif").toString());
		charII3 = new Image(ClassLoader.getSystemResource("priest_walk_down.gif").toString());
		charII4 = new Image(ClassLoader.getSystemResource("priest_walk_up.gif").toString());
		
		charIII1 = new Image(ClassLoader.getSystemResource("berserk_walk_right.gif").toString());
		charIII2 = new Image(ClassLoader.getSystemResource("berserk_walk_left.gif").toString());
		charIII3 = new Image(ClassLoader.getSystemResource("berserk_walk_down.gif").toString());
		charIII4 = new Image(ClassLoader.getSystemResource("berserk_walk_up.gif").toString());
		
		enemy1 = new Image(ClassLoader.getSystemResource("ogre.png").toString());
		enemy2 = new Image(ClassLoader.getSystemResource("pyro_idle.gif").toString());
		enemy3 = new Image(ClassLoader.getSystemResource("skeleton.png").toString());
		enemy4 = new Image(ClassLoader.getSystemResource("Warlock.png").toString());
		boss = new Image(ClassLoader.getSystemResource("boss.png").toString());
		
		exclamation = new Image(ClassLoader.getSystemResource("exclamation.gif").toString());
		battle = new Image(ClassLoader.getSystemResource("vs.gif").toString());
		
		wasd = new Image(ClassLoader.getSystemResource("wasd.jpg").toString());
		enemyFound = new Image(ClassLoader.getSystemResource("enemyFound.jpg").toString());
		back = new Image(ClassLoader.getSystemResource("back.png").toString());
		arrowNext = new Image(ClassLoader.getSystemResource("arrow.png").toString());
		arrowPrev = new Image(ClassLoader.getSystemResource("arrow_back.png").toString());
		nextLevel = new Image(ClassLoader.getSystemResource("nextLevel.jpg").toString());
		fightPic = new Image(ClassLoader.getSystemResource("fightPic.jpg").toString());
	}
	
	
}
