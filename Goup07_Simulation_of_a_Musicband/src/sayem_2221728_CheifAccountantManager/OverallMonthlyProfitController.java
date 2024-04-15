/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_CheifAccountantManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sadia_2220645_InstrumentManager.BudgetReceipt;
import sayem_2221728_BandMember.Budget;
import sayem_2221728_BandMember.ExpenseEarningInfo;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class OverallMonthlyProfitController implements Initializable {

    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private TextField yearTextField;
    @FXML
    private TableView<DummyProfit> overallMonthlyProfitTV;
    @FXML
    private TableColumn<DummyProfit, LocalDate> dateColumn;
    @FXML
    private TableColumn<DummyProfit, String> eventNameColumn;
    @FXML
    private TableColumn<DummyProfit, Float> incomeColumn;
    @FXML
    private TableColumn<DummyProfit, Float> expenseColumn;
    @FXML
    private TableColumn<DummyProfit, Float> profitColumn;
    @FXML
    private DatePicker dateDP;
    @FXML
    private TextField eventNameTF;
    @FXML
    private TextField incomeTF;
    @FXML
    private TextField expenseTF;
    @FXML
    private TextArea profitAmountTA;
    @FXML
    private TextArea totalProfitAmountTA;
    @FXML
    private TextArea expenseEarningInfoTA;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<DummyProfit, LocalDate>("date"));
        eventNameColumn.setCellValueFactory(new PropertyValueFactory<DummyProfit, String>("eventName"));
        incomeColumn.setCellValueFactory(new PropertyValueFactory<DummyProfit, Float>("income"));
        expenseColumn.setCellValueFactory(new PropertyValueFactory<DummyProfit, Float>("expense"));
        profitColumn.setCellValueFactory(new PropertyValueFactory<DummyProfit, Float>("profit"));
    }    


    @FXML
    private void showMonthlyProfitChartButton(ActionEvent event) {
    }

    @FXML
    private void getInExpenseEarningInfoButton(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList <ExpenseEarningInfo> ExpenseEarningInfolist = FXCollections.observableArrayList();
        try {
             ExpenseEarningInfo i;
             ois = new ObjectInputStream(new FileInputStream("ExpenseEarningInfo.bin"));
             
            while(true){
                i = (ExpenseEarningInfo) ois.readObject();
                
               
                  ExpenseEarningInfolist.add(i);
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
        
        
        StringBuilder ExpenseEarningInfolistDetails = new StringBuilder();
        for (ExpenseEarningInfo ee : ExpenseEarningInfolist ) {
            ExpenseEarningInfolistDetails.append(ee.toString()).append("\n");
        }

        expenseEarningInfoTA.setText(ExpenseEarningInfolistDetails.toString());
    }

    @FXML
    private void calculateTotalProfitButton(ActionEvent event) {
        float totalProfit = 0.0f;
        ObservableList<DummyProfit> items = overallMonthlyProfitTV.getItems();

        for (DummyProfit item : items) {
            totalProfit += item.getProfit();
    }
    
    totalProfitAmountTA.setText(Float.toString(totalProfit));
}


    @FXML
    private void addToTableButton(ActionEvent event) {
        LocalDate date = dateDP.getValue();
        String eventName = eventNameTF.getText();
        float expense = Float.parseFloat(expenseTF.getText());
        float income = Float.parseFloat(incomeTF.getText());
        float profit = Float.parseFloat(profitAmountTA.getText());
        DummyProfit dp = new DummyProfit(date, eventName, expense, income, profit);
        overallMonthlyProfitTV.getItems().add(dp);
        if (dateDP.getValue() == null|| eventNameTF.getText().isEmpty()){}
    }

    @FXML
    private void calculateProfitButton(ActionEvent event) {
        
        float profit = Float.parseFloat(incomeTF.getText()) - Float.parseFloat(expenseTF.getText());
        profitAmountTA.setText(Float.toString(profit));
    }
}

    
