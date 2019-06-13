package hu.definition.elokeszito;

import java.io.IOException;

import hu.definition.elokeszito.model.AltalanosAdatok;
import hu.definition.elokeszito.view.AltalanosDialogController;
import hu.definition.elokeszito.view.TabAltalanosController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
		this.primaryStage.setTitle("El�k�sz�t� Elj�r�s");
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

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
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
			// Load Be�ll�t�sok TAB from fxml file
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

	public static void main(String[] args) {
		launch(args);
	}
}
