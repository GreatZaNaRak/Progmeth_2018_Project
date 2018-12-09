package scene;

import Draw.DrawMenuScene;
import javafx.scene.layout.StackPane;

public class endScene extends StackPane{

	public endScene() {
		
	}
	
	public void run() {
		DrawMenuScene.setEndCredit(this);
	}
	
}
