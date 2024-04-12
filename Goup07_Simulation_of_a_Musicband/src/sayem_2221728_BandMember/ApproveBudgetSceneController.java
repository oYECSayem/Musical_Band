/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_BandMember;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ApproveBudgetSceneController implements Initializable {

    @FXML
    private TextArea othersBudgetInfoTA;
    @FXML
    private DatePicker dateTF;
    @FXML
    private TextField budgetIDTF;
    @FXML
    private TextField budgetEventTF;
    @FXML
    private TextField taxesTF;
    @FXML
    private TextField amountTF;
    @FXML
    private TableColumn<Budget, LocalDate> dateColumn;
    @FXML
    private TableColumn<Budget, Integer> budgetIDColumn;
    @FXML
    private TableColumn<Budget, String> budgetEventColumn;
    @FXML
    private TableColumn<Budget, Float> taxesColumn;
    @FXML
    private TableColumn<Budget, Float> amountColumn;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBudgetInTableButton(ActionEvent event) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<Budget, LocalDate>("date"));
        budgetIDColumn.setCellValueFactory(new PropertyValueFactory<Budget, Integer>("ID"));
        budgetEventColumn.setCellValueFactory(new PropertyValueFactory<Budget, String>("event"));
        taxesColumn.setCellValueFactory(new PropertyValueFactory<Budget, Float>("taxes"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Budget, Float>("amount"));

    }
    
}
