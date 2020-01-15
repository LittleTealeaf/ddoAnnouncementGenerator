package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <b>Variables:</b>
 * <ul>
 * <li>{@code name} - Name of the Quest</li>
 * <li>{@code uuid} - Unique Identifier</li>
 * <li>{@code pack} - Adventure Pack</li>
 * <li>{@code isRaid} - Is the adventure a raid</li>
 * <li>{@code versions} - An {@link ArrayList} of {@link QuestVersion} objects
 * </ul>
 * 
 * @author Tealeaf
 * @see QuestVersion
 * @see ArrayList
 */
public class Quest {

	private String name;
	private String uuid;
	private String pack;
	private boolean isRaid;
	private List<QuestVersion> versions;

	/**
	 * Creates an empty {@code Quest} object with set parameters<br>
	 * <ul>
	 * <li>{@code name} = ""</li>
	 * <li>{@code UUID} = {@link UUID#randomUUID() UUID.randomUUID().toString()}</li>
	 * <li>{@code pack} = ""</li>
	 * <li>{@code isRaid} = false</li>
	 * <li>{@code versions} = an empty {@link QuestVersion} {@link ArrayList}</li>
	 * </ul>
	 * 
	 * @see UUID
	 * @see Quest
	 * @see QuestVersion
	 */
	public Quest() {
		this("");
	}

	/**
	 * Creates an empty {@code Quest} object with set parameters
	 * 
	 * @param name
	 */
	public Quest(String name) {
		this(name, new ArrayList<QuestVersion>());
	}

	/**
	 * 
	 * @param name
	 * @param versions
	 */
	public Quest(String name, List<QuestVersion> versions) {
		this(name, versions, false);
	}

	/**
	 * 
	 * @param name
	 * @param versions
	 * @param isRaid
	 */
	public Quest(String name, List<QuestVersion> versions, boolean isRaid) {
		this(name, versions, isRaid, "");
	}

	/**
	 * 
	 * @param name
	 * @param versions
	 * @param isRaid
	 * @param pack
	 */
	public Quest(String name, List<QuestVersion> versions, boolean isRaid, String pack) {
		this(name, UUID.randomUUID().toString(), versions, isRaid, pack);
	}

	/**
	 * 
	 * @param name
	 * @param uuid
	 */
	public Quest(String name, String uuid) {
		this(name, uuid, new ArrayList<QuestVersion>());
	}

	/**
	 * 
	 * @param name
	 * @param uuid
	 * @param versions
	 */
	public Quest(String name, String uuid, List<QuestVersion> versions) {
		this(name, uuid, versions, false);
	}

	/**
	 * 
	 * @param name
	 * @param uuid
	 * @param versions
	 * @param isRaid
	 */
	public Quest(String name, String uuid, List<QuestVersion> versions, boolean isRaid) {
		this(name, uuid, versions, isRaid, "");
	}

	/**
	 * Creates a {@code Quest} object with given parameters
	 * 
	 * @param name     {@link Quest} name to give the object
	 * @param uuid
	 * @param versions
	 * @param isRaid
	 * @param pack
	 */
	public Quest(String name, String uuid, List<QuestVersion> versions, boolean isRaid, String pack) {
		this.name = name;
		this.uuid = uuid;
		this.pack = pack;
		this.isRaid = isRaid;
		this.versions = versions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public boolean isRaid() {
		return isRaid;
	}

	public void setRaid(boolean isRaid) {
		this.isRaid = isRaid;
	}

	public List<QuestVersion> getVersions() {
		return versions;
	}

	public QuestVersion getVersion(LevelRange levelRange) {
		for(QuestVersion v : versions) if(v.getLevelRange() == levelRange) return v;
		return null;
	}

	public void setVersions(List<QuestVersion> versions) {
		this.versions = versions;
	}

	public void addVersion(QuestVersion version) {
		this.versions.add(version);
	}

	public void removeVersion(QuestVersion version) {
		this.versions.remove(version);
	}

	public static class QuestVersion {

		private LevelRange levelRange;
		private int minLevel;
		private int maxLevel;

		public QuestVersion(LevelRange levelRange, int minLevel, int maxLevel) {
			this.levelRange = levelRange;
			this.minLevel = minLevel;
			this.maxLevel = maxLevel;
		}

		public LevelRange getLevelRange() {
			return levelRange;
		}

		public void setLevelRange(LevelRange levelRange) {
			this.levelRange = levelRange;
		}

		public int getMinLevel() {
			return minLevel;
		}

		public void setMinLevel(int minLevel) {
			this.minLevel = minLevel;
		}

		public int getMaxLevel() {
			return maxLevel;
		}

		public void setMaxLevel(int maxLevel) {
			this.maxLevel = maxLevel;
		}
	}

	public static enum LevelRange {

		HEROIC("Heroic", "H"),
		EPIC("Epic", "E"),
		LEGENDARY("Legendary", "L");

		private String fullName;
		private String shortName;

		LevelRange(String fullName, String shortName) {
			this.fullName = fullName;
			this.shortName = shortName;
		}

		public String getFullName() {
			return fullName;
		}

		public String getShortName() {
			return shortName;
		}

		public String toString() {
			return getFullName();
		}
	}
}
