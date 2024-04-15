/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fahim_2220440_EventOrganizer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author MOSTOFA FAHIM HASAN
 */
public class ManageBudgetAndExpensesController implements Initializable {

    @FXML
    private TableView<ManageBudgetAndExpenses> tableviewOfExpenses;
    @FXML
    private TableColumn<ManageBudgetAndExpenses, String> sLTableViewColumn;
    @FXML
    private TableColumn<ManageBudgetAndExpenses, String> nameTableViewCloumn;
    @FXML
    private TableColumn<ManageBudgetAndExpenses, String> AmountTableViewCooumn;
    @FXML
    private TableColumn<ManageBudgetAndExpenses, String> typeTableViewColumn;
    @FXML
    private TableColumn<ManageBudgetAndExpenses, String> deleteTableViewColumn;
    @FXML
    private Button addExpensesButton;
    @FXML
    private ComboBox<String> entryTypeComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        entryTypeComboBox.getItems().add("Instrument");
        entryTypeComboBox.getItems().add("Concert");
        entryTypeComboBox.getItems().add("Fees");
        entryTypeComboBox.getItems().add("Food");
        entryTypeComboBox.getItems().add("Others");
        
        sLTableViewColumn.setCellValueFactory(new PropertyValueFactory<>)("sL"));
        nameTableViewCloumn.setCellValueFactory(new PropertyValueFactory<>)("name"));
        AmountTableViewCooumn.setCellValueFactory(new PropertyValueFactory<>)("Amount"));
        typeTableViewColumn.setCellValueFactory(new PropertyValueFactory<>)("Type"));
       
        
        
    }    

    @FXML
    private void addExpensesOnClick(ActionEvent event) {
    }
    
}
