package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
 * @param <T>
 *
 */
public class Data<T> {

	/**
	 * The directory of the application local memory.<br>
	 * For example, on windows this is often referred to the {@code %appdata%} location
	 */
	private static String appDir = AppDirsFactory.getInstance().getUserDataDir("DDO Announcement Generator", "", "Tealeaf", true);

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
	 * Initializes the {@link staticJSON} and {@link objectJSON} objects
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
		if(create) f.getParentFile().mkdirs();
		return f;
	}
	
	//TODO move all these methods to other programs
	
	public static String serializeObject(Object src) {
		return objectJSON.toJson(src);
	}

	
	public static Object deserializeObject(String json, Type Class) {
		return objectJSON.fromJson(json,Class.getClass());
	}
	
	public static String serializeClass(Object src) {
		return staticJSON.toJson(src);
	}
	
	public static Object deserializeClass(String json, Type Class) {
		return staticJSON.fromJson(json, Class.getClass());
	}
	
	public static Object deserializeClass(BufferedReader reader, Type Class) {
		return staticJSON.fromJson(reader, Class.getClass());
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
	 * Create a gson builder with pre-set configuration
	 * <p>
	 * <b>Registered Classes:</b>
	 * <ul>
	 * <li>{@link ZoneId}</li>
	 * </ul>
	 * 
	 * @return A {@link GsonBuilder}
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

				private String id;

				public Converter(ZoneId z) {
					this.id = z.getId();
				}
			}
		}

		// TODO do I really need the LocalDateTimeAdapter?
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
