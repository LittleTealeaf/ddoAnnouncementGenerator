package uielements;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * A Combo of a date picker and a time picker
 *
 * @author Tealeaf
 *
 */
public class DateTimePicker extends HBox {


	//Zoned Time property
	private final ObjectProperty<ZonedDateTime> zonedTime = new SimpleObjectProperty<>(this, "Date Time");

	private final DatePicker date;
	private TimePicker time;

	/**
	 * Creates an empty {@code DateTimePicker}, using the System Default
	 * <p>Uses {@link ZoneId#systemDefault()} as the pre-set Time
	 *
	 * @see ZoneId
	 * @see LocalDateTime
	 */
	public DateTimePicker() {
		this(LocalDateTime.now().atZone(ZoneId.systemDefault()));
	}

	/**
	 * Creates an empty {@code DateTimePicker}, using a set {@code ZonedDateTime}
	 * @param zonedTime - The {@link ZonedDateTime} to initialize the selector with
	 * @see ZonedDateTime
	 */
	public DateTimePicker(ZonedDateTime zonedTime) {
		super();

		this.zonedTime.setValue(zonedTime);

		date = new DatePicker();
		date.setValue(zonedTime.toLocalDate());
		date.valueProperty().addListener((e, o, n) -> updateDateTime());

		time = new TimePicker(LocalDateTime.ofInstant(this.zonedTime.getValue().toInstant(), ZoneId.systemDefault()).toLocalTime());
		time.valueProperty().addListener((e, o, n) -> updateDateTime());

		this.getChildren().addAll(date, time);
		this.setSpacing(10);
	}

	/*
	 * Updates the date time
	 */
	private void updateDateTime() {
		zonedTime.setValue(time.getValue().atDate(date.getValue()).atZone(ZoneId.systemDefault()));
	}

	public ObjectProperty<ZonedDateTime> valueProperty() {
		return zonedTime;
	}

	public ZonedDateTime getValue() {
		return zonedTime.getValue();
	}

	public void setValue(ZonedDateTime time) {
		zonedTime.setValue(time);
		date.setValue(time.toLocalDate());
		this.time = new TimePicker(LocalDateTime.ofInstant(this.zonedTime.getValue().toInstant(), ZoneId.systemDefault()).toLocalTime());
		this.getChildren().set(1, this.time);
	}
}
