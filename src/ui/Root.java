package ui;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import application.Data;
import classes.Announcement;
import classes.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import uielements.DateTimePicker;
import uielements.ZoneSelector;

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

			// DEBUG

			DateTimePicker picker = new DateTimePicker();

			picker.setValue(ZonedDateTime.now());

			VBox debug = new VBox(picker, new ZoneSelector());

			Button bExec = new Button("Compile");
			bExec.setOnAction(e -> {
				Announcement a = new Announcement();
				a.setTime(picker.getValue());

				picker.setValue(ZonedDateTime.now().plusHours(10));
				area.setText(Data.serializeObject(a));
			});

			HBox bottom = new HBox(bExec, area);

			root.setCenter(debug);
			root.setBottom(bottom);

			// \DEBUG

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
