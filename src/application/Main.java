package application;

import java.util.Calendar;
import java.util.Date;

import classes.LevelRange;
import classes.Quest;
import classes.Quest.QuestVersion;
import classes.Settings;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.Root;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main {

	public static void main(String[] args) {
		
		Quest quest = new Quest();
		quest.setName("Killing Time");
		quest.addVersion(new QuestVersion(LevelRange.LEGENDARY,32));
		quest.setRaid(true);
		quest.setPack("Dawn of Dragonborn");
		
		System.out.println(quest.toString());
		
		Settings.loadSettings();
		Root.display(args);
	}
}