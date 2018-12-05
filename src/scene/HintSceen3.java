package scene;

import SceneManage.SceneManagement;
import SharedObject.RenderableHolder;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sound.soundManagement;

public class HintSceen3 extends VBox{
	
	private static ImageView backPic;
	private static ImageView arrowPicPrev;
	
	public HintSceen3() {
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(100);
		this.setStyle("-fx-background-color : black");
		
		Label finalCall = new Label("\t\tOne Last Hint!!\nIf you found that the boss is too\npowerful"
				+ " try to kill all other enemy\nin the map first.....  GOOD LUCK!!! XD");
		finalCall.setStyle("-fx-font-size : 50; -fx-font-weight : bold; -fx-font-color : white");
		
		HBox buttons = new HBox();
		buttons.setAlignment(Pos.CENTER);
		backPic = new ImageView(RenderableHolder.back);
		backPic.setFitHeight(60); backPic.setFitWidth(120);
		setBack();
		
		arrowPicPrev = new ImageView(RenderableHolder.arrowPrev);
		arrowPicPrev.setFitHeight(60); arrowPicPrev.setFitWidth(80);
		setPrev();
		
		buttons.getChildren().addAll(arrowPicPrev, backPic);
		
		this.getChildren().add(finalCall);
		this.getChildren().add(buttons);
		
	}
	
	private static void setBack() {
		backPic.setOnMouseClicked(e -> {
			SceneManagement.switchScene(SceneManagement.menuScene);
			soundManagement.confirmed();
			soundManagement.music();
		});
	}
	
	private static void setPrev() {
		arrowPicPrev.setOnMouseClicked(e -> {
			SceneManagement.switchScene(SceneManagement.hintScene2);
			soundManagement.confirmed();
		});
	}
}
