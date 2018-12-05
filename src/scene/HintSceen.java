package scene;

import SceneManage.SceneManagement;
import SharedObject.RenderableHolder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sound.soundManagement;

public class HintSceen extends VBox{
	
	private static ImageView backPic;
	private static ImageView arrowPic;

	public HintSceen() {
		this.setStyle("-fx-background-color: black");
		this.setPadding(new Insets(30, 30, 30, 30));
		this.setSpacing(15);
		
		HBox movingHint = new HBox();
		movingHint.setSpacing(30);
		ImageView wasdPic = new ImageView(RenderableHolder.wasd);
		wasdPic.setFitWidth(250); wasdPic.setFitHeight(250);
		Label movingLabel = new Label("Press W A S D to\nMove up left down\nand right");
		movingLabel.setStyle("-fx-font-size : 50; -fx-font-weight: bold");
		movingHint.getChildren().add(wasdPic);
		movingHint.getChildren().add(movingLabel);
		
		
		HBox enemyFound = new HBox();
		enemyFound.setSpacing(30);

		ImageView enemyFoundPic = new ImageView(RenderableHolder.enemyFound);
		enemyFoundPic.setFitWidth(300); enemyFoundPic.setFitHeight(250);
		Label enemyFoundLabel = new Label("When found enemy \npress \"SPACE\" to\nenter fight! or go to\nnext level!");
		enemyFoundLabel.setStyle("-fx-font-size : 50; -fx-font-weight: bold");
		enemyFound.getChildren().addAll(enemyFoundLabel, enemyFoundPic);
		
		
		HBox buttonPane = new HBox();
		buttonPane.setAlignment(Pos.CENTER_LEFT);
		ImageView nextLevelPic = new ImageView(RenderableHolder.nextLevel);
		nextLevelPic.setFitWidth(300); nextLevelPic.setFitHeight(250);
		buttonPane.setSpacing(70);
		
		HBox buttons = new HBox();
		buttons.setPrefHeight(250); buttons.setPrefWidth(250);
		buttons.setAlignment(Pos.CENTER);
		
		backPic = new ImageView(RenderableHolder.back);
		backPic.setFitHeight(60); backPic.setFitWidth(120);
		setBack();
		
		arrowPic = new ImageView(RenderableHolder.arrowNext);
		arrowPic.setFitHeight(60); arrowPic.setFitWidth(80);
		setNext();
		buttons.getChildren().addAll(backPic, arrowPic);
		
		buttonPane.getChildren().addAll(nextLevelPic, buttons);
		
		
		
		this.getChildren().add(movingHint);
		this.getChildren().add(enemyFound);
		this.getChildren().add(buttonPane);
	}
	
	private static void setBack() {
		backPic.setOnMouseClicked(e -> {
			SceneManagement.switchScene(SceneManagement.menuScene);
			soundManagement.confirmed();
			soundManagement.music();
		});
	}
	
	private static void setNext() {
		arrowPic.setOnMouseClicked(e -> {
			SceneManagement.switchScene(SceneManagement.hintScene2);
			soundManagement.confirmed();
		});
	}
}
