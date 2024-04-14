/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_Fan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PurchasingTicketSceneController implements Initializable {

    @FXML
    private TableView<?> purchasedTicketTableView;
    @FXML
    private TableColumn<?, ?> ticketIdCol;
    @FXML
    private TableColumn<?, ?> ticketDescriptionCol;
    @FXML
    private TableColumn<?, ?> priceCol;
    @FXML
    private TableColumn<?, ?> quantityCol;
    @FXML
    private TableColumn<?, ?> totalPriceCol;
    @FXML
    private TableColumn<?, ?> ticketTypeCol;
    @FXML
    private TableColumn<?, ?> paymentMode;
    @FXML
    private TableColumn<?, ?> paymentMode1;
    @FXML
    private PasswordField pinNumberTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmpurchaseButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void goToPreviousPageButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void showDetailsButtonOnClicked(ActionEvent event) {
    }
    
}
