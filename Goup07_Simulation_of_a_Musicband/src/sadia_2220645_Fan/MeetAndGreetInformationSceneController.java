/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_Fan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MeetAndGreetInformationSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextArea notificationTextArea;
    @FXML
    private ComboBox<?> selectEventTypeComboBox;
    @FXML
    private Label allEventsLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void selectEventTypeButtonOnCicked(ActionEvent event) {
    }

    @FXML
    private void addEventButtonOnclicked(ActionEvent event) {
    }
    
}
