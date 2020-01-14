package ui;

import application.Generator;
import classes.Announcement;
import classes.Difficulty;
import classes.DifficultyRange;
import classes.Quest;
import classes.QuestInstance;
import classes.Quests;
import classes.Settings;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Root extends Application {
	
	private static BorderPane root;

	private static Announcement ann;

	private static GridPane quests;

	@Override
	public void start(Stage primaryStage) {
		ann = new Announcement();
		
		for(String s : new String[] {"01e9fj45k6jie9f","f8wej9f02j3f","f9we0jf0e9e"}) {
			Quest q = new Quest();
			q.setUuid(s);
			ann.addQuest(new QuestInstance(q));
		}

		try {
			primaryStage.setMaximized(Settings.startMaximized);
			primaryStage.maximizedProperty().addListener((e, o, n) -> {
				Settings.startMaximized = n.booleanValue();
				Settings.save();
			});

			root = new BorderPane();
			root.setTop(getMenu());
			root.setCenter(getContent());

			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void display(String[] args) {
		launch(args);
	}

	private static MenuBar getMenu() {
		MenuBar r = new MenuBar();

		return r;
	}

	private static Node getContent() {		
		quests = new GridPane();
		quests.setHgap(5);
		quests.setVgap(7);
		updateQuests();
		
		Button bAdd = new Button("Add Quests");
		
		HBox qUnder = new HBox(bAdd);

		VBox left = new VBox(quests,qUnder);
		left.setSpacing(10);
		
		
		TextArea output = new TextArea();
		output.focusedProperty().addListener((e,o,n) -> {
			if(n.booleanValue()) output.setText(Generator.generateDiscord(ann));
		});

		VBox right = new VBox(output);
		right.setSpacing(10);

		HBox r = new HBox(left, right);
		r.setSpacing(10);
		r.setPadding(new Insets(10));

		return r;
	}

	public static void updateQuests() {
quests.getChildren().clear();
		for(int i = 0; i < ann.getQuests().size(); i++) {
			QuestInstance q = ann.getQuests().get(i);
			Text name = new Text(q.getQuest().getName());
			
			Text flagging = new Text(q.getQuest().getFlagging());
			
			ComboBox<DifficultyRange> questRange = new ComboBox<DifficultyRange>();
			questRange.setItems(FXCollections.observableArrayList(DifficultyRange.values()));
			questRange.getSelectionModel().select(q.getRange());
			questRange.getSelectionModel().selectedItemProperty().addListener((e,o,n) -> q.setRange(n));
			
			ComboBox<Difficulty> difficulty = new ComboBox<Difficulty>();
			difficulty.setItems(FXCollections.observableArrayList(Difficulty.values()));
			difficulty.getSelectionModel().select(q.getDifficulty());
			difficulty.getSelectionModel().selectedItemProperty().addListener((e,o,n) -> q.setDifficulty(n));
			
		
			Spinner<Integer> minLevel = new Spinner<Integer>();
			minLevel.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(q.getLevelMin(), q.getLevelMax(), q.getLevelMin()));
			minLevel.valueProperty().addListener((e,o,n) -> q.setLevelMin(n));
			minLevel.setEditable(true);
			minLevel.setPrefWidth(75);
			
			Spinner<Integer> maxLevel = new Spinner<Integer>();
			maxLevel.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(q.getLevelMin(), q.getLevelMax(), q.getLevelMax()));
			maxLevel.valueProperty().addListener((e,o,n) -> q.setLevelMax(n));
			maxLevel.setEditable(true);
			maxLevel.setPrefWidth(75);
			
			Button bEditQuest = new Button("Edit");
			bEditQuest.setOnAction(e -> EditQuest.open(Quests.getQuest(q.getQuest())));
			
			Button bDelete = new Button("Delete");
			bDelete.setOnAction(e -> {
				ann.removeQuest(q);
				updateQuests();
			});
			
			quests.addRow(i, name,flagging,questRange,difficulty,minLevel,maxLevel,bEditQuest,bDelete);
		}

	}
}
