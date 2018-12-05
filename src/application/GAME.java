package application;

import SceneManage.SceneManagement;
import SharedObject.RenderableHolder;
import javafx.application.Application;
import javafx.stage.Stage;


public class GAME extends Application {
	
	private SceneManagement sceneManage;
	
	@Override
	public void start(Stage primaryStage) {
		sceneManage = new SceneManagement(primaryStage);
		sceneManage.setUp();
			
		primaryStage.getIcons().add(RenderableHolder.gameIcon);
		primaryStage.setTitle("FINAL FANTASY II");
		primaryStage.setWidth(900);
		primaryStage.setHeight(900);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
