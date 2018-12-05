package SceneManage;

import Character_Animate.Character_Ani;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.BattleScene;
import scene.CreditScene;
import scene.GameScene;
import scene.HintSceen;
import scene.HintSceen2;
import scene.HintSceen3;
import scene.MenuScene;
import scene.PlayScene;
import scene.stage_1;

public class SceneManagement {
	
	private static Stage primaryStage;
	private static MenuScene menu = new MenuScene();
	private static CreditScene Credit = new CreditScene();
	private static Character_Ani charAni = new Character_Ani();
	private static PlayScene play = new PlayScene();
	public static GameScene game = new GameScene();
	public static stage_1 stage1 = new stage_1();
	public static BattleScene battle = new BattleScene();
	private static HintSceen hint = new HintSceen();
	private static HintSceen2 hint2 = new HintSceen2();
	private static HintSceen3 hint3 = new HintSceen3();
	
	public static Scene menuScene = new Scene(menu);
	public static Scene creditScene = new Scene(Credit);
	public static Scene playScene = new Scene(play);
	public static Scene gameScene = new Scene(game);
	public static Scene stage1Scene = new Scene(stage1);
	public static Scene battleScene = new Scene(battle);
	public static Scene hintScene = new Scene(hint);
	public static Scene hintScene2 = new Scene(hint2);
	public static Scene hintScene3 = new Scene(hint3);
	
	public SceneManagement(Stage stage) {
		primaryStage = stage;
	}
	
	public void setUp() {
		
		primaryStage.setWidth(900);
		primaryStage.setHeight(900);
		primaryStage.setResizable(false);
		switchScene(menuScene);
		MenuScene.setMenuAction();
	}
	
	public static void switchScene(Scene scene) {
		primaryStage.setScene(scene);
	}
	
}
