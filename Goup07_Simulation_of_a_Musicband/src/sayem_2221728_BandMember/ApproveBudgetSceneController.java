/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_BandMember;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sadia_2220645_Fan.LyricsAndSpecialMgs;
import sadia_2220645_InstrumentManager.BudgetReceipt;
import static sayem_2221728_BandMember.BandMember.giveApprovedBudgetToAccountant;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ApproveBudgetSceneController implements Initializable {

    @FXML
    private TextArea othersBudgetInfoTA;
    @FXML
    private DatePicker dateTF;
    @FXML
    private TextField budgetIDTF;
    @FXML
    private TextField budgetEventTF;
    @FXML
    private TextField taxesTF;
    @FXML
    private TextField amountTF;
    @FXML
    private TableColumn<Budget, LocalDate> dateColumn;
    @FXML
    private TableColumn<Budget, Integer> budgetIDColumn;
    @FXML
    private TableColumn<Budget, String> budgetEventColumn;
    @FXML
    private TableColumn<Budget, Float> taxesColumn;
    @FXML
    private TableColumn<Budget, Float> amountColumn;
    @FXML
    private TableView<Budget> budgetTableView;
    Budget budget;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<Budget, LocalDate>("date"));
        budgetIDColumn.setCellValueFactory(new PropertyValueFactory<Budget, Integer>("ID"));
        budgetEventColumn.setCellValueFactory(new PropertyValueFactory<Budget, String>("event"));
        taxesColumn.setCellValueFactory(new PropertyValueFactory<Budget, Float>("taxes"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Budget, Float>("amount"));
    }    

    @FXML
    private void addBudgetInTableButton(ActionEvent event) {
    LocalDate date = dateTF.getValue();
    int budgetID;
    float taxes;
    float amount;
    
    // Check for empty fields
    if (dateTF.getValue() == null || budgetIDTF.getText().isEmpty() || 
        budgetEventTF.getText().isEmpty() || taxesTF.getText().isEmpty() ||
        amountTF.getText().isEmpty()) {
        // If any of the fields are empty, show the alert
        Alert unfill = new Alert(Alert.AlertType.WARNING);
        unfill.setTitle("Warning");
        unfill.setHeaderText(null);
        unfill.setContentText("Please fill in all fields.");
        unfill.showAndWait();
        return;
    }
    
    // Parse numeric fields
    /*try {
        budgetID = Integer.parseInt(budgetIDTF.getText());
        taxes = Float.parseFloat(taxesTF.getText());
        amount = Float.parseFloat(amountTF.getText());
    } catch (NumberFormatException e) {
        // If parsing fails, show an error alert and return
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please enter valid numeric values for Budget ID, Taxes, and Amount.");
        alert.showAndWait();
        return;
    }*/

    // If all checks pass, add the budget to the table
    budget = new Budget(dateTF.getValue(), Integer.parseInt(budgetIDTF.getText()), 
            budgetEventTF.getText(),Float.parseFloat(taxesTF.getText()), Float.parseFloat(amountTF.getText()));
    budgetTableView.getItems().add(budget);
    giveApprovedBudgetToAccountant(budget);
    
    // Show success alert
    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
    successAlert.setTitle("Success");
    successAlert.setHeaderText(null);
    successAlert.setContentText("Budget information has been successfully added to the table.");
    
    // Add a "Success" button
    ButtonType successButton = new ButtonType("Success");
    successAlert.getButtonTypes().setAll(successButton);
    
    // Show the alert and wait for the user to click the "Success" button
    successAlert.showAndWait().ifPresent(buttonType -> {
        if (buttonType == successButton) {
            // Do something if the "Success" button is clicked
            System.out.println("Success button clicked!");
        }
    });
}

    @FXML
    private void showOthersBudgetInfoButton(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList <BudgetReceipt> BudgetReceiptlist = FXCollections.observableArrayList();
        try {
             BudgetReceipt i;
             ois = new ObjectInputStream(new FileInputStream("BudgetReceipt.bin"));
             
            while(true){
                i = (BudgetReceipt) ois.readObject();
                
               
                  BudgetReceiptlist.add(i);
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
        
        
        StringBuilder BudgetReceiptlistDetails = new StringBuilder();
        for (BudgetReceipt mm : BudgetReceiptlist ) {
            BudgetReceiptlistDetails.append(mm.toString()).append("\n");
        }

        othersBudgetInfoTA.setText(BudgetReceiptlistDetails.toString());

        //othersBudgetInfoTA.setText(budgetDetails.toString());
    }
}


    

