/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_Fan;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import sayem_2221728_BandMember.EventSchedule;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GreetAndMeetInformationSceneController implements Initializable {

    @FXML
    private TextArea greetAndMeetInfoTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void seeMeetAndgreetInfoButtonOnClicked(ActionEvent event) {
         ObjectInputStream ois = null;
        ObservableList<EventSchedule> EventSchedulelist = FXCollections.observableArrayList();
        try {
           EventSchedule i;
            ois = new ObjectInputStream(new FileInputStream("EventSchedule.bin"));

            while (true) {
                i = (EventSchedule) ois.readObject();
                //if(i.)

                // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                EventSchedulelist.add(i);
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
        for (EventSchedule mm : EventSchedulelist) {
            lyricAndMgsDetails .append(mm.toString()).append("\n");
        }

        greetAndMeetInfoTextArea.setText(EventSchedulelist.toString());
    }
    
    
}
