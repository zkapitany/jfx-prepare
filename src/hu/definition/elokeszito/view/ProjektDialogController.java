package hu.definition.elokeszito.view;

import hu.definition.elokeszito.model.ProjectData;
import hu.definition.elokeszito.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ProjektDialogController {

    @FXML
    private TextField projektCimField;
    @FXML
    private TextField projektRovidCimField;
    @FXML
    private TextField munkaSzamField;
    @FXML
    private TextField rajzSzamField;
    @FXML
    private TextField iktatoSzamField;
    @FXML
    private TextField seplandSzamField;
    @FXML
    private TextField pmhCimField;
    @FXML
    private TextField ugyintezoNevField;
    @FXML
    private TextField ugyintezoTelefonField;
    @FXML
    private TextField maiDatumField;


    private Stage dialogStage;
    private ProjectData projektData;
    private boolean okClicked = false;


    @FXML
    private void initialize() {
    }

    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void setProjektData(ProjectData projektData) {
        this.projektData = projektData;

        projektCimField.setText(projektData.getProjektCim());
        projektRovidCimField.setText(projektData.getProjektRovidCim());
        munkaSzamField.setText(projektData.getMunkaSzam());
        rajzSzamField.setText(projektData.getRajzSzam());
        iktatoSzamField.setText(projektData.getIktatoSzam());
        seplandSzamField.setText(projektData.getSeplandSzam());
        pmhCimField.setText(projektData.getPmhCim());
        ugyintezoNevField.setText(projektData.getUgyintezoNev());
        ugyintezoTelefonField.setText(projektData.getUgyintezoTelefon());
        maiDatumField.setText(projektData.getMaiDatum());
    }


    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	projektData.setProjektCim(projektCimField.getText());
        	projektData.setProjektRovidCim(projektRovidCimField.getText());
        	projektData.setMunkaSzam(munkaSzamField.getText());
        	projektData.setRajzSzam(rajzSzamField.getText());
        	projektData.setIktatoSzam(iktatoSzamField.getText());
        	projektData.setSeplandSzam(seplandSzamField.getText());
        	projektData.setPmhCim(pmhCimField.getText());
        	projektData.setUgyintezoNev(ugyintezoNevField.getText());
        	projektData.setUgyintezoTelefon(ugyintezoTelefonField.getText());
        	projektData.setMaiDatum(maiDatumField.getText());

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

        if (projektCimField.getText() == null || projektCimField.getText().length() == 0) {
            errorMessage += "�res Projekt C�m!\n"; 
        }
        if (projektRovidCimField.getText() == null || projektRovidCimField.getText().length() == 0) {
            errorMessage += "�res R�vid Projekt C�m!\n"; 
        }
        if (munkaSzamField.getText() == null || munkaSzamField.getText().length() == 0) {
            errorMessage += "�res Munkasz�m!\n"; 
        }
        if (rajzSzamField.getText() == null || rajzSzamField.getText().length() == 0) {
            errorMessage += "�res Rajzsz�m!\n"; 
        }
        if (iktatoSzamField.getText() == null || iktatoSzamField.getText().length() == 0) {
            errorMessage += "�res Iktat�sz�m!\n"; 
        }
        if (seplandSzamField.getText() == null || seplandSzamField.getText().length() == 0) {
            errorMessage += "�res Sepland Sz�m!\n"; 
        }
        if (pmhCimField.getText() == null || pmhCimField.getText().length() == 0) {
            errorMessage += "�res PMH n�v!\n"; 
        }
        if (ugyintezoNevField.getText() == null || ugyintezoNevField.getText().length() == 0) {
            errorMessage += "�res �gyint�z� N�v!\n"; 
        }
        if (ugyintezoTelefonField.getText() == null || ugyintezoTelefonField.getText().length() == 0) {
            errorMessage += "�res �gyint�z� Telefon!\n"; 
        }
        if (maiDatumField.getText() == null || maiDatumField.getText().length() == 0) {
            errorMessage += "�res Mai D�tum!\n"; 
        }
        

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("�res Mez�");
            alert.setHeaderText("Jav�tsd az �res mez�t/mez�ket!");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}