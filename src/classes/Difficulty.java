package classes;


public enum Difficulty {
	
	CASUAL("Casual","C"),
	NORMAL("Normal","N"),
	HARD("Hard","H"),
	ELITE("Elite","E"),
	REAPER1("Reaper 1","R1"),
	REAPER2("Reaper 2","R2"),
	REAPER3("Reaper 3","R3"),
	REAPER4("Reaper 4","R4"),
	REAPER5("Reaper 5","R5"),
	REAPER6("Reaper 6","R6"),
	REAPER7("Reaper 7","R7"),
	REAPER8("Reaper 8","R8"),
	REAPER9("Reaper 9","R9"),
	REAPER10("Reaper 10","R10");

	private String displayName;
	private String shortName;

	Difficulty(String displayName, String shortName) {
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
