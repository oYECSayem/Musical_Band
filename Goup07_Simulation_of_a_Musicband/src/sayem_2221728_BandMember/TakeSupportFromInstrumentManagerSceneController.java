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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import sadia_2220645_InstrumentManager.Mgs;
import sadia_2220645_InstrumentManager.SetupGuidelinesAndManuals;
import static sayem_2221728_BandMember.BandMember.askForTechnicalSupport;


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
    private TextArea recieveMessageTA;
    @FXML
    private TextArea viewGuidelineTA;

    ToggleGroup tg;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        minorRB.setToggleGroup(tg);
        majorRB.setToggleGroup(tg);
        bandMemberRoleCB.getItems().addAll("Vocal", "guitarist", 
                "Bassiest","Drammer", "Keyboardiest" );
        instrumentNameCB.getItems().addAll("Guitar", "Bass guitar",
                "Keyboard", "Dram");
    }    

    @FXML
    private void contactForTechnicalSupportButton(ActionEvent event) {
        String name = nameTF.getText();
        String defectType = "";
        if (minorRB.isSelected()){
            defectType = "Minor defect";
        }
        if (majorRB.isSelected()){
            defectType = "Major defect";
        }
        String instrumentName = instrumentNameCB.getValue();
        String role = bandMemberRoleCB.getValue();
        
        //ObservableList<String> instrumentName = instrumentNameCB.getItems();

        // Cast the selected toggle to RadioButton
        //RadioButton selectedRadioButton = (RadioButton) problemTypeRB.getSelectedToggle();
        //Toggle problemType = selectedRadioButton != null ? selectedRadioButton : minorRB; // Default to minor if none selected

        //ObservableList<String> role = bandMemberRoleCB.getItems();
        String text = technicalProblemTA.getText();
        TechnicalSupportMessage m1 = new TechnicalSupportMessage(name,  text, instrumentName, role, defectType);
        askForTechnicalSupport(m1);
        technicalProblemTA.clear();
        nameTF.clear();
        technicalProblemTA.clear();
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
    

    @FXML
    private void recieveMessageButton(ActionEvent event) {
       {
        ObjectInputStream ois = null;
        ObservableList<Mgs> mgslist = FXCollections.observableArrayList();
        try {
           Mgs i;
            ois = new ObjectInputStream(new FileInputStream("InstrumentManagerMessages.bin"));
            while (true) {
                i = (Mgs) ois.readObject();

                // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                mgslist.add(i);
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
        StringBuilder mgsDetails = new StringBuilder();
        for (Mgs mm : mgslist) {
            mgsDetails .append(mm.toString()).append("\n");
        }

        recieveMessageTA.setText(mgsDetails.toString());
    }
    }
    
    
    
}
