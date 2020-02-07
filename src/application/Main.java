package application;

import classes.Quests;
import classes.Settings;
import ui.Root;

public class Main {

	public static void main(String[] args) {
		Data.load();

		Settings.loadSettings();
		Quests.load();
		Root.display(args);
	}
}