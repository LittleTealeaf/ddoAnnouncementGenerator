package classes;


public class QuestInstance {
	
	private Quest quest;
	private int levelMin;
	private int levelMax;
	private Difficulty difficulty;
	private DifficultyRange range;
	
	public QuestInstance(Quest quest) {
		this.setQuest(Quests.getQuest(quest));
		levelMin = quest.getAbsMinLevel();
		levelMax = quest.getAbsMaxLevel();
		difficulty = Difficulty.NORMAL;
		setRange(DifficultyRange.LEGENDARY);
	}

	public Quest getQuest() {

		return quest;

	}

	public void setQuest(Quest quest) {

		this.quest = quest;

	}

	
	public int getLevelMin() {
		return levelMin;
	}

	
	public void setLevelMin(int levelMin) {
		this.levelMin = levelMin;
	}

	
	public int getLevelMax() {
		return levelMax;
	}

	
	public void setLevelMax(int levelMax) {
		this.levelMax = levelMax;
	}

	
	public Difficulty getDifficulty() {
		return difficulty;
	}

	
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public DifficultyRange getRange() {

		return range;

	}

	public void setRange(DifficultyRange range) {

		this.range = range;

	}
}
