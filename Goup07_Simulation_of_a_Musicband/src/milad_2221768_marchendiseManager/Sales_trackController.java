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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class Sales_trackController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<Customer, String> productNameColumn;
    @FXML
    private TableColumn<Customer, Integer> quantityColumn;
    @FXML
    private TableColumn<Customer, String> customerN;
    @FXML
    private TableColumn<Customer, String> addressColumn;
    @FXML
    private TableColumn<Customer, String> phoneNumberColumn;
    @FXML
    private TableColumn<Customer, Integer> priceColumn;
    @FXML
    private TableView<Customer> tableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("quantity"));
        customerN.setCellValueFactory(new PropertyValueFactory<Customer, String>("customer_Name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone_number"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("sellingPrice"));
        
        
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
    private void loadSalesOnClick(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList <Customer> CustomerList = FXCollections.observableArrayList();
        try {
             Customer i;
             ois = new ObjectInputStream(new FileInputStream("CustomerInfo.bin"));
             
            while(true){
                i = (Customer) ois.readObject();            
                CustomerList.add(i);
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

        
        tableView.setItems( CustomerList);
    }
    
}
