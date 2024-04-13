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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PurchaseMerchandiseScelectSceneController implements Initializable {

    @FXML
    private TableView<?> merchandiseTableView;
    @FXML
    private TableColumn<?, ?> idCol;
    @FXML
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableColumn<?, ?> descriptionCol;
    @FXML
    private TableColumn<?, ?> priceCol;
    @FXML
    private TableColumn<?, ?> availabilityCol;
    @FXML
    private TableColumn<?, ?> quantityCol;
    @FXML
    private ComboBox<?> quantityComboBox;
    @FXML
    private TextArea selectedItemsDescriptionTextArea;
    @FXML
    private DatePicker datepicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addToCartButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void nextPurchaseProcessButtonOnCicked(ActionEvent event) {
    }
    
}
