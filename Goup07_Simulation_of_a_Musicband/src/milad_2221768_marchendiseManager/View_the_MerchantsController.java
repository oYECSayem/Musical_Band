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

/**
 * FXML Controller class
 *
 * @author User
 */
public class View_the_MerchantsController implements Initializable {

    @FXML
    private TableView<Merchant> tableview;
    @FXML
    private TableColumn<Merchant, String> productNameColumn;
    @FXML
    private TableColumn<Merchant, Integer> availableQuantityColumn;
    @FXML
    private TableColumn<Merchant, String> descriptionColumn;
    @FXML
    private TableColumn<Merchant, Integer> sellingPriceColumn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Merchant, String>("productName"));
        availableQuantityColumn.setCellValueFactory(new PropertyValueFactory<Merchant, Integer>("quantity"));
        sellingPriceColumn.setCellValueFactory(new PropertyValueFactory<Merchant, Integer>("sellingPrice"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Merchant, String>("description"));
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
    private void showProductsButton(ActionEvent event) {
        
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

        
        tableview.setItems( MerchantList);
        
    }
    
}
