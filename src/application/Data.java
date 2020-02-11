package application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import javafx.scene.image.Image;
import net.harawata.appdirs.AppDirsFactory;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
	private static final String appDir = AppDirsFactory.getInstance().getUserDataDir("DDO Announcement Generator", "", "Tealeaf", true);

	/**
	 * A {@code JSON} reader and writer that reads and writes static variables as well as non-static
	 * variables
	 */
	private static Gson staticJSON;
	/**
	 * A {@code JSON} reader and writer that reads and writes regular non-static variables
	 */
	private static Gson objectJSON;

	/**
	 * Initializes the {@link Data#staticJSON} and {@link Data#objectJSON} objects
	 * <p>
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
	 * <p>
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
	 * <p>
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
		if (create && f.getParentFile().mkdirs()) System.out.println("Created Parent Directory of " + f.getPath());
		return f;
	}

	// TODO move all these methods to other programs

	/**
	 * Serializes an object into a {@code JSON} String
	 * 
	 * @param src Object to serialize
	 * @return {@code JSON} String equivalent of that object
	 */
	public static String serializeObject(Object src) {
		return objectJSON.toJson(src);
	}

	/**
	 * Deserializes an object from a {@code JSON} string to the respective Object
	 * 
	 * @param json  The {@code JSON} string to deserialize
	 * @param Class The Class of the object to deserialize. Ex: {@code Settings.class}
	 * @return The Object, of the given {@code Class} from the serialized data
	 */
	public static Object deserializeObject(String json, Type Class) {
		return objectJSON.fromJson(json, Class);
	}

	/**
	 * Serializes an object with static variables
	 * 
	 * @param src Object to serialize
	 * @return {@code JSON} String equivalent of that class
	 */
	public static String serializeClass(Object src) {
		return staticJSON.toJson(src);
	}

	/**
	 * Deserializes an object from a {@code JSON} string to the respective Object, including any static
	 * variables
	 * <p>
	 * Static variables will be set, so there is no need to do anything with the return value if all you
	 * need is the static variables
	 * 
	 * @param json  The {@code JSON} string to deserialize, incuding static variables
	 * @param Class The Class of the object to deserialize. Ex: {@code Settings.class}
	 * @return Object of the serialized class
	 */
	public static Object deserializeClass(String json, Type Class) {
		return staticJSON.fromJson(json, Class);
	}

	/**
	 * Deserializes an object from a {@code JSON} string to the respective Object, including any static
	 * variables
	 * <p>
	 * Static variables will be set, so there is no need to do anything with the return value if all you
	 * need is the static variables
	 *
	 * @param reader The {@link BufferedReader Buffered Reader} to read the json from
	 * @param Class  The Class of the object to deserialize. Ex: {@code Settings.class}
	 * @return Object of the serialized class
	 */
	@SuppressWarnings ("UnusedReturnValue")
	public static Object deserializeClass(BufferedReader reader, Type Class) {
		return staticJSON.fromJson(reader, Class);
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
		} catch(Exception ignored) {}

	}

	/**
	 * Create a {@code GSON} builder with pre-set configuration
	 * <p>
	 * <b>Registered Classes:</b>
	 * <ul>
	 * <li>{@link ZoneId}</li>
	 * <li>{@link ZonedDateTime}</li>
	 * <li>{@link LocalDateTime}</li>
	 * </ul>
	 * 
	 * @return A pre-generated {@link GsonBuilder}
	 */
	private static GsonBuilder createBuilder() {
		GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

		gsonBuilder.registerTypeHierarchyAdapter(ZoneId.class, new GsonAdapters.ZoneIdAdapter());
		gsonBuilder.registerTypeHierarchyAdapter(LocalDateTime.class, new GsonAdapters.LocalDateTimeAdapter());
		gsonBuilder.registerTypeHierarchyAdapter(ZonedDateTime.class, new GsonAdapters.ZonedDateTimeAdapter());

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
		 * Adapter for the {@code ZoneId} class
		 * 
		 * @author Tealeaf
		 * @see ZoneId
		 */
		public static class ZoneIdAdapter extends TypeAdapter<ZoneId> {

			@Override
			public void write(JsonWriter out, ZoneId value) throws IOException {

				if(value == null) {
					out.nullValue();
				} else {
					out.value(new Converter(value).id);
				}

			}

			@Override
			public ZoneId read(JsonReader in) throws IOException {

				if(in.peek() == JsonToken.NULL) {
					in.nextNull();
					return null;
				}

				String id = in.nextString();
				return ZoneId.of(id);
			}

			private static class Converter {

				private final String id;

				public Converter(ZoneId z) {
					this.id = z.getId();
				}
			}
		}

		/**
		 * Adapter for the {@code LocalDateTime} class
		 * 
		 * @author Tealeaf
		 * @see LocalDateTime
		 */
		public static class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

			private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu HH:mm:ss");

			@Override
			public void write(JsonWriter out, LocalDateTime value) throws IOException {

				if(value == null) {
					out.nullValue();
				} else {
					out.value(formatter.format(value));
				}

			}

			@Override
			public LocalDateTime read(JsonReader in) throws IOException {

				if(in.peek() == JsonToken.NULL) {
					in.nextNull();
					return null;
				}

				return LocalDateTime.parse(in.nextString(), formatter.withLocale(Locale.ENGLISH));
			}
		}

		/**
		 * Adapter for the {@code ZonedDateTime} class
		 * 
		 * @author Tealeaf
		 * @see ZonedDateTime
		 */
		public static class ZonedDateTimeAdapter extends TypeAdapter<ZonedDateTime> {

			@Override
			public void write(JsonWriter out, ZonedDateTime value) throws IOException {

				if(value == null) {
					out.nullValue();
				} else {
					out.value(value.toString());
				}

			}

			@Override
			public ZonedDateTime read(JsonReader in) throws IOException {

				if(in.peek() == JsonToken.NULL) {
					in.nextNull();
					return null;
				}

				return ZonedDateTime.parse(in.nextString());
			}
		}
	}
}
