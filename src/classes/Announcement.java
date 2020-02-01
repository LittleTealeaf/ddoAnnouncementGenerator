package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A Class representation of an announcement, including what quests / raids will be run, the time of the event, time zones that it will include, etc.
 * @author Tealeaf
 *
 */
public class Announcement {
	
	public Date dateTime;
	
	public List<TimeZone> timeZones;
	
	public Announcement() {
		timeZones = new ArrayList<TimeZone>();
		timeZones.add(new TimeZone());
	}
	
	public Announcement(Date dateTime) {
		this.dateTime = dateTime;
		
		timeZones = new ArrayList<TimeZone>();
		timeZones.add(new TimeZone());
	}

	
	public Date getDateTime() {
		return dateTime;
	}

	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public TimeZone getDefaultTimeZone() {
		return timeZones.get(0);
	}
	
	public List<TimeZone> getTimeZones() {
		return timeZones;
	}
	
	public void setTimeZones(List<TimeZone> timeZones) {
		this.timeZones = timeZones;
	}
	
	public void addTimeZone(TimeZone timeZone) {
		for(TimeZone zone : timeZones) if(timeZone.equals(zone)) return;
		timeZones.add(timeZone);
	}
	
	public void removeTimeZone(TimeZone timeZone) {
	}
}
