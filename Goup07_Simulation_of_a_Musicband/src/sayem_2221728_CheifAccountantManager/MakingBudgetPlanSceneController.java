package sayem_2221728_CheifAccountantManager;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sayem_2221728_BandMember.Budget;


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
        
    }

    @FXML
    private void getTotalBudgetAmountButton(ActionEvent event) {
        
    }

    @FXML
    private void calculateBudgetSummeryButton(ActionEvent event) {
    }
    
}
