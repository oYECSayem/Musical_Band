/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_CheifAccountantManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MakingBudgetPlanSceneController implements Initializable {

    @FXML
    private AnchorPane showBudgetAmountLabel;
    @FXML
    private TableColumn<?, ?> dateColumn;
    @FXML
    private TableColumn<?, ?> categoryColumn;
    @FXML
    private TableColumn<?, ?> taxesColumn;
    @FXML
    private TableColumn<?, ?> amountColumn;
    @FXML
    private RadioButton monthlyRB;
    @FXML
    private RadioButton annuallyRB;
    @FXML
    private Label makingBudgetAmountLabel;
    @FXML
    private TextArea calculationBudgetTA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addEntryButton(ActionEvent event) {
    }

    @FXML
    private void getTotalBudgetAmountButton(ActionEvent event) {
        
    }
    
}
