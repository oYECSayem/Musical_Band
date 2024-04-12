/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sadia_2220645_Fan.LyricsAndSpecialMgs;
import static sadia_2220645_InstrumentManager.InstrumentManager.sendGuidelineAndManuals;
import static sadia_2220645_InstrumentManager.InstrumentManager.sendMgs;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class GiveTechnicalSupportAndServicesSceneController implements Initializable {

    @FXML
    private TextField instrumentNameTextField;
    @FXML
    private RadioButton onlineServiceRadioButton;
    @FXML
    private RadioButton offlineServiceRadioButton;
    
    @FXML
    private TextArea sendMgsTextArea;
    @FXML
    private TextArea guidelineTextArea;
    @FXML
    private TextArea manualTextArea;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TextArea guidelineAndManualDetailsTextArea;
   
    @FXML
    private TextArea receiveMgsTextArea;
    
    ToggleGroup tg;
    private ArrayList<SetupGuidelinesAndManuals> GuidelinesAndManualList=new ArrayList<>();
    @FXML
    private TextField mgsSenderNameTextField;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       tg=new ToggleGroup();
       onlineServiceRadioButton.setToggleGroup(tg);
       offlineServiceRadioButton.setToggleGroup(tg);
       
       instrumentNameTextField.setDisable(true);
       guidelineTextArea.setDisable(true);
       guidelineTextArea.setDisable(true);
       manualTextArea.setDisable(true);
       guidelineAndManualDetailsTextArea.setDisable(true);
       
       datepicker.setDisable(true);
       mgsSenderNameTextField.setDisable(true);
       sendMgsTextArea.setDisable(true);
       
       
       
        
    }

    @FXML
    private void onlineRadioButtonOnClicked(ActionEvent event) {
        if (onlineServiceRadioButton.isSelected()) {
            instrumentNameTextField.setDisable(false);
            guidelineTextArea.setDisable(false);
            guidelineTextArea.setDisable(false);
            manualTextArea.setDisable(false);
            guidelineAndManualDetailsTextArea.setDisable(false);

            datepicker.setDisable(true);
            sendMgsTextArea.setDisable(true);
            mgsSenderNameTextField.setDisable(true);

        }
    }

    @FXML
    private void offlineRadioButtonOnClicked(ActionEvent event) {
       instrumentNameTextField.setDisable(true);
       guidelineTextArea.setDisable(true);
       guidelineTextArea.setDisable(true);
       manualTextArea.setDisable(true);
       guidelineAndManualDetailsTextArea.setDisable(true);
       
       datepicker.setDisable(false);
       sendMgsTextArea.setDisable(false);
       mgsSenderNameTextField.setDisable(false);
    }
    @FXML
    private void addSetupGuidelineAndManualButtonOnClicked(ActionEvent event) {
        //SetupGuidelinesAndManuals(String instrumentName, String guidelines, String manuals)
        String instrumentName= instrumentNameTextField.getText();
        String guidelines= guidelineTextArea.getText();
        String manuals = manualTextArea.getText();
        
        
        SetupGuidelinesAndManuals guidelineAndManual;
        guidelineAndManual=new SetupGuidelinesAndManuals(instrumentName, guidelines, manuals);
        
        sendGuidelineAndManuals(guidelineAndManual);
        
        
        
        
        
    } 
    
    @FXML
    private void showGuidelineAndManualButtonOnClicked(ActionEvent event) {
        
        StringBuilder SB = new StringBuilder();

        for (SetupGuidelinesAndManuals sm : GuidelinesAndManualList ) {
            SB.append(sm.toString()).append("\n");
        }
        guidelineAndManualDetailsTextArea.setText(SB.toString());

    }

    @FXML
    private void sendMgsButtonOnclicked(ActionEvent event) {
        String senderName=mgsSenderNameTextField.getText();
        String mgsdescription=sendMgsTextArea.getText();
        LocalDate schedule=datepicker.getValue();
        
        Mgs m;
        m= new Mgs(senderName,mgsdescription,schedule);
        sendMgs(m);
        
    }

    @FXML
    private void receiveMgsButtonOnClicked(ActionEvent event) {
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
            lyricAndMgsDetails.append(mm.toString()).append("\n");
        }

        //showAllMgsAndLyricesTextArea.setText(lyricAndMgsDetails.toString());
    
    }

    @FXML
    private void ShowAndsendGuidelineAndManuaButtonOnClicked(ActionEvent event) {
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

        guidelineAndManualDetailsTextArea.setText(GuidelinesAndManualDetails.toString());
    }

        
    }

  
