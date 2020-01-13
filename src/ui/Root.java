package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Root extends Application {

	@Override
	public void start(Stage primaryStage) {

		try {
			BorderPane root = new BorderPane();
			root.setTop(getMenu());
			
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
}

