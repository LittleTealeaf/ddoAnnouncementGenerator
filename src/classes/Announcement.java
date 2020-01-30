package classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * A Class representation of an announcement, including what quests / raids will be run, the time of the event, time zones that it will include, etc.
 * @author Tealeaf
 *
 */
public class Announcement {
	
	public List<TimeZone> timeZones;
	
	public Date dateTime;
	
	public Announcement() {
		timeZones = new ArrayList<TimeZone>();
		
	}
	
	public Announcement(Date dateTime) {
		this.timeZones = new ArrayList<TimeZone>();
		this.dateTime = dateTime;
	}

	
	public Date getDateTime() {
		return dateTime;
	}

	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}
