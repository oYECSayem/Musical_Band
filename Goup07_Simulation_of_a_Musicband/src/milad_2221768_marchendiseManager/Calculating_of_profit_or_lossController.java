package milad_2221768_marchendiseManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Calculating_of_profit_or_lossController implements Initializable {

    @FXML
    private PieChart piechart;
    @FXML
    private Label sellTextArea;
    @FXML
    private Label investTextArea;
    @FXML
    private Label profitTextArea;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void returnToDashBoardFromCalcOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Merchendize_manager_dashboard.fxml"));
        root = (Parent) myLoader.load();
        Scene myScene = new Scene(root);

        Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        myStage.setScene(myScene);
        myStage.show();
    }

    @FXML
    private void generatePieOnClick(ActionEvent event) {
        ObjectInputStream ois = null;
        //ObservableList<PieChart.Data> pieChartData =
        //    FXCollections.observableArrayList(
        //    new PieChart.Data("Executed", 60),
        //    new PieChart.Data("Passed", 25),
        //    new PieChart.Data("Fails", 15));
        // chart.setData(pieChartData);

        ObservableList <Customer> MerchantList = FXCollections.observableArrayList();
        try {
             Customer i;
             ois = new ObjectInputStream(new FileInputStream("MerchantProfit.bin"));
             
            while(true){
                i = (Customer) ois.readObject();
                
               // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                
                 MerchantList.add(i);
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
        
        
    }
    
}
