package classes;

import java.io.IOException;
import java.nio.file.Files;

import application.System;

public class Settings {

	public Settings() {
	}

	public static void loadSettings() {

		try {
			System.staticJSON.fromJson(Files.newBufferedReader(System.getAppFile("Settings.json").toPath()), Settings.class);
		} catch(IOException e) {}

	}
}
