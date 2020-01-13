package application;

import classes.Announcement;
import classes.QuestInstance;

public class Generator {
	
	public static String generateDiscord(Announcement announcement) {
		String r = "";
		r+="```yaml\n";
		
		for(QuestInstance q : announcement.getQuests()) {
			r+=(q.getQuest().isRaid()) ? "RAID" : "QUEST";
			r+=": " + q.getRange().shortName() + q.getDifficulty().shortName() + "  " + q.getQuest().getName();
			r+=" (" + ((q.getQuest().getFlagging().contentEquals("")) ? "n" : "f") + ")";
			r+=" ML " + q.getLevelMin();
			r+="\n";
		}
		
		r+="```";
		return r;
	}
}
