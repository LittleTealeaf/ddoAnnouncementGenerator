package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <b>Variables:</b>
 * <ul>
 * <li>{@code name} - Name of the Quest<br>
 * <i>default: {@code ""}</i></li>
 * <li>{@code uuid} - Unique Identifier<br>
 * <i>default: {@link UUID#randomUUID() UUID.randomUUID().toString()}</i></li>
 * <li>{@code pack} - Adventure Pack<br>
 * <i>default: {@code ""}</i></li>
 * <li>{@code isRaid} - Is the adventure a raid<br>
 * <i>default: {@code false}</i></li>
 * <li>{@code versions} - An {@link ArrayList} of {@link QuestVersion} objects<br>
 * <i>default: empty {@link ArrayList} of {@link QuestVersion Quest Versions}
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
	 * Creates a new Quest object with no name
	 * 
	 * @see Quest
	 */
	public Quest() {
		this("");
	}

	/**
	 * Creates a new Quest object with set parameters
	 * 
	 * @param name - Name to give the {@link Quest} object
	 * @see Quest
	 */
	public Quest(String name) {
		this(name, new ArrayList<QuestVersion>());
	}

	/**
	 * Creates a new Quest object with set parameters
	 * 
	 * @param name     - Name to give the {@link Quest} object
	 * @param versions - List of {@link QuestVersion Quest Versions} that specify different versions of
	 *                 the {@link Quest quest}
	 * 
	 * @see QuestVersion
	 */
	public Quest(String name, List<QuestVersion> versions) {
		this(name, versions, false);
	}

	/**
	 * Creates a new Quest object with set parameters
	 * 
	 * @param name     - Name to give the {@link Quest}
	 * @param versions - List of {@link QuestVersion Quest Versions} that specify different versions of
	 *                 the {@link Quest quest}
	 * @param isRaid   - Whether or not the {@link Quest} is a raid. A {@link Quest quest} is a raid if
	 *                 it allows for 12 players to participate.
	 * @see QuestVersion
	 */
	public Quest(String name, List<QuestVersion> versions, boolean isRaid) {
		this(name, versions, isRaid, "");
	}

	/**
	 * Creates a new Quest object with set parameters
	 * 
	 * @param name     - Name to give the {@link Quest}
	 * @param versions - List of {@link QuestVersion Quest Versions} that specify different versions of
	 *                 the {@link Quest quest}
	 * @param isRaid   - Whether or not the {@link Quest} is a raid. A {@link Quest quest} is a raid if
	 *                 it allows for 12 players to participate.
	 * @param pack     - The adventure pack that the {@link Quest} is part of
	 */
	public Quest(String name, List<QuestVersion> versions, boolean isRaid, String pack) {
		this(name, UUID.randomUUID().toString(), versions, isRaid, pack);
	}

	/**
	 * Creates a new Quest object with a set {@code UUID} and parameters
	 * 
	 * @param name - Name to give the {@link Quest}
	 * @param uuid - Unique Identifier of the {@link Quest}<br>
	 *             Use the {@link UUID#randomUUID() UUID.randomUUID().toString()} method to generate a
	 *             new {@link UUID}
	 * @see UUID
	 */
	public Quest(String name, String uuid) {
		this(name, uuid, new ArrayList<QuestVersion>());
	}

	/**
	 * Creates a new Quest object with a set {@code UUID} and parameters
	 * 
	 * @param name     - Name to give the {@link Quest}
	 * @param uuid     - Unique Identifier of the {@link Quest}<br>
	 *                 Use the {@link UUID#randomUUID() UUID.randomUUID().toString()} method to generate
	 *                 a
	 *                 new {@link UUID}
	 * @param versions - List of {@link QuestVersion Quest Versions} that specify different versions of
	 *                 the {@link Quest quest}
	 * @see UUID
	 * @see QuestVersion
	 */
	public Quest(String name, String uuid, List<QuestVersion> versions) {
		this(name, uuid, versions, false);
	}

	/**
	 * Creates a new Quest object with a set {@code UUID} and parameters
	 * @param name     - Name to give the {@link Quest}
	 * @param uuid     - Unique Identifier of the {@link Quest}<br>
	 *                 Use the {@link UUID#randomUUID() UUID.randomUUID().toString()} method to generate
	 *                 a
	 *                 new {@link UUID}
	 * @param versions - List of {@link QuestVersion Quest Versions} that specify different versions of
	 *                 the {@link Quest quest}
	 * @param isRaid   - Whether or not the {@link Quest} is a raid. A {@link Quest quest} is a raid if
	 *                 it allows for 12 players to participate.
	 */
	public Quest(String name, String uuid, List<QuestVersion> versions, boolean isRaid) {
		this(name, uuid, versions, isRaid, "");
	}

	/**
	 * Creates a new Quest object with a set {@code UUID} and parameters
	 * 
	 * @param name     - Name to give the {@link Quest}
	 * @param uuid     - Unique Identifier of the {@link Quest}<br>
	 *                 Use the {@link UUID#randomUUID() UUID.randomUUID().toString()} method to generate
	 *                 a
	 *                 new {@link UUID}
	 * @param versions - List of {@link QuestVersion Quest Versions} that specify different versions of
	 *                 the {@link Quest quest}
	 * @param isRaid   - Whether or not the {@link Quest} is a raid. A {@link Quest quest} is a raid if
	 *                 it allows for 12 players to participate.
	 * @param pack     - The adventure pack that the {@link Quest} is part of
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
