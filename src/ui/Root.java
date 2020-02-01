package ui;

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
				area.setText(Data.objectJSON.toJson(new Announcement(n)));
				System.out.println(new Announcement(n).getTimeZones().get(0).getNameShort());
			});
			
			//TODO Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
			
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
