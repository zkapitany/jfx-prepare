package hu.definition.elokeszito.view;

import hu.definition.elokeszito.model.Hrsz;
import hu.definition.elokeszito.model.ProjectData;
import hu.definition.elokeszito.model.Tulajdonos;
import hu.definition.elokeszito.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HrszDialogController {

    @FXML
    private TextField hrszField;
    @FXML
    private TextField hrszVarosField;
    @FXML
    private TextField hrszUtcaField;
    @FXML
    private TextField besorolasField;
    @FXML
    private TextField tulajdonosNevField;
    @FXML
    private TextField tulajdonosCimField;
    @FXML
    private TextField hanyadField;


    private Stage dialogStage;
    private Hrsz hrsz;
    private boolean okClicked = false;


    @FXML
    private void initialize() {
    }

    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void setHrsz(Hrsz hrsz) {
        this.hrsz = hrsz;

        hrszField.setText(hrsz.getSzam());
        hrszVarosField.setText(hrsz.getVaros());
        hrszUtcaField.setText(hrsz.getUtca());
        besorolasField.setText(hrsz.getBesorolas());
        tulajdonosNevField.setText(hrsz.getTulajdonos().getNev());
        tulajdonosCimField.setText(hrsz.getTulajdonos().getCim());
        hanyadField.setText(hrsz.getTulajdonos().getHanyad());
    }


    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	hrsz.setSzam(hrszField.getText());
        	hrsz.setVaros(hrszVarosField.getText());
        	hrsz.setUtca(hrszUtcaField.getText());
        	hrsz.setBesorolas(besorolasField.getText());
        	hrsz.setTulajdonos(new Tulajdonos(tulajdonosNevField.getText(), tulajdonosCimField.getText(), hrszField.getText(), hanyadField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    private boolean isInputValid() {
        String errorMessage = "";

        if (hrszField.getText() == null || hrszField.getText().length() == 0) {
            errorMessage += "Üres Hrsz. !\n"; 
        }
        if (hrszVarosField.getText() == null || hrszVarosField.getText().length() == 0) {
            errorMessage += "Üres Hrsz Város!\n"; 
        }
        if (hrszUtcaField.getText() == null || hrszUtcaField.getText().length() == 0) {
            errorMessage += "Üres Hrsz Utca!\n"; 
        }
        if (besorolasField.getText() == null || besorolasField.getText().length() == 0) {
            errorMessage += "Üres Besorolas!\n"; 
        }
        if (tulajdonosNevField.getText() == null || tulajdonosNevField.getText().length() == 0) {
            errorMessage += "Üres Tulajdonos Név!\n"; 
        }
        if (tulajdonosCimField.getText() == null || tulajdonosCimField.getText().length() == 0) {
            errorMessage += "Üres Tulajdonos Cím Szám!\n"; 
        }
        if (hanyadField.getText() == null || hanyadField.getText().length() == 0) {
            errorMessage += "Üres Hányad!\n"; 
        }
        

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Üres Mezõ");
            alert.setHeaderText("Javítsd az üres mezõt/mezõket!");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}