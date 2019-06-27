package hu.definition.elokeszito.view;

import hu.definition.elokeszito.MainApp;
import hu.definition.elokeszito.model.Hrsz;
import hu.definition.elokeszito.model.Tulajdonos;
import javafx.fxml.FXML;
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
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		hrszTable.setItems(mainApp.getHrszList());
	}
}
