package milad_2221768_marchendiseManager;

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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sadia_2220645_Fan.CashMemo;
import static milad_2221768_marchendiseManager.Customer.addCustomer;
import static milad_2221768_marchendiseManager.Customer.addprofit;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Orders_on_progressController implements Initializable {

    @FXML
    private TextArea orderTextArea;
    @FXML
    private TableView<Merchant> tableView;
    @FXML
    private TableColumn<Merchant, Integer> productIDcolumn;
    @FXML
    private TableColumn<Merchant, String> nameColumn;
    @FXML
    private TableColumn<Merchant, Integer> investedPriceColumn;
    @FXML
    private TableColumn<Merchant, Integer> sellingPriceColumn;
    @FXML
    private TextField customersNameTextFeild;
    @FXML
    private TextField adressTextFeild;
    @FXML
    private TextField PhoneNumberTextFeild;
    @FXML
    private TextField productNameTextFeild1;
    @FXML
    private TextField productIDTextFeild;
    @FXML
    private TextField quantityTextFeild;
    @FXML
    private TextField priceTextFeild1111;
    
    Alert success=new Alert(Alert.AlertType.INFORMATION,"Successfully On Sales Track.");
    @FXML
    private TextField investedPriceTextFeild11111;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Merchant, String>("productName"));
        productIDcolumn.setCellValueFactory(new PropertyValueFactory<Merchant, Integer>("productID"));
        sellingPriceColumn.setCellValueFactory(new PropertyValueFactory<Merchant, Integer>("sellingPrice"));
        investedPriceColumn.setCellValueFactory(new PropertyValueFactory<Merchant, Integer>("investedPrice"));
        // TODO
    }    

    @FXML
    private void returnToDashOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Merchendize_manager_dashboard.fxml"));
        root = (Parent) myLoader.load();
        Scene myScene = new Scene(root);

        Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        myStage.setScene(myScene);
        myStage.show();

    }

    @FXML
    private void viewTheOrderOnClick(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList <CashMemo> CashMemoList = FXCollections.observableArrayList();
        try {
             CashMemo i;
             ois = new ObjectInputStream(new FileInputStream("CashMemo.bin"));
             
            while(true){
                i = (CashMemo) ois.readObject();
              
               CashMemoList.add(i);
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
        
        StringBuilder CashMemoDetails = new StringBuilder();
        for (CashMemo mm : CashMemoList) {
           CashMemoDetails.append(mm.toString()).append("\n");
        }


        orderTextArea.setText(CashMemoDetails.toString());
    }

    @FXML
    private void viewTheproductDetailsOnClick(ActionEvent event) {
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

        
        tableView.setItems( MerchantList);
    }

    @FXML
    private void trackSalesButton(ActionEvent event) {
        String cusname = customersNameTextFeild.getText();
        String addres = adressTextFeild.getText();
        String number = PhoneNumberTextFeild.getText();
        String productNa = productNameTextFeild1.getText();
        int proID = Integer.parseInt(productIDTextFeild.getText());
        int quant = Integer.parseInt(quantityTextFeild.getText());
        int price = Integer.parseInt(priceTextFeild1111.getText());
        int invest = Integer.parseInt(investedPriceTextFeild11111.getText());
        
        Customer c = new Customer(cusname, addres, number, quant, productNa, proID, price);
        addCustomer(c);
        
        
        Customer d = new Customer(quant,invest, price);
        addprofit(d);
        success.show();
        
        customersNameTextFeild.clear();
        adressTextFeild.clear();
        PhoneNumberTextFeild.clear();
        productNameTextFeild1.clear();
        productIDTextFeild.clear();
        quantityTextFeild.clear();
        priceTextFeild1111.clear();
    }
    
}
