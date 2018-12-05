package scene;

import java.util.Random;
import Character_Logic.InsufficientManaException;
import Character_Logic.AllCharacter;
import SceneManage.SceneManagement;
import SharedObject.RenderableHolder;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sound.soundManagement;

public class BattleScene extends BorderPane {

	private static GraphicsContext bgGc, enemyGC;
	private static Button back, action, EndTurn, normalAttack, skill1, skill2;
	public static Label char1health, char2health, char3health, enemyHealth1, enemyHealth2;
	public static Label enemyHealth3, enemyHealth4, enemyHealth5;
	private static HBox box;
	private static AnimationTimer walk;
	private static VBox skill;
	public static int turn = 1, skillCount = 1, t1, escapeChance = 1;
	public static AllCharacter allChar = new AllCharacter();
	private static boolean checkHealing;
	private static int count_defeated;

	public BattleScene() {
		
		// >>>>>>>>>>> stage <<<<<<<<<<<<<<<

		Canvas bgCavnas = new Canvas(900, 700);
		bgGc = bgCavnas.getGraphicsContext2D();

		Canvas enemyCanvas = new Canvas(900, 700);
		enemyGC = enemyCanvas.getGraphicsContext2D();
		
		StackPane bg = new StackPane();
		bg.getChildren().add(bgCavnas);
		bg.getChildren().add(enemyCanvas);
		this.setCenter(bg);
		
		checkHealing = false;
		count_defeated = 0;

		// >>>>>>>>>>> stage <<<<<<<<<<<<<<<

		this.setBottom(box);

	}

	public static void update() {
		
		boolean check = false;
		action.setDisable(false);
		EndTurn.setDisable(true);
		normalAttack.setDisable(true);
		skill1.setDisable(true);
		skill2.setDisable(true);
		for (int i = 0; i < AllCharacter.getMyHero().size(); i++) {
			if (!AllCharacter.getMyHero().get(i).isAlive()) {
				AllCharacter.getMyHero().remove(i);
				check = true;
			}
		}
		if (AllCharacter.getMyHero().size() == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("GAME OVER, Please try again");
			alert.showAndWait();
			Platform.exit();
			return;
		}
		if (check)
			resetTurn();
		char1health.setText("HP: " + AllCharacter.getCharacters().get(0).getHealth() + " MP: "
				+ AllCharacter.getCharacters().get(0).getMana());
		char2health.setText("HP: " + AllCharacter.getCharacters().get(1).getHealth() + " MP: "
				+ AllCharacter.getCharacters().get(1).getMana());
		char3health.setText("HP: " + AllCharacter.getCharacters().get(2).getHealth() + " MP: "
				+ AllCharacter.getCharacters().get(2).getMana());
	}

