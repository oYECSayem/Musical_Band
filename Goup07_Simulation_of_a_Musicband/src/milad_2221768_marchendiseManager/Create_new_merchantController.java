package milad_2221768_marchendiseManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
//import java.util.ArrayList;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static milad_2221768_marchendiseManager.Merchant.addMerchant;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Create_new_merchantController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    //private TextField quantityTextField;
    @FXML
    private TextField investedPriceTextFeild;
    @FXML
    private TextField sellingPriceTextFeild;
    @FXML
    private TextField descriptionTextFeild;
    @FXML
    private TextField productnameTextFeild;
    @FXML
    private TableView<Merchant> tableview;
    @FXML
    private TableColumn<Merchant, String> productNameTable;

    
    //private TableColumn<Merchant, Integer> availableQuantityTable;
    
    @FXML

    //private TableColumn<Merchant, Integer> availableQuantityTable;

    private TableColumn<Merchant, Integer> investedpriceTable;
    @FXML
    private TableColumn<Merchant, Integer> sellingPriceTable;
    @FXML
    private TableColumn<Merchant, String> descriptionTable;
    
    Alert success=new Alert(Alert.AlertType.INFORMATION,"Successfully Added the product");
    
    //Alert error =new Alert(Alert.AlertType.INFORMATION,"Please Enter All the Information Correctly");
    
    //ArrayList<Merchant> merch = new ArrayList<>();
    @FXML
    private TextField productIDTextField;
    @FXML
    private TableColumn<Merchant, Integer> productIDTable;
    
    

    //public Merchant(String productName, int quantity, int investedPrice, int sellingPrice, String description)
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productNameTable.setCellValueFactory(new PropertyValueFactory<Merchant, String>("productName"));
        productIDTable.setCellValueFactory(new PropertyValueFactory<Merchant, Integer>("productID"));
        investedpriceTable.setCellValueFactory(new PropertyValueFactory<Merchant, Integer>("investedPrice"));
        sellingPriceTable.setCellValueFactory(new PropertyValueFactory<Merchant, Integer>("sellingPrice"));
        descriptionTable.setCellValueFactory(new PropertyValueFactory<Merchant, String>("description"));
        
    }    

    @FXML
    private void returningDashBoardOnClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Merchendize_manager_dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //Parent root = null;
        //FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Merchendize_manager_dashboard.fxml"));
        //root = (Parent) myLoader.load();
        //Scene myScene = new Scene(root);

        //Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //myStage.setScene(myScene);
        //myStage.show();
    }

    @FXML
    private void addProductArrayButton(ActionEvent event) {
        
        String name = productnameTextFeild.getText();
        int quant = Integer.parseInt(productIDTextField.getText());
        int invest = Integer.parseInt(investedPriceTextFeild.getText());
        int selling = Integer.parseInt(sellingPriceTextFeild.getText());
        String descrip = descriptionTextFeild.getText();
        
        //if (name != null && quant != 0 && invest != 0 && selling != 0 && descrip != null){
        //    Merchant m = new Merchant(name, quant, invest, selling, descrip);
        //    addMerchant(m);
        //    success.show();
        //}else{
        //    error.show();
        //}
        
        Merchant m = new Merchant(name, quant, invest, selling, descrip);
        addMerchant(m);
        success.show();
        
        productnameTextFeild.clear();
        productIDTextField.clear();
        investedPriceTextFeild.clear();
        sellingPriceTextFeild.clear();
        descriptionTextFeild.clear();
       
    }

    @FXML
    private void showAllOnClick(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList <Merchant> MerchantList = FXCollections.observableArrayList();
        try {
             Merchant i;
             ois = new ObjectInputStream(new FileInputStream("Merchant.bin"));
             
            while(true){
                i = (Merchant) ois.readObject();
                
               // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                
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

        
        tableview.setItems( MerchantList);
        
        //tableview.getItems().clear();
        //tableview.getItems().addAll(merch);
        
        
        
    }
}