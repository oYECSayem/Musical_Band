/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_BandMember;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TakeSupportFromInstrumentManagerSceneController implements Initializable {

    @FXML
    private TextArea technicalProblemTA;
    @FXML
    private TextField nameTF;
    @FXML
    private ComboBox<String> bandMemberRoleCB;
    @FXML
    private ComboBox<String> instrumentNameCB;
    @FXML
    private RadioButton majorRB;
    @FXML
    private RadioButton minorRB;
    @FXML
    private ToggleGroup problemTypeRB;
    @FXML
    private TextArea recieveMessageTA;
    @FXML
    private TextArea viewGuidelineTA;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bandMemberRoleCB.getItems().addAll("Vocal", "guitarist", 
                "Bassiest","Drammer", "Keyboardiest" );
        instrumentNameCB.getItems().addAll("Guitar", "Bass guitar",
                "Keyboard", "Dram");
    }    

    @FXML
    private void contactForTechnicalSupportButton(ActionEvent event) {
    }


    @FXML
    private void viewGuidelineButton(ActionEvent event) {
    }

    @FXML
    private void recieveMessageButton(ActionEvent event) {
    }
    
}
