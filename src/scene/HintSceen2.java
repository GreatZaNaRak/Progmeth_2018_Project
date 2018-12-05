package scene;

import SceneManage.SceneManagement;
import SharedObject.RenderableHolder;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sound.soundManagement;

public class HintSceen2 extends VBox{
	
	private static ImageView backPic;
	private static ImageView arrowPicNext;
	private static ImageView arrowPicPrev;
	
	public HintSceen2() {
		
		this.setSpacing(15);
		this.setStyle("-fx-background-color : black");
		ImageView fightPicture = new ImageView(RenderableHolder.fightPic);
		fightPicture.setFitHeight(600); fightPicture.setFitWidth(900);
		
		Label infor = new Label("During fight each turn you have to press action to do\n"
				+ "attack or using skill. You can't do action if it is enemy turn\n"
				+ "or your character is dead");
		infor.setStyle("-fx-font-size : 35; -fx-font-weight : bold");
		
		HBox buttons = new HBox();
		buttons.setAlignment(Pos.CENTER);
		backPic = new ImageView(RenderableHolder.back);
		backPic.setFitHeight(60); backPic.setFitWidth(120);
		setBack();
		
		arrowPicNext = new ImageView(RenderableHolder.arrowNext);
		arrowPicNext.setFitHeight(60); arrowPicNext.setFitWidth(80);
		setNext();
		
		arrowPicPrev = new ImageView(RenderableHolder.arrowPrev);
		arrowPicPrev.setFitHeight(60); arrowPicPrev.setFitWidth(80);
		setPrev();
		
		buttons.getChildren().addAll(arrowPicPrev, backPic, arrowPicNext);
		
		this.getChildren().add(fightPicture);
		this.getChildren().add(infor);
		this.getChildren().add(buttons);
		
	}
	
	private static void setBack() {
		backPic.setOnMouseClicked(e -> {
			SceneManagement.switchScene(SceneManagement.menuScene);
			soundManagement.confirmed();
			soundManagement.music();
		});
	}
	
	private static void setNext() {
		arrowPicNext.setOnMouseClicked(e -> {
			SceneManagement.switchScene(SceneManagement.hintScene3);
			soundManagement.confirmed();
		});
	}
	
	private static void setPrev() {
		arrowPicPrev.setOnMouseClicked(e -> {
			SceneManagement.switchScene(SceneManagement.hintScene);
			soundManagement.confirmed();
		});
	}

}
