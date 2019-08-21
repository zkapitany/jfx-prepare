package hu.definition.elokeszito.view;

import java.io.File;

import hu.definition.elokeszito.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class RootLayoutController {

	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void handleNew() {
		mainApp.getProjektData().clear();
		mainApp.getHrszList().clear();
		mainApp.setProjektFilePath(null);
		mainApp.setHrszFilePath(null);
		
	}
	
	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
		
		int lastDot = file.getPath().lastIndexOf('.');
    	String nameOnly = file.getPath().substring(0,lastDot);

		File hrszFile= new File(nameOnly + "-hrsz.xml");

		if (file != null) {
			mainApp.loadProjektDataFromFile(file);
			mainApp.loadHrszDataFromFile(hrszFile);
		}
		
	}
	



	@FXML
	private void handleSaveAll() {
		File projektFile = mainApp.getProjektFilePath();
		
		if (projektFile != null) {
			mainApp.saveProjektDataToFile(projektFile);
		} 

		File hrszFile = mainApp.getHrszFilePath();
		
		if (hrszFile != null) {
			mainApp.saveHrszDataToFile(hrszFile);
		} 
	}
	
	
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
		
		int lastDot = file.getPath().lastIndexOf('.');
    	String nameOnly = file.getPath().substring(0,lastDot);

		File hrszFile= new File(nameOnly + "-hrsz.xml");

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainApp.saveProjektDataToFile(file);
			mainApp.saveHrszDataToFile(hrszFile);
		}
		
	}
	


	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Elõkészítõ Eljárás");
		alert.setHeaderText("About");
		alert.setContentText("Author: Marco Jakob & Kapitány Zoltán\nWebsite: http://www.definition.hu");

		alert.showAndWait();
	}

	@FXML
	private void handleExit() {
		System.exit(0);
	}
}
