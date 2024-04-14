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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sadia_2220645_Fan.LyricsAndSpecialMgs;
import static sayem_2221728_BandMember.BandMember.giveSocialMediaLink;


public class SocialMediaSceneController implements Initializable {

    @FXML
    private TextField nameTF;
    @FXML
    private TextField fbTF;
    @FXML
    private TextField igTF;
    @FXML
    private TextField ytTF;
    @FXML
    private TextField twTF;
    @FXML
    private TextArea socialMediaTA;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addSocialMediaButton(ActionEvent event) {
        String name = nameTF.getText();
        String fb = fbTF.getText();
        String ig = igTF.getText();
        String yt = ytTF.getText();
        String tw =twTF.getText();
        SocialMedia sm = new SocialMedia(name, fb, ig, yt, tw);
        giveSocialMediaLink(sm);
    }

    @FXML
    private void viewSocialMediaButton(ActionEvent event) {
        ObjectInputStream ois = null;
        ObservableList<SocialMedia> SocialMedialist = FXCollections.observableArrayList();
        try {
           SocialMedia i;
            ois = new ObjectInputStream(new FileInputStream("SocialMedia.bin"));

            while (true) {
                i = (SocialMedia) ois.readObject();

                // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
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

        socialMediaTA.setText(SocialMediaDetails.toString());
    }
    
}
