package uielements;

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

    //private static List<ZoneId> allZones = Arrays.asList(ZoneId.)

    public ZoneSelector() {
        super();
        //this(Arrays.asList(new Zone(ZoneId.systemDefault())));
    }

//	public ZoneSelector(List<Zone> Ids) {
//		super();
//		textField = new TextField();
//		scrollPane = new ScrollPane();
//		//zones = FXCollections.observableArrayList(Ids);
//
//		list = new VBox();
//		list.setSpacing(10);
//
//		textField.textProperty().addListener((e, o, n) -> {
//			updateList(n);
//		});
//
//		scrollPane.setContent(list);
//
//		updateList("");
//
//		this.getChildren().addAll(textField, scrollPane);
//	}

//	public ObservableList<Zone> zoneProperty() {
//		return zones;
//	}
//
//	private void updateList(String filter) {
//		list.getChildren().clear();
//
//	}
}
