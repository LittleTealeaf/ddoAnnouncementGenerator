package ui;

import java.time.LocalDateTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;

/**
 * A Combo of a date picker and a time picker
 * @author Tealeaf
 *
 */
public class DateTimePicker extends HBox {
	
	private final ObjectProperty<LocalDateTime> dateTime = new SimpleObjectProperty<LocalDateTime>(this, "Date Time", LocalDateTime.now());
	
	private DatePicker date;
	private TimePicker time;
	
	public DateTimePicker() {
		super();
		date = new DatePicker();
		date.setValue(dateTime.getValue().toLocalDate());
		date.valueProperty().addListener((e,o,n) -> updateDateTime());
		
		time = new TimePicker(dateTime.getValue().toLocalTime());
		time.valueProperty().addListener((e,o,n) -> updateDateTime());
		
		this.getChildren().addAll(date,time);
		this.setSpacing(10);
	}
	
	private void updateDateTime() {
		dateTime.setValue(time.getValue().atDate(date.getValue()));
	}
	
	public ObjectProperty<LocalDateTime> getValueProperty() {
		return dateTime;
	}
}
