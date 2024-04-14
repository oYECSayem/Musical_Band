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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import milad_2221768_marchendiseManager.Merchant;
import static sadia_2220645_Fan.Fan.Purchasemerchandise;

 
public class PurchasingMerchandiseSceneController implements Initializable {

    @FXML
    private RadioButton cashOnDeliveryRadioButton;
    @FXML
    private RadioButton onlinePaymentRadioButton;
    @FXML
    private RadioButton mobileBankingRadioButton;
    @FXML
    private ComboBox<?> selectMobileBankOptionComboBox;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneNumTextField;
    
    @FXML
    private TextField addressTextField;
    
    ToggleGroup tg;
    @FXML
    private TextArea merchandiseInfoTextField;
    @FXML
    private TextArea purchasedMerchandiseReceiptTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cashOnDeliveryRadioButton.setToggleGroup(tg);
        onlinePaymentRadioButton.setToggleGroup(tg);
        mobileBankingRadioButton.setToggleGroup(tg);
        
        
        
        // TODO
    }    

    @FXML
    private void showpurchaseMerchandiseDetailsButtonOnClicked(ActionEvent event) {
        
        ObjectInputStream ois = null;
        ObservableList <Cart> CartList = FXCollections.observableArrayList();
        try {
             Cart i;
             ois = new ObjectInputStream(new FileInputStream("Cart.bin"));
             
            while(true){
                i = (Cart) ois.readObject();
              
                 CartList.add(i);
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
        
        StringBuilder CartDetails = new StringBuilder();
        for (Cart mm :  CartList) {
            CartDetails.append(mm.toString()).append("\n");
        }


        merchandiseInfoTextField.setText(CartDetails.toString());
        
    }
    
    

    @FXML
    private void confirmOrderButtonOnClicked(ActionEvent event) {
        String paymentMode=" ";
        if(cashOnDeliveryRadioButton.isSelected()){
            paymentMode="Chash On Delevery.";
        }if(onlinePaymentRadioButton.isSelected()){
            paymentMode="Online payment.";
        }if(mobileBankingRadioButton.isSelected()){
            paymentMode="Mobile Banking.";
        }
        
        String name=nameTextField.getText();
        String address=addressTextField.getText();
        int phoneNum=Integer.parseInt(phoneNumTextField.getText());
        String merchantDetails=merchandiseInfoTextField.getText();
        
        CashMemo m=new CashMemo( name,address, merchantDetails, paymentMode, phoneNum) ;
        
        Purchasemerchandise(m);
        
        
        //-------read------------------
        
        ObjectInputStream ois = null;
        ObservableList <CashMemo> CashMemoList = FXCollections.observableArrayList();
        try {
             CashMemo i;
             ois = new ObjectInputStream(new FileInputStream("Cart.bin"));
             
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


        purchasedMerchandiseReceiptTextField.setText(CashMemoDetails.toString());
        
    }

    @FXML
    private void previousSceneButtonOnClicked(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PurchaseMerchandiseScelectScene.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene PurchaseMerchandiseScelectScene = new Scene(parent);

        currentStage.setScene(PurchaseMerchandiseScelectScene);
        currentStage.show();
    }
    }
    

