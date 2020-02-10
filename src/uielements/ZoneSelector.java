package uielements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Selector for specific Time Zones
 *
 * @author Tealeaf
 */
public class ZoneSelector extends VBox {
	
	/*
	Plan: Have a search-bar on top, underneath is a scrollpane with separate entries and each one has a
	check box and the time zone
	 */

	private FlowPane zoneDisplay = new FlowPane();

	private TextField textField;
	private ScrollPane scrollPane;
	private VBox list;

	private ObservableList<ZoneId> zones;

	public ZoneSelector() {
		this(Arrays.asList(ZoneId.systemDefault()));
	}

	public ZoneSelector(List<ZoneId> Ids) {
		super();
		textField = new TextField();
		scrollPane = new ScrollPane();
		zones = FXCollections.observableArrayList(Ids);

		list = new VBox();
		list.setSpacing(10);

		updateList("");

		this.getChildren().addAll(textField, scrollPane);
	}

	private void updateList(String filter) {
		list.getChildren().clear();
		for (ZoneId id : zones) { // LIST ALL ZONES IN HEREEEEE
			//TODO if filter
			CheckBox checkbox = new CheckBox(id.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
			checkbox.setSelected(zones.contains(id));
			checkbox.selectedProperty().addListener((e, o, n) -> {
				zones.remove(id);
				if (n) zones.add(id);
			});
			list.getChildren().add(checkbox);
		}
	}
}
