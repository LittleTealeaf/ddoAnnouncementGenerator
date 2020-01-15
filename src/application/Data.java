package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.scene.image.Image;
import net.harawata.appdirs.AppDirsFactory;

/**
 * Class consisting of various functions pertaining to the system, including JSON readers/writers,
 * file locations, etc.
 * 
 * @author Tealeaf
 *
 */
public class Data {

	/**
	 * The directory of the application local memory.<br>
	 * For example, on windows this is often referred to the {@code %appdata%} location
	 */
	private static String appDir = AppDirsFactory.getInstance().getUserDataDir("DDO Announcement Generator", "", "Tealeaf", true);

	/**
	 * A {@code JSON} reader and writer that reads and writes static variables as well as non-static
	 * variables
	 */
	public static Gson staticJSON = new GsonBuilder().excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT).setPrettyPrinting().create();
	/**
	 * A {@code JSON} reader and writer that reads and writes regular non-static variables
	 */
	public static Gson objectJSON = new GsonBuilder().setPrettyPrinting().create();

	/**
	 * Returns the {@code File} depending on it's path in relation to the base directory
	 * 
	 * <br>
	 * <br>
	 * The base directory, when used here, describes the directory of the %appdata% location for this
	 * specific app, regardless of OS
	 * 
	 * @param path An array of strings representing the path an object takes from the base directory.
	 *             <br>
	 *             All the strings in the array are folders nested into eachother, except for the very
	 *             last one which is the file
	 *             <br>
	 *             For example, inputting {@code {"Data","File.txt"}} will return in the
	 *             {@code path + "\Data\File.txt"}
	 * @return File at that path
	 * @see #getAppFile(boolean, String...)
	 */
	public static File getAppFile(String... path) {
		return getAppFile(false, path);
	}

	/**
	 * Returns the {@code File} depending on it's path in relation to the base directory
	 * 
	 * <br>
	 * <br>
	 * The base directory, when used here, describes the directory of the {@code %appdata%} location for
	 * this specific app, regardless of OS
	 * 
	 * @param create Whether or not to create the path if it does not already exist
	 * @param path   An array of strings representing the path an object takes from the base directory.
	 *               <br>
	 *               All the strings in the array are folders nested into eachother, except for the very
	 *               last one which is the file
	 *               <br>
	 *               For example, inputting {@code {"Data","File.txt"} } will return in the
	 *               {@code path + "\Data\File.txt"}
	 * @return File at that path
	 * @see #getAppFile(String...)
	 */
	public static File getAppFile(boolean create, String... path) {
		File f = new File(java.nio.file.Paths.get(appDir, path).toString());
		if(create) f.getParentFile().mkdirs();
		return f;
	}

	/**
	 * Writes a set of data to a file
	 * 
	 * @param file {@link File} to write to
	 * @param data {@link String} of data to write in the file
	 */
	public static void writeFile(File file, String data) {

		try {
			FileWriter writer = new FileWriter(file);
			writer.write(data);
			writer.close();
		} catch(Exception e) {}

	}

	/**
	 * A categorization containing methods to read resources
	 * 
	 * @author Tealeaf
	 *
	 */
	public static class Resource {

		public static InputStream getInputStream(String name) {
			return ClassLoader.getSystemResourceAsStream(name);
		}

		public static BufferedReader getBufferedReader(String name) {
			return new BufferedReader(getInputStreamReader(name));
		}

		public static InputStreamReader getInputStreamReader(String name) {
			return new InputStreamReader(getInputStream(name));
		}

		public static Image getImage(String name) {
			return new Image(getInputStream(name));
		}
	}
}
