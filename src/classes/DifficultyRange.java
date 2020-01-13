package classes;


public enum DifficultyRange {

	HEROIC("Heroic","H"),
	EPIC("Epic","E"),
	LEGENDARY("Legendary","L");

	private String displayName;
	private String shortName;

	DifficultyRange(String displayName, String shortName) {
		this.displayName = displayName;
		this.shortName = shortName;
	}

	public String displayName() {
		return displayName;
	}
	
	public String shortName() {
		return shortName;
	}

	public String toString() {
		return displayName;
	}
}
