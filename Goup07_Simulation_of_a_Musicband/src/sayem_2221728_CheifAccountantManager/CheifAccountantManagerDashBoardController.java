/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_CheifAccountantManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CheifAccountantManagerDashBoardController implements Initializable {

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
    private void makingBudgetPlanSceneButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MakingBudgetPlanScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void overallMonthlyProfitButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OverallMonthlyProfit.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void expenseTrackingSceneButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ExpenseTrackingScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void makeMonthlySalesReportButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MakeMonthlySalesReportScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void monitoringMonthlyRevenueSceneButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MonitoringMonthlyRevenueScene.fxml"));
         borderPane.setCenter(root);
    }

    @FXML
    private void taxCompalienceSceneButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TaxCompalienceScene.fxml"));
         borderPane.setCenter(root);
    }
    
}
