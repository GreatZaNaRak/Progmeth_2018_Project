package scene;

import Character_Animate.Red;
import Character_Animate.Pearl;
import Character_Animate.Tommy;
import Character_Animate.Ready;
import Character_Logic.AllCharacter;
import SceneManage.SceneManagement;
import SharedObject.RenderableHolder;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sound.soundManagement;

public class PlayScene extends BorderPane{
	
	private Label sceneLabel;
	private Red red;
	private Pearl pearl;
	private Tommy tommy;
	private Ready ready;
	private VBox CharacterSelected;
	private HBox firstChar, secondChar, thirdChar;
	private GraphicsContext firstGC, secondGC, thirdGC;
	private Button playSceneToMenu, start;
	private Text label1, label2, label3;
	private BorderPane information;
	public static int CharToPlay = 0;
	
	
	public PlayScene() {
		
		// >>>>>>>>>>>>>>> Play Scene <<<<<<<<<<<<<<<<<<<<<
		
		this.setPlaySceneAction();
		information = new BorderPane();
		
		// >>>>>>>>>>> Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> Top Center pane <<<<<<<<<<<<<<<<<<
		
		sceneLabel = new Label("Character Select");
		
		sceneLabel.setFont(Font.font("Comic Sans MS", 45));
		sceneLabel.setTextFill(Color.WHITE);
		sceneLabel.setAlignment(Pos.CENTER);
		sceneLabel.setPrefHeight(120);
		sceneLabel.setPrefWidth(600);
		sceneLabel.setStyle("-fx-background-color : black");
		
		information.setTop(sceneLabel);
		
		// >>>>>>>>>>> Top Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> Center Center pane <<<<<<<<<<<<<<<<<<
		
	
		red = new Red();
		pearl = new Pearl();
		tommy = new Tommy();
		ready = new Ready();
		
		// >>>>>>>>>>> Center Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> Bottom Center pane <<<<<<<<<<<<<<<<<<
		
		HBox btn = new HBox();
		btn.setAlignment(Pos.CENTER);
		btn.setSpacing(20);
		btn.setPrefHeight(120);
		btn.setStyle("-fx-background-color : black");
		
		playSceneToMenu = new Button("Back");
		this.setBackAction();
		start = new Button("Start");
		this.setStartAction();
		btn.getChildren().add(start);
		btn.getChildren().add(playSceneToMenu);
		start.setVisible(false);
		
		// >>>>>>>>>>> Bottom Center pane <<<<<<<<<<<<<<<<<<
		
		information.setBottom(btn);
		
		// >>>>>>>>>>> Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> left pane <<<<<<<<<<<<<<<<<<
		
		CharacterSelected = new VBox();
		CharacterSelected.setAlignment(Pos.CENTER);
		CharacterSelected.setSpacing(20);
		CharacterSelected.setPrefWidth(350);
		CharacterSelected.setStyle("-fx-background-color : DarkBlue");
		
		firstChar = new HBox();
		firstChar.setAlignment(Pos.CENTER);
		firstChar.setSpacing(15);
		
		Canvas firstCanvas = new Canvas(200, 200);
		firstGC = firstCanvas.getGraphicsContext2D();
		label1 = new Text("Red       ");
		label1.setFont(Font.font(30));
		
		firstChar.getChildren().addAll(firstCanvas, label1);
		firstGC.drawImage(RenderableHolder.char1Image, 0, 0, 180, 180);
		this.setFirstCharAction();
		
		secondChar = new HBox();
		secondChar.setAlignment(Pos.CENTER);
		secondChar.setSpacing(15);
		
		Canvas secondCanvas = new Canvas(200, 200);
		secondGC = secondCanvas.getGraphicsContext2D();
		label2 = new Text("Pearl     ");
		label2.setFont(Font.font(30));
		
		secondChar.getChildren().addAll(secondCanvas, label2);
		secondGC.drawImage(RenderableHolder.char2Image, 0, 0, 180, 180);
		this.setSecondCharAction();
		
		thirdChar = new HBox();
		thirdChar.setAlignment(Pos.CENTER);
		thirdChar.setSpacing(15);
		
		Canvas thirdCanvas = new Canvas(200, 200);
		thirdGC = thirdCanvas.getGraphicsContext2D();
		label3 = new Text("Tommy");
		label3.setFont(Font.font(30));
		
		thirdChar.getChildren().addAll(thirdCanvas, label3);
		thirdGC.drawImage(RenderableHolder.char3Image, 0, 0, 180, 180);
		this.setThirdCharAction();
		
		
		CharacterSelected.getChildren().add(firstChar);
		CharacterSelected.getChildren().add(secondChar);
		CharacterSelected.getChildren().add(thirdChar);
		
		// >>>>>>>>>>> left pane <<<<<<<<<<<<<<<<<<
		
		this.setLeft(CharacterSelected);
		this.setCenter(information);
		
		
		// >>>>>>>>>>>>>>> Play Scene <<<<<<<<<<<<<<<<<<<<<
				
	}
	
