package classes;

import java.io.IOException;
import java.nio.file.Files;

import application.Data;

public class Settings {

	public Settings() {}

	public static boolean startMaximized = true;

	public static void loadSettings() {

		try {
			Data.staticJSON.fromJson(Files.newBufferedReader(Data.getAppFile(true, "Settings.json").toPath()), Settings.class);
		} catch(IOException e) {}

		save();
	}

	public static void save() {
		Data.writeFile(Data.getAppFile(true, "Settings.json"), Data.staticJSON.toJson(new Settings()));
	}
}
