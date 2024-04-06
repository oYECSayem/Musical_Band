/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MakeInstrumentTrackListSceneController implements Initializable {
    @FXML
    private TextField instrumentIdTextField;
    @FXML
    private TableView<Instrument> instrumentListTableView;
    @FXML
    private TableColumn<Instrument, String> instrumentNameCol;
    @FXML
    private TableColumn<Instrument, Integer> IdCol;
    @FXML
    private TableColumn<Instrument, String> serialNumberCol;
    @FXML
    private TableColumn<Instrument, String> modelCol;
    @FXML
    private TableColumn<Instrument, String> quantityCol;
    @FXML
    private TextField serialNumberTextField;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private ComboBox<String> instrumentnameComboBox;

    ArrayList<Instrument> InstrumentList=new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        instrumentnameComboBox.getItems().addAll("Guitar", "Electric Guitar", "Piano", "Violin", "Flute",
                 "Trumpet", "Drum set", "Saxophone", "Ukulele");

        instrumentNameCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("name"));
        IdCol.setCellValueFactory(new PropertyValueFactory<Instrument,Integer>("InstrumentID"));
        serialNumberCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("serialNumber"));
        modelCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("model"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("qantity"));
     
        
    }
  

    @FXML
    private void addInstrumentButtonOnClicked(ActionEvent event) {
        
         //Instrument(String name, String serialNumber, String model, int InstrumentID, int qantity)
        InstrumentList.add(new Instrument(instrumentnameComboBox.getValue(),serialNumberTextField.getText(), modelTextField.getText(),
                Integer.parseInt(instrumentIdTextField.getText()),Integer.parseInt(quantityTextField.getText())));
        
    }
    
   
    @FXML
    private void showInstrumentListButtonOnClicked(ActionEvent event) {
        
        instrumentListTableView.getItems().addAll(InstrumentList);   
        
    }


    
    
}