	public static void drawCommandBox(int enemyID) {

		if (GameScene.enemyID <= 4) {
			bgGc.drawImage(RenderableHolder.background1, 0, 0, 900, 700);
		} else {
			bgGc.drawImage(RenderableHolder.background2, 0, 0, 900, 700);
		}

		if (AllCharacter.getCharacters().get(0).isAlive()) {
			bgGc.drawImage(RenderableHolder.char1, 250, 240, 70, 70);
		} else { 
			bgGc.drawImage(RenderableHolder.char1Dead, 250, 240, 60, 60);
		}
		if (AllCharacter.getCharacters().get(1).isAlive()) {
			bgGc.drawImage(RenderableHolder.charII1, 250, 370, 70, 70);
		} else { 
			bgGc.drawImage(RenderableHolder.char2Dead, 250, 370, 60, 60);
		}
		if (AllCharacter.getCharacters().get(2).isAlive()) {
			bgGc.drawImage(RenderableHolder.charIII1, 250, 500, 70, 70);
		} else { 
			bgGc.drawImage(RenderableHolder.char3Dead, 250, 500, 60, 60);
		}

		box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.setPrefHeight(200);
		box.setStyle("-fx-background-color : blue");

		// >>>>>>>>>>>>>>>>>>>>>>>>>> Enemy Information  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		switch (enemyID) {
		case 3:
			VBox enemyBox1 = new VBox();
			enemyBox1.setPrefWidth(280);
			enemyBox1.setAlignment(Pos.CENTER);
			enemyBox1.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");

			HBox enemyInfo1 = new HBox();
			enemyInfo1.setSpacing(20);
			enemyInfo1.setPadding(new Insets(0, 0, 0, 30));

			Label enemy1Label = new Label(AllCharacter.getCharacters().get(3).getName());
			enemy1Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");

			enemyHealth1 = new Label();
			enemyHealth1.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			enemyHealth1.setText("" + AllCharacter.getCharacters().get(3).getHealth() + "/"
					+ AllCharacter.getCharacters().get(3).getMAXHEALTH());

			enemyInfo1.getChildren().addAll(enemy1Label, enemyHealth1);

			enemyBox1.getChildren().add(enemyInfo1);
			box.getChildren().add(enemyBox1);
			break;
		case 4:
			VBox enemyBox2 = new VBox();
			enemyBox2.setAlignment(Pos.CENTER);
			enemyBox2.setPrefWidth(280);
			enemyBox2.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");

			HBox enemyInfo2 = new HBox();
			enemyInfo2.setSpacing(20);
			enemyInfo2.setPadding(new Insets(0, 0, 0, 30));

			Label enemy2Label = new Label(AllCharacter.getCharacters().get(4).getName());
			enemy2Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");

			enemyHealth2 = new Label();
			enemyHealth2.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			enemyHealth2.setText("" + AllCharacter.getCharacters().get(4).getHealth() + "/"
					+ AllCharacter.getCharacters().get(4).getMAXHEALTH());

			enemyInfo2.getChildren().addAll(enemy2Label, enemyHealth2);

			enemyBox2.getChildren().add(enemyInfo2);

			box.getChildren().add(enemyBox2);
			break;
		case 5:
			VBox enemyBox3 = new VBox();
			enemyBox3.setAlignment(Pos.CENTER);
			enemyBox3.setPrefWidth(280);
			enemyBox3.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");

			HBox enemyInfo3 = new HBox();
			enemyInfo3.setSpacing(20);
			enemyInfo3.setPadding(new Insets(0, 0, 0, 30));

			Label enemy3Label = new Label(AllCharacter.getCharacters().get(5).getName());
			enemy3Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");

			enemyHealth3 = new Label();
			enemyHealth3.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			enemyHealth3.setText("" + AllCharacter.getCharacters().get(5).getHealth() + "/"
					+ AllCharacter.getCharacters().get(5).getMAXHEALTH());

			enemyInfo3.getChildren().addAll(enemy3Label, enemyHealth3);

			enemyBox3.getChildren().add(enemyInfo3);

			box.getChildren().add(enemyBox3);
			break;
		case 6:
			VBox enemyBox4 = new VBox();
			enemyBox4.setAlignment(Pos.CENTER);
			enemyBox4.setPrefWidth(280);
			enemyBox4.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");

			HBox enemyInfo4 = new HBox();
			enemyInfo4.setSpacing(20);
			enemyInfo4.setPadding(new Insets(0, 0, 0, 30));

			Label enemy4Label = new Label(AllCharacter.getCharacters().get(6).getName());
			enemy4Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");

			enemyHealth4 = new Label();
			enemyHealth4.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			enemyHealth4.setText("" + AllCharacter.getCharacters().get(6).getHealth() + "/"
					+ AllCharacter.getCharacters().get(6).getMAXHEALTH());

			enemyInfo4.getChildren().addAll(enemy4Label, enemyHealth4);

			enemyBox4.getChildren().add(enemyInfo4);

			box.getChildren().add(enemyBox4);
			break;
		case 7:
			VBox enemyBox5 = new VBox();
			enemyBox5.setAlignment(Pos.CENTER);
			enemyBox5.setPrefWidth(280);
			enemyBox5.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");

			HBox enemyInfo5 = new HBox();
			enemyInfo5.setSpacing(20);
			enemyInfo5.setPadding(new Insets(0, 0, 0, 30));

			Label enemy5Label = new Label(AllCharacter.getCharacters().get(7).getName());
			enemy5Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");

			enemyHealth5 = new Label();
			enemyHealth5.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			if(count_defeated == 4) {
				AllCharacter.getCharacters().get(7).setHealth(150);
				AllCharacter.getCharacters().get(7).setMAXHEALTH(150);
			}	
			enemyHealth5.setText("" + AllCharacter.getCharacters().get(7).getHealth() + "/"
					+ AllCharacter.getCharacters().get(7).getMAXHEALTH());
			
			enemyInfo5.getChildren().addAll(enemy5Label, enemyHealth5);

			enemyBox5.getChildren().add(enemyInfo5);

			box.getChildren().add(enemyBox5);
			break;
		default:
			break;
		}

