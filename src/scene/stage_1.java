package scene;

import java.util.Optional;
import Character_Logic.AllCharacter;
import SceneManage.SceneManagement;
import SharedObject.RenderableHolder;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import sound.soundManagement;

public class stage_1 extends StackPane {
	
	private static Canvas canvas;
	private static AnimationTimer animate;
	public static GraphicsContext gc, bgGc, enemyGC, enemy1GC, enemy2GC, bossGC;
	private static final int SPEED = 10; // should be 5
	private static boolean isHit, isEnemyFound = false;
	private static int x = 50, y = 450, distanceX = 50, distanceY = 450, previous = -450;
	private static int enemy3X = 900, enemy4X = 250, bossX = 360;
	private static int bgX = 0, bgY = 0;

	public stage_1() {
		
		Canvas bgCavnas = new Canvas(2000, 900);
		bgGc = bgCavnas.getGraphicsContext2D();
		
		bgGc.drawImage(RenderableHolder.background2, 0, 0, 2000, 900);
		
		canvas = new Canvas(900, 900);
		gc = canvas.getGraphicsContext2D();
		
		Canvas enermyCanvas = new Canvas(900, 900);
		enemyGC = enermyCanvas.getGraphicsContext2D();
		enemyGC.fillOval(previous, 450, 80, 80);
		
		Canvas enemy1Canvas = new Canvas(900, 900);
		enemy1GC = enemy1Canvas.getGraphicsContext2D();
		enemy1GC.drawImage(RenderableHolder.enemy3, enemy3X, 450, 100, 100);
		
		Canvas enemy2Canvas = new Canvas(900, 900);
		enemy2GC = enemy2Canvas.getGraphicsContext2D();
		enemy2GC.drawImage(RenderableHolder.enemy4, enemy4X, 650, 100, 100);
		
		Canvas bossCanvas = new Canvas(900, 900);
		bossGC = bossCanvas.getGraphicsContext2D();
		bossGC.drawImage(RenderableHolder.boss, bossX, 220, 150, 150);
		
		this.getChildren().add(bgCavnas);
		this.getChildren().add(enermyCanvas);
		this.getChildren().addAll(enemy1Canvas, enemy2Canvas, bossCanvas);
		this.getChildren().add(canvas);		
	}
	
	
	public static void drawChar(int charToPlay) {
		switch (charToPlay) {
		case 1 : gc.drawImage(RenderableHolder.char1, x, y, 100, 100); break;
		case 2 : gc.drawImage(RenderableHolder.charII1, x, y, 100, 100); break;
		case 3 : gc.drawImage(RenderableHolder.charIII1, x, y, 100, 100); break;
		}
	}
	
