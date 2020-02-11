package uielements;

import classes.Zone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

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

	private ObservableList<Zone> zones;

	//private static List<ZoneId> allZones = Arrays.asList(ZoneId.)

	public ZoneSelector() {
		this(Arrays.asList(new Zone(ZoneId.systemDefault())));
	}

	public ZoneSelector(List<Zone> Ids) {
		super();
		textField = new TextField();
		scrollPane = new ScrollPane();
		zones = FXCollections.observableArrayList(Ids);

		list = new VBox();
		list.setSpacing(10);

		textField.textProperty().addListener((e, o, n) -> {
			updateList(n);
		});

		scrollPane.setContent(list);

		updateList("");

		this.getChildren().addAll(textField, scrollPane);
	}

	public ObservableList<Zone> zoneProperty() {
		return zones;
	}

	private void updateList(String filter) {
		list.getChildren().clear();
		for (Zone zone : Zone.allZones())
			if (zone.isFilter(filter)) { //Gets all zones that fit the filter
				CheckBox checkbox = new CheckBox(zone.getShortName() + " " + zone.getNarrowName() + " " + zone.getFullName() + " " + zone.getId());

				boolean isSelected = false;
				for (Zone a : zones) if (a.equals(zone)) isSelected = true;
				checkbox.setSelected(isSelected);
				//either make this into it's own method? or have it directly set the checkbox in "checkbox.setselected"

				checkbox.selectedProperty().addListener((e, o, n) -> {
					if (!n && zones.contains(zone)) zones.remove(zone);
					else if (!zones.contains(zone)) zones.add(zone);
				});

				list.getChildren().add(checkbox);
			}
	}
}
