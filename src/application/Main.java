package application;

import classes.Quests;
import classes.Settings;
import ui.Root;

import java.time.ZoneId;

public class Main {

	public static void main(String[] args) {
		Data.load();

		System.out.println(ZoneId.getAvailableZoneIds());

		Settings.loadSettings();
		Quests.load();
		Root.display(args);
	}
}