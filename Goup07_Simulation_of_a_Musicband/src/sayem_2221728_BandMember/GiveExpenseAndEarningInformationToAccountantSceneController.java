/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_BandMember;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static sayem_2221728_BandMember.BandMember.giveOverallMonthlyProfitInfoToAccountant;


public class GiveExpenseAndEarningInformationToAccountantSceneController implements Initializable {

    @FXML
    private TextField eventNameTF;
    @FXML
    private TextField expenseTF;
    @FXML
    private TextField earningAmountTF;
    @FXML
    private TextArea infoTA;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void giveInoToAccountantButton(ActionEvent event) {
        String eventName = eventNameTF.getText();
        float expense = Float.parseFloat(expenseTF.getText());
        float earningAmount = Float.parseFloat(earningAmountTF.getText());
        ExpenseEarningInfo ee = new ExpenseEarningInfo(eventName, expense, earningAmount);
        giveOverallMonthlyProfitInfoToAccountant(ee);
        eventNameTF.clear();
        expenseTF.clear();
        earningAmountTF.clear();
    }
    
}
