/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sayem_2221728_BandMember;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sadia_2220645_InstrumentManager.SetupGuidelinesAndManuals;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TakeSupportFromInstrumentManagerSceneController implements Initializable {

    @FXML
    private TextArea technicalProblemTA;
    @FXML
    private TextField nameTF;
    @FXML
    private ComboBox<String> bandMemberRoleCB;
    @FXML
    private ComboBox<String> instrumentNameCB;
    @FXML
    private RadioButton majorRB;
    @FXML
    private RadioButton minorRB;
    @FXML
    private ToggleGroup problemTypeRB;
    @FXML
    private TextArea recieveMessageTA;
    @FXML
    private TextArea viewGuidelineTA;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bandMemberRoleCB.getItems().addAll("Vocal", "guitarist", 
                "Bassiest","Drammer", "Keyboardiest" );
        instrumentNameCB.getItems().addAll("Guitar", "Bass guitar",
                "Keyboard", "Dram");
    }    

    @FXML
    private void contactForTechnicalSupportButton(ActionEvent event) {
    }


    @FXML
    private void viewGuidelineButton(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList<SetupGuidelinesAndManuals> GuidelinesAndManualslist = FXCollections.observableArrayList();
        try {
            SetupGuidelinesAndManuals i;
            ois = new ObjectInputStream(new FileInputStream("GuidelineAndManuals.bin"));

            while (true) {
                i = (SetupGuidelinesAndManuals) ois.readObject();

                // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                GuidelinesAndManualslist.add(i);
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
        StringBuilder GuidelinesAndManualDetails = new StringBuilder();
        for (SetupGuidelinesAndManuals s : GuidelinesAndManualslist) {
             GuidelinesAndManualDetails.append(s.toString()).append("\n");
        }

        viewGuidelineTA.setText(GuidelinesAndManualDetails.toString());
    }
    

    /*@FXML
    private void recieveMessageButton(ActionEvent event) {
        {
        ObjectInputStream ois = null;
        ObservableList<sadia_2220645_InstrumentManager.Message> messagelist = FXCollections.observableArrayList();
        try {
           Message i;
            ois = new ObjectInputStream(new FileInputStream("InstrumentManagderMessages.bin"));

            while (true) {
                i = (Message) ois.readObject();

                // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                messagelist.add(i);
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
        StringBuilder budgetDetails = new StringBuilder();
        for (Budget mm : budgetlist) {
            budgetDetails .append(mm.toString()).append("\n");
        }

        recieveMessageTA.setText(budgetDetails.toString());
    }
    }*/
    
    
    
}
