package classes;

import java.io.IOException;
import java.nio.file.Files;

import application.Data;

/**
 * A Class that describes any user-based settings.<br>
 * Settings are saved in the user's app directory. <br>
 * <br>
 * <b>Settings:</b><ul><li>{@link #startMaximized}</li></ul>
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
	 * Initially loads the settings
	 */
	public static void loadSettings() {

		try {
			//Uses a static JSON to load the contents from the settings file, if it exists
			Data.staticJSON.fromJson(Files.newBufferedReader(Data.getAppFile(true, "Settings.json").toPath()), Settings.class);
		} catch(IOException e) {}

		save();
	}

	/**
	 * Saves the settings
	 */
	public static void save() {
		Data.writeFile(Data.getAppFile(true, "Settings.json"), Data.staticJSON.toJson(new Settings()));
	}
}
