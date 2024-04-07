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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class QuetionAndAnswerContestSceneController implements Initializable {

    @FXML
    private Label q1Label;
    @FXML
    private Label q2Label;
    @FXML
    private RadioButton Q1_option_1;
    @FXML
    private RadioButton Q2_option_1;
    @FXML
    private RadioButton Q2_option_2;
    @FXML
    private RadioButton Q1_option_2;
    @FXML
    private Label winnerResultLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void answerSubmitButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void showWinnerNameButtonOnClicked(ActionEvent event) {
    }
    
}
