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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PurchasingMerchandiseSceneController implements Initializable {

    @FXML
    private RadioButton cashOnDeliveryRadioButton;
    @FXML
    private RadioButton onlinePaymentRadioButton;
    @FXML
    private RadioButton mobileBankingRadioButton;
    @FXML
    private TableView<?> purchasingItemsTableView;
    @FXML
    private TableColumn<?, ?> orderIdCol;
    @FXML
    private TableColumn<?, ?> productNameCol;
    @FXML
    private TableColumn<?, ?> priceCol;
    @FXML
    private TableColumn<?, ?> quantityCol;
    @FXML
    private TableColumn<?, ?> totalPriceCol;
    @FXML
    private TableColumn<?, ?> paymentModeCol;
    @FXML
    private TableColumn<?, ?> phoneNumCol;
    @FXML
    private ComboBox<?> selectMobileBankOptionComboBox;
    @FXML
    private CheckBox cancelOrderCheckBox;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneNumTextField;
    @FXML
    private TextField pinNumTextField;
    @FXML
    private TextField addressTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showpurchaseMerchandiseDetailsButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void confirmOrderButtonOnClicked(ActionEvent event) {
    }
    
}
