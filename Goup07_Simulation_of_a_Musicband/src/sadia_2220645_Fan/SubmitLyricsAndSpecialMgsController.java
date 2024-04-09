/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_Fan;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static sadia_2220645_Fan.Fan.submitSpecialMgsAndLyrics;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SubmitLyricsAndSpecialMgsController implements Initializable {

    @FXML
    private TextArea sendMgsTextArea;
    @FXML
    private TextField nameTextField;
    private TextArea receiveMgsTextArea;
    @FXML
    private TextArea lyricsTextArea;
    @FXML
    private TextArea showAllMgsAndLyricesTextArea;
    @FXML
    private TextArea receiveMgsTextArea1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
   @FXML
    private void submitMgsAndLyricsButtonOnClicked(ActionEvent event) {

   
        String senderName = nameTextField.getText();
        String mgs = sendMgsTextArea.getText();
        String lyr = lyricsTextArea.getText();

     
        LyricsAndSpecialMgs mgsObj = new LyricsAndSpecialMgs(senderName, lyr, mgs);

        
        // Writing file
        submitSpecialMgsAndLyrics(mgsObj);

        
        nameTextField.clear();
        sendMgsTextArea.clear();
        lyricsTextArea.clear();

    }


   
    @FXML
    private void receiveMgsButtonOnClicked(ActionEvent event) {


      
    }

    @FXML
    private void viewAllMgsAndLyricsButtonOnClicked(ActionEvent event) {
        
        
         ObjectInputStream ois = null;
        ObservableList<LyricsAndSpecialMgs> LyricsAndSpecialMgslist = FXCollections.observableArrayList();
        try {
           LyricsAndSpecialMgs i;
            ois = new ObjectInputStream(new FileInputStream("LyricsAndSpecialMgs.bin"));

            while (true) {
                i = (LyricsAndSpecialMgs) ois.readObject();

                // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                LyricsAndSpecialMgslist.add(i);
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
        StringBuilder lyricAndMgsDetails = new StringBuilder();
        for (LyricsAndSpecialMgs mm : LyricsAndSpecialMgslist) {
            lyricAndMgsDetails .append(mm.toString()).append("\n");
        }

        showAllMgsAndLyricesTextArea.setText(lyricAndMgsDetails.toString());
    }

    

}


