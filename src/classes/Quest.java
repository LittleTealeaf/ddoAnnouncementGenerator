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
	 *                 It is not a raid if it only allows a maximum of 6 players or hirelings to
	 *                 enter. <i>Hirelings cannot enter raids</i>
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
	 *                 it allows for 12 players to participate. <br>
	 *                 It is not a raid if it only allows a maximum of 6 players or hirelings to
	 *                 enter.<br>
	 *                 <br>
	 *                 <i>Hirelings cannot enter raids</i>
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
	 * 
	 * @param name     - Name to give the {@link Quest}
	 * @param uuid     - Unique Identifier of the {@link Quest}<br>
	 *                 Use the {@link UUID#randomUUID() UUID.randomUUID().toString()} method to generate
	 *                 a
	 *                 new {@link UUID}
	 * @param versions - List of {@link QuestVersion Quest Versions} that specify different versions of
	 *                 the {@link Quest quest}
	 * @param isRaid   - Whether or not the {@link Quest} is a raid. A {@link Quest quest} is a raid if
	 *                 it allows for 12 players to participate. <br>
	 *                 It is not a raid if it only allows a maximum of 6 players or hirelings to
	 *                 enter.<br>
	 *                 <br>
	 *                 <i>Hirelings cannot enter raids</i>
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
	 *                 it allows for 12 players to participate. <br>
	 *                 It is not a raid if it only allows a maximum of 6 players or hirelings to
	 *                 enter.<br>
	 *                 <br>
	 *                 <i>Hirelings cannot enter raids</i>
	 * @param pack     - The adventure pack that the {@link Quest} is part of
	 */
	public Quest(String name, String uuid, List<QuestVersion> versions, boolean isRaid, String pack) {
		this.name = name;
		this.uuid = uuid;
		this.pack = pack;
		this.isRaid = isRaid;
		this.versions = versions;
	}

	/**
	 * Gets the name of the Quest
	 * 
	 * @return Name of the {@link Quest}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Quest
	 * 
	 * @param name - Name to give the {@link Quest}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the UUID of the Quest
	 * 
	 * @return Unique Identifier of the {@link Quest}
	 * @see UUID
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Sets the UUID of the Quest.<br>
	 * <br>
	 * This method will not update current references to the {@link Quest}, use with care.
	 * 
	 * @param uuid - Unique Identifier of the {@link Quest}<br>
	 *             Use the {@link UUID#randomUUID() UUID.randomUUID().toString()} method to generate
	 *             a
	 * @see UUID
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Gets the Adventure Pack of the Quest
	 * 
	 * @return Adventure Pack the {@link Quest} belongs to
	 */
	public String getPack() {
		return pack;
	}

	/**
	 * Sets the Adventure Pack of the Quest
	 * 
	 * @param pack - The adventure pack that the {@link Quest} is part of
	 */
	public void setPack(String pack) {
		this.pack = pack;
	}

	/**
	 * Gets the Quest type
	 * 
	 * @return {@code true} - if the {@link Quest quest} is a raid, and allows for a total of 12 players
	 *         to enter<br>
	 *         {@code false} - if the {@link Quest quest} is not a raid and only allows for a maximum of
	 *         6 players to
	 *         join.
	 */
	public boolean isRaid() {
		return isRaid;
	}

	/**
	 * Sets whether or not the Quest is a raid
	 * 
	 * @param isRaid - Whether or not the {@link Quest} is a raid. A {@link Quest quest} is a raid if
	 *               it allows for 12 players to participate. <br>
	 *               It is not a raid if it only allows a maximum of 6 players or hirelings to
	 *               enter.<br>
	 *               <br>
	 *               <i>Hirelings cannot enter raids</i>
	 */
	public void setRaid(boolean isRaid) {
		this.isRaid = isRaid;
	}

	/**
	 * Gets the complete list of all versions of the Quest
	 * 
	 * @return List of {@link QuestVersion Quest Versions} of the {@link Quest}
	 * @see QuestVersion
	 */
	public List<QuestVersion> getVersions() {
		return versions;
	}

	/**
	 * Gets the Quest Version object of a particular level range
	 * 
	 * @param levelRange - the {@link LevelRange} of the {@link Quest}
	 * @return the {@link QuestVersion Quest Version} of the {@link Quest} that is of that
	 *         {@link LevelRange Level Range}
	 * @see QuestVersion
	 * @see LevelRange
	 */
	public QuestVersion getVersion(LevelRange levelRange) {
		for(QuestVersion v : versions) if(v.getLevelRange() == levelRange) return v;
		return null;
	}

	/**
	 * Sets the complete list of Quest VErsions
	 * 
	 * @param versions - List of {@link QuestVersion Quest Versions} that specify different versions of
	 *                 the {@link Quest quest}
	 * @see QuestVersion
	 */
	public void setVersions(List<QuestVersion> versions) {
		this.versions = versions;
	}

	/**
	 * Adds a particular Quest Version to the list of Quest Versions
	 * 
	 * @param version - The specified {@link QuestVersion} of the {@link Quest} to add to the current
	 *                list of {@link QuestVersion Quest Versions}
	 * @see QuestVersion
	 */
	public void addVersion(QuestVersion version) {
		this.versions.add(version);
	}

	/**
	 * Removes a particular Quest Version to the list of Quest Versions
	 * 
	 * @param version - The specified {@link QuestVersion} of the {@link Quest} to remove from the
	 *                current list of {@link QuestVersion Quest Versions}
	 * @see QuestVersion
	 */
	public void removeVersion(QuestVersion version) {
		this.versions.remove(version);
	}

	/**
	 * A specific representation of the {@link Quest quest's} different difficulty levels.
	 * <br>
	 * <br>
	 * <b>Variables:</b><br>
	 * <ul>
	 * <li>{@code levelRange} - the {@link LevelRange} of the {@code QuestVersion}</li>
	 * <li>{@code questLevel} - the Level of the {@link QuestVersion}</li>
	 * <li>{@code minLevel} - the default Minimum Level of the {@code QuestVersion}</li>
	 * <li>{@code maxLevel} - the default Maximum Level of the {@code QuestVersion}</li>
	 * </ul>
	 * 
	 * @author Tealeaf
	 *
	 */
	public static class QuestVersion {

		private LevelRange levelRange;
		private int questLevel;
		private int minLevel;
		private int maxLevel;

		// @formatter:off
		/**
		 * Creates a default Quest Version object from a set level range
		 * <br>
		 * <br>
		 * Default Values:
		 * <br>
		 * <table>
		 * <tr>
		 * <td>Range</td>
		 * <td>Level</td>
		 * <td>Min</td>
		 * <td>Max</td>
		 * </tr>
		 * <tr>
		 * <td>HEROIC</td>
		 * <td>1</td>
		 * <td>1</td>
		 * <td>20</td>
		 * </tr>
		 * <tr>
		 * <td>EPIC</td>
		 * <td>21</td>
		 * <td>20</td>
		 * <td>30</td>
		 * </tr>
		 * <tr>
		 * <tr>
		 * <td>
		 * LEGENDARY
		 * </td>
		 * <td>
		 * 29
		 * </td>
		 * <td>
		 * 28
		 * </td>
		 * <td>
		 * 30
		 * </td>
		 * </tr>
		 * </table>
		 * 
		 * @param levelRange
		 */
		// @formatter:on
		public QuestVersion(LevelRange levelRange) {
			this.levelRange = levelRange;

			switch (levelRange) {
			case HEROIC:
				questLevel = 1;
				minLevel = 1;
				maxLevel = 20;
				break;
			case EPIC:
				questLevel = 21;
				minLevel = 20;
				maxLevel = 20;
				break;
			case LEGENDARY:
				questLevel = 29;
				minLevel = 28;
				maxLevel = 30;
				break;
			}

		}

		public QuestVersion(LevelRange levelRange, int questLevel) {
			this.levelRange = levelRange;
			this.questLevel = questLevel;

			switch (levelRange) {
			case HEROIC:
				minLevel = questLevel - 2;
				maxLevel = questLevel + 2;
				break;
			case EPIC:
				minLevel = 20;
				maxLevel = 30;
				break;
			case LEGENDARY:
				minLevel = 28;
				maxLevel = 30;
				break;
			}

		}

		public QuestVersion(LevelRange levelRange, int questLevel, int minLevel, int maxLevel) {
			this.levelRange = levelRange;
			this.questLevel = questLevel;
			this.minLevel = minLevel;
			this.maxLevel = maxLevel;
		}

		public LevelRange getLevelRange() {
			return levelRange;
		}

		public void setLevelRange(LevelRange levelRange) {
			this.levelRange = levelRange;
		}

		public int getQuestLevel() {
			return questLevel;
		}

		public void setQuestLevel(int questLevel) {
			this.questLevel = questLevel;
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
