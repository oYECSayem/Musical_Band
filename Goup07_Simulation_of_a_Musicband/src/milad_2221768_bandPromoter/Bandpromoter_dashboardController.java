package milad_2221768_bandPromoter;

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
public class Bandpromoter_dashboardController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createNewOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Create_New.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void viewOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(".fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void chatboxOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Communicate_with_band_members.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void deleteOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Delete_previous_content.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ContestOverviewOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Context_winner.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void eventBudgetCreatorOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Event_Budget_Creator.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void eventBudgetOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Event_Budget_List.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sponsorOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sponsor.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sponsorListOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sponsor_List.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
