package classes;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A Class representation of an announcement, including what quests / raids will be run, the time of
 * the event, time zones that it will include, etc.
 * 
 * @author Tealeaf
 *
 */
public class Announcement {
	
	
	private ZonedDateTime time;
	private List<ZoneId> timeZones = new ArrayList<ZoneId>(Settings.defaultZones);
	
	
	private List<QuestReference> quests = new ArrayList<QuestReference>();
	
	public Announcement() {
		
	}
	
	public Announcement(ZonedDateTime time) {
		this.time = time;
	}

	
	public ZonedDateTime getTime() {
		return time;
	}

	
	public void setTime(ZonedDateTime time) {
		this.time = time;
	}

	
	public List<ZoneId> getTimeZones() {
		return timeZones;
	}

	
	public void setTimeZones(List<ZoneId> timeZones) {
		this.timeZones = timeZones;
	}

	
	public List<QuestReference> getQuests() {
		return quests;
	}

	
	public void setQuests(List<QuestReference> quests) {
		this.quests = quests;
	}
	
	
	
}
