package hu.definition.elokeszito;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import hu.definition.elokeszito.model.Hrsz;
import hu.definition.elokeszito.model.ProjectData;
import hu.definition.elokeszito.model.ProjectDataWrapper;
import hu.definition.elokeszito.model.Tulajdonos;
import hu.definition.elokeszito.view.HrszDialogController;
import hu.definition.elokeszito.view.ProjektDialogController;
import hu.definition.elokeszito.view.RootLayoutController;
import hu.definition.elokeszito.view.TabHrszController;
import hu.definition.elokeszito.view.TabProjektController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane tabParentLayout;
	private ObservableList<ProjectData> projectData = FXCollections.observableArrayList();
	private ObservableList<Hrsz> hrszList = FXCollections.observableArrayList();
//	private ObservableList<Tulajdonos> tulajdonosList = FXCollections.observableArrayList();
	
	public MainApp() {
        // Add some sample data
        projectData.add(new ProjectData("McDonalds Gödöllõ", "Meki_new"));
        hrszList.add(new Hrsz("1724/5", "Vác", "Hunyadi u. 13.", "kivett út", new Tulajdonos("Kiss Péter", "Vác Dózsa Gy. út 58.", "1724/5", "1/2")));
        hrszList.add(new Hrsz("1724/5", "Vác", "Hunyadi u. 13.", "kivett út", new Tulajdonos("Nagy Ödön", "Pécel Keleti Gy. út 101.", "1724/5", "1/2")));
        hrszList.add(new Hrsz("6644/23", "Vác", "Ady Endre út 20.", "kivett közterület", new Tulajdonos("Váci Önkormányzat", "Ady Endre út 20.", "6644/23", "1/1")));
        hrszList.add(new Hrsz("82147/1", "Vác", "Bartók Béla u. 211/A.", "kivett malom", new Tulajdonos("Szabó László", "Bartók Béla u. 211/A.", "82147/1", "1/1")));

//        tulajdonosList.add(new Tulajdonos("Váci Önkormányzat", "Vác Dózsa Gy. út 58.", "1724/5", "1/1"));
        
    }

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Elõkészítõ Eljárás");
		
		this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));
		
		initTabParentLayout();
		showTabProjekt();
		showTabHrsz();
		showTabBeallitasok();
		
		
	}

	public void initTabParentLayout() {
		try {
			// Load TabParentLayout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			tabParentLayout = loader.load();

			// Show the Scene
			Scene scene = new Scene(tabParentLayout);
			primaryStage.setScene(scene);
			BorderPane root = (BorderPane) primaryStage.getScene().getRoot();
			
			// Give the controller access to the main app.
	        RootLayoutController controller = loader.getController();
	        controller.setMainApp(this);

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Try to load last opened projekt file.
	    File file = getProjektFilePath();
	    if (file != null) {
	        loadProjektDataFromFile(file);
	    }
	}

	public void showTabProjekt() {
		try {
			// Load Projekt TAB from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/TabProjekt.fxml"));
			AnchorPane TabProjektContent = loader.load();

			BorderPane tabBorderPane = (BorderPane) tabParentLayout.getChildren().get(1);
			TabPane tabPane = (TabPane) tabBorderPane.getChildren().get(0);
			Tab TabProjektFul = (Tab) tabPane.getTabs().get(0);

		    TabProjektFul.setContent(TabProjektContent);
			 
			TabProjektController controller = loader.getController();
		    controller.setMain(this);
		    


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showTabHrsz() {
		try {
			// Load Hrsz TAB from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/TabHrsz.fxml"));
			AnchorPane tabHrszContent = loader.load();

			BorderPane tabBorderPane = (BorderPane) tabParentLayout.getChildren().get(1);
			TabPane tabPane = (TabPane) tabBorderPane.getChildren().get(0);
			Tab tabHrszFul = (Tab) tabPane.getTabs().get(1);

			tabHrszFul.setContent(tabHrszContent);
			
			TabHrszController hrszController = loader.getController();
			hrszController.setMainApp(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showTabBeallitasok() {
		try {
			// Load Beállítások TAB from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/TabBeallitasok.fxml"));
			AnchorPane tabBeallitasokContent = loader.load();

			BorderPane tabBorderPane = (BorderPane) tabParentLayout.getChildren().get(1);
			TabPane tabPane = (TabPane) tabBorderPane.getChildren().get(0);
			Tab tabBeallitasokFul = (Tab) tabPane.getTabs().get(2);

			tabBeallitasokFul.setContent(tabBeallitasokContent);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public boolean showProjektDialog(ProjectData projektData) {
	    try {

	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/ProjektDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Projekt");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        ProjektDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setProjektData(projektData);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public boolean showHrszDialog(Hrsz hrsz) {
	    try {

	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/HrszDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Hrsz.");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        HrszDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setHrsz(hrsz);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public ObservableList<ProjectData> getProjektData() {
        return projectData;
    }
	
	public ObservableList<Hrsz> getHrszList() {
        return hrszList;
    }
	
//	public ObservableList<Tulajdonos> getTulajdonosList() {
//        return tulajdonosList;
//    }
	
	
	public File getProjektFilePath() {
	    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	    String filePath = prefs.get("filePath", null);
	    if (filePath != null) {
	        return new File(filePath);
	    } else {
	        return null;
	    }
	}


	public void setProjektFilePath(File file) {
	    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	    if (file != null) {
	        prefs.put("filePath", file.getPath());

	        primaryStage.setTitle("Elõkészítõ - " + file.getName());
	    } else {
	        prefs.remove("filePath");

	        primaryStage.setTitle("Elõkészítõ");
	    }
	}
	
	
	
	public void loadProjektDataFromFile(File file) {
	    try {
	        JAXBContext context = JAXBContext
	                .newInstance(ProjectDataWrapper.class);
	        Unmarshaller um = context.createUnmarshaller();

	        // Reading XML from the file and unmarshalling.
	        ProjectDataWrapper wrapper = (ProjectDataWrapper) um.unmarshal(file);

	        projectData.clear();
	        projectData.addAll(wrapper.getData());

	        // Save the file path to the registry.
	        setProjektFilePath(file);

	    } catch (Exception e) { // catches ANY exception	    	
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Could not load Data");
	        alert.setContentText("Could not load projekt data from file:\n" + file.getPath());

	        alert.showAndWait();
	    }
	}


	public void saveProjektDataToFile(File file) {
	    try {
	        JAXBContext context = JAXBContext
	                .newInstance(ProjectDataWrapper.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	        // Wrapping our projekt data.
	        ProjectDataWrapper wrapper = new ProjectDataWrapper();
	        wrapper.setData(projectData);

	        // Marshalling and saving XML to the file.
	        m.marshal(wrapper, file);

	        // Save the file path to the registry.
	        setProjektFilePath(file);
	        
	    } catch (Exception e) { // catches ANY exception
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Could not save data");
	        alert.setContentText("Could not save projekt data to file:\n" + file.getPath());

	        alert.showAndWait();
	    }
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
