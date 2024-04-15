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
import sayem_2221728_BandMember.Message;


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
     /* ObjectInputStream ois = null;
        ObservableList <Latestnews> LatestnewsList = FXCollections.observableArrayList();
        try {
             Latestnews i;
             ois = new ObjectInputStream(new FileInputStream("Latestnews.bin"));
             
            while(true){
                i = (Latestnews) ois.readObject();
              
                LatestnewsList.add(i);
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
    StringBuilder LatestnewsDetails = new StringBuilder();
    for (Latestnews n : LatestnewsList) {
        LatestnewsDetails.append(n.toString()).append("\n");
    }

      latestNewsTextArea.setText(LatestnewsDetails.toString());*/
        
        
    }

    @FXML
    private void showAlbumDetailsButtonOnClicked(ActionEvent event) {
        // Handle the show album details button click
    }
}
