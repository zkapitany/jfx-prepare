package hu.definition.elokeszito.view;

import hu.definition.elokeszito.model.Hrsz;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HrszDialogController {

    @FXML
    private TextField hrszSzamField;
    @FXML
    private TextField hrszHanyadField;
    @FXML
    private TextField hrszVarosField;
    @FXML
    private TextField hrszUtcaField;
    @FXML
    private TextField hrszBesorolasField;
    @FXML
    private TextField tulajdonosNevField;
    @FXML
    private TextField tulajdonosHrszField;
    @FXML
    private TextField tulajdonosVarosField;
    @FXML
    private TextField tulajdonosUtcaField;
//    @FXML
//    private TextField tulajdonosCimField;



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

        hrszSzamField.setText(hrsz.getHrszSzam());
        hrszHanyadField.setText(hrsz.getHrszHanyad());
        hrszVarosField.setText(hrsz.getHrszVaros());
        hrszUtcaField.setText(hrsz.getHrszUtca());
        hrszBesorolasField.setText(hrsz.getHrszBesorolas());
        tulajdonosNevField.setText(hrsz.getTulajdonosNev());
        tulajdonosHrszField.setText(hrsz.getTulajdonosHrsz());
        tulajdonosVarosField.setText(hrsz.getTulajdonosVaros());
        tulajdonosUtcaField.setText(hrsz.getTulajdonosUtca());
//        tulajdonosCimField.setText(hrsz.getTulajdonosCim());
    }


    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	hrsz.setHrszSzam(hrszSzamField.getText());
        	hrsz.setHrszHanyad(hrszHanyadField.getText());
        	hrsz.setHrszVaros(hrszVarosField.getText());
        	hrsz.setHrszUtca(hrszUtcaField.getText());
        	hrsz.setHrszBesorolas(hrszBesorolasField.getText());
        	hrsz.setTulajdonosNev(tulajdonosNevField.getText());
        	hrsz.setTulajdonosHrsz(tulajdonosHrszField.getText());
        	hrsz.setTulajdonosVaros(tulajdonosVarosField.getText());
        	hrsz.setTulajdonosUtca(tulajdonosUtcaField.getText());
        	hrsz.setTulajdonosCim(tulajdonosHrszField.getText() + " " + tulajdonosVarosField.getText() + ", " + tulajdonosUtcaField.getText());

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

        if (hrszSzamField.getText() == null || hrszSzamField.getText().length() == 0) {
            errorMessage += "Üres Hrsz. !\n"; 
        }
        if (hrszHanyadField.getText() == null || hrszHanyadField.getText().length() == 0) {
            errorMessage += "Üres Hrsz. Hányad !\n"; 
        }
        if (hrszVarosField.getText() == null || hrszVarosField.getText().length() == 0) {
            errorMessage += "Üres Hrsz. Város!\n"; 
        }
        if (hrszUtcaField.getText() == null || hrszUtcaField.getText().length() == 0) {
            errorMessage += "Üres Hrsz. Utca!\n"; 
        }
        if (hrszBesorolasField.getText() == null || hrszBesorolasField.getText().length() == 0) {
            errorMessage += "Üres Hrsz. Besorolas!\n"; 
        }
        if (tulajdonosNevField.getText() == null || tulajdonosNevField.getText().length() == 0) {
            errorMessage += "Üres Tulajdonos Név!\n"; 
        }
        if (tulajdonosHrszField.getText() == null || tulajdonosHrszField.getText().length() == 0) {
            errorMessage += "Üres Tulajdonos Hrsz.!\n"; 
        }
        if (tulajdonosVarosField.getText() == null || tulajdonosVarosField.getText().length() == 0) {
            errorMessage += "Üres Tulajdonos Város!\n"; 
        }
        if (tulajdonosUtcaField.getText() == null || tulajdonosUtcaField.getText().length() == 0) {
            errorMessage += "Üres Tulajdonos Utca!\n"; 
        }
//        if (tulajdonosCimField.getText() == null || tulajdonosCimField.getText().length() == 0) {
//            errorMessage += "Üres Tulajdonos Cím!\n"; 
//        }

        

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