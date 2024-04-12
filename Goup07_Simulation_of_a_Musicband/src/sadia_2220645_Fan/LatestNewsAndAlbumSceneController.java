package sadia_2220645_Fan;

import java.net.URL;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class LatestNewsAndAlbumSceneController implements Initializable {

    @FXML
    private ComboBox<?> latestNewsComboBox;
    @FXML
    private ComboBox<?> albumsComboBox;
    @FXML
    private TextArea latestNewsTextArea;
    @FXML
    private TextArea albumTextArea;

   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your controller here
    }


    @FXML
    private void showNewsButtonOnClicked(ActionEvent event) {
        
    }

    @FXML
    private void showAlbumDetailsButtonOnClicked(ActionEvent event) {
        // Handle the show album details button click
    }
}
