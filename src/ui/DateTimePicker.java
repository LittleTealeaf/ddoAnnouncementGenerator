package ui;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;

/**
 * A Combo of a date picker and a time picker
 * 
 * @author Tealeaf
 *
 */
public class DateTimePicker extends HBox {

	private final ObjectProperty<Date> dateTime = new SimpleObjectProperty<Date>(this, "Date Time", Date.from(Instant.now()));

	private DatePicker date;
	private TimePicker time;

	public DateTimePicker() {
		super();
		date = new DatePicker();
		date.setValue(LocalDate.now());
		date.valueProperty().addListener((e, o, n) -> updateDateTime());

		time = new TimePicker(LocalDateTime.ofInstant(dateTime.getValue().toInstant(), ZoneId.systemDefault()).toLocalTime());
		time.valueProperty().addListener((e, o, n) -> updateDateTime());

		this.getChildren().addAll(date, time);
		this.setSpacing(10);
	}

	private void updateDateTime() {
		// dateTime.setValue(time.getValue().atDate(date.getValue()));
		dateTime.setValue(Date.from(time.getValue().atDate(date.getValue()).atZone(ZoneId.systemDefault()).toInstant()));
	}

	public ObjectProperty<Date> getValueProperty() {
		return dateTime;
	}
}
