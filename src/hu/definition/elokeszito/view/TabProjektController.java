package hu.definition.elokeszito.view;

import hu.definition.elokeszito.MainApp;
import hu.definition.elokeszito.model.ProjectData;
import hu.definition.elokeszito.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TabProjektController {

	@FXML
	private TableView<ProjectData> projektTable;
	@FXML
	private TableColumn<ProjectData, String> projektCimColumn;
	@FXML
	private TableColumn<ProjectData, String> projektRovidCimColumn;

	@FXML
	private Label projektCimLabel;	
	@FXML
	private Label projektRovidCimLabel;
	@FXML
	private Label munkaSzamLabel;
	@FXML
	private Label rajzSzamLabel;
	@FXML
	private Label iktatoSzamLabel;
	@FXML
	private Label seplandSzamLabel;
	@FXML
	private Label pmhCimLabel;
	@FXML
	private Label ugyintezoNevLabel;
	@FXML
	private Label ugyintezoTelefonLabel;
	@FXML
	private Label maiDatumLabel;

	private MainApp mainApp;

	public TabProjektController() {
	}

	@FXML
	private void initialize() {
		// Initialize the projekt table with the two columns.
	    projektCimColumn.setCellValueFactory(cellData -> cellData.getValue().projektCimProperty());
	    projektRovidCimColumn.setCellValueFactory(cellData -> cellData.getValue().projektRovidCimProperty());
	    
	    showProjektDetail(null);

	    projektTable.getSelectionModel().selectedItemProperty().addListener(
	    		(observable, oldValue, newValue) -> showProjektDetail(newValue)
	    		);
	}
	

	public void setMain(MainApp mainApp) {
		this.mainApp = mainApp;

		projektTable.setItems(mainApp.getProjektData());
	}
	
	
	private void showProjektDetail(ProjectData projektData) {
	    if (projektData != null) {
	        projektCimLabel.setText(projektData.getProjektCim());
	        projektRovidCimLabel.setText(projektData.getProjektRovidCim());
	        munkaSzamLabel.setText(projektData.getMunkaSzam());
	        rajzSzamLabel.setText(projektData.getRajzSzam());
	        iktatoSzamLabel.setText(projektData.getIktatoSzam());
	        seplandSzamLabel.setText(projektData.getSeplandSzam());
	        pmhCimLabel.setText(projektData.getPmhCim());
	        ugyintezoNevLabel.setText(projektData.getUgyintezoNev());
	        ugyintezoTelefonLabel.setText(projektData.getUgyintezoTelefon());
	        maiDatumLabel.setText(projektData.getMaiDatum());

	    } else {
	        projektCimLabel.setText("");
	        projektRovidCimLabel.setText("");
	        munkaSzamLabel.setText("");
	        rajzSzamLabel.setText("");
	        iktatoSzamLabel.setText("");
	        seplandSzamLabel.setText("");
	        pmhCimLabel.setText("");
	        ugyintezoNevLabel.setText("");
	        ugyintezoTelefonLabel.setText("");
	        maiDatumLabel.setText("");

	    }
	}
	
	@FXML
	private void handleDeleteProjekt() {
	    int selectedIndex = projektTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        projektTable.getItems().remove(selectedIndex);
	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Projekt Selected");
	        alert.setContentText("Please select a projekt in the table.");

	        alert.showAndWait();
	    }
	}
	

	@FXML
	private void handleNewProjekt() {
	    ProjectData tempData = new ProjectData();
	    boolean okClicked = mainApp.showProjektDialog(tempData);
	    if (okClicked) {
	        mainApp.getProjektData().add(tempData);
	    }
	}

	
	@FXML
	private void handleEditProjekt() {
	    ProjectData selectedData = projektTable.getSelectionModel().getSelectedItem();
	    if (selectedData != null) {
	        boolean okClicked = mainApp.showProjektDialog(selectedData);
	        if (okClicked) {
	            showProjektDetail(selectedData);
	        }

	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Projekt Selected");
	        alert.setContentText("Please select a projekt in the table.");

	        alert.showAndWait();
	    }
	}

}
