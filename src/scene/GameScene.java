package scene;

import Character_Animate.Character_Ani;
import Character_Logic.AllCharacter;
import SceneManage.SceneManagement;
import SharedObject.RenderableHolder;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import sound.soundManagement;

public class GameScene extends StackPane {
	
	private static Canvas canvas;
	public static AnimationTimer animate, enemyMove;
	public static GraphicsContext gc, enemyGC, bgGc, enemy1GC, enemy2GC;
	public static int enemyID = 0, bgX = 0, bgY = 0, cnt = 0;
	private static final int SPEED = 10;
	private static boolean isHit, isEnemyFound = false;
	private static int x = 50, y = 450, distanceX = 50, distanceY = 450, next = 1250, enermyX = 750;

	public GameScene() {

		Canvas bgCavnas = new Canvas(2000, 900);
		bgGc = bgCavnas.getGraphicsContext2D();
		
		bgGc.drawImage(RenderableHolder.background1, 0, 0, 2000, 900);
		
		canvas = new Canvas(900, 900);
		gc = canvas.getGraphicsContext2D();
		
		Canvas enermyCanvas = new Canvas(900, 900);
		enemyGC = enermyCanvas.getGraphicsContext2D();
		enemyGC.fillOval(next, 450, 80, 80);
		
		Canvas enemy1Canvas = new Canvas(900, 900);
		enemy1GC = enemy1Canvas.getGraphicsContext2D();
		enemy1GC.drawImage(RenderableHolder.enemy1, enermyX, 200, 100, 100);
		
		Canvas enemy2Canvas = new Canvas(900, 900);
		enemy2GC = enemy2Canvas.getGraphicsContext2D();
		enemy2GC.drawImage(RenderableHolder.enemy2, enermyX - 450 , 600, 100, 100);
		
		this.getChildren().add(bgCavnas);
		this.getChildren().add(enermyCanvas);
		this.getChildren().add(enemy1Canvas);
		this.getChildren().add(enemy2Canvas);
		this.getChildren().add(canvas);
		
	}
	
	public static void drawChar(int charToPlay) {
		switch (charToPlay) {
		case 1 : gc.drawImage(RenderableHolder.char1, x, y, 100, 100); break;
		case 2 : gc.drawImage(RenderableHolder.charII1, x, y, 100, 100); break;
		case 3 : gc.drawImage(RenderableHolder.charIII1, x, y, 100, 100); break;
		}
	}
	
