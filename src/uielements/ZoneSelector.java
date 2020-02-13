package uielements;

import classes.Zone;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

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

    //private ObservableList<Zone> zones;

    //private static List<ZoneId> allZones = Arrays.asList(ZoneId.)\

    private ObservableList<Zone> zones;

    public ZoneSelector() {
        super();

    }
}
