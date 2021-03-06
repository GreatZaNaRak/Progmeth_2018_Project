package Character_Animate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Pearl extends VBox{
	Label name, talent, skill1, skill2, special;
	
	public Pearl() {
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setStyle("-fx-font-size : 30");
		name = new Label("Name : Pearl");
		talent = new Label("\"She is cute and kind.\"");
		skill1 = new Label("Skill1 \"Heal\" :\n\tHeal all hero\n\theal point = 40.");
		skill2 = new Label("Skill2 \"Fear\" :\n\tDecrease enemy attack point\n\tby 35%.");
		special = new Label("Special : If selected all Character\n\tHealh increase by 50.");
	}
	
	public void set() {
		this.getChildren().addAll(name, talent, skill1, skill2, special);
	}
	
	public void clear() {
		this.getChildren().removeAll(name, talent, skill1, skill2, special);
	}

}