	private void setBackAction() {
		this.playSceneToMenu.setOnAction(e -> {
			SceneManagement.switchScene(SceneManagement.menuScene);
			soundManagement.music();
			firstChar.setVisible(true);
			secondChar.setVisible(true);
			thirdChar.setVisible(true);
			start.setVisible(false);
			CharacterSelected.setMouseTransparent(false);
			ready.clear();
		});
	}
	
	
	private void setPlaySceneAction() {
		this.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ESCAPE) {
				CharacterSelected.setMouseTransparent(false);
				firstChar.setVisible(true);
				secondChar.setVisible(true);
				thirdChar.setVisible(true);
				start.setVisible(false);
				ready.clear();
				
			}
		});
	}
	
	private void setStartAction() {
		start.setOnMouseClicked(e -> {
			switch (PlayScene.CharToPlay) {
			case 1 : 
				AllCharacter.getMyHero().get(0).setDamage(AllCharacter.getMyHero().get(0).getDamage() + 5);
				AllCharacter.getMyHero().get(1).setDamage(AllCharacter.getMyHero().get(1).getDamage() + 5);
				AllCharacter.getMyHero().get(2).setDamage(AllCharacter.getMyHero().get(2).getDamage() + 5);
				break;
			case 2 : 
				AllCharacter.getMyHero().get(0).setHealth(AllCharacter.getMyHero().get(0).getHealth() + 50);
				AllCharacter.getMyHero().get(1).setHealth(AllCharacter.getMyHero().get(1).getHealth() + 50);
				AllCharacter.getMyHero().get(2).setHealth(AllCharacter.getMyHero().get(2).getHealth() + 50);
				break;
			case 3 : 
				AllCharacter.getMyHero().get(0).setDefend(AllCharacter.getMyHero().get(0).getDefend() + 5);
				AllCharacter.getMyHero().get(0).setDefend(AllCharacter.getMyHero().get(0).getDefend() + 5);
				AllCharacter.getMyHero().get(0).setDefend(AllCharacter.getMyHero().get(0).getDefend() + 5);
				break;
			default : 
				System.out.println(".."); 
				break;
			}
			
			GameScene.drawChar(CharToPlay);
			switch (CharToPlay) {
			case 1: GameScene.setGameAction(RenderableHolder.char1, 
					RenderableHolder.char2, 
					RenderableHolder.char3, 
					RenderableHolder.char4); break;
					
			case 2: GameScene.setGameAction(RenderableHolder.charII1, 
					RenderableHolder.charII2, 
					RenderableHolder.charII3, 
					RenderableHolder.charII4); break;
			
			case 3: GameScene.setGameAction(RenderableHolder.charIII1, 
					RenderableHolder.charIII2, 
					RenderableHolder.charIII3, 
					RenderableHolder.charIII4); break;
			}
			SceneManagement.switchScene(SceneManagement.gameScene);
			soundManagement.gameSound1();
		});
	}
	
	private void setFirstCharAction() {
		firstChar.setOnMouseEntered(e -> {
			soundManagement.charSelect();
			label1.setFill(Color.RED);
			label1.setStyle("-fx-font-weight : bolder");
			information.setCenter(red);
			red.set();
		});
		
		firstChar.setOnMouseExited(e -> {
			label1.setFill(Color.BLACK);
			label1.setStyle("-fx-font-weight : normal");
			red.clear();
		});
		
		firstChar.setOnMouseClicked(e -> {
			CharToPlay = 1;
			soundManagement.confirmed();
			CharacterSelected.setMouseTransparent(true);
			secondChar.setVisible(false);
			thirdChar.setVisible(false);
			start.setVisible(true);
			information.setCenter(ready);
			ready.set();
		});
	}
	
	private void setSecondCharAction() {
		secondChar.setOnMouseEntered(e -> {
			soundManagement.charSelect();
			label2.setFill(Color.RED);
			label2.setStyle("-fx-font-weight : bolder");
			information.setCenter(pearl);
			pearl.set();
		});
		
		secondChar.setOnMouseExited(e -> {
			label2.setFill(Color.BLACK);
			label2.setStyle("-fx-font-weight : normal");
			pearl.clear();
		});
		
		secondChar.setOnMouseClicked(e -> {
			CharToPlay = 2;
			soundManagement.confirmed();
			CharacterSelected.setMouseTransparent(true);
			firstChar.setVisible(false);
			thirdChar.setVisible(false);
			start.setVisible(true);
			information.setCenter(ready);
			ready.set();
		});
	}

	private void setThirdCharAction() {
		thirdChar.setOnMouseEntered(e -> {
			soundManagement.charSelect();
			label3.setFill(Color.RED);
			label3.setStyle("-fx-font-weight : bolder");
			information.setCenter(tommy);
			tommy.set();
		});
		
		thirdChar.setOnMouseExited(e -> {
			label3.setFill(Color.BLACK);
			label3.setStyle("-fx-font-weight : normal");
			tommy.clear();
		});
		
		thirdChar.setOnMouseClicked(e -> {
			CharToPlay = 3;
			soundManagement.confirmed();
			CharacterSelected.setMouseTransparent(true);
			firstChar.setVisible(false);
			secondChar.setVisible(false);
			start.setVisible(true);
			information.setCenter(ready);
			ready.set();
		});
	}
	
}
