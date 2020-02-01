package classes;

import classes.Quest.QuestVersion;

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
	
	//This is only to be used in-content
	private transient QuestVersion questVersion;

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

	/**
	 * Creates a default Quest Reference from a Quest and a given Level Range<br>
	 * Creates a new {@link QuestReference} object referencing the given {@link Quest}, with the given
	 * {@link LevelRange level range} if the {@link Quest} has a {@link Quest.QuestVersion Quest
	 * Version} for that {@link LevelRange level range}<br>
	 * If the {@link Quest} has no {@link Quest.QuestVersion Quest Version} with the given
	 * {@link LevelRange level range}, {@code levelRange} will be set to {@code null}
	 * 
	 * @param quest      - the {@link Quest} to reference
	 * @param levelRange - the {@link LevelRange Level Range} to default to. if the {@link Quest} has no
	 *                   {@link Quest.QuestVersion Quest Version} with the given {@link LevelRange},
	 *                   {@code levelRange} will be set to {@code null}
	 * @see Quest.QuestVersion
	 * @see Quest
	 * @see LevelRange
	 */
	public QuestReference(Quest quest, LevelRange levelRange) {
		this.quest = quest;
		// Sets levelRange to null if the quest does not have that level range
		this.levelRange = (quest.getVersion(levelRange) != null) ? levelRange : null;
	}
	
	private QuestVersion getQuestVersion() {
		//If the quest version is null, gets the quest version
		return (questVersion != null) ? questVersion : (questVersion = quest.getVersion(levelRange));
	}
	
	/**
	 * Forces an update of {@code questVersion}
	 * @return the updated {@link QuestVersion}
	 */
	private QuestVersion getUpdateQuestVersion() {
		return (questVersion = quest.getVersion(levelRange));
	}
	
	/**
	 * Gets the referenced quest
	 * @return Referenced {@link Quest}
	 */
	public Quest getQuest() {
		return quest;
	}

	
	public void setQuest(Quest quest) {
		this.quest = quest;
	}

	
	public LevelRange getLevelRange() {
		return levelRange;
	}

	
	public void setLevelRange(LevelRange levelRange) {
		this.levelRange = levelRange;
	}

	
	public Integer getMinLevel() {
		return (minLevel != null) ? minLevel : (minLevel = getQuestVersion().getMinLevel());
	}

	
	public void setMinLevel(Integer minLevel) {
		this.minLevel = minLevel;
	}

	
	public Integer getMaxLevel() {
		return (maxLevel != null) ? maxLevel : (maxLevel = getQuestVersion().getMaxLevel());
	}

	
	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	
}
