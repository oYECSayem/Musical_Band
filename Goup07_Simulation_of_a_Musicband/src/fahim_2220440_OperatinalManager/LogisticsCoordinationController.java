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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MOSTOFA FAHIM HASAN
 */
public class LogisticsCoordinationController implements Initializable {

    @FXML
    private ComboBox<?> assignedTaskComboBox;
    @FXML
    private TextField assignedMemberNameTextField;
    @FXML
    private DatePicker assignedFromDatePicker;
    @FXML
    private DatePicker assignedToDatePicker;
    @FXML
    private Button addLogisticsMemberButton;
    @FXML
    private TableView<?> logisticsCoordinationTableView;
    @FXML
    private TableColumn<?, ?> assignedMemberNameTableColumn;
    @FXML
    private TableColumn<?, ?> assignedTaskTableColumn;
    @FXML
    private TableColumn<?, ?> assignedFromTableColumn;
    @FXML
    private TableColumn<?, ?> assignedToTableColumn;
    @FXML
    private TableColumn<?, ?> emailTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
