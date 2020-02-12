package classes;

import java.time.ZoneId;

public enum Zone {
    ET(ZoneId.of("US/NewYork"), "e", "Eastern Time"),
    PT(ZoneId.of("US/Pacific"), "p", "Pacific Time"),
    MT(ZoneId.of("US/Mountain"), "m", "Mountain Time"),
    AT(ZoneId.of("US/Alaska"), "a", "Alaska Time"),
    HT(ZoneId.of("US/Hawaii"), "h", "Hawaii Time");


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
}
