/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fahim_2220440_OperatinalManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author MOSTOFA FAHIM HASAN
 */
public class ContractNegotiationController implements Initializable {

    @FXML
    private Button assignNewContractButton;
    @FXML
    private TableView<?> contractInfoTableView;
    @FXML
    private TableColumn<?, ?> companyNameTableColumn;
    @FXML
    private TableColumn<?, ?> createDateTableColumn;
    @FXML
    private TableColumn<?, ?> deadlineTableColumn;
    @FXML
    private TableColumn<?, ?> contractAmountTableColumn;
    @FXML
    private TableColumn<?, ?> focalPersonTableColumn;
    @FXML
    private TableColumn<?, ?> emailTableColumn;
    @FXML
    private TableColumn<?, ?> statusTableColumn;
    @FXML
    private RadioButton pendingRadioButton;
    @FXML
    private RadioButton approvedRadioButton;
    @FXML
    private RadioButton rejectedRadioButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
