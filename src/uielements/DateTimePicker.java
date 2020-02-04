package uielements;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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

	private final ObjectProperty<ZonedDateTime> zonedTime = new SimpleObjectProperty<ZonedDateTime>(this, "Date Time");

	private DatePicker date;
	private TimePicker time;

	public DateTimePicker() {
		this(LocalDateTime.now().atZone(ZoneId.systemDefault()));
	}

	public DateTimePicker(ZonedDateTime zonedTime) {
		super();

		this.zonedTime.setValue(zonedTime);

		date = new DatePicker();
		date.setValue(LocalDate.now());
		date.valueProperty().addListener((e, o, n) -> updateDateTime());

		time = new TimePicker(LocalDateTime.ofInstant(this.zonedTime.getValue().toInstant(), ZoneId.systemDefault()).toLocalTime());
		time.valueProperty().addListener((e, o, n) -> updateDateTime());

		this.getChildren().addAll(date, time);
		this.setSpacing(10);
	}

	/**
	 * Updates the zoned time
	 */
	private void updateDateTime() {
		zonedTime.setValue(time.getValue().atDate(date.getValue()).atZone(ZoneId.systemDefault()));
	}

	public ObjectProperty<ZonedDateTime> getValueProperty() {
		return zonedTime;
	}
}
