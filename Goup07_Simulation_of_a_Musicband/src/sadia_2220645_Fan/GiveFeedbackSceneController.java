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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GiveFeedbackSceneController implements Initializable {

    @FXML
    private RadioButton albumRadioButton;
    @FXML
    private RadioButton songsRaddioButton;
    @FXML
    private RadioButton concertRadioButton;
    @FXML
    private RadioButton merchandiseRadioButton;
    @FXML
    private TextArea feedbackTextArea;
    @FXML
    private TextField nameTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitFeedbackButtonOnClicked(ActionEvent event) {
    }
    
}
