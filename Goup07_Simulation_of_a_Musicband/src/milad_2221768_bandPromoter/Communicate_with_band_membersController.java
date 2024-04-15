package milad_2221768_bandPromoter;

//import java.io.File;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static milad_2221768_bandPromoter.Communication.addMassage;


public class Communicate_with_band_membersController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField massageText;
    @FXML
    private Label othermassage;
    @FXML
    private TextArea massageTextArea;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void returnDashboardOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Bandpromoter_dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sendButton(ActionEvent event) {
        String mass = massageText.getText();
        Communication c = new Communication(mass);
        
        
        File binFile = new File("Communication.bin");
        if (binFile.exists()) {
            binFile.delete();
        }
        
        addMassage(c);
        
        ObjectInputStream ois = null;
        ObservableList <Communication> CommunicationList = FXCollections.observableArrayList();
        try {
             Communication i;
             ois = new ObjectInputStream(new FileInputStream("Communication.bin"));
             
            while(true){
                i = (Communication) ois.readObject();
              
               CommunicationList.add(i);
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
        
        StringBuilder CommunicationDetails = new StringBuilder();
        for (Communication mm : CommunicationList) {
           CommunicationDetails.append(mm.toString()).append("\n");
        }
        
        massageTextArea.setText(CommunicationDetails.toString());

    }
    
}
