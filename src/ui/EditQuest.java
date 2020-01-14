package ui;

import java.util.List;

import classes.Quest;
import classes.QuestInstance;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditQuest {
	
	public static Stage stage;
	private static Quest q;
	
	public static void open(Quest quest) {
		q = quest;
		if(stage != null && stage.isShowing()) stage.close();
		stage = new Stage();
		
		stage.setTitle((q == null) ? "Create Quest" : "Edit " + q.getName());
		
		if(q == null) q = new Quest();
		
		Text lname = new Text("Name");
		
		TextField name = new TextField();
		name.setText(q.getName());
		name.textProperty().addListener((e,o,n) -> q.setName(n));
		
		GridPane content = new GridPane();
		
		BorderPane page = new BorderPane();
	}
}
