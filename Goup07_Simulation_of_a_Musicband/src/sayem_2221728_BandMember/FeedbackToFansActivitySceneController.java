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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FeedbackToFansActivitySceneController implements Initializable {

    @FXML
    private TextArea replyFansTA;
    @FXML
    private TextArea fansLyricsTA;
    @FXML
    private ComboBox<?> rateSongCB;
    @FXML
    private TextField nameTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitReplyButton(ActionEvent event) {
    }

    @FXML
    private void acceptMessageLyricsButton(ActionEvent event) {
    }
    
}
