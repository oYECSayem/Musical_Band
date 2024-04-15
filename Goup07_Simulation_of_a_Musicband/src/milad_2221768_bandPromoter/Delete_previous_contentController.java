package milad_2221768_bandPromoter;

import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Delete_previous_contentController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextArea newsTextArea;
    @FXML
    private TextArea campdetailsText;
    
    Alert success=new Alert(Alert.AlertType.INFORMATION,"The File has been deleted.");

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
    private void returnFromDeleteCampaign(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Bandpromoter_dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void generatebutton(ActionEvent event) {
        
        ObjectInputStream ois = null;
        ObservableList <LatestNews> LatestNewsList = FXCollections.observableArrayList();
        try {
             LatestNews i;
             ois = new ObjectInputStream(new FileInputStream("LatestNews.bin"));
             
            while(true){
                i = (LatestNews) ois.readObject();
              
               LatestNewsList.add(i);
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
        
        StringBuilder LatestNewsDetails = new StringBuilder();
        for (LatestNews mm : LatestNewsList) {
           LatestNewsDetails.append(mm.toString()).append("\n");
        }

        newsTextArea.setText(LatestNewsDetails.toString());
    
    }

    @FXML
    private void deleteCampButton(ActionEvent event) {
        File binFile = new File("Campaign.bin");
        if (binFile.exists()) {
            binFile.delete();
        }
        
        campdetailsText.clear();
        success.show();
    }

    @FXML
    private void generateCampButton(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList <Campaign> CampaignList = FXCollections.observableArrayList();
        try {
             Campaign i;
             ois = new ObjectInputStream(new FileInputStream("Campaign.bin"));
             
            while(true){
                i = (Campaign) ois.readObject();
              
               CampaignList.add(i);
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
        
        StringBuilder CampaignDetails = new StringBuilder();
        for (Campaign mm : CampaignList) {
           CampaignDetails.append(mm.toString()).append("\n");
        }


        campdetailsText.setText(CampaignDetails.toString());
    }

    @FXML
    private void deleteButton(ActionEvent event) {
        File binFile = new File("LatestNews.bin");
        if (binFile.exists()) {
            binFile.delete();
        }
        
        newsTextArea.clear();
        success.show();
    }
    
}
