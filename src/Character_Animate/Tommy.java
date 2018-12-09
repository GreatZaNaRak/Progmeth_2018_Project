package Character_Animate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Tommy extends VBox{
	Label name, talent, skill1, skill2, special;
	
	public Tommy() {
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setStyle("-fx-font-size : 30");
		name = new Label("Name : Tommy");
		talent = new Label("\"He is brave and powerful.\"");
		skill1 = new Label("Skill1 \"Tackle\" :\nHit enemy with powerful slash\n\tDamage = 50.");
		skill2 = new Label("Skill2 \"Resist\" :\n\tIncrease defend power\n\tDefend increase by 35%.");
		special = new Label("Special : If selected all Character\n\tDefend increase by 5.");
	}
	
	public void set() {
		this.getChildren().addAll(name, talent, skill1, skill2, special);
	}
	
	public void clear() {
		this.getChildren().removeAll(name, talent, skill1, skill2, special);
	}

}