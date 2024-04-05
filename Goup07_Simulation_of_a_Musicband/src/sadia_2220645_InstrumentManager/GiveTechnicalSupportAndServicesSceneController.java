/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GiveTechnicalSupportAndServicesSceneController implements Initializable {

    @FXML
    private TextField instrumentNameTextField;
    @FXML
    private RadioButton onlineServiceRadioButton;
    @FXML
    private RadioButton offlineServiceRadioButton;
    
    @FXML
    private TextArea sendMgsTextArea;
    @FXML
    private TextArea guidelineTextArea;
    @FXML
    private TextArea manualTextArea;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TextArea guidelineAndManualDetailsTextArea;
   
    @FXML
    private TextArea receiveMgsTextArea;
    
    ToggleGroup tg;
    private ArrayList<SetupGuidelinesAndManuals> GuidelinesAndManualList=new ArrayList<>();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       tg=new ToggleGroup();
       onlineServiceRadioButton.setToggleGroup(tg);
       offlineServiceRadioButton.setToggleGroup(tg);
       
       instrumentNameTextField.setDisable(true);
       guidelineTextArea.setDisable(true);
       guidelineTextArea.setDisable(true);
       manualTextArea.setDisable(true);
       guidelineAndManualDetailsTextArea.setDisable(true);
       
       datepicker.setDisable(true);
       sendMgsTextArea.setDisable(true);
       
       
       
        
    }

    @FXML
    private void onlineRadioButtonOnClicked(ActionEvent event) {
        if (onlineServiceRadioButton.isSelected()) {
            instrumentNameTextField.setDisable(false);
            guidelineTextArea.setDisable(false);
            guidelineTextArea.setDisable(false);
            manualTextArea.setDisable(false);
            guidelineAndManualDetailsTextArea.setDisable(false);

            datepicker.setDisable(true);
            sendMgsTextArea.setDisable(true);

        }
    }

    @FXML
    private void offlineRadioButtonOnClicked(ActionEvent event) {
       instrumentNameTextField.setDisable(true);
       guidelineTextArea.setDisable(true);
       guidelineTextArea.setDisable(true);
       manualTextArea.setDisable(true);
       guidelineAndManualDetailsTextArea.setDisable(true);
       
       datepicker.setDisable(false);
       sendMgsTextArea.setDisable(false);
    }
    @FXML
    private void addSetupGuidelineAndManualButtonOnClicked(ActionEvent event) {
        //SetupGuidelinesAndManuals(String instrumentName, String guidelines, String manuals)
        String instrumentName= instrumentNameTextField.getText();
        String guidelines= guidelineTextArea.getText();
        String manuals = manualTextArea.getText();
        
        
        SetupGuidelinesAndManuals guidelineAndManual;
        guidelineAndManual=new SetupGuidelinesAndManuals(instrumentName, guidelines, manuals);
        
        GuidelinesAndManualList.add(guidelineAndManual);
        
        
        
    } 
    
    @FXML
    private void showGuidelineAndManualButtonOnClicked(ActionEvent event) {
        
        StringBuilder SB = new StringBuilder();

        for (SetupGuidelinesAndManuals sm : GuidelinesAndManualList ) {
            SB.append(sm.toString()).append("\n");
        }
        guidelineAndManualDetailsTextArea.setText(SB.toString());

    }

    @FXML
    private void sendMgsButtonOnclicked(ActionEvent event) {
    }

    @FXML
    private void receiveMgsButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void sendGuidelineAndManuaButtonOnClicked(ActionEvent event) {
    }

   

    

    
    
}
