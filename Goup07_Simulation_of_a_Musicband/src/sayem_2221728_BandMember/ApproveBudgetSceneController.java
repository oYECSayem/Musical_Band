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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sadia_2220645_Fan.LyricsAndSpecialMgs;
import sadia_2220645_InstrumentManager.BudgetReceipt;

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
    @FXML
    private Button showOthersBudgetInfoButton;

    
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
        int budgetID = Integer.parseInt(budgetIDTF.getText());
        String budgetEvent = budgetEventTF.getText();
        float taxes = Float.parseFloat(taxesTF.getText());
        float amount = Float.parseFloat(amountTF.getText());

        budget = new Budget(date, budgetID, budgetEvent, taxes, amount);
        budgetTableView.getItems().add(budget);
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
        
         // Display feedback details in the TextArea
        StringBuilder BudgetReceiptlistDetails = new StringBuilder();
        for (BudgetReceipt mm : BudgetReceiptlist ) {
            BudgetReceiptlistDetails.append(mm.toString()).append("\n");
        }

        othersBudgetInfoTA.setText(BudgetReceiptlistDetails.toString());

        //othersBudgetInfoTA.setText(budgetDetails.toString());
    }
}


    

