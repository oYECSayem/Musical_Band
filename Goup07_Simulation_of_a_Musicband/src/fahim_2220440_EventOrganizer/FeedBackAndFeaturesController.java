/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fahim_2220440_EventOrganizer;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author MOSTOFA FAHIM HASAN
 */
public class FeedBackAndFeaturesController implements Initializable {

    @FXML
    private Button createPollButton;
    @FXML
    private ComboBox<String> selectConcertComboBox;
    @FXML
    private Button addOptionButtonForPolls;
    @FXML
    private Button deleteButtonForPolls;
    @FXML
    private Button addCommentSectionButton;
    @FXML
    private Button addRatingButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    selectConcertComboBox.getItems().add("71StreetConcert");
    selectConcertComboBox.getItems().add("MadisonSqureConcert");
    selectConcertComboBox.getItems().add("YellowGroundConcert");
    selectConcertComboBox.getItems().add("TimesSqureConcert");
    selectConcertComboBox.getItems().add("ODDTownConcert");
    
    }    

    @FXML
    private void createPollOnClick(ActionEvent event) {
        
    }

    @FXML
    private void addOptionOnClick(ActionEvent event) {
    }

    @FXML
    private void deleteOptionOnClick(ActionEvent event) {
    }

    @FXML
    private void addCommentSectionOnClick(ActionEvent event) {
    }

    @FXML
    private void addRatingOnClick(ActionEvent event) {
    }
    
}
