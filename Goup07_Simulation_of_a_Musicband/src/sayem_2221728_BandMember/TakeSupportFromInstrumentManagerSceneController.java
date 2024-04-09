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

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TakeSupportFromInstrumentManagerSceneController implements Initializable {

    @FXML
    private TextArea technicalProblemTA;
    @FXML
    private TextArea instrumentSetupGuidelinesTA;
    @FXML
    private TextField nameTF;
    @FXML
    private TextArea getSetUpGuidelineTA;
    @FXML
    private ComboBox<?> bandMemberRoleCB;
    @FXML
    private ComboBox<?> instrumentNameCB;
    @FXML
    private RadioButton majorRB;
    @FXML
    private RadioButton minorRB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void contactForTechnicalSupportButton(ActionEvent event) {
    }

    @FXML
    private void instrumentSetupGuidelinesButton(ActionEvent event) {
    }
    
}
