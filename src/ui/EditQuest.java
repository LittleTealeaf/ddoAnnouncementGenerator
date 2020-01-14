package ui;

import java.util.List;

import classes.Quest;
import classes.QuestInstance;
import classes.Quests;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditQuest {
	
	public static Stage stage;
	private static Quest q;
	
	public static void open(Quest quest) {
		q = Quests.getQuest(quest);
		if(stage != null && stage.isShowing()) stage.close();
		stage = new Stage();
		
		stage.setTitle((q == null) ? "Create Quest" : "Edit " + q.getName());
		
		if(q == null) q = new Quest();
		
		Text lname = new Text("Name");
		
		TextField name = new TextField();
		name.setText(q.getName());
		name.textProperty().addListener((e,o,n) -> q.setName(n));
		
		Text lpack = new Text("Pack");
		
		TextField pack = new TextField();
		pack.setText(q.getName());
		pack.textProperty().addListener((e,o,n) -> q.setPack(n));
		
		GridPane content = new GridPane();
		content.add(lname, 0, 0);
		content.add(name, 1, 0);
		content.add(lpack, 0, 1);
		content.add(pack, 1, 1);
		
		
		BorderPane page = new BorderPane();
		page.setCenter(content);
		
		Scene sc = new Scene(page);
		
		stage.setScene(sc);
		stage.show();
	}
}