	public static void hitEnermy() {
		animate = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if (690 < distanceX && distanceX < 800  &&  150 < distanceY && distanceY < 240) {
					if (AllCharacter.getCharacters().get(3).isAlive()) {
						gc.drawImage(RenderableHolder.exclamation, x + 22, y - 60, 62, 62);
						isEnemyFound = true;
						enemyID = 3;
					} else {
						isEnemyFound = false;
					}
				} else if (690 - 450 < distanceX && distanceX < 800 - 450 && 550 < distanceY && distanceY < 640) {
					if (AllCharacter.getCharacters().get(4).isAlive()) {
						gc.drawImage(RenderableHolder.exclamation, x + 22, y - 60, 62, 62);
						isEnemyFound = true;
						enemyID = 4;
					} else {
						isEnemyFound = false;
					}
				} else {
					isEnemyFound = false;
					enemyID = 0;
					animate.stop();
				}
			}
		};animate.start();
	}
	
	
	
	public static void setGameAction(Image char1, Image char2, Image char3, Image char4) {
		SceneManagement.gameScene.setOnKeyPressed(e -> {
			if (cnt == 1) return;
			if (e.getCode() == KeyCode.D) {
				if (x >= 820) {
					x += 0;
					distanceX += 0;
				}
				else {
					x += SPEED;
					distanceX += SPEED;
				}
				if (x >= 600 && bgX > -550) {
					x -= SPEED;
					bgX -= SPEED;
					next -= SPEED;
					enermyX -= SPEED;
					bgGc.drawImage(RenderableHolder.background1, bgX, bgY, 2000, 900);
					enemyGC.clearRect(0, 0, 2000, 900);
					enemy1GC.clearRect(0, 0, 2000, 900);
					enemy2GC.clearRect(0, 0, 2000, 900);
					enemyGC.fillOval(next, 450, 80, 80);
					if (AllCharacter.getCharacters().get(3).isAlive()) 
						enemy1GC.drawImage(RenderableHolder.enemy1, enermyX, 200, 100, 100);
					if (AllCharacter.getCharacters().get(4).isAlive()) 
						enemy2GC.drawImage(RenderableHolder.enemy2, enermyX - 450, 600, 100, 100);
				}
				gc.clearRect(0, 0, 900, 900);
				gc.drawImage(char1, x, y, 100, 100);
				hitNextLevel();
				hitEnermy();
				
			} else if (e.getCode() == KeyCode.S) {
				if (y >= 790) {
					y += 0;
					distanceY += 0;
				}
				else {
					y += SPEED;
					distanceY += SPEED;
				}
				gc.clearRect(0, 0, 900, 900);
				gc.drawImage(char3, x, y, 100, 100);
				hitNextLevel();
				hitEnermy();
				
			} else if (e.getCode() == KeyCode.A) {
				if (x <= 0) {
					x -= 0;
					distanceX -= 0;
				}
				else {
					x -= SPEED;
					distanceX -= SPEED;
				}
				if (x <= 150 && bgX <= 550) {
					x += SPEED;
					bgX += SPEED;
					next += SPEED;
					enermyX += SPEED;
					bgGc.drawImage(RenderableHolder.background1, bgX, bgY, 2000, 900);
					enemyGC.clearRect(0, 0, 2000, 900);
					enemy1GC.clearRect(0, 0, 2000, 900);
					enemy2GC.clearRect(0, 0, 2000, 900);
					enemyGC.fillOval(next, 450, 80, 80);
					if (AllCharacter.getCharacters().get(3).isAlive()) 
						enemy1GC.drawImage(RenderableHolder.enemy1, enermyX, 200, 100, 100);
					if (AllCharacter.getCharacters().get(4).isAlive()) 
						enemy2GC.drawImage(RenderableHolder.enemy2, enermyX - 450, 600, 100, 100);
				}
				gc.clearRect(0, 0, 900, 900);
				gc.drawImage(char2, x, y, 100, 100);
				hitNextLevel();
				hitEnermy();
				
			} else if (e.getCode() == KeyCode.W) {
				if (y <= 150) {
					y -= 0;
					distanceY -= 0;
				}
				else {
					y -= SPEED;
					distanceY -= SPEED;
				}
				gc.clearRect(0, 0, 900, 900);
				gc.drawImage(char4, x, y, 100, 100);
				hitNextLevel();
				hitEnermy();
				
			} else if (e.getCode() == KeyCode.SPACE && isHit) {
				soundManagement.enterSound();
				SceneManagement.switchScene(SceneManagement.stage1Scene);
				soundManagement.stopGameSound();
				soundManagement.gameSound2();
				stage_1.drawChar(PlayScene.CharToPlay);
				switch (PlayScene.CharToPlay) {
				
				case 1: stage_1.setGameAction(Character_Ani.getChar1(), 
						Character_Ani.getChar2(), 
						Character_Ani.getChar3(), 
						Character_Ani.getChar4()); break;
						
				case 2: stage_1.setGameAction(Character_Ani.getCharII1(), 
						Character_Ani.getCharII2(), 
						Character_Ani.getCharII3(), 
						Character_Ani.getCharII4()); break;
				
				case 3: stage_1.setGameAction(Character_Ani.getCharIII1(), 
						Character_Ani.getCharIII2(), 
						Character_Ani.getCharIII3(), 
						Character_Ani.getCharIII4()); break;
				}
				
			} else if (e.getCode() == KeyCode.SPACE && isEnemyFound) {
				soundManagement.enterFightSound();
				soundManagement.stopGameSound();
				BattleScene.drawEnermy();
				BattleScene.resetTurn();
				BattleScene.drawCommandBox(enemyID);
				BattleScene.resetTurn();
				SceneManagement.battle.setBottom(BattleScene.getBox());
				AnimationTimer rr = new AnimationTimer() {
					
					@Override
					public void handle(long now) {
						enemyGC.drawImage(RenderableHolder.battle, 0, 0, 900, 900);
					}
				};rr.start();
		
				Timeline timeline = new Timeline(
					    new KeyFrame(Duration.ZERO, e1 -> {
					    	cnt = 1;
					    	switch (enemyID) {
					    	case 3:
					    		enemy2GC.clearRect(0, 0, 2000, 900);
					    		break;
					    	case 4:
					    		enemy1GC.clearRect(0, 0, 2000, 900);
					    		break;
					    	}
					    }),
					    new KeyFrame(Duration.seconds(2.2), e1 -> { 
					    	enemyGC.clearRect(0, 0, 2000, 900);
					    	cnt = 0;
					    	drawChar(PlayScene.CharToPlay);
					    	enemyGC.fillOval(next, 450, 80, 80);
					    	if (AllCharacter.getCharacters().get(3).isAlive()) 
					    		enemy1GC.drawImage(RenderableHolder.enemy1, enermyX, 200, 100, 100);
							if (AllCharacter.getCharacters().get(4).isAlive()) 
								enemy2GC.drawImage(RenderableHolder.enemy2, enermyX - 450, 600, 100, 100);
					    	SceneManagement.switchScene(SceneManagement.battleScene);
					    	soundManagement.battleSound();
					    	rr.stop();
					    	})
					);
					timeline.play();
			} 
		});
	}
	
	public static void hitNextLevel() {
		if (1200 < distanceX && distanceX < 1300  &&  350 < distanceY && distanceY < 450) {
			isHit = true;
		} else {
			isHit = false;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public static boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit_in) {
		isHit = isHit_in;
	}

}
