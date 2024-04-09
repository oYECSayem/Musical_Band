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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ApproveBudgetController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private CheckBox chkBColumn;
    @FXML
    private TableColumn<?, ?> budgetIDColumn;
    @FXML
    private TableColumn<?, ?> descriptionColumn;
    @FXML
    private TableColumn<?, ?> amountColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewBudgetPlanButton(ActionEvent event) {
    }

    @FXML
    private void submitSelectedBudgetButton(ActionEvent event) {
    }
    
}
