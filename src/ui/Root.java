package ui;

import java.time.ZoneId;

import application.Data;
import classes.Announcement;
import classes.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Root extends Application {

	private static BorderPane root;

	@Override
	public void start(Stage primaryStage) {

		try {
			primaryStage.setMaximized(Settings.startMaximized);
			primaryStage.maximizedProperty().addListener((e, o, n) -> {
				Settings.startMaximized = n.booleanValue();
				Settings.save();
			});

			root = new BorderPane();
			
			TextArea area = new TextArea();
			
			//DEBUG
			
			DateTimePicker picker = new DateTimePicker();
			picker.getValueProperty().addListener((e,o,n) -> {
				String text = n.toString();
				text+= "\n" + n.withZoneSameInstant(ZoneId.of("GMT"));
				area.setText(text);
			});
			
			root.setCenter(picker);
			root.setBottom(area);
			
			//\DEBUG

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
}
