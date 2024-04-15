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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PurchaseConcertTicketSceneController implements Initializable {

    @FXML
    private AnchorPane availabilityCol;
    @FXML
    private TableView<?> ticketViewCol;
    @FXML
    private TableColumn<?, ?> ticketIdCol;
    @FXML
    private TableColumn<?, ?> concertDetailsCol;
    @FXML
    private TableColumn<?, ?> ticketPriceCol;
    @FXML
    private TableColumn<?, ?> quantityCol;
    @FXML
    private TableColumn<?, ?> totalPriceCol;
    @FXML
    private TableColumn<?, ?> concertDetailsCol1;
    @FXML
    private ComboBox<?> scelectTicketQuantityComboBox;
    @FXML
    private RadioButton vipTicketRadioButton;
    @FXML
    private TextField priceTextField;
    @FXML
    private RadioButton nonVipTicketRadioButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addConcertEventButonOnClicked(ActionEvent event) {
    }

    @FXML
    private void ticketPurchaseProcessButtonOnClicked(ActionEvent event) {
    }
    
}
