package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import javafx.scene.image.Image;
import net.harawata.appdirs.AppDirsFactory;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonParseException;

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

	/**
	 * Create a gson builder that registers required classes
	 * 
	 * <br>
	 * <br>
	 * Registered Classes:
	 * <ul>
	 * <li>{@link LocalDate}</li>
	 * <li>{@link LocalDateTime}</li>
	 * </ul>
	 * 
	 * @author Tealeaf
	 * @author Initial format referenced from
	 *         <a href="https://www.javaguides.net/2019/11/gson-localdatetime-localdate.html">Ramesh
	 *         Fadatare</a>
	 * @return A {@link GsonBuilder} that registers the classes
	 */
	private static GsonBuilder createBuilder() {
		GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

		//
		gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());

		gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());

		gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());

		gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

		gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer());

		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());

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
	 * Serializer for the LocalDate class
	 * 
	 * @author <a href="https://www.javaguides.net/2019/11/gson-localdatetime-localdate.html">Ramesh
	 *         Fadatare (Source Link)</a>
	 * @see LocalDate
	 */
	static class LocalDateSerializer implements JsonSerializer<LocalDate> {

		private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

		@Override
		public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context) {
			return new JsonPrimitive(formatter.format(localDate));
		}
	}

	/**
	 * Deserializer for the LocalDate class
	 * 
	 * @author <a href="https://www.javaguides.net/2019/11/gson-localdatetime-localdate.html">Ramesh
	 *         Fadatare (Source Link)</a>
	 * @see LocalDate
	 */
	static class LocalDateDeserializer implements JsonDeserializer<LocalDate> {

		@Override
		public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			return LocalDate.parse(json.getAsString(), DateTimeFormatter.ofPattern("d-MMM-yyyy").withLocale(Locale.ENGLISH));
		}
	}

	/**
	 * Serializer for the LocalDateTime class
	 * 
	 * @author <a href="https://www.javaguides.net/2019/11/gson-localdatetime-localdate.html">Ramesh
	 *         Fadatare (Source Link)</a>
	 * @see LocalDateTime
	 */
	static class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {

		private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss");

		@Override
		public JsonElement serialize(LocalDateTime localDateTime, Type srcType, JsonSerializationContext context) {
			return new JsonPrimitive(formatter.format(localDateTime));
		}
	}

	/**
	 * Deserializer for the LocalDateTime class
	 * 
	 * @author <a href="https://www.javaguides.net/2019/11/gson-localdatetime-localdate.html">Ramesh
	 *         Fadatare (Source Link)</a>
	 * @see LocalDateTime
	 */
	static class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

		@Override
		public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			return LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss").withLocale(Locale.ENGLISH));
		}
	}

	/**
	 * Deserializer for the Date class
	 * 
	 * @author <a href=
	 *         "https://makeinjava.com/date-serialization-deserialization-pojo-json-gson-example/">Source</a>
	 *
	 */
	static class DateDeserializer implements JsonDeserializer<Date> {

		public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			return json == null ? null : new Date(json.getAsLong());
		}
	}

	/**
	 * Serializer for the Date class
	 * 
	 * @author <a href=
	 *         "https://makeinjava.com/date-serialization-deserialization-pojo-json-gson-example/">Source</a>
	 *@author Implemented and Edited by Tealeaf
	 *
	 */
	static class DateSerializer implements JsonSerializer<Date> {

		@Override
		public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
			return date == null ? null : new JsonPrimitive(date.getTime());
		}
	}
}
