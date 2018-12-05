package Character_Animate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Red extends VBox{
	Label name, talent, skill1, skill2, special;
	
	public Red() {
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setStyle("-fx-font-size : 30");
		name = new Label("Name : Red");
		talent = new Label("He is handsome and brave.");
		skill1 = new Label("Skill1 \"Slash\" :\n\tHit enemy with powerful slash\n\tDamage = 50.");
		skill2 = new Label("Skill2 \"Warcry\" :\n\tIncrease Attack damage\n\tAttack increase by 30%.");
		special = new Label("Special : If selected all character\n\tattack increase by 5.");
	}
	
	public void set() {
		this.getChildren().addAll(name, talent, skill1, skill2, special);
	}
	
	public void clear() {
		this.getChildren().removeAll(name, talent, skill1, skill2, special);
	}

}
