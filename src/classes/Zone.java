package classes;

import java.time.ZoneId;

public enum Zone {
    AT(ZoneId.of("US/Alaska"), "a", "Alaska Time"),
    ET(ZoneId.of("US/NewYork"), "e", "Eastern Time"),
    HT(ZoneId.of("US/Hawaii"), "h", "Hawaii Time"),
    MT(ZoneId.of("US/Mountain"), "m", "Mountain Time"),
    PT(ZoneId.of("US/Pacific"), "p", "Pacific Time");


    ZoneId id;
    String shortName;
    String longName;

    Zone(ZoneId id, String shortName, String longName) {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
    }

    public ZoneId getZone() {
        return id;
    }

    public String getNameLong() {
        return longName;
    }

    public String getNameShort() {
        return shortName;
    }

    public String toString() {
        return longName;
    }
}
