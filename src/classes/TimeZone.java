package classes;

import java.time.ZoneId;

//TODO fully comment this class

/**
 * A Serializable class that represents a specific Time Zone<br>
 * <br>
 * This works by using the {@link ZoneId#getId()} method, which returns a {@link String}. This is
 * stored in the {@code id} variable. When the {@link ZoneId} is requested, it uses a transient
 * {@link ZoneId} variable, which it will instantiate using {@link ZoneId#of(String)}. When
 * serialized and deserialized, only the {@code id} will be saved<br>
 * <br>
 * <i>The default {@link ZoneId} used is {@link ZoneId#systemDefault()}
 * 
 * @author Tealeaf
 * @see ZoneId
 *
 */
public class TimeZone {

	private String id;

	private transient ZoneId zoneId;

	/**
	 * Creates a new {@code TimeZone} object.<br>
	 * <br>
	 * Uses the default {@link ZoneId}, which is found through {@link ZoneId#systemDefault()}<br>
	 * Initializes the id by using {@link #setZone(ZoneId)}
	 * 
	 * @see ZoneId
	 */
	public TimeZone() {
		setZone(ZoneId.systemDefault());
	}

	/**
	 * Creates a new {@code TimeZone} object.<br>
	 * <br>
	 * Initializes the id by using {@link #setZone(ZoneId)}
	 * 
	 * @param zoneId - The {@link ZoneId} to initiate with
	 */
	public TimeZone(ZoneId zoneId) {
		setZone(zoneId);
	}

	/**
	 * Gets the {@code id} of the {@code TimeZone}<br>
	 * The ID is the {@link String} representative of the {@link ZoneID}
	 * 
	 * @return ID of the {@link TimeZone}
	 * @see ZoneId
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the {@code id} of the {@code TimeZone}<br>
	 * The ID is the {@link String} representative of the {@link ZoneID}<br>
	 * 
	 * @param id - ID of the {@link TimeZone}
	 * @return <b>{@code true}</b> - {@code id} is a valid {@link ZoneId}<br>
	 *         <b>{@code false}</b> - {@code id} is not a valid {@link ZoneId}
	 * 
	 * @see ZoneId
	 */
	public boolean setId(String id) {

		try {
			ZoneId.of(id);
			this.id = id;
			return true;
		} catch(Exception e) {
			return false;
		}

	}

	/**
	 * Gets the {@code ZoneId} that correlates with the {@code id}<br>
	 * <br>
	 * If {@code zoneId} has not already been instantiated, it instantiates it by using the
	 * {@link ZoneId#of(String)}<br>
	 * 
	 * 
	 * @return the {@link ZoneId} created from the {@code id}
	 * 
	 * @see ZoneId
	 */
	public ZoneId getZone() {
		return (zoneId == null) ? (zoneId = ZoneId.of(id)) : zoneId;
	}

	/**
	 * Sets the {@code ZoneId} and {@code id} of the {@code TimeZone}
	 * 
	 * @param zoneId - {@link ZoneId} to set for the {@link TimeZone}
	 * @see ZoneId
	 */
	public void setZone(ZoneId zoneId) {
		this.zoneId = zoneId;
		id = zoneId.getId();
	}

	/**
	 * Checks if the {@code id}s of this {@code TimeZone} and the given {@code TimeZone}
	 * 
	 * @param timeZone - {@link TimeZone} to compare with this {@link TimeZone}
	 * @return <b>{@code true}</b> if they have the same {@code id}<br>
	 *         <b>{@code false}</b> if they do not have the same {@code id}
	 */
	public boolean equals(TimeZone timeZone) {
		return this.getId().contentEquals(timeZone.getId());
	}
}