		// >>>>>>>>>>>>>>>>>>>>> Character Information <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		VBox charInfo = new VBox();
		charInfo.setAlignment(Pos.CENTER);
		charInfo.setPrefWidth(350);
		charInfo.setSpacing(10);
		charInfo.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");

		HBox char1Info = new HBox();
		char1Info.setSpacing(30);
		char1Info.setPadding(new Insets(0, 0, 0, 30));
		Label char1Label = new Label("RED");
		char1Label.setStyle("-fx-font-size : 20;-fx-font-weight: bold");
		char1health = new Label();
		char1health.setText("HP: " + AllCharacter.getCharacters().get(0).getHealth() + " MP: "
				+ AllCharacter.getCharacters().get(0).getMana());
		char1health.setStyle("-fx-font-size : 20;-fx-font-weight: bold");
		char1Info.getChildren().addAll(char1Label, char1health);

		HBox char2Info = new HBox();
		char2Info.setSpacing(30);
		char2Info.setPadding(new Insets(0, 0, 0, 30));
		Label char2Label = new Label("PEARL");
		char2Label.setStyle("-fx-font-size : 20;-fx-font-weight: bold");
		char2health = new Label();
		char2health.setText("HP: " + AllCharacter.getCharacters().get(1).getHealth() + " MP: "
				+ AllCharacter.getCharacters().get(1).getMana());
		char2health.setStyle("-fx-font-size : 20;-fx-font-weight: bold");
		char2Info.getChildren().addAll(char2Label, char2health);

		HBox char3Info = new HBox();
		char3Info.setSpacing(30);
		char3Info.setPadding(new Insets(0, 0, 0, 30));
		Label char3Label = new Label("TOMMY");
		char3Label.setStyle("-fx-font-size : 20;-fx-font-weight: bold");
		char3health = new Label();
		char3health.setText("HP: " + AllCharacter.getCharacters().get(2).getHealth() + " MP: "
				+ AllCharacter.getCharacters().get(2).getMana());
		char3health.setStyle("-fx-font-size : 20;-fx-font-weight: bold");
		char3Info.getChildren().addAll(char3Label, char3health);

		charInfo.getChildren().addAll(char1Info, char2Info, char3Info);

		// >>>>>>>>>>>>>>>>>> command <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		VBox command = new VBox();
		command.setSpacing(15);
		command.setPrefWidth(150);
		command.setAlignment(Pos.CENTER);
		command.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");

		action = new Button("Action");
		action.setPrefWidth(80);
		back = new Button("Escape");
		back.setPrefWidth(80);
		EndTurn = new Button("EndTurn");
		EndTurn.setPrefWidth(80);
		EndTurn.setDisable(true);

		command.getChildren().addAll(action, EndTurn, back);

		box.getChildren().add(charInfo);
		box.getChildren().add(command);

		// >>>>>>>>>>>>>>>> skill <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		skill = new VBox();
		skill.setSpacing(15);
		skill.setPrefWidth(170);
		skill.setAlignment(Pos.CENTER);
		skill.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");

		normalAttack = new Button("N-atk");
		normalAttack.setPrefWidth(80);
		skill1 = new Button();
		skill1.setPrefWidth(80);
		skill2 = new Button();
		skill2.setPrefWidth(80);

		// >>>>>>>>>>>>>>>> handle button <<<<<<<<<<<<<<<<<<<<<<<<<<

		box.getChildren().add(skill);

		action.setOnMouseClicked(e -> {
			walkingChar();
			if (turn < 5) {
				back.setDisable(true);
			} else {
				back.setDisable(false);
			}
			t1 = turn % 4;
			switch (t1) {
			case 1:
				if (skillCount == 1);
				else skill.getChildren().remove(0, 3);
				redSkill();
				skillCount++;
				break;
			case 2:
				skill.getChildren().remove(0, 3);
				pearlSkill();
				break;
			case 3:
				skill.getChildren().remove(0, 3);
				tommySkill();
				break;
			}
			action.setDisable(true);
			EndTurn.setDisable(false);
		});

		back.setOnMouseClicked(e -> {
			enemyGC.clearRect(0, 0, 2000, 900);
			skillCount = 1; escapeChance = 1;
			resetTurn();
			if (enemyID <= 4) {
				soundManagement.stopGameSound();
				SceneManagement.switchScene(SceneManagement.gameScene);
				soundManagement.gameSound1();
			} else {
				soundManagement.stopGameSound();
				SceneManagement.switchScene(SceneManagement.stage1Scene);
				soundManagement.gameSound2();
			}
		});

