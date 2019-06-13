package hu.definition.elokeszito;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import hu.definition.elokeszito.model.AltalanosAdatok;
import hu.definition.elokeszito.model.AltalanosAdatokWrapper;
import hu.definition.elokeszito.view.AltalanosDialogController;
import hu.definition.elokeszito.view.RootLayoutController;
import hu.definition.elokeszito.view.TabAltalanosController;
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
	private ObservableList<AltalanosAdatok> generalData = FXCollections.observableArrayList();
	
	public MainApp() {
        // Add some sample data
        generalData.add(new AltalanosAdatok("Kapitany", "Zoltan"));
        generalData.add(new AltalanosAdatok("Zozo", "Meister"));
        generalData.add(new AltalanosAdatok("John", "Lennon"));
    }

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Elõkészítõ Eljárás");
		
		this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));
		
		initTabParentLayout();
		showTabAltalanos();
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
		
		// Try to load last opened person file.
	    File file = getGeneralFilePath();
	    if (file != null) {
	        loadGeneralDataFromFile(file);
	    }
	}

	public void showTabAltalanos() {
		try {
			// Load Altalanos TAB from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/TabAltalanos.fxml"));
			AnchorPane tabAltalanosContent = loader.load();

			BorderPane tabBorderPane = (BorderPane) tabParentLayout.getChildren().get(1);
			TabPane tabPane = (TabPane) tabBorderPane.getChildren().get(0);
			Tab tabAltalanosFul = (Tab) tabPane.getTabs().get(0);

		    tabAltalanosFul.setContent(tabAltalanosContent);
			 
			TabAltalanosController controller = loader.getController();
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
	

	public boolean showAltalanosDialog(AltalanosAdatok generalData) {
	    try {

	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/AltalanosDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        AltalanosDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setGeneralData(generalData);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	        
	    } catch (IOException e) {
	    	System.out.println(" --- showAltalanosDialog Error ---");
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public ObservableList<AltalanosAdatok> getGeneralData() {
        return generalData;
    }
	
	
	public File getGeneralFilePath() {
	    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	    String filePath = prefs.get("filePath", null);
	    if (filePath != null) {
	        return new File(filePath);
	    } else {
	        return null;
	    }
	}


	public void setGeneralFilePath(File file) {
	    Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	    if (file != null) {
	        prefs.put("filePath", file.getPath());

	        primaryStage.setTitle("Elõkészítõ - " + file.getName());
	    } else {
	        prefs.remove("filePath");

	        primaryStage.setTitle("Elõkészítõ");
	    }
	}
	
	
	
	public void loadGeneralDataFromFile(File file) {
	    try {
	        JAXBContext context = JAXBContext
	                .newInstance(AltalanosAdatokWrapper.class);
	        Unmarshaller um = context.createUnmarshaller();

	        // Reading XML from the file and unmarshalling.
	        AltalanosAdatokWrapper wrapper = (AltalanosAdatokWrapper) um.unmarshal(file);

	        generalData.clear();
	        generalData.addAll(wrapper.getData());

	        // Save the file path to the registry.
	        setGeneralFilePath(file);

	    } catch (Exception e) { // catches ANY exception	    	
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Could not load Data");
	        alert.setContentText("Could not load general data from file:\n" + file.getPath());

	        alert.showAndWait();
	    }
	}


	public void saveGeneralDataToFile(File file) {
	    try {
	        JAXBContext context = JAXBContext
	                .newInstance(AltalanosAdatokWrapper.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	        // Wrapping our person data.
	        AltalanosAdatokWrapper wrapper = new AltalanosAdatokWrapper();
	        wrapper.setData(generalData);

	        // Marshalling and saving XML to the file.
	        m.marshal(wrapper, file);

	        // Save the file path to the registry.
	        setGeneralFilePath(file);
	        
	    } catch (Exception e) { // catches ANY exception
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Could not save data");
	        alert.setContentText("Could not save general data to file:\n" + file.getPath());

	        alert.showAndWait();
	    }
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
