package scene;

import SceneManage.SceneManagement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sound.soundManagement;

public class HintSceen extends VBox{
	
	private static ImageView i3;
	private static ImageView i4;

	public HintSceen() {
		this.setStyle("-fx-background-color: black");
		this.setPadding(new Insets(30, 30, 30, 30));
		this.setSpacing(15);
		
		HBox movingHint = new HBox();
		movingHint.setSpacing(30);
		Image img = new Image(ClassLoader.getSystemResource("wasd.jpg").toString());
		ImageView i = new ImageView(img);
		i.setFitWidth(250); i.setFitHeight(250);
		Label movingLabel = new Label("Press W A S D to\nMove up left down\nand right");
		movingLabel.setStyle("-fx-font-size : 50; -fx-font-weight: bold");
		movingHint.getChildren().add(i);
		movingHint.getChildren().add(movingLabel);
		
		
		HBox enemyFound = new HBox();
		enemyFound.setSpacing(30);
		Image img2 = new Image(ClassLoader.getSystemResource("enemyFound.jpg").toString());
		ImageView i2 = new ImageView(img2);
		i2.setFitWidth(300); i2.setFitHeight(250);
		Label enemyFoundLabel = new Label("When found enemy \npress \"SPACE\" to\n     enter fight!");
		enemyFoundLabel.setStyle("-fx-font-size : 50; -fx-font-weight: bold");
		enemyFound.getChildren().addAll(enemyFoundLabel, i2);
		
		StackPane buttons = new StackPane();
		buttons.setPrefHeight(300); buttons.setPrefWidth(300);
		buttons.setAlignment(Pos.CENTER);
		HBox buttonPane = new HBox();
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setSpacing(5);
		Image img3 = new Image(ClassLoader.getSystemResource("back.png").toString());
		i3 = new ImageView(img3);
		i3.setFitHeight(60); i3.setFitWidth(120);
		setBack();
		Image img4 = new Image(ClassLoader.getSystemResource("arrow.png").toString());
		i4 = new ImageView(img4);
		i4.setFitHeight(60); i4.setFitWidth(80);
		setNext();
		
		buttonPane.getChildren().addAll(i3, i4);
		
		buttons.getChildren().add(buttonPane);
		
		this.getChildren().add(movingHint);
		this.getChildren().add(enemyFound);
		this.getChildren().add(buttons);
	}
	
	private static void setBack() {
		i3.setOnMouseClicked(e -> {
			SceneManagement.switchScene(SceneManagement.menuScene);
			soundManagement.confirmed();
			soundManagement.music();
		});
	}
	
	private static void setNext() {
		i4.setOnMouseClicked(e -> {
			SceneManagement.switchScene(SceneManagement.hintScene2);
			soundManagement.confirmed();
		});
	}
}
