/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_BandMember;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GiveScheduleForCollabrationSceneController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField meetSessionsTF;
    @FXML
    private TextField eventTitlesTF;
    @FXML
    private TextArea descriptionsTA;
    @FXML
    private DatePicker datesDP;
    @FXML
    private TextField timesTF;
    @FXML
    private TextField locationTF;
    @FXML
    private TextArea giveawayTA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