	public static void setGameAction(Image char1, Image char2, Image char3, Image char4) {
		SceneManagement.stage1Scene.setOnKeyPressed(e -> {
			if (GameScene.cnt == 1) return;
			if (e.getCode() == KeyCode.D) {
				if (x >= 810) {
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
					enemy3X -= SPEED;
					enemy4X -= SPEED;
					bossX -= SPEED;
					previous -= SPEED;
					bgGc.drawImage(RenderableHolder.background2, bgX, bgY, 2000, 900);
					enemyGC.clearRect(0, 0, 2000, 900);
					enemy2GC.clearRect(0, 0, 2000, 900);
					enemy1GC.clearRect(0, 0, 2000, 900);
					bossGC.clearRect(0, 0, 2000, 900);
					if (AllCharacter.getCharacters().get(5).isAlive()) 
						enemy1GC.drawImage(RenderableHolder.enemy3, enemy3X, 450, 100, 100);
					if (AllCharacter.getCharacters().get(6).isAlive()) 
						enemy2GC.drawImage(RenderableHolder.enemy4, enemy4X, 650, 100, 100);
					if (AllCharacter.getCharacters().get(7).isAlive()) 
						bossGC.drawImage(RenderableHolder.boss, bossX, 220, 150, 150);
					enemyGC.fillOval(previous, 450, 80, 80);
				}
				gc.clearRect(0, 0, 900, 900);
				gc.drawImage(char1, x, y, 100, 100);
				hitPrevLevel();
				hitEnermy();
				
			} else if (e.getCode() == KeyCode.S) {
				if (y >= 780) {
					y += 0;
					distanceY += 0;
				}
				else {
					y += SPEED;
					distanceY += SPEED;
				}
				gc.clearRect(0, 0, 900, 900);
				gc.drawImage(char3, x, y, 100, 100);
				hitPrevLevel();
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
					enemy3X += SPEED;
					enemy4X += SPEED;
					bossX += SPEED;
					bgX += SPEED;
					previous += SPEED;
					bgGc.drawImage(RenderableHolder.background2, bgX, bgY, 2000, 900);
					enemyGC.clearRect(0, 0, 2000, 900);
					enemy2GC.clearRect(0, 0, 2000, 900);
					enemy1GC.clearRect(0, 0, 2000, 900);
					bossGC.clearRect(0, 0, 2000, 900);
					if (AllCharacter.getCharacters().get(5).isAlive()) 
						enemy1GC.drawImage(RenderableHolder.enemy3, enemy3X, 450, 100, 100);
					if (AllCharacter.getCharacters().get(6).isAlive()) 
						enemy2GC.drawImage(RenderableHolder.enemy4, enemy4X, 650, 100, 100);
					if (AllCharacter.getCharacters().get(7).isAlive()) 
						bossGC.drawImage(RenderableHolder.boss, bossX, 220, 150, 150);
					enemyGC.fillOval(previous, 450, 80, 80);
				}
				gc.clearRect(0, 0, 900, 900);
				gc.drawImage(char2, x, y, 100, 100);
				hitPrevLevel();
				hitEnermy();
				
			} else if (e.getCode() == KeyCode.W) {
				if (y <= 330) {
					y -= 0;
					distanceY -= 0;
				}
				else {
					y -= SPEED;
					distanceY -= SPEED;
				}
				gc.clearRect(0, 0, 900, 900);
				gc.drawImage(char4, x, y, 100, 100);
				hitPrevLevel();
				hitEnermy();
				
			}  else if (e.getCode() == KeyCode.SPACE && isHit) {
				soundManagement.enterSound();
				soundManagement.stopGameSound();
				soundManagement.gameSound1();
				SceneManagement.switchScene(SceneManagement.gameScene);
			} else if (e.getCode() == KeyCode.SPACE && isEnemyFound) {
				soundManagement.enterFightSound();
				soundManagement.stopGameSound();
				BattleScene.drawEnermy();
				BattleScene.drawCommandBox(GameScene.enemyID);
				BattleScene.resetTurn();
				SceneManagement.battle.setBottom(SceneManagement.battle.getBox());
				AnimationTimer rr = new AnimationTimer() {
					
					@Override
					public void handle(long now) {
						enemyGC.drawImage(RenderableHolder.battle, 0, 0, 900, 900);
					}
				};rr.start();
		
				Timeline timeline = new Timeline(
					    new KeyFrame(Duration.ZERO, e1 -> {
					    	enemy2GC.clearRect(0, 0, 2000, 900);
							enemy1GC.clearRect(0, 0, 2000, 900);
							bossGC.clearRect(0, 0, 2000, 900);
					    	GameScene.cnt = 1;
					    }),
					    new KeyFrame(Duration.seconds(2.2), e1 -> { 
					    	enemyGC.clearRect(0, 0, 2000, 900);
					    	GameScene.cnt = 0;
					    	if (AllCharacter.getCharacters().get(5).isAlive()) 
					    		enemy1GC.drawImage(RenderableHolder.enemy3, enemy3X, 450, 100, 100);
							if (AllCharacter.getCharacters().get(6).isAlive()) 
								enemy2GC.drawImage(RenderableHolder.enemy4, enemy4X, 650, 100, 100);
							if (AllCharacter.getCharacters().get(7).isAlive()) 
								bossGC.drawImage(RenderableHolder.boss, bossX, 220, 150, 150);
					    	enemyGC.fillOval(previous, 450, 80, 80);
					    	SceneManagement.switchScene(SceneManagement.battleScene);
					    	if (GameScene.enemyID == 7) {
					    		soundManagement.bossSound();
					    	} else {
					    		soundManagement.battleSound();
					    	}
					    	rr.stop();
					    	})
					);
					timeline.play();
			}
			
		});
	}
	
	public static void hitEnermy() {
		animate = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if (850 < distanceX && distanceX < 950  &&  400 < distanceY && distanceY < 500) {
					if (AllCharacter.getCharacters().get(5).isAlive()) {
						gc.drawImage(RenderableHolder.exclamation, x + 22, y - 60, 62, 62);
						isEnemyFound = true;
						GameScene.enemyID = 5;
					} else {
						isEnemyFound = false;
					}
				} else if (200 < distanceX && distanceX < 280 && 600 < distanceY && distanceY < 680) {
					if (AllCharacter.getCharacters().get(6).isAlive()) {
						gc.drawImage(RenderableHolder.exclamation, x + 22, y - 60, 62, 62);
						isEnemyFound = true;
						GameScene.enemyID = 6;
					} else {
						isEnemyFound = false;
					}
				} else if (310 < distanceX && distanceX < 450 && 200 < distanceY && distanceY < 340) {
					if (AllCharacter.getCharacters().get(7).isAlive()) {
						gc.drawImage(RenderableHolder.exclamation, x + 22, y - 60, 62, 62);
						isEnemyFound = true;
						GameScene.enemyID = 7;
					} else {
						isEnemyFound = false;
					}
				} else {
					isEnemyFound = false;
					GameScene.enemyID = 0;
					animate.stop();
				}
			}
		};animate.start();
	}
	
	public static void hitPrevLevel() {
		if (-500 < distanceX && distanceX < -410  &&  350 < distanceY && distanceY < 450) {
			isHit = true;
		} else {
			isHit = false;
		}
	}
	
	public static int getSPEED() {
		return SPEED;
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