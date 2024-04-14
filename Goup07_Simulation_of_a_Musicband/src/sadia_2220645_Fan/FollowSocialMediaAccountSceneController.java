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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import sayem_2221728_BandMember.SocialMedia;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FollowSocialMediaAccountSceneController implements Initializable {

    @FXML
    private AnchorPane facebookRadioButton;
    @FXML
    private RadioButton instagramRadioButton;
    @FXML
    private ComboBox<String> bandMembarNameComboBox;
    @FXML
    private RadioButton twitterRadioButton;
    @FXML
    private RadioButton youTubeRadioButton;
    @FXML
    private Label resultLabel;
    @FXML
    private TextArea allmeadialinksTextArea;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bandMembarNameComboBox.getItems().addAll("Sayem","Milad","Sadia","Fahim");
       
    }    

    @FXML
    private void bandMemberNameButtonOnClicked(ActionEvent event) {
        
        if( bandMembarNameComboBox.getValue().equals("Sayem")){
            allmeadialinksTextArea.setText("Facebook: facebook.com/Sayem\n" +
        "Instagram: instagram.com/Sayem\n" +
        "YouTube: youtube.com/user/Sayem\n" +
        "Twitter: twitter.com/Sayem");
            
        }else if( bandMembarNameComboBox.getValue().equals("Milad")){
            allmeadialinksTextArea.setText("Facebook: facebook.com/Milad\n" +
        "Instagram: instagram.com/Milad\n" +
        "YouTube: youtube.com/user/Milad\n" +
        "Twitter: twitter.com/Milad");
            
        }else if( bandMembarNameComboBox.getValue().equals("Sadia")){
            allmeadialinksTextArea.setText("Facebook: facebook.com/Sadia\n" +
        "Instagram: instagram.com/Sadia\n" +
        "YouTube: youtube.com/user/Sadia\n" +
        "Twitter: twitter.com/Sadia");
            
        }else if( bandMembarNameComboBox.getValue().equals("Fahim")){
            allmeadialinksTextArea.setText("Facebook: facebook.com/Fahim\n" +
        "Instagram: instagram.com/Fahim\n" +
        "YouTube: youtube.com/user/Fahim\n" +
        "Twitter: twitter.com/Fahim");
            
        }
    }

    @FXML
    private void showSocialMediaLinksButtonOnClicked(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList<SocialMedia> SocialMedialist = FXCollections.observableArrayList();
        try {
           SocialMedia i;
            ois = new ObjectInputStream(new FileInputStream("SocialMedia.bin"));

            while (true) {
                i = (SocialMedia) ois.readObject();

                // if(i.getFb()){
                
                SocialMedialist.add(i);
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
        StringBuilder SocialMediaDetails = new StringBuilder();
        for (SocialMedia mm : SocialMedialist) {
           SocialMediaDetails .append(mm.toString()).append("\n");
        }

        allmeadialinksTextArea.setText(SocialMediaDetails.toString());
    }
    
    
    
}
