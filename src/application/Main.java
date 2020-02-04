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
		
		System.out.println(Data.objectJSON.toJson(new test(ZoneId.systemDefault())));
		
		Quest quest = new Quest();
		quest.setName("Killing Time");
		quest.addVersion(new QuestVersion(LevelRange.LEGENDARY, 32));
		quest.setRaid(true);
		quest.setPack("Dawn of Dragonborn");

		Settings.loadSettings();
		Root.display(args);
	}
	
	private static class test {
		
		private ZoneId zoneId;
		
		public test(ZoneId id) {
			this.zoneId = id;
		}
		
		public ZoneId getId() {
			return zoneId;
		}
		
		public void setId(ZoneId id) {
			this.zoneId = id;
		}
	}
	
}