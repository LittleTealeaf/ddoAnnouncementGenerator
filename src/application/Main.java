package application;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

import classes.EventTime;
import classes.LevelRange;
import classes.Quest;
import classes.Quest.QuestVersion;
import classes.Settings;
import ui.Root;

public class Main {

	public static void main(String[] args) {
		
		Quest quest = new Quest();
		quest.setName("Killing Time");
		quest.addVersion(new QuestVersion(LevelRange.LEGENDARY,32));
		quest.setRaid(true);
		quest.setPack("Dawn of Dragonborn");
		
		
		
		
		Settings.loadSettings();
		Root.display(args);
	}
}