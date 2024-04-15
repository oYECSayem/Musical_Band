/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_Fan;

import java.io.EOFException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import static sadia_2220645_Fan.Fan.giveFeedback;


/**
 * FXML Controller class
 *
 * @author USER
 */
public class GiveFeedbacksSceneController implements Initializable {

    @FXML
    private RadioButton albumRadioButton;
    @FXML
    private RadioButton songsRaddioButton;
    @FXML
    private RadioButton concertRadioButton;
    @FXML
    private RadioButton merchandiseRadioButton;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea viewfeedbackDetailsTextArea1;
    
    @FXML
    private TextField nameTextField;
    
    
   
    
    
    private ToggleGroup tg ;
    
    
    
    Alert ErrorDate= new Alert(Alert.AlertType.WARNING,"Please select the right date");
    Alert Success= new Alert(Alert.AlertType.INFORMATION,"Your Feedback Successfully Added!");
    
    
    private ObservableList<Feedback> fb = FXCollections.observableArrayList();
    // ArrayList<Feedback> fb= new ArrayList<>();
    @FXML
    private TextArea writeFeedbacksTextArea;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ToggleGroup tg=new ToggleGroup();
        albumRadioButton.setToggleGroup(tg);
        songsRaddioButton.setToggleGroup(tg);
        concertRadioButton.setToggleGroup(tg);
        merchandiseRadioButton.setToggleGroup(tg);
        
    }    

    @FXML
    private void submitFeedbackButtonOnClicked(ActionEvent event) {
        
        String topic = "";
        if (albumRadioButton.isSelected()) {
            topic = "Albums";
        } else if (songsRaddioButton.isSelected()) {
            topic = "Songs";
        }else if (concertRadioButton.isSelected()){
             topic = "Concert";
            
        }else if (merchandiseRadioButton.isSelected()){
             topic = "Merchandise";
            
        }

        String name = nameTextField.getText();
        String description =writeFeedbacksTextArea.getText();

        
    
        Feedback newfeedback;
       
        LocalDate date = datePicker.getValue();
        
        LocalDate selectedDate =datePicker .getValue();
        LocalDate currentDate = LocalDate.now();

        if (selectedDate != null && !selectedDate.isBefore(currentDate)) {
            newfeedback = new Feedback(name, topic, description,date);
            giveFeedback(newfeedback);
            Success.show();
        } else { 
          ErrorDate.show();}
        
        nameTextField.clear();
        datePicker.setValue(null);
        songsRaddioButton.setSelected(false);
       albumRadioButton.setSelected(false);
       concertRadioButton.setSelected(false);
       merchandiseRadioButton.setSelected(false);
        
       
        
    }

    @FXML
    private void viewFeedbackButtonOnClicked(ActionEvent event) {
       //instrumentListTableView.getItems().addAll(InstrumentList);
        
         ObjectInputStream ois = null;
        ObservableList <Feedback> feedbacklist = FXCollections.observableArrayList();
        try {
             Feedback i;
             ois = new ObjectInputStream(new FileInputStream("Feedback.bin"));
             
            while(true){
                i = (Feedback) ois.readObject();
                
               // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                
                 feedbacklist.add(i);
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
    StringBuilder feedbackDetails = new StringBuilder();
    for (Feedback feedback : feedbacklist) {
        feedbackDetails.append(feedback.toString()).append("\n");
    }

    viewfeedbackDetailsTextArea1.setText(feedbackDetails.toString());
    }
    
    
}
