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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sadia_2220645_Fan.LyricsAndSpecialMgs;
import static sayem_2221728_BandMember.BandMember.replyMessage;


public class FeedbackToFansActivitySceneController implements Initializable {

    @FXML
    private TextArea replyFansTA;
    @FXML
    private ComboBox<?> rateSongCB;
    @FXML
    private TextField nameTF;
    @FXML
    private TextArea fansMessageLyricsTA;

   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitReplyButton(ActionEvent event) {
        String msg1 = replyFansTA.getText();
        String sender1 = nameTF.getText();
        Message m = new Message(sender1, msg1);
        replyMessage(m);
    }

    @FXML
    private void acceptMessageLyricsButton(ActionEvent event) {
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

        fansMessageLyricsTA.setText(lyricAndMgsDetails.toString());
    }

}
    

