package Character_Animate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Vincent extends VBox{
	Label name, talent, weak, ultimate;
	
	public Vincent() {
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setStyle("-fx-font-size : 30");
		name = new Label("Name : Vincent");
		talent = new Label("Talent : He is brave and powerful");
		weak = new Label("Skill1 \"Tackle\" :\nhit enemy with powerful slash\n\tDamage = 50");
		ultimate = new Label("Skill2 \"Resist\" :\n\tincrease defend power\n\tDefend increase by 35");
		
	}
	
	public void set() {
		this.getChildren().addAll(name, talent, weak, ultimate);
	}
	
	public void clear() {
		this.getChildren().removeAll(name, talent, weak, ultimate);
	}

}