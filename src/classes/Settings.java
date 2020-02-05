package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import application.Data;

/**
 * A Class that describes any user-based settings.<br>
 * Settings are saved in the user's app directory. <br>
 * <p>
 * <b>Settings:</b>
 * <ul>
 * <li>{@link #startMaximized}</li>
 * <li>{@link #showSeconds}</li>
 * </ul>
 * 
 * @author Tealeaf
 *
 */
public class Settings {

	public Settings() {}

	/**
	 * Whether or not to start the application in Maximized mode
	 */
	public static boolean startMaximized = true;

	/**
	 * Whether to include seconds in the announcements
	 */
	public static boolean showSeconds = false;

	/**
	 * Default list of {@code ZoneId} to include
	 * @see ZoneId
	 */
	public static List<ZoneId> defaultZones = Arrays.asList(ZoneId.systemDefault());

	/**
	 * Initially loads the settings
	 */
	public static void loadSettings() {

		try {
			// Uses a static JSON to load the contents from the settings file, if it exists
			Data.deserializeClass(Files.newBufferedReader(Data.getAppFile(true, "Settings.json").toPath()), Settings.class);
		} catch(IOException e) {}

		save();
	}

	/**
	 * Saves the settings
	 */
	public static void save() {
		Data.writeFile(Data.getAppFile(true, "Settings.json"), Data.serializeClass(new Settings()));
	}
}
