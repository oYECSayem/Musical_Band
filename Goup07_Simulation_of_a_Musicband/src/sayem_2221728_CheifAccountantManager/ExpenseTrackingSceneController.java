/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_CheifAccountantManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ExpenseTrackingSceneController implements Initializable {

    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> categoryColumn;
    @FXML
    private TableColumn<?, ?> actualColumn;
    @FXML
    private TableColumn<?, ?> budgetedColumn;
    @FXML
    private TableColumn<?, ?> varianceColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
