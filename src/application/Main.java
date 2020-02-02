package application;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import classes.LevelRange;
import classes.Quest;
import classes.Quest.QuestVersion;
import classes.Settings;
import ui.Root;

public class Main {

	public static void main(String[] args) {
		Data.load();
		
		ZonedDateTime now = LocalDateTime.of(2020, 2, 2, 21, 00).atZone(ZoneId.systemDefault());	
		
		Quest quest = new Quest();
		quest.setName("Killing Time");
		quest.addVersion(new QuestVersion(LevelRange.LEGENDARY, 32));
		quest.setRaid(true);
		quest.setPack("Dawn of Dragonborn");

		Settings.loadSettings();
		Root.display(args);
	}
}