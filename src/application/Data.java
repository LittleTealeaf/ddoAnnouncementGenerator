package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

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
	public static Gson staticJSON;
	/**
	 * A {@code JSON} reader and writer that reads and writes regular non-static variables
	 */
	public static Gson objectJSON;

	/**
	 * Initializes the {@link staticJSON} and {@link objectJSON} objects
	 * <br>
	 * <br>
	 * <i>This method is the first thing to be called in the {@link Main} class, otherwise everything
	 * breaks</i>
	 */
	public static void load() {
		staticJSON = createBuilder().excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT).create();
		objectJSON = createBuilder().create();
	}

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

	// TODO update jdoc
	/**
	 * Create a gson builder with pre-set configuration
	 * <br>
	 * <br>
	 * <b>Registered Classes:</b>
	 * <ul>
	 * <li>{@link ZoneId}</li>
	 * </ul>
	 * 
	 * @return A {@link GsonBuilder}
	 */
	private static GsonBuilder createBuilder() {
		GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

		gsonBuilder.registerTypeHierarchyAdapter(ZoneId.class, new GsonAdapters.ZoneIdAdapter.Adapter());

		return gsonBuilder;
	}

	/**
	 * A categorization containing methods to read resources
	 * 
	 * @author Tealeaf
	 *
	 */
	public static class Resource {

		// TODO create the input stream
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

	/**
	 * A Categorization of all the GSON adapters
	 * 
	 * @author Tealeaf
	 *
	 */
	static class GsonAdapters {

		/**
		 * Classes for adapting the {@link ZoneId} Class
		 * 
		 * @author Tealeaf
		 *
		 */
		static public class ZoneIdAdapter {

			/**
			 * The specific adapter for the {@link ZoneId}
			 * 
			 * @author Tealeaf
			 *
			 */
			static public class Adapter extends TypeAdapter<ZoneId> {

				public ZoneId read(JsonReader reader) throws IOException {

					if(reader.peek() == JsonToken.NULL) {
						reader.nextNull();
						return null;
					}

					String id = reader.nextString();
					return ZoneId.of(id);
				}

				public void write(JsonWriter writer, ZoneId value) throws IOException {

					if(value == null) {
						writer.nullValue();
					} else {
						writer.value(new Zone(value).id);
					}

				}
			}

			/**
			 * A converter class used to store the {@link ZoneId#getId() Id} of the {@link ZoneId}
			 * 
			 * @author Tealeaf
			 *
			 */
			private static class Zone {

				private String id;

				public Zone(ZoneId z) {
					this.id = z.getId();
				}
			}
		}
	}
}
