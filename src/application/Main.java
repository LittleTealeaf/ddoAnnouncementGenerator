package application;

import classes.LevelRange;
import classes.Quest;
import classes.Quests;
import classes.Quest.QuestVersion;
import classes.Settings;
import ui.Root;

public class Main {
	
	/*
	 * DOCUMENTING STYLE:
	 * use the code thingies in descriptors on first line and any re-use of it, include links in the see area
	 */

	public static void main(String[] args) {
		Data.load();

		Quest quest = new Quest();
		quest.setName("Killing Time");
		quest.addVersion(new QuestVersion(LevelRange.LEGENDARY, 32));
		quest.setRaid(true);
		quest.setPack("Dawn of Dragonborn");

		Settings.loadSettings();
		Quests.load();
		Root.display(args);
	}
}