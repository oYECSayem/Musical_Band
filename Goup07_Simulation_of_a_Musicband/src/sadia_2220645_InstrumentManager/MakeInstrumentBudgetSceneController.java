/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MakeInstrumentBudgetSceneController implements Initializable {

    @FXML
    private TextField selectQantityTextField;
    @FXML
    private TableColumn<?, ?> newInstrumentNameCol;
    @FXML
    private TableColumn<?, ?> modelCol;
    @FXML
    private TableColumn<?, ?> brandNameCol;
    @FXML
    private TableColumn<?, ?> priceCol;
    @FXML
    private TableColumn<?, ?> quantityCol;
    @FXML
    private TableColumn<?, ?> totalPriceCol;
    @FXML
    private TableColumn<?, ?> totalQantityCol;
    @FXML
    private TextArea budgetSubmitTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addInstrumentToBudgetPlanButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void viewBudgetPlanButtonOnclicked(ActionEvent event) {
    }

    @FXML
    private void submitBudjetPlanButtonOnClicked(ActionEvent event) {
    }
    
}
