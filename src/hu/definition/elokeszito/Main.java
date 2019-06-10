package hu.definition.elokeszito;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane tabParentLayout;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Elõkészítõ Eljárás");
		initTabParentLayout();
		showTabAltalanos();
		showTabHrsz();
		showTabBeallitasok();
	}

	public void initTabParentLayout() {
		try {
			// Load TabParentLayout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
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
			loader.setLocation(Main.class.getResource("view/TabAltalanos.fxml"));
			AnchorPane tabAltalanosContent = loader.load();

			BorderPane tabBorderPane = (BorderPane) tabParentLayout.getChildren().get(1);
			TabPane tabPane = (TabPane) tabBorderPane.getChildren().get(0);
			Tab tabAltalanosFul = (Tab) tabPane.getTabs().get(0);

			tabAltalanosFul.setContent(tabAltalanosContent);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showTabHrsz() {
		try {
			// Load Hrsz TAB from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/TabHrsz.fxml"));
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
			loader.setLocation(Main.class.getResource("view/TabBeallitasok.fxml"));
			AnchorPane tabBeallitasokContent = loader.load();

			BorderPane tabBorderPane = (BorderPane) tabParentLayout.getChildren().get(1);
			TabPane tabPane = (TabPane) tabBorderPane.getChildren().get(0);
			Tab tabBeallitasokFul = (Tab) tabPane.getTabs().get(2);

			tabBeallitasokFul.setContent(tabBeallitasokContent);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
