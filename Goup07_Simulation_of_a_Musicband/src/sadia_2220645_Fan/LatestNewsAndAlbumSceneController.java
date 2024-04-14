package sadia_2220645_Fan;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import sadia_2220645_InstrumentManager.BudgetReceipt;


public class LatestNewsAndAlbumSceneController implements Initializable {

    @FXML
    private ComboBox<?> latestNewsComboBox;
    @FXML
    private ComboBox<?> albumsComboBox;
    @FXML
    private TextArea latestNewsTextArea;
    @FXML
    private TextArea albumTextArea;

   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your controller here
    }


    @FXML
    private void showNewsButtonOnClicked(ActionEvent event) {
        
        ObjectInputStream ois = null;
        ObservableList <BudgetReceipt> BudgetReceiptlist = FXCollections.observableArrayList();
        try {
             BudgetReceipt i;
             ois = new ObjectInputStream(new FileInputStream("BudgetReceipt.bin"));
             
            while(true){
                i = (BudgetReceipt) ois.readObject();
                
               // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                
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

        latestNewsTextArea.setText(BudgetReceiptlistDetails.toString());
        
    }

    @FXML
    private void showAlbumDetailsButtonOnClicked(ActionEvent event) {
        // Handle the show album details button click
    }
}
