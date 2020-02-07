package classes;

import application.Data;
import resources.LoadedQuests;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Quests {
	
	private static List<Quest> quests = LoadedQuests.getQuests();
	
	public Quests() {}
	
	public static void load() {
		try {
			Data.deserializeClass(Files.newBufferedReader(Data.getAppFile(true, "Quests.json").toPath()), Quests.class);
		} catch (IOException ignored) {

		}
		
		save();
	}
	
	public static void save() {
		Data.writeFile(Data.getAppFile(true,"Quests.json"), Data.serializeClass(new Quests()));
	}
	
	public static List<Quest> getQuests() {
		return quests;
	}
	
	public static void setQuests(List<Quest> quests) {
		Quests.quests = quests;
	}
	
	public static Quest getQuest(int index) {
		return quests.get(index);
	}
	
	public static void removeQuest(Quest quest) {
		quests.remove(quest);
	}
	
	public static void addQuest(Quest quest) {
		if(!quests.contains(quest)) quests.add(quest);
	}
}
