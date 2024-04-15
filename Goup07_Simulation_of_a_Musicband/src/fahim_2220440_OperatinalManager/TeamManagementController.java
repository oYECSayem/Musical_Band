/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fahim_2220440_OperatinalManager;

import java.net.URL;
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
public class TeamManagementController implements Initializable {

    @FXML
    private ComboBox<?> bandMemberComboBox;
    @FXML
    private Button createChatButton;
    @FXML
    private Button sendMailButton;
    @FXML
    private ComboBox<?> bandMemberselec1;
    @FXML
    private Button moreMemberButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createGroupChat(ActionEvent event) {
    }
    
}
