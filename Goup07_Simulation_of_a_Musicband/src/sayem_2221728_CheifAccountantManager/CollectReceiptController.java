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
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CollectReceiptController implements Initializable {

    @FXML
    private MenuItem uploadMenuItem;
    @FXML
    private MenuItem exitMenuItem;
    @FXML
    private MenuItem addReceiptMenuItem;
    @FXML
    private MenuItem deleteReceiptMenuItem;
    @FXML
    private Button addReceiptButton;
    @FXML
    private Button deleteReceiptButton;
    @FXML
    private Button refreshButton;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private TableView<?> receiptsTable;
    @FXML
    private TableColumn<?, ?> receiptNumberCol;
    @FXML
    private TableColumn<?, ?> dateCol;
    @FXML
    private TableColumn<?, ?> vendorNameCol;
    @FXML
    private TableColumn<?, ?> amountCol;
    @FXML
    private TableColumn<?, ?> descriptionCol;
    @FXML
    private TableColumn<?, ?> categoryCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void uploadReceipt(ActionEvent event) {
    }

    @FXML
    private void exitApplication(ActionEvent event) {
    }

    @FXML
    private void showReceiptEntryForm(ActionEvent event) {
    }

    @FXML
    private void deleteReceipt(ActionEvent event) {
    }

    @FXML
    private void refreshReceipts(ActionEvent event) {
    }

    @FXML
    private void searchReceipts(ActionEvent event) {
    }
    
}
