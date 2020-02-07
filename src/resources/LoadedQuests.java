package resources;

import classes.LevelRange;
import classes.Quest;
import classes.Quest.QuestVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class dedicated to listing all current and prominent raids
 *
 * @author Tealeaf
 */
public class LoadedQuests {

	// Quest(String name, List<QuestVersion> versions, String flagging, boolean isRaid, String pack)

	public static List<Quest> getQuests() {
		List<Quest> r = new ArrayList<>();

		r.add(new Quest("A Vision of Destruction", Collections.singletonList(new QuestVersion(LevelRange.HEROIC, 18)), "No Flagging Required", true, "The Vale of Twilight"));
		r.add(new Quest("Ascension Chamber", Collections.singletonList(new QuestVersion(LevelRange.HEROIC, 17)), "A Complete Sigil, and completion of the 4 Litany paths", true, "The Necropolis, Part 4"));
		r.add(new Quest("Caught in the Web", Collections.singletonList(new QuestVersion(LevelRange.EPIC, 24, 20, 30)), "Eveningstar Chains 1-3", true, "Menace of the Underdark"));
		r.add(new Quest("Defiler of the Just", Collections.singletonList(new QuestVersion(LevelRange.LEGENDARY, 30)), "Archons Trial, Demon Assault, and Devil's Details", true, "Trials of the Archons"));
		r.add(new Quest("Fire on Thunder Peak", Collections.singletonList(new QuestVersion(LevelRange.EPIC, 30)), "Defeat Dagan in Thunderholme Slayer Area", true, "Shadow Under Thunderholme"));
		r.add(new Quest("Hound of Xoriat", Arrays.asList(new QuestVersion(LevelRange.HEROIC, 18), new QuestVersion(LevelRange.LEGENDARY, 32)), "No Flagging Required", true, "The Vale of Twilight"));
		r.add(new Quest("Killing Time", Collections.singletonList(new QuestVersion(LevelRange.LEGENDARY, 32)), "Minimum Level 28", true, "Dragonblood Prophecy"));
		r.add(new Quest("Tempest Spine", Arrays.asList(new QuestVersion(LevelRange.HEROIC, 10), new QuestVersion(LevelRange.LEGENDARY, 32, 20, 30)), "No Flagging", true, "Free to Play"));
		r.add(new Quest("Old Baba's Hut", Collections.singletonList(new QuestVersion(LevelRange.LEGENDARY, 32)), "Into the Mists", true, "Mists of Ravenloft"));
		r.add(new Quest("Project Nemesis", Collections.singletonList(new QuestVersion(LevelRange.LEGENDARY, 32)), "Access to Alcorin's Forge", true, "Masterminds of Sharn"));
		r.add(new Quest("Riding the Storm Out", Collections.singletonList(new QuestVersion(LevelRange.LEGENDARY, 32)), "Minimum Level 28", true, "Dragonblood Prophecy"));
		r.add(new Quest("The Temple of Deathwyrm", Collections.singletonList(new QuestVersion(LevelRange.LEGENDARY, 30, 20, 30)), "Defeat Sarva Bellistrae in Thunderholme Slayer", true, "Shadow Under Thunderholme"));
		r.add(new Quest("The Chronoscope", Arrays.asList(new QuestVersion(LevelRange.HEROIC, 6), new QuestVersion(LevelRange.EPIC, 21)), "No Flagging", true, "Devil Assault"));
		r.add(new Quest("The Codex and the Shroud", Collections.singletonList(new QuestVersion(LevelRange.LEGENDARY, 32)), "To Curse the Sky & Creeping Death", true, "The Vale of Twilight"));
		r.add(new Quest("The Curse of Strahd", Collections.singletonList(new QuestVersion(LevelRange.LEGENDARY, 32)), "Ravenloft Chains 1-3 In Order", true, "Mists of Ravenloft"));
		r.add(new Quest("The Fall of Truth", Collections.singletonList(new QuestVersion(LevelRange.EPIC, 25)), "Gianthold Flagging Quests", true, "Ruins of Gianthold"));
		r.add(new Quest("The Lord of Blades", Arrays.asList(new QuestVersion(LevelRange.HEROIC, 20, 18, 20), new QuestVersion(LevelRange.EPIC, 22)), "Blown to Bits, Power Play, and Schemes of the Enemy", true, "Secrets of the Artificers"));
		r.add(new Quest("The Mark of Death", Collections.singletonList(new QuestVersion(LevelRange.LEGENDARY, 30)), "Epic Necropolis IV Quests", true, "The Necropolis, Part 4"));
		r.add(new Quest("The Master Artificer", Arrays.asList(new QuestVersion(LevelRange.HEROIC, 19, 17, 20), new QuestVersion(LevelRange.EPIC, 22)), "Blown to Bits, Power Play, and Schemes of the Enemy", true, "Secrets of the Artificers"));
		r.add(new Quest("The Reaver's Fate", Collections.singletonList(new QuestVersion(LevelRange.HEROIC, 14)), "Gianthold Flagging Quests", true, "Ruins of Gianthold"));
		r.add(new Quest("The Shroud", Collections.singletonList(new QuestVersion(LevelRange.HEROIC, 17)), "All Vale walkup quests, Completed Shavarath Signet Stone", true, "The Vale of Twilight"));
		r.add(new Quest("The Titan Awakes", Collections.singletonList(new QuestVersion(LevelRange.HEROIC, 12)), "Complete The Twilight Forge raid", true, "The Restless Isles"));
		r.add(new Quest("The Twilight Forge", Collections.singletonList(new QuestVersion(LevelRange.HEROIC, 11)), "Completed Sigil of Dal Quor", true, "The Restless Isles"));
		r.add(new Quest("The Vault Iof Night", Arrays.asList(new QuestVersion(LevelRange.HEROIC, 10), new QuestVersion(LevelRange.EPIC, 22)), "Vault of Night Quests (1-4)", true, "Vault of Night"));
		r.add(new Quest("Too Hot to Handle", Collections.singletonList(new QuestVersion(LevelRange.LEGENDARY, 32)), "Sharn Chains 1-2 (Clifftop)", true, "Masterminds of Sharn"));
		r.add(new Quest("Tower of Dispair", Collections.singletonList(new QuestVersion(LevelRange.HEROIC, 20, 18, 20)), "Complicated, See Wiki", true, "The Devils of Shavarath"));
		r.add(new Quest("Zawabis Refuge", Arrays.asList(new QuestVersion(LevelRange.HEROIC, 12), new QuestVersion(LevelRange.EPIC, 22)), "Items from Quests", true, "Demon Sands"));


		return r;
	}
}
