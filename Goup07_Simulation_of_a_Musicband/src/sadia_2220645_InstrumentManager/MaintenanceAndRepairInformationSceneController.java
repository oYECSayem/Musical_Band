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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MaintenanceAndRepairInformationSceneController implements Initializable {

    @FXML
    private ComboBox<?> defectCatagoryComboBox;
    @FXML
    private TextField repairCostTextField;
    @FXML
    private TableView<?> repairInstrumentsTableView;
    @FXML
    private TableColumn<?, ?> repairInstrumentCol;
    @FXML
    private TableColumn<?, ?> repairInstrumentIDCol;
    @FXML
    private TableColumn<?, ?> defectCatagoryCol;
    @FXML
    private TableColumn<?, ?> repairCostCol;
    @FXML
    private TableColumn<?, ?> totalRepairCostCol;
    @FXML
    private ComboBox<?> defectedInstrumentNameComboBox;
    @FXML
    private TextArea expanceReciptTextArea;
    @FXML
    private TextField repairInstrumentIdTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addRepairedInstrumentButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void showRepairedInstrumentDetailsButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void submitExpanceReceiptButtonOnClicked(ActionEvent event) {
    }
    
}
