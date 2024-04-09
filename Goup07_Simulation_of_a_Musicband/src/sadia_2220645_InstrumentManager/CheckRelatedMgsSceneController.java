/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CheckRelatedMgsSceneController implements Initializable {

    @FXML
    private TextArea sendMgsTextArea;
    @FXML
    private RadioButton checkRecivedRdioButton;
    @FXML
    private RadioButton checkCanceledRadioButton;
    @FXML
    private TextArea receiveMgsTextArea1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void receiveMgsButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void sendMgsButtonOnClicked(ActionEvent event) {
    }
    
}
