package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * A Class that represents a Quest or a Raid in DDO
 * 
 * @author Tealeaf
 *
 */
public class Quest {

	private String name;
	private String pack;
	private boolean isRaid;
	private String flagging;

	/**
	 * Creates an empty {@code Quest quest} class
	 */
	public Quest() {
		name = "";
		pack = "";
		isRaid = false;
		setFlagging("");
	}

	/**
	 * Gets the Quest Name
	 * 
	 * @return Name of the {@link Quest quest}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Quest Name
	 * 
	 * @param name New name to give the {@link Quest quest} object
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the Quest Pack
	 * 
	 * @return Pack that the {@link Quest quest} belongs to
	 */
	public String getPack() {
		return pack;
	}

	/**
	 * Sets the Quest Pack
	 * 
	 * @param pack Adventure Pack that the {@link Quest quest} belongs to
	 */
	public void setPack(String pack) {
		this.pack = pack;
	}

	/**
	 * Gets whether or not the Quest is a Raid
	 * 
	 * @return {@code True} if the {@link Quest quest} is a raid, {@code False} if the {@link Quest
	 *         quest} is not a raid
	 */
	public boolean isRaid() {
		return isRaid;
	}

	/**
	 * Sets whether or not the Quest is a Raid
	 * 
	 * @param isRaid Set to {@code True} if the {@link Quest quest} is a raid, if not then set to
	 *               {@code False}
	 */
	public void setRaid(boolean isRaid) {
		this.isRaid = isRaid;
	}

	/**
	 * Gets the quest flagging
	 * 
	 * @return Flagging required before being able to enter the {@link Quest quest}
	 */
	public String getFlagging() {
		return flagging;
	}

	/**
	 * Sets the quest flagging
	 * 
	 * @param flagging The flagging required before being able to enter the {@link Quest quest}
	 */
	public void setFlagging(String flagging) {
		this.flagging = flagging;
	}
}
