package classes;

/**
 * A class that creates a reference to an included quest.
 * 
 * @author Tealeaf
 *
 */
public class QuestReference {

	private Quest quest;
	private LevelRange levelRange;

	private Integer minLevel;
	private Integer maxLevel;

	/**
	 * Creates a default Quest Reference from a Quest<br>
	 * Chooses the highest {@link LevelRange level range} that the {@link Quest quest} is part of
	 * 
	 * @param quest - the {@link Quest} to reference
	 */
	public QuestReference(Quest quest) {
		this.quest = quest;

		// If the legendary version exists, then set levelrange to that, otherwise if epic version exists
		// then set levelrange to that, default to heroic, then default to null
		levelRange = (quest.getVersion(LevelRange.LEGENDARY) != null) ? LevelRange.LEGENDARY : (quest.getVersion(LevelRange.EPIC) != null) ? LevelRange.EPIC : (quest.getVersion(LevelRange.HEROIC) != null) ? LevelRange.HEROIC : null;
	}
}
