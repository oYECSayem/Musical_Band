/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

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
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class InstrumentManagerDashboardController implements Initializable {

    
    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuItem Task;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
  

   

    @FXML
    private void instrumentTrackListButtonOnClicked(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("MakeInstrumentTrackListScene.fxml"));
         borderPane.setCenter(root);
        
    }

    @FXML
    private void defectedInstrumentsListButtonOnClicked(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("DefectedInstrumentTrackListScene.fxml"));
         borderPane.setCenter(root);
        
    }

    @FXML
    private void newUpdatedInstrumentListButtonOnClicked(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("MakeNewUpdatedInstrumentListScene.fxml"));
         borderPane.setCenter(root);
        
    }

    @FXML
    private void technicalSupportButtonOnClicked(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("GiveTechnicalSupportAndServicesScene.fxml"));
         borderPane.setCenter(root);
        
    }

    @FXML
    private void checkRelatedMgsButtonOnClicked(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("CheckRelatedMgsScene.fxml"));
         borderPane.setCenter(root);
        
    }

    @FXML
    private void feedbackButtonOnCliked(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("TakeFeedbacksScene.fxml"));
         borderPane.setCenter(root);
        
    }

    @FXML
    private void instrumentBudgetButtonOnClicked(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("  MakeInstrumentBudgetScene.fxml"));
         borderPane.setCenter(root);
        
    }

    @FXML
    private void logOutButtonOnclicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainPkg/LoginSc.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene LoginSc = new Scene(parent);

        currentStage.setScene(LoginSc);
        currentStage.show();
    }
    
}
