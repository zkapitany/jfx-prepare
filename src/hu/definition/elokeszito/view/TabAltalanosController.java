package hu.definition.elokeszito.view;

import hu.definition.elokeszito.MainApp;
import hu.definition.elokeszito.model.AltalanosAdatok;
import hu.definition.elokeszito.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TabAltalanosController {

	@FXML
	private TableView<AltalanosAdatok> generalTable;
	@FXML
	private TableColumn<AltalanosAdatok, String> firstNameColumn;
	@FXML
	private TableColumn<AltalanosAdatok, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;	
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;

	private MainApp mainApp;

	public TabAltalanosController() {
	}

	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
	    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
	    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
	    
	    showPersonDetails(null);

	    generalTable.getSelectionModel().selectedItemProperty().addListener(
	    		(observable, oldValue, newValue) -> showPersonDetails(newValue)
	    		);
	}
	

	public void setMain(MainApp mainApp) {
		this.mainApp = mainApp;

		generalTable.setItems(mainApp.getGeneralData());
	}
	
	
	private void showPersonDetails(AltalanosAdatok generalData) {
	    if (generalData != null) {
	        firstNameLabel.setText(generalData.getFirstName());
	        lastNameLabel.setText(generalData.getLastName());
	        streetLabel.setText(generalData.getStreet());
	        postalCodeLabel.setText(Integer.toString(generalData.getPostalCode()));
	        cityLabel.setText(generalData.getCity());
	        birthdayLabel.setText(DateUtil.format(generalData.getBirthday()));

	    } else {
	        firstNameLabel.setText("");
	        lastNameLabel.setText("");
	        streetLabel.setText("");
	        postalCodeLabel.setText("");
	        cityLabel.setText("");
	        birthdayLabel.setText("");
	    }
	}
	
	@FXML
	private void handleDeletePerson() {
	    int selectedIndex = generalTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        generalTable.getItems().remove(selectedIndex);
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
	

	@FXML
	private void handleNewPerson() {
	    AltalanosAdatok tempAdatok = new AltalanosAdatok();
	    boolean okClicked = mainApp.showAltalanosDialog(tempAdatok);
	    if (okClicked) {
	        mainApp.getGeneralData().add(tempAdatok);
	    }
	}

	
	@FXML
	private void handleEditPerson() {
	    AltalanosAdatok selectedAdat = generalTable.getSelectionModel().getSelectedItem();
	    if (selectedAdat != null) {
	        boolean okClicked = mainApp.showAltalanosDialog(selectedAdat);
	        if (okClicked) {
	            showPersonDetails(selectedAdat);
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
