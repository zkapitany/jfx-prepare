package hu.definition.elokeszito.view;

import hu.definition.elokeszito.MainApp;
import hu.definition.elokeszito.model.Hrsz;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TabHrszController {
	
	@FXML
	private TextField filterField;
	
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
	private Label hrszHanyadLabel;
	@FXML
	private Label hrszVarosLabel;
	@FXML
	private Label hrszUtcaLabel;
	@FXML
	private Label hrszBesorolasLabel;
	@FXML
	private Label tulajdonosNevLabel;
	@FXML
	private Label tulajdonosHrszLabel;
	@FXML
	private Label tulajdonosVarosLabel;
	@FXML
	private Label tulajdonosUtcaLabel;
	@FXML
	private Label tulajdonosCimLabel;

	// Reference to the main application.
	private MainApp mainApp;

	public TabHrszController() {
	}

	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		hrszColumn.setCellValueFactory(cellData -> cellData.getValue().hrszSzamProperty());
		tulajdonosColumn.setCellValueFactory(cellData -> cellData.getValue().tulajdonosCimProperty());
		hanyadColumn.setCellValueFactory(cellData -> cellData.getValue().hrszHanyadProperty());
		
		// Clear person details.
	    showHrszDetails(null);

	    // Listen for selection changes and show the person details when changed.
	    hrszTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showHrszDetails(newValue));
	    
	    //Sorting and filtering
	    // 1. Wrap the ObservableList in a FilteredList (initially display all data).
//	 		FilteredList<Hrsz> filteredData = new FilteredList<>(, p -> true);
	    
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
	        hrszSzamLabel.setText(hrsz.getHrszSzam());
	        hrszHanyadLabel.setText(hrsz.getHrszHanyad());
	        hrszVarosLabel.setText(hrsz.getHrszVaros());
	        hrszUtcaLabel.setText(hrsz.getHrszUtca());
	        hrszBesorolasLabel.setText(hrsz.getHrszBesorolas());
	        tulajdonosNevLabel.setText(hrsz.getTulajdonosNev());
	        tulajdonosHrszLabel.setText(hrsz.getTulajdonosHrsz());
	        tulajdonosVarosLabel.setText(hrsz.getTulajdonosVaros());
	        tulajdonosUtcaLabel.setText(hrsz.getTulajdonosUtca());
	        tulajdonosCimLabel.setText(hrsz.getTulajdonosCim());
	        

	    } else {
	    	hrszSzamLabel.setText("");
	    	hrszHanyadLabel.setText("");
	        hrszVarosLabel.setText("");
	        hrszUtcaLabel.setText("");
	        hrszBesorolasLabel.setText("");
	        tulajdonosNevLabel.setText("");
	        tulajdonosHrszLabel.setText("");
	        tulajdonosVarosLabel.setText("");
	        tulajdonosUtcaLabel.setText("");
	        tulajdonosCimLabel.setText("");
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
