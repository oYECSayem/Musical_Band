/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_Fan;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import milad_2221768_marchendiseManager.Merchant;
import static sadia_2220645_Fan.Cart.addMerchandiseTotheCart;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PurchaseMerchandiseScelectSceneController implements Initializable {

    @FXML
    private TableView<Merchant> merchandiseTableView;
    @FXML
    private TableColumn<Merchant,Integer> idCol;
    @FXML
    private TableColumn<Merchant, String> nameCol;
    @FXML
    private TableColumn<Merchant, String> descriptionCol;
    @FXML
    private TableColumn<Merchant,Integer> priceCol;
    @FXML
    private TableColumn<?, ?> availabilityCol;
    @FXML
    private TableColumn<?, ?> quantityCol;
    @FXML
    private TextArea selectedProducttextArea;
    @FXML
    private TextArea customizedOrderTextArea;
   
    @FXML
    private TextField quantityTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCol.setCellValueFactory(new PropertyValueFactory<Merchant, String>("productName"));
        idCol.setCellValueFactory(new PropertyValueFactory<Merchant, Integer>("productID"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Merchant, Integer>("sellingPrice"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<Merchant, String>("description"));

    }

    @FXML
    private void addToCartButtonOnClicked(ActionEvent event) {

       ObservableList<Merchant> instrumentBudgetList = merchandiseTableView.getSelectionModel().getSelectedItems();
       
       int quantity =Integer.parseInt(quantityTextField.getText());

   
       StringBuilder MerchantDetails = new StringBuilder();
    
    
    for (Merchant merchant : instrumentBudgetList) {
        MerchantDetails.append("Name: ").append(merchant.getProductName()).append("\n");
        MerchantDetails.append("Description:: ").append(merchant.getDescription()).append("\n");
        MerchantDetails.append("ID: ").append(merchant.getProductID()).append("\n");
        MerchantDetails.append("Price: ").append(merchant.getSellingPrice()).append("\n");
        MerchantDetails.append("Total Cost: ").append(merchant.getSellingPrice() *quantity).append("\n\n");
        
    }

     selectedProducttextArea.setText(MerchantDetails.toString());
    
       
       String merchandiseInfo=selectedProducttextArea.getText();
       Cart c=new Cart(merchandiseInfo);
       addMerchandiseTotheCart(c);
       
       quantityTextField.clear();
    
    }

    @FXML
    private void nextPurchaseProcessButtonOnCicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PurchasingMerchandiseScene.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene PurchasingMerchandiseScene = new Scene(parent);

        currentStage.setScene(PurchasingMerchandiseScene);
        currentStage.show();
    }

    @FXML
    private void viewPoductTableButtonOnClicked(ActionEvent event) {
        
         ObjectInputStream ois = null;
        ObservableList <Merchant> MerchantList = FXCollections.observableArrayList();
        try {
             Merchant i;
             ois = new ObjectInputStream(new FileInputStream("Merchant.bin"));
             
            while(true){
                i = (Merchant) ois.readObject();
              
                 MerchantList.add(i);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }

        
        merchandiseTableView.setItems( MerchantList);
        
        
    }
    
}
