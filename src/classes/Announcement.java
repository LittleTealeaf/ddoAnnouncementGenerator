package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * A Class representation of an announcement, including what quests / raids will be run, the time of the event, time zones that it will include, etc.
 * @author Tealeaf
 *
 */
public class Announcement {
	
	public List<TimeZone> timeZones;
	
	public Announcement() {
		timeZones = new ArrayList<TimeZone>();
		
	}
}
