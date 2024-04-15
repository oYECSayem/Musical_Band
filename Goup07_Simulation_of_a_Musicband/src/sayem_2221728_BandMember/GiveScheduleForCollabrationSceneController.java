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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sadia_2220645_Fan.LyricsAndSpecialMgs;
import static sayem_2221728_BandMember.BandMember.giveCollabrationSchedule;

public class GiveScheduleForCollabrationSceneController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField eventTitlesTF;
    @FXML
    private TextArea descriptionsTA;
    @FXML
    private DatePicker datesDP;
    @FXML
    private TextField timesTF;
    @FXML
    private TextField locationTF;
    @FXML
    private TextArea giveawayTA;
    @FXML
    private TextArea viewSchedueTA;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // String eventTitle, String description, String date, String time, String location, String giveaway
       
    }    

    @FXML
    private void submitSchedule(ActionEvent event) {
       String eventTitle = eventTitlesTF.getText();
       String description = descriptionsTA.getText();
       LocalDate date = datesDP.getValue();
       String time = timesTF.getText();
       String location = locationTF.getText();
       String giveawayDetails = giveawayTA.getText();
       if (eventTitlesTF.getText().isEmpty()|| descriptionsTA.getText() .isEmpty() || 
           timesTF.getText().isEmpty()|| locationTF.getText().isEmpty() || giveawayTA.getText().isEmpty()
               ||datesDP.getValue() == null){
           Alert unfill = new Alert(Alert.AlertType.WARNING);
           unfill.setTitle("Warning");
           unfill.setHeaderText(null);
           unfill.setContentText("Please fill in all fields.");
           unfill.showAndWait();
           return;
       }
       EventSchedule eSc = new EventSchedule(eventTitle, description, date, time, location, giveawayDetails);
       giveCollabrationSchedule(eSc);
       eventTitlesTF.clear();
       descriptionsTA.clear();
       timesTF.clear();
       locationTF.clear();
       giveawayTA.clear();
       Alert success = new Alert(Alert.AlertType.CONFIRMATION);
       success.setTitle("Success");
       success.setHeaderText(null);
       success.setContentText("Schedule Successfully added");
       success.show();
       return;
       
    }

    @FXML
    private void viewtSchedule(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList<EventSchedule> EventSchedulelist = FXCollections.observableArrayList();
        try {
           EventSchedule i;
            ois = new ObjectInputStream(new FileInputStream("EventSchedule.bin"));

            while (true) {
                i = (EventSchedule) ois.readObject();

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

        viewSchedueTA.setText(EventSchedulelist.toString());
    }
}
    

