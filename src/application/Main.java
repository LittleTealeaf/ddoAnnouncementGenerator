package application;

import java.util.Calendar;
import java.util.Date;

import classes.Settings;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.Root;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main {

	public static void main(String[] args) {
		Settings.loadSettings();
		Root.display(args);
	}
}