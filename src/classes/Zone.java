package classes;

import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A Class that contains a ZoneId, and methods for filter methods
 *
 * @author Tealeaf
 */
public class Zone {

    /*
    TODO make this into an enumerator
    ZONES: Eastern, Central, Western, Pacific, Europe (separate) --> research
     */

    private String id;

    private transient ZoneId zoneId;

    public Zone(String id) {
        this.id = id;
    }

    public Zone(ZoneId zoneId) {
        this.id = zoneId.getId();
        this.zoneId = zoneId;
    }

    /**
     * Returns a list of all {@code TimeZone} objects.
     * <p>
     * This method uses {@link ZoneId#getAvailableZoneIds()} to generate the list of IDs,
     * then converts that list into a {@link List} of {@link Zone}, creating each one
     * using the {@link Zone#Zone(String)} method
     * </p>
     *
     * @return {@link List}<{@link Zone}> of all listed Time Zones
     */
    public static List<Zone> allZones() {
        List<Zone> zones = new ArrayList<>();
        for (String id : ZoneId.getAvailableZoneIds()) zones.add(new Zone(id));
        return zones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ZoneId getZoneId() {
        return zoneId == null ? (zoneId = ZoneId.of(id)) : zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
        this.id = zoneId.getId();
    }

    public ZoneId updateZoneId() {
        return zoneId = ZoneId.of(id);
    }

    public String getFullName() {
        return getZoneId().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    public String getNarrowName() {
        return getZoneId().getDisplayName(TextStyle.NARROW, Locale.getDefault());
    }

    public String getShortName() {
        return getZoneId().getDisplayName(TextStyle.SHORT, Locale.getDefault());
    }

    public boolean isFilter(String filter) {
        for (String s : new String[]{getShortName(), getFullName(), getNarrowName(), getId()}) {
            if (s.toLowerCase().replace(" ", "").contains(filter.toLowerCase().replace(" ", ""))) return true;
        }
        return false;
    }

    public boolean equals(Object other) {
        return this.id.contentEquals(((Zone) other).getId());
    }
}
