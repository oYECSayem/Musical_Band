package milad_2221768_marchendiseManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Edit_productController implements Initializable {
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void returnToMerchantDashboardOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Merchendize_manager_dashboard.fxml"));
        root = (Parent) myLoader.load();
        Scene myScene = new Scene(root);

        Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        myStage.setScene(myScene);
        myStage.show();
    }
    
}