		EndTurn.setOnMouseClicked(e -> {
			walk.stop();
			if (turn % 2 == 0) {
				if(checkHealing == true) {
					RenderableHolder.healing.play();
					checkHealing = false;
				}
			}
			if (turn % 4 == 0) {
				action.setDisable(true);
				int target = new Random().nextInt(AllCharacter.getMyHero().size());
				AllCharacter.getCharacters().get(GameScene.enemyID).attack(AllCharacter.getMyHero().get(target));
				updateEnemyInfo();
				RenderableHolder.tackle.play();
			}
			enemyGC.clearRect(650, 300, 150, 150);
			drawEnermy();
			turn++; escapeChance++;
			update();
		});

	}

	public static void enemyDied() {
		switch (GameScene.enemyID) {
		case 3:
			if (AllCharacter.getCharacters().get(3).getHealth() <= 0) {
				AllCharacter.getCharacters().get(3).setIsAlive(false);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("You win fight against Ogre!!");
				alert.show();
				count_defeated++;
				AllCharacter.getCharacters().get(0).setMana(AllCharacter.getCharacters().get(0).getMAXMANA());
				AllCharacter.getCharacters().get(0).setDamage(AllCharacter.getCharacters().get(0).getDefault_damage());
				AllCharacter.getCharacters().get(0).setDefend(AllCharacter.getCharacters().get(0).getDefault_defense());
				AllCharacter.getCharacters().get(1).setMana(AllCharacter.getCharacters().get(1).getMAXMANA());
				AllCharacter.getCharacters().get(1).setDamage(AllCharacter.getCharacters().get(1).getDefault_damage());
				AllCharacter.getCharacters().get(1).setDefend(AllCharacter.getCharacters().get(1).getDefault_defense());
				AllCharacter.getCharacters().get(2).setMana(AllCharacter.getCharacters().get(2).getMAXMANA());
				AllCharacter.getCharacters().get(2).setDamage(AllCharacter.getCharacters().get(2).getDefault_damage());
				AllCharacter.getCharacters().get(2).setDefend(AllCharacter.getCharacters().get(2).getDefault_defense());
				enemyGC.clearRect(0, 0, 2000, 900);
				GameScene.enemy1GC.clearRect(0, 0, 2000, 900);
				SceneManagement.switchScene(SceneManagement.gameScene);
				soundManagement.stopGameSound();
				soundManagement.gameSound1();
				resetTurn();
				skillCount = 1; escapeChance = 1;
			}
			break;
		case 4:
			if (AllCharacter.getCharacters().get(4).getHealth() <= 0) {
				AllCharacter.getCharacters().get(4).setIsAlive(false);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("You win fight against Pyromancer!!");
				alert.show();
				count_defeated++;
				AllCharacter.getCharacters().get(0).setMana(AllCharacter.getCharacters().get(0).getMAXMANA());
				AllCharacter.getCharacters().get(0).setDamage(AllCharacter.getCharacters().get(0).getDefault_damage());
				AllCharacter.getCharacters().get(0).setDefend(AllCharacter.getCharacters().get(0).getDefault_defense());
				AllCharacter.getCharacters().get(1).setMana(AllCharacter.getCharacters().get(1).getMAXMANA());
				AllCharacter.getCharacters().get(1).setDamage(AllCharacter.getCharacters().get(1).getDefault_damage());
				AllCharacter.getCharacters().get(1).setDefend(AllCharacter.getCharacters().get(1).getDefault_defense());
				AllCharacter.getCharacters().get(2).setMana(AllCharacter.getCharacters().get(2).getMAXMANA());
				AllCharacter.getCharacters().get(2).setDamage(AllCharacter.getCharacters().get(2).getDefault_damage());
				AllCharacter.getCharacters().get(2).setDefend(AllCharacter.getCharacters().get(2).getDefault_defense());
				enemyGC.clearRect(0, 0, 2000, 900);
				GameScene.enemy2GC.clearRect(0, 0, 2000, 900);
				SceneManagement.switchScene(SceneManagement.gameScene);
				soundManagement.stopGameSound();
				soundManagement.gameSound1();
				resetTurn();
				skillCount = 1; escapeChance = 1;
			}
			break;
		case 5:
			if (AllCharacter.getCharacters().get(5).getHealth() <= 0) {
				AllCharacter.getCharacters().get(5).setIsAlive(false);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("You win fight with skeleton!!");
				alert.show();
				count_defeated++;
				AllCharacter.getCharacters().get(0).setMana(AllCharacter.getCharacters().get(0).getMAXMANA());
				AllCharacter.getCharacters().get(0).setDamage(AllCharacter.getCharacters().get(0).getDefault_damage());
				AllCharacter.getCharacters().get(0).setDefend(AllCharacter.getCharacters().get(0).getDefault_defense());
				AllCharacter.getCharacters().get(1).setMana(AllCharacter.getCharacters().get(1).getMAXMANA());
				AllCharacter.getCharacters().get(1).setDamage(AllCharacter.getCharacters().get(1).getDefault_damage());
				AllCharacter.getCharacters().get(1).setDefend(AllCharacter.getCharacters().get(1).getDefault_defense());
				AllCharacter.getCharacters().get(2).setMana(AllCharacter.getCharacters().get(2).getMAXMANA());
				AllCharacter.getCharacters().get(2).setDamage(AllCharacter.getCharacters().get(2).getDefault_damage());
				AllCharacter.getCharacters().get(2).setDefend(AllCharacter.getCharacters().get(2).getDefault_defense());
				enemyGC.clearRect(0, 0, 2000, 900);
				stage_1.enemy1GC.clearRect(0, 0, 2000, 900);
				SceneManagement.switchScene(SceneManagement.stage1Scene);
				soundManagement.stopGameSound();
				soundManagement.gameSound2();
				resetTurn();
				skillCount = 1; escapeChance = 1;
			}
			break;
		case 6:
			if (AllCharacter.getCharacters().get(6).getHealth() <= 0) {
				AllCharacter.getCharacters().get(6).setIsAlive(false);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("You win fight with Warlock!!");
				alert.show();
				count_defeated++;
				AllCharacter.getCharacters().get(0).setMana(AllCharacter.getCharacters().get(0).getMAXMANA());
				AllCharacter.getCharacters().get(0).setDamage(AllCharacter.getCharacters().get(0).getDefault_damage());
				AllCharacter.getCharacters().get(0).setDefend(AllCharacter.getCharacters().get(0).getDefault_defense());
				AllCharacter.getCharacters().get(1).setMana(AllCharacter.getCharacters().get(1).getMAXMANA());
				AllCharacter.getCharacters().get(1).setDamage(AllCharacter.getCharacters().get(1).getDefault_damage());
				AllCharacter.getCharacters().get(1).setDefend(AllCharacter.getCharacters().get(1).getDefault_defense());
				AllCharacter.getCharacters().get(2).setMana(AllCharacter.getCharacters().get(2).getMAXMANA());
				AllCharacter.getCharacters().get(2).setDamage(AllCharacter.getCharacters().get(2).getDefault_damage());
				AllCharacter.getCharacters().get(2).setDefend(AllCharacter.getCharacters().get(2).getDefault_defense());
				enemyGC.clearRect(0, 0, 2000, 900);
				stage_1.enemy2GC.clearRect(0, 0, 2000, 900);
				SceneManagement.switchScene(SceneManagement.stage1Scene);
				soundManagement.stopGameSound();
				soundManagement.gameSound2();
				resetTurn();
				skillCount = 1; escapeChance = 1;
			}
			break;
		case 7:
			if (AllCharacter.getCharacters().get(7).getHealth() <= 0) {
				AllCharacter.getCharacters().get(7).setIsAlive(false);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("Congraturation!!You defeat last boss.");
				alert.show();
				AllCharacter.getCharacters().get(0).setMana(AllCharacter.getCharacters().get(0).getMAXMANA());
				AllCharacter.getCharacters().get(0).setDamage(AllCharacter.getCharacters().get(0).getDefault_damage());
				AllCharacter.getCharacters().get(0).setDefend(AllCharacter.getCharacters().get(0).getDefault_defense());
				AllCharacter.getCharacters().get(1).setMana(AllCharacter.getCharacters().get(1).getMAXMANA());
				AllCharacter.getCharacters().get(1).setDamage(AllCharacter.getCharacters().get(1).getDefault_damage());
				AllCharacter.getCharacters().get(1).setDefend(AllCharacter.getCharacters().get(1).getDefault_defense());
				AllCharacter.getCharacters().get(2).setMana(AllCharacter.getCharacters().get(2).getMAXMANA());
				AllCharacter.getCharacters().get(2).setDamage(AllCharacter.getCharacters().get(2).getDefault_damage());
				AllCharacter.getCharacters().get(2).setDefend(AllCharacter.getCharacters().get(2).getDefault_defense());
				enemyGC.clearRect(0, 0, 2000, 900);
				stage_1.bossGC.clearRect(0, 0, 2000, 900);
				SceneManagement.switchScene(SceneManagement.stage1Scene);
				soundManagement.stopGameSound();
				soundManagement.gameSound2();
				resetTurn();
				skillCount = 1; escapeChance = 1;
			}
			break;
		default:
			break;
		}
	}

	public static void walkingChar() {

		int char_turn = turn % 4;
		char_turn--;
		if (char_turn >= 0) {
			switch (char_turn) {
			case 0:
				walk = new AnimationTimer() {
					int i = 250;

					@Override
					public void handle(long now) {
						// TODO Auto-generated method stub
						i++;
						if (i == 400)
							walk.stop();
						bgGc.clearRect(0, 0, 2000, 900);
						if (GameScene.enemyID <= 4) {
							bgGc.drawImage(RenderableHolder.background1, 0, 0, 900, 700);
						} else {
							
							bgGc.drawImage(RenderableHolder.background2, 0, 0, 900, 700);
						}
						if (AllCharacter.getCharacters().get(0).isAlive()) {
							bgGc.drawImage(RenderableHolder.char1, i, 240, 70, 70);
						} else {
							bgGc.drawImage(RenderableHolder.char1Dead, 250, 240, 60, 60);
						}
						if (AllCharacter.getCharacters().get(1).isAlive()) {
							bgGc.drawImage(RenderableHolder.charII1, 250, 370, 70, 70);
						} else {
							bgGc.drawImage(RenderableHolder.char2Dead, 250, 370, 60, 60);
						}
						if (AllCharacter.getCharacters().get(2).isAlive()) {
							bgGc.drawImage(RenderableHolder.charIII1, 250, 500, 70, 70);
						} else {
							bgGc.drawImage(RenderableHolder.char3Dead, 250, 500, 60, 60);
						}
					}
				};
				walk.start();
				break;
			case 1:
				walk = new AnimationTimer() {
					int i = 250;

					@Override
					public void handle(long now) {
						// TODO Auto-generated method stub
						i++;
						if (i == 400)
							walk.stop();
						bgGc.clearRect(0, 0, 2000, 900);
						if (GameScene.enemyID <= 4) {
							bgGc.drawImage(RenderableHolder.background1, 0, 0, 900, 700);
						} else {
							bgGc.drawImage(RenderableHolder.background2, 0, 0, 900, 700);
						}
						if (AllCharacter.getCharacters().get(0).isAlive()) {
							bgGc.drawImage(RenderableHolder.char1, 250, 240, 70, 70);
						} else {
							bgGc.drawImage(RenderableHolder.char1Dead, 250, 240, 60, 60);
						}
						if (AllCharacter.getCharacters().get(1).isAlive()) {
							bgGc.drawImage(RenderableHolder.charII1, i, 370, 70, 70);
						} else {
							bgGc.drawImage(RenderableHolder.char2Dead, 250, 370, 60, 60);
						}
						if (AllCharacter.getCharacters().get(2).isAlive()) {
							bgGc.drawImage(RenderableHolder.charIII1, 250, 500, 70, 70);
						} else {
							bgGc.drawImage(RenderableHolder.char3Dead, 250, 500, 60, 60);
						}
					}
				};
				walk.start();
				break;
			case 2:
				walk = new AnimationTimer() {
					int i = 250;

					@Override
					public void handle(long now) {
						// TODO Auto-generated method stub
						i++;
						if (i == 400)
							walk.stop();
						bgGc.clearRect(0, 0, 2000, 900);
						if (GameScene.enemyID <= 4) {
							bgGc.drawImage(RenderableHolder.background1, 0, 0, 900, 700);
						} else {
							bgGc.drawImage(RenderableHolder.background2, 0, 0, 900, 700);
						}
						if (AllCharacter.getCharacters().get(0).isAlive()) {
							bgGc.drawImage(RenderableHolder.char1, 250, 240, 70, 70);
						} else {
							bgGc.drawImage(RenderableHolder.char1Dead, 250, 240, 60, 60);
						}
						if (AllCharacter.getCharacters().get(1).isAlive()) {
							bgGc.drawImage(RenderableHolder.charII1, 250, 370, 70, 70);
						} else {
							bgGc.drawImage(RenderableHolder.char2Dead, 250, 370, 60, 60);
						}
						if (AllCharacter.getCharacters().get(2).isAlive()) {
							bgGc.drawImage(RenderableHolder.charIII1, i, 500, 70, 70);
						} else {
							bgGc.drawImage(RenderableHolder.char3Dead, 250, 500, 60, 60);
						}
					}
				};
				walk.start();
				break;
			}
		} else {
			bgGc.clearRect(0, 0, 2000, 900);
			if (GameScene.enemyID <= 4) {
				bgGc.drawImage(RenderableHolder.background1, 0, 0, 900, 700);
			} else {
				bgGc.drawImage(RenderableHolder.background2, 0, 0, 900, 700);
			}
			if (AllCharacter.getCharacters().get(0).isAlive()) 
				bgGc.drawImage(RenderableHolder.char1, 250, 240, 70, 70);
			else
				bgGc.drawImage(RenderableHolder.char1Dead, 250, 240, 60, 60);
			if (AllCharacter.getCharacters().get(1).isAlive()) 
				bgGc.drawImage(RenderableHolder.charII1, 250, 370, 70, 70);
			else
				bgGc.drawImage(RenderableHolder.char2Dead, 250, 370, 60, 60);
			if (AllCharacter.getCharacters().get(2).isAlive())
				bgGc.drawImage(RenderableHolder.charIII1, 250, 500, 70, 70);
			else
				bgGc.drawImage(RenderableHolder.char3Dead, 250, 500, 60, 60);
		}
	}

	public static void drawEnermy() {
		switch (GameScene.enemyID) {
		case 3:
			enemyGC.drawImage(RenderableHolder.enemy1, 650, 370, 70, 70);
			break;
		case 4:
			enemyGC.drawImage(RenderableHolder.enemy2, 650, 370, 70, 70);
			break;
		case 5:
			enemyGC.drawImage(RenderableHolder.enemy3, 650, 370, 70, 70);
			break;
		case 6:
			enemyGC.drawImage(RenderableHolder.enemy4, 650, 370, 70, 70);
			break;
		case 7:
			enemyGC.drawImage(RenderableHolder.boss, 650, 300, 150, 150);
			break;
		default:
			System.out.println("..");
			break;
		}
	}

	public static void updateEnemyInfo() {
		switch (GameScene.enemyID) {
		case 3:
			enemyGC.drawImage(RenderableHolder.attacked, 650, 370, 70, 70);
			enemyHealth1.setText("" + AllCharacter.getCharacters().get(GameScene.enemyID).getHealth() + "/"
					+ AllCharacter.getCharacters().get(GameScene.enemyID).getMAXHEALTH());
			break;
		case 4:
			enemyGC.drawImage(RenderableHolder.attacked, 650, 370, 70, 70);
			enemyHealth2.setText("" + AllCharacter.getCharacters().get(GameScene.enemyID).getHealth() + "/"
					+ AllCharacter.getCharacters().get(GameScene.enemyID).getMAXHEALTH());
			break;
		case 5:
			enemyGC.drawImage(RenderableHolder.attacked, 650, 370, 70, 70);
			enemyHealth3.setText("" + AllCharacter.getCharacters().get(GameScene.enemyID).getHealth() + "/"
					+ AllCharacter.getCharacters().get(GameScene.enemyID).getMAXHEALTH());
			break;
		case 6:
			enemyGC.drawImage(RenderableHolder.attacked, 650, 370, 70, 70);
			enemyHealth4.setText("" + AllCharacter.getCharacters().get(GameScene.enemyID).getHealth() + "/"
					+ AllCharacter.getCharacters().get(GameScene.enemyID).getMAXHEALTH());
			break;
		case 7:
			enemyGC.drawImage(RenderableHolder.attacked, 650, 370, 70, 70);
			enemyHealth5.setText("" + AllCharacter.getCharacters().get(GameScene.enemyID).getHealth() + "/"
					+ AllCharacter.getCharacters().get(GameScene.enemyID).getMAXHEALTH());
			break;
		}
	}

	public static void redSkill() {
		skill1.setText("Slash");
		skill2.setText("Warcry");
		normalAttack.setDisable(false);
		skill1.setDisable(false);
		skill2.setDisable(false);
		normalAttack.setOnMouseClicked(e -> {
			AllCharacter.getCharacters().get(0).attack(AllCharacter.getCharacters().get(GameScene.enemyID));
			RenderableHolder.attacking.play();
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});

		skill1.setOnMouseClicked(e -> {
			try {
				AllCharacter.getCharacters().get(0).useSkill(0, AllCharacter.getCharacters().get(GameScene.enemyID));
				RenderableHolder.attacking.play();
			} catch (InsufficientManaException e1) {
				// TODO Auto-generated catch block
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("You need more " + e1.getAmount() + " mana.");
				alert.showAndWait();
			}
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});

		skill2.setOnMouseClicked(e -> {
			try {
				AllCharacter.getCharacters().get(0).useSkill(1, AllCharacter.getCharacters().get(0));
				RenderableHolder.buffing.play();
			} catch (InsufficientManaException e1) {
				// TODO Auto-generated catch block
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("You need more " + e1.getAmount() + " mana.");
				alert.showAndWait();
			}
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});

		skill.getChildren().addAll(normalAttack, skill1, skill2);
		if (!AllCharacter.getCharacters().get(0).isAlive()) {
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		}
	}

	public static void pearlSkill() {
		skill1.setText("Heal");
		skill2.setText("Fear");
		normalAttack.setDisable(false);
		skill1.setDisable(false);
		skill2.setDisable(false);
		normalAttack.setOnMouseClicked(e -> {
			AllCharacter.getCharacters().get(1).attack(AllCharacter.getCharacters().get(GameScene.enemyID));
			RenderableHolder.attacking.play();
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});

		skill1.setOnMouseClicked(e -> {
			try {
				AllCharacter.getCharacters().get(1).useSkill(1, AllCharacter.getCharacters().get(0));
				AllCharacter.getCharacters().get(0).getHeal(40);
				AllCharacter.getCharacters().get(1).getHeal(40);
				AllCharacter.getCharacters().get(2).getHeal(40);
				checkHealing = true;
			} catch (InsufficientManaException e1) {
				// TODO Auto-generated catch block
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("You need more " + e1.getAmount() + " mana.");
				alert.showAndWait();
			}
			updateEnemyInfo();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});

		skill2.setOnMouseClicked(e -> {
			try {
				AllCharacter.getCharacters().get(1).useSkill(1, AllCharacter.getCharacters().get(GameScene.enemyID));
				RenderableHolder.debuffing.play();
			} catch (InsufficientManaException e1) {
				// TODO Auto-generated catch block
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("You need more " + e1.getAmount() + " mana.");
				alert.showAndWait();
			}
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});

		skill.getChildren().addAll(normalAttack, skill1, skill2);
		if (!AllCharacter.getCharacters().get(1).isAlive()) {
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		}
	}

	public static void tommySkill() {
		skill1.setText("Tackle");
		skill2.setText("Resist");
		normalAttack.setDisable(false);
		skill1.setDisable(false);
		skill2.setDisable(false);
		normalAttack.setOnMouseClicked(e -> {
			AllCharacter.getCharacters().get(2).attack(AllCharacter.getCharacters().get(GameScene.enemyID));
			RenderableHolder.attacking.play();
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});

		skill1.setOnMouseClicked(e -> {
			try {
				AllCharacter.getCharacters().get(2).useSkill(0, AllCharacter.getCharacters().get(GameScene.enemyID));
				RenderableHolder.tackle.play();
			} catch (InsufficientManaException e1) {
				// TODO Auto-generated catch block
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("You need more " + e1.getAmount() + " mana.");
				alert.showAndWait();
			}
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});

		skill2.setOnMouseClicked(e -> {
			try {
				AllCharacter.getCharacters().get(2).useSkill(1, AllCharacter.getCharacters().get(2));
				RenderableHolder.buffing.play();
			} catch (InsufficientManaException e1) {
				// TODO Auto-generated catch block
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("You need more " + e1.getAmount() + " mana.");
				alert.showAndWait();
			}
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});

		skill.getChildren().addAll(normalAttack, skill1, skill2);
		if (!AllCharacter.getCharacters().get(2).isAlive()) {
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		}
	}

	public static HBox getBox() {
		return box;
	}

	public static void resetTurn() {
		turn = 1;
	}

}