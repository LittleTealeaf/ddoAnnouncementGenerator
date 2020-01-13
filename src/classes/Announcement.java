package classes;

import java.util.ArrayList;
import java.util.List;

public class Announcement {
	
	private String name;
	private List<QuestInstance> quests;
	
	public Announcement() {
		name = "";
		setQuests(new ArrayList<QuestInstance>());
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}


	public List<QuestInstance> getQuests() {

		return quests;

	}


	public void setQuests(List<QuestInstance> quests) {

		this.quests = quests;

	}
	
	public void addQuest(QuestInstance quest) {
		this.quests.add(quest);
	}
	
	public void removeQuest(QuestInstance quest) {
		this.quests.remove(quest);
	}
	
}
