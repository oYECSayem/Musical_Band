/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_Fan;

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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FansDashboardController implements Initializable {

    @FXML
    private BorderPane borderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitSongsAndSpecialMgsButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SubmitLyricsAndSpecialMgs.fxml"));
         borderPane.setCenter(root);
        
    }

    @FXML
    private void followSocialMediaButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FollowSocialMediaAccountScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void latestAlbumsAndNewsButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LatestNewsAndAlbumScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void greetAndMeetButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GreetAndMeetInformationScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void contestButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("QuetionAndAnswerContestScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void concertTicketButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PurchasingTicketScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void merchandiseButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PurchaseMerchandiseScelectScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void FeedbackButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GiveFeedbacksScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void logOutButtonOnClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainPkg/LoginSc.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene LoginSc = new Scene(parent);

        currentStage.setScene(LoginSc);
        currentStage.show();
    }
    

    
    
}
