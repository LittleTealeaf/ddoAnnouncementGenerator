package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import application.Data;
import application.Main;

public class Quests {
	
	
	private static List<Quest> quests;
	
	public Quests() {
		if(quests == null) quests = new ArrayList<Quest>();
	}
	
	public static void load() {
		try {
			Data.staticJSON.fromJson(Files.newBufferedReader(Data.getAppFile(true,"Quests.json").toPath()), Quests.class);
		} catch(Exception e) {
			new Quest();
			save();
		}
	}
	
	public static void save() {
		Data.writeFile(Data.getAppFile(true,"Quests.json"), Data.staticJSON.toJson(new Quests()));
	}
	
	public static Quest getQuest(Quest quest) {
		System.out.println(quests);
		if(quests == null) quests = new ArrayList<Quest>();
		else for(Quest q : quests) if(q.getUuid().contentEquals(quest.getUuid())) return q;
		System.out.println("Added " + quest);
		quests.add(quest);
		save();
		return quest;
	}
}
