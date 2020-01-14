package ui;

import java.util.List;

import classes.Quest;
import classes.QuestInstance;
import classes.Quests;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		
		Text lMin = new Text("Min Level");
		
		Spinner<Integer> minLevel = new Spinner<Integer>();
		minLevel.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, q.getAbsMinLevel()));
		minLevel.valueProperty().addListener((e,o,n) -> q.setAbsMinLevel(n));
		minLevel.setEditable(true);
		minLevel.setPrefWidth(75);
		
		Text lMax = new Text("Max Level");
	
		Spinner<Integer> maxLevel = new Spinner<Integer>();
		maxLevel.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, q.getAbsMaxLevel()));
		maxLevel.valueProperty().addListener((e,o,n) -> q.setAbsMaxLevel(n));
		maxLevel.setEditable(true);
		maxLevel.setPrefWidth(75);
		
		CheckBox isRaid = new CheckBox("Is Raid");
		isRaid.setSelected(q.isRaid());
		isRaid.selectedProperty().addListener((e,o,n) -> q.setRaid(n));
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		
		grid.add(lname, 0, 0);
		grid.add(name, 1, 0);
		grid.add(lpack, 2, 0);
		grid.add(pack, 3, 0);
		
		grid.add(lMin, 0, 1);
		grid.add(minLevel, 1, 1);
		grid.add(isRaid, 2, 1);
		
		grid.add(lMax, 0, 2);
		grid.add(maxLevel, 1, 2);
		
		Text lFlagging = new Text("Flagging");
		
		TextArea flagging = new TextArea();
		flagging.setText(q.getFlagging());
		flagging.textProperty().addListener((e,o,n) -> {
			if(n.contains("\n")) flagging.setText(n.replace("\n", ""));
			else q.setFlagging(n);
		});
		
		VBox vbContent = new VBox(grid,lFlagging,flagging);
		vbContent.setSpacing(10);
		vbContent.setPadding(new Insets(10));
		
		Button bSave = new Button("Save");
		bSave.setOnAction(e -> {
			Quests.save();
			Root.updateQuests();
			stage.close();
		});
		
		HBox bottom = new HBox(bSave);
		bottom.setPadding(new Insets(10));
		bottom.setSpacing(10);
		
		BorderPane page = new BorderPane();
		page.setCenter(vbContent);
		page.setBottom(bottom);
		
		Scene sc = new Scene(page);
		
		stage.setScene(sc);
		stage.show();
	}
}
