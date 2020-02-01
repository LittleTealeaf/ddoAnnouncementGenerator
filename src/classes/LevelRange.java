package classes;

/**
 * An Enumerator that describes a {@link Quest quest's} Level Range
 * <ul>
 * <li><b>HEROIC</b> - {@link Quest Quests} levels 1-20</li>
 * <li><b>EPIC</b> - {@link Quest Quests} levels 21-27</li>
 * <li><b>LEGENDARY</b> - {@link Quest Quests} levels 28+</li>
 * </ul>
 * 
 * @author Tealeaf
 *
 */
public enum LevelRange {

	/**
	 * Level Range describing {@link Quest quests} levels 1-20
	 */
	HEROIC("Heroic", "H"),
	/**
	 * Level Range describing {@link Quest quests} levels 21-27
	 */
	EPIC("Epic", "E"),
	/**
	 * Level Range describing {@link Quests quests} levels 28+
	 */
	LEGENDARY("Legendary", "L");

	private String fullName;
	private String shortName;

	/**
	 * Creating the Level Range
	 * 
	 * @param fullName  - the Full Name of the {@link LevelRange}
	 * @param shortName - the Short Name of the {@link LevelRange}
	 */
	LevelRange(String fullName, String shortName) {
		this.fullName = fullName;
		this.shortName = shortName;
	}

	/**
	 * Gets the full name of the Level Range
	 * 
	 * @return Gets the full name of the {@link LevelRange Level Range}
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Gets the short name of the Level Range
	 * 
	 * @return Gets the short name of the {@link LevelRange Level Range}
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * Returns the full name by default
	 * 
	 * @return {@link #getFullName()}
	 */
	public String toString() {
		return getFullName();
	}
}