/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_BandMember;

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
public class BandMemberDashboardController implements Initializable {

    @FXML
    private BorderPane borderPane;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void giveScheduleButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GiveScheduleForCollabrationScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void approveBudgetButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ApproveBudgetScene.fxml"));
         borderPane.setCenter(root);
    }


    @FXML
    private void instrumentTechnicalSupportButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TakeSupportFromInstrumentManagerScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void lyricsWritingButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FeedbackToFansActivityScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void contactWithOperationalManagerButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CommunicateWithOperationalManagerAndBandPromoter.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void communicationWithFansButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FeedbackToFansActivityScene.fxml"));
         borderPane.setCenter(root);
    }
    private void feedbackAndImprovemantButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TakeFeedbackAndImprovementSection.fxml"));
         borderPane.setCenter(root);
    }

    private void SocialMediaLinkButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SocialMediaScene.fxml"));
         borderPane.setCenter(root);
    }

    private void logOutButton(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainPkg/LoginSc.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene LoginSc = new Scene(parent);

        currentStage.setScene(LoginSc);
        currentStage.show();
    }

    @FXML
    private void uploadContentButton(ActionEvent event) {
    }

    @FXML
    private void giveEarningAndExpenseInfoToAccountantButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GiveExpenseAndEarningInformationToAccountantScene.fxml"));
         borderPane.setCenter(root);
    }
}
