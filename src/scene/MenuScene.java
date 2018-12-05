package scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import Draw.DrawMenuScene;
import SceneManage.SceneManagement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sound.soundManagement;

public class MenuScene extends BorderPane {
	
	private static VBox buttons;
	private static Canvas playCanvas, creditCanvas, hintCanvas, enterCanvas;
	private static GraphicsContext playGC, creditGC, hintGC, enterGC;
	private static int count = 1;
	
	public MenuScene() {
		
		StackPane centerPane = new StackPane();
		
		buttons = new VBox();
		buttons.setSpacing(0);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		buttons.setPadding(new Insets(50, 50, 50, 50));
		
		Text gameTitle = new Text("CP::MONSTER FANTASY");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		gameTitle.setStyle("-fx-font-weigt: bold; -fx-font-size : 75; -fx-fill :"
				+ "linear-gradient(from 0% 0% to 100% 200%, repeat, orange 30%, red 50%);");
		gameTitle.setStroke(Color.BLACK);
		gameTitle.setStrokeWidth(3);
		gameTitle.setFill(Color.WHITE);
		gameTitle.setFont(Font.font("Comic Sans MS"));
		
		playCanvas = new Canvas(400, 100);
		playGC = playCanvas.getGraphicsContext2D();
		playGC.setFill(Color.BLACK);
		playGC.setTextAlign(TextAlignment.CENTER);
		playGC.setFont(Font.font("Comic Sans MS", 50));
		playGC.fillText("PLAY", 200, 50);
		this.setPlayCanvasAction();
		
		creditCanvas = new Canvas(400, 100);
		creditGC = creditCanvas.getGraphicsContext2D();
		creditGC.setFill(Color.BLACK);
		creditGC.setTextAlign(TextAlignment.CENTER);
		creditGC.setFont(Font.font("Comic Sans MS", 50));
		creditGC.fillText("CREDIT", 210, 50);
		this.setCreditCanvasAction();
		
		hintCanvas = new Canvas(400, 100);
		hintGC = hintCanvas.getGraphicsContext2D();
		hintGC.setFill(Color.BLACK);
		hintGC.setTextAlign(TextAlignment.CENTER);
		hintGC.setFont(Font.font("Comic Sans MS", 50));
		hintGC.fillText("HINT", 200, 50);
		this.setExitCanvasAction();
		
		buttons.getChildren().add(gameTitle);
		buttons.getChildren().add(playCanvas);
		buttons.getChildren().add(creditCanvas);
		buttons.getChildren().add(hintCanvas);
		
		buttons.setVisible(false);
		
		
		VBox foreground = new VBox();
		foreground.setAlignment(Pos.CENTER);
		foreground.setSpacing(230);
		foreground.getChildren().add(gameTitle);
		foreground.getChildren().add(buttons);
		
		enterCanvas = new Canvas(760, 300);
		enterGC = enterCanvas.getGraphicsContext2D();
		DrawMenuScene.drawEnter(enterGC);
			
			
		
		DrawMenuScene.setBG(this);
		centerPane.getChildren().add(foreground);
		centerPane.getChildren().add(enterCanvas);
		this.setCenter(centerPane);
		
		soundManagement.music();
		
		
	}
	
	public static void setMenuAction() {
		SceneManagement.menuScene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER && count == 1) {
				soundManagement.gun();
				enterCanvas.setVisible(false);
				buttons.setVisible(true);
				count++;
			} else if (e.getCode() == KeyCode.ESCAPE && count != 1) {
				enterCanvas.setVisible(true);
				buttons.setVisible(false);
				count--;
			}
		});
	}
	
	private void setPlayCanvasAction() {
		playCanvas.setOnMouseEntered(e -> {
			playGC.setLineWidth(4);
			playGC.setStroke(Color.ORANGE);
			playGC.setFill(Color.WHITE);
			playGC.setFont(Font.font("Comic Sans MS", 50));
			playGC.setTextAlign(TextAlignment.CENTER);
			playGC.fillText("PLAY", 200, 50);
			playGC.moveTo(80, 20);
			playGC.lineTo(80, 50);
			playGC.lineTo(115, 35);
			playGC.closePath();
			playGC.stroke();
		});
		
		playCanvas.setOnMouseExited(e -> {
			playGC.setFill(Color.WHITE);
			playGC.clearRect(0, 0, 310, 80);
			playGC.setFill(Color.BLACK);
			playGC.setFont(Font.font("Comic Sans MS", 50));
			playGC.setTextAlign(TextAlignment.CENTER);
			playGC.fillText("PLAY", 200, 50);
		});
		
		playCanvas.setOnMouseClicked(e -> {
			soundManagement.confirmed();
			SceneManagement.switchScene(SceneManagement.playScene);
			soundManagement.stopMusic();
		});
	}
	
	private void setCreditCanvasAction() {
		creditCanvas.setOnMouseEntered(e -> {
			creditGC.setLineWidth(4);
			creditGC.setStroke(Color.ORANGE);
			creditGC.setFill(Color.WHITE);
			creditGC.setFont(Font.font("Comic Sans MS", 50));
			creditGC.setTextAlign(TextAlignment.CENTER);
			creditGC.fillText("CREDIT", 210, 50);
			creditGC.moveTo(60, 20);
			creditGC.lineTo(60, 50);
			creditGC.lineTo(95, 35);
			creditGC.closePath();
			creditGC.stroke();
		});
		
		creditCanvas.setOnMouseExited(e -> {
			creditGC.setFill(Color.WHITE);
			creditGC.clearRect(0, 0, 400, 80);
			creditGC.setFill(Color.BLACK);
			creditGC.setFont(Font.font("Comic Sans MS", 50));
			creditGC.setTextAlign(TextAlignment.CENTER);
			creditGC.fillText("CREDIT", 210, 50);
		});
		
		creditCanvas.setOnMouseClicked(e -> {
			soundManagement.confirmed();
			soundManagement.stopMusic();
			SceneManagement.switchScene(SceneManagement.creditScene);
		});
	}
	
	private void setExitCanvasAction() {
		hintCanvas.setOnMouseEntered(e -> {
			hintGC.setLineWidth(4);
			hintGC.setStroke(Color.ORANGE);
			hintGC.setFill(Color.WHITE);
			hintGC.setFont(Font.font("Comic Sans MS", 50));
			hintGC.setTextAlign(TextAlignment.CENTER);
			hintGC.fillText("HINT", 200, 50);
			hintGC.moveTo(80, 20);
			hintGC.lineTo(80, 50);
			hintGC.lineTo(115, 35);
			hintGC.closePath();
			hintGC.stroke();
		});
		
		hintCanvas.setOnMouseExited(e -> {
			hintGC.setFill(Color.WHITE);
			hintGC.clearRect(0, 0, 400, 80);
			hintGC.setFill(Color.BLACK);
			hintGC.setFont(Font.font("Comic Sans MS", 50));
			hintGC.setTextAlign(TextAlignment.CENTER);
			hintGC.fillText("HINT", 200, 50);
		});
		
		hintCanvas.setOnMouseClicked(e -> {
			soundManagement.confirmed();
			soundManagement.stopMusic();
			SceneManagement.switchScene(SceneManagement.hintScene);
		});
	}
	
}