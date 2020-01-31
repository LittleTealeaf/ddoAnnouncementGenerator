package application;

import java.time.ZoneId;

import classes.LevelRange;
import classes.Quest;
import classes.Quest.QuestVersion;
import classes.Settings;
import ui.Root;
import ui.TimeZoneComboBox;

public class Main {

	public static void main(String[] args) {
		Data.load();

		Quest quest = new Quest();
		quest.setName("Killing Time");
		quest.addVersion(new QuestVersion(LevelRange.LEGENDARY, 32));
		quest.setRaid(true);
		quest.setPack("Dawn of Dragonborn");

		Settings.loadSettings();
		Root.display(args);
	}
}