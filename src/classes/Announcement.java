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
	
}
