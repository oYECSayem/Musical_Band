package sayem_2221728_CheifAccountantManager;

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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sayem_2221728_BandMember.Budget;
import sayem_2221728_BandMember.SocialMedia;


public class MakingBudgetPlanSceneController implements Initializable {

    @FXML
    private AnchorPane showBudgetAmountLabel;
    @FXML
    private TableColumn<Budget, LocalDate> dateColumn;
    @FXML
    private TableColumn<Budget, Float> taxesColumn;
    @FXML
    private TableColumn<Budget, Float> amountColumn;
    @FXML
    private RadioButton monthlyRB;
    @FXML
    private RadioButton annuallyRB;
    @FXML
    private Label makingBudgetAmountLabel;
    @FXML
    private TableColumn<Budget, Integer> budgetIDColumn;
    @FXML
    private TableColumn<Budget, String> budgetEventColumn;
    @FXML
    private TextArea calculateBudgetTA;

    ToggleGroup tg;
    @FXML
    private TableView<Budget> makingBudgetPlanTV;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<Budget, LocalDate>("date"));
        budgetIDColumn.setCellValueFactory(new PropertyValueFactory<Budget, Integer>("ID"));
        budgetEventColumn.setCellValueFactory(new PropertyValueFactory<Budget, String>("event"));
        taxesColumn.setCellValueFactory(new PropertyValueFactory<Budget, Float>("taxes"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Budget, Float>("amount"));
        monthlyRB.setToggleGroup(tg);
        annuallyRB.setToggleGroup(tg);
    }    

    @FXML
    private void addEntryButton(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList<Budget> Budgetlist = FXCollections.observableArrayList();
        try {
           Budget i;
            ois = new ObjectInputStream(new FileInputStream("Budget.bin"));

            while (true) {
                i = (Budget) ois.readObject();

                // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                Budgetlist.add(i);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
            }
        }

        // Display feedback details in the TextArea
        StringBuilder BudgetDetails = new StringBuilder();
        for (Budget mm : Budgetlist) {
           BudgetDetails .append(mm.toString()).append("\n");
        }
        

        makingBudgetPlanTV.setItems(Budgetlist);
    }


    @FXML
    private void getTotalBudgetAmountButton(ActionEvent event) {
    // Initialize total amount variable
    float totalAmount = 0;

    // Traverse through the budgetList and sum up the amounts
    for (Budget budget : makingBudgetPlanTV.getItems()) {
        totalAmount += budget.getAmount();
    }

    // Display the total amount in the makingBudgetAmountLabel
    makingBudgetAmountLabel.setText("Total Budget Amount: $" + totalAmount);
}

    @FXML
    private void calculateBudgetSummeryButton(ActionEvent event) {
    // Initialize StringBuilder to store the summary
    StringBuilder summary = new StringBuilder();

    // Traverse through the budgetList and calculate summaries
    for (Budget budget : makingBudgetPlanTV.getItems()) {
        // Perform calculations and append to the summary
        // Example:
        // summary.append("Budget ID: ").append(budget.getID()).append(", Summary: ").append(calculateSummary(budget)).append("\n");
    }

    // Set the calculated summary to the calculateBudgetTA
    calculateBudgetTA.setText(summary.toString());
    }

    
}
