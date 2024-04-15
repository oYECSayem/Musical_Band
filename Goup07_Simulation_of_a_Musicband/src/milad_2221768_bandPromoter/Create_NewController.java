package milad_2221768_bandPromoter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static milad_2221768_bandPromoter.Campaign.addCampaign;
import static milad_2221768_bandPromoter.LatestNews.addLatestNews;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Create_NewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private DatePicker dateText;
    @FXML
    private TextField descriptionText;
    @FXML
    private TextField titletext;
    @FXML
    private DatePicker dateCampText;
    @FXML
    private TextField campDetailsText;
    @FXML
    private TextField venueDetailsText;
    
    Alert success=new Alert(Alert.AlertType.INFORMATION,"Successfully Created the news");
    Alert successful=new Alert(Alert.AlertType.INFORMATION,"Successfully Created the Campaign");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void returnFromDailyUpdatesOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Bandpromoter_dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    @FXML
    private void returnFromCampaignOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Bandpromoter_dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    @FXML
    private void uploadDailyUpdatesButton(ActionEvent event) {
        LocalDate dat = dateText.getValue();
        String descrip = descriptionText.getText();
        String titl = titletext.getText();
        
        LatestNews a = new LatestNews(titl, descrip, dat);
        addLatestNews(a);
        success.show();
        
        descriptionText.clear();
        titletext.clear();
        
    }

    @FXML
    private void uploadCampButton(ActionEvent event) {
        LocalDate dat = dateCampText.getValue();
        String descrip = campDetailsText.getText();
        String ven = venueDetailsText.getText();
        
        Campaign a = new Campaign(ven, descrip, dat);
        addCampaign(a);
        successful.show();
        
        campDetailsText.clear();
        venueDetailsText.clear();
        
    }
    
}
