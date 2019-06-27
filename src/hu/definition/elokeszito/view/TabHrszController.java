package hu.definition.elokeszito.view;

import hu.definition.elokeszito.MainApp;
import hu.definition.elokeszito.model.Hrsz;
import hu.definition.elokeszito.model.Tulajdonos;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TabHrszController {
	@FXML
	private TableView<Hrsz> hrszTable;
	@FXML
	private TableColumn<Hrsz, String> hrszColumn;
	@FXML
	private TableColumn<Hrsz, String> tulajdonosColumn;
	@FXML
	private TableColumn<Hrsz, String> hanyadColumn;

	@FXML
	private Label hrszSzamLabel;
	@FXML
	private Label hrszVarosLabel;
	@FXML
	private Label hrszUtcaLabel;
	@FXML
	private Label hrszBesorolasLabel;
	@FXML
	private Label tulajdonosNevLabel;
	@FXML
	private Label tulajdonosCimLabel;
	@FXML
	private Label tulajdonosHanyadLabel;

	// Reference to the main application.
	private MainApp mainApp;

	public TabHrszController() {
	}

	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		hrszColumn.setCellValueFactory(cellData -> cellData.getValue().szamProperty());
		tulajdonosColumn.setCellValueFactory(cellData -> cellData.getValue().getTulajdonos().cimProperty());
		hanyadColumn.setCellValueFactory(cellData -> cellData.getValue().getTulajdonos().hanyadProperty());
		
		// Clear person details.
	    showHrszDetails(null);

	    // Listen for selection changes and show the person details when changed.
	    hrszTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showHrszDetails(newValue));
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		hrszTable.setItems(mainApp.getHrszList());
	}
	
	/**
	 * Fills all text fields to show details about the person.
	 * If the specified person is null, all text fields are cleared.
	 * 
	 * @param person the person or null
	 */
	private void showHrszDetails(Hrsz hrsz) {
	    if (hrsz != null) {
	        // Fill the labels with info from the person object.
	        hrszSzamLabel.setText(hrsz.getSzam());
	        hrszVarosLabel.setText(hrsz.getVaros());
	        hrszUtcaLabel.setText(hrsz.getUtca());
	        hrszBesorolasLabel.setText(hrsz.getBesorolas());
	        tulajdonosNevLabel.setText(hrsz.getTulajdonos().getNev());
	        tulajdonosCimLabel.setText(hrsz.getTulajdonos().getCim());
	        tulajdonosHanyadLabel.setText(hrsz.getTulajdonos().getHanyad());
	        

	    } else {
	    	hrszSzamLabel.setText("");
	        hrszVarosLabel.setText("");
	        hrszUtcaLabel.setText("");
	        hrszBesorolasLabel.setText("");
	        tulajdonosNevLabel.setText("");
	        tulajdonosCimLabel.setText("");
	        tulajdonosHanyadLabel.setText("");
	    }
	}
	
	@FXML
	private void handleDeleteHrsz() {
	    int selectedIndex = hrszTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        hrszTable.getItems().remove(selectedIndex);
	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Hrsz Selected");
	        alert.setContentText("Please select a hrsz. in the table.");

	        alert.showAndWait();
	    }
	}
	

	@FXML
	private void handleNewHrsz() {
	    Hrsz tempHrsz = new Hrsz();
	    boolean okClicked = mainApp.showHrszDialog(tempHrsz);
	    if (okClicked) {
	        mainApp.getHrszList().add(tempHrsz);
	    }
	}


	@FXML
	private void handleEditHrsz() {
	    Hrsz selectedHrsz = hrszTable.getSelectionModel().getSelectedItem();
	    if (selectedHrsz != null) {
	        boolean okClicked = mainApp.showHrszDialog(selectedHrsz);
	        if (okClicked) {
	            showHrszDetails(selectedHrsz);
	        }

	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Person Selected");
	        alert.setContentText("Please select a person in the table.");

	        alert.showAndWait();
	    }
	}
}
