package application;

import java.time.ZoneId;

import classes.LevelRange;
import classes.Quest;
import classes.Quest.QuestVersion;
import classes.Settings;
import ui.Root;

public class Main {

	public static void main(String[] args) {
		Data.load();
		
		System.out.println(Data.objectJSON.toJson(ZoneId.systemDefault()));
		
		Quest quest = new Quest();
		quest.setName("Killing Time");
		quest.addVersion(new QuestVersion(LevelRange.LEGENDARY, 32));
		quest.setRaid(true);
		quest.setPack("Dawn of Dragonborn");

		Settings.loadSettings();
		Root.display(args);
	}
	
	private static class test {
		
		private ZoneId id;
		
		public test(ZoneId id) {
			this.id = id;
		}
		
		public ZoneId getId() {
			return id;
		}
		
		public void setId(ZoneId id) {
			this.id = id;
		}
	}
	
}