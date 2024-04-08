/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import MainPkg.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static sadia_2220645_InstrumentManager.InstrumentManager.addInstrument;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MakeInstrumentTrackListSceneController implements Initializable {
   
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
    private TextField instrumentNameTextField;
    
     ArrayList<Instrument> InstrumentList=new ArrayList<>();
      ArrayList<Integer> InstrumentID=new ArrayList<>();
    @FXML
    private TextField instrumentIdTextField;
    @FXML
    private TextArea instrumentDetailsTextArea;
    @FXML
    private ComboBox<Integer> instrumentIdComboBox;
    
    Alert success=new Alert(Alert.AlertType.INFORMATION,"Successfully Added the product");
     Alert alert=new Alert(Alert.AlertType.WARNING," product exixt Already!");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       // instrumentnameComboBox.getItems().addAll("Guitar", "Electric Guitar", "Piano", "Violin", "Flute",
        //         "Trumpet", "Drum set", "Saxophone", "Ukulele");

        instrumentNameCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("name"));
        IdCol.setCellValueFactory(new PropertyValueFactory<Instrument,Integer>("InstrumentID"));
        serialNumberCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("serialNumber"));
        modelCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("model"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("qantity"));
        
        
       
     
        
    }
  
    @FXML
    private void addNewInstrumentButtonOnClicked(ActionEvent event) {
        // int ID= Integer.parseInt(instrumentIdTextField.getText());
        
         //Instrument(String name, String serialNumber, String model, int InstrumentID, int qantity)
       // InstrumentList.add(new Instrument(instrumentNameTextField.getText(),serialNumberTextField.getText(), modelTextField.getText(),
        //        Integer.parseInt(instrumentIdTextField.getText()),Integer.parseInt(quantityTextField.getText())));
        
        
       
       // InstrumentID.add(ID);
        
        //instrumentIdComboBox.getItems().add(ID);
        String name=instrumentNameTextField.getText();
        int  InstrumentID= Integer.parseInt(instrumentIdTextField.getText());
        String serialNumber=serialNumberTextField.getText();
         String model=modelTextField.getText();
         
        int qantity=Integer.parseInt(quantityTextField.getText());
        
        //Instrument(String name, String serialNumber, String model, int InstrumentID, int qantity
        
        Instrument i=new Instrument(name, serialNumber,  model, InstrumentID, qantity);
         
        
         if(!Instrument.checkInstrumentExixtance(i)){
              addInstrument(i);
               success.show();
         }else{
            alert.show();
         }
         //InstrumentManager.addInstrument(i);
        
       
                    
        
    }
    
    @FXML
    private void showInstrumentListButtonOnClicked(ActionEvent event) {
        
        //instrumentListTableView.getItems().addAll(InstrumentList);
        
         ObjectInputStream ois = null;
        ObservableList <Instrument> InstrumentList = FXCollections.observableArrayList();
        try {
             Instrument i;
             ois = new ObjectInputStream(new FileInputStream("Instrument.bin"));
             
            while(true){
                i = (Instrument) ois.readObject();
                
               // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                
                 InstrumentList.add(i);
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

        
        instrumentListTableView.setItems( InstrumentList);
        
         
    }

    @FXML
    private void intumentIdComboBoxButtonOnClicked(ActionEvent event) {
        
          int scelecteID= instrumentIdComboBox.getValue();
         for(Instrument i:InstrumentList){
             if(i.getInstrumentID()==scelecteID){
                 instrumentDetailsTextArea.setText("\nInstrument Name:"+i.getName()+"\nInstumentId:"+i.getInstrumentID()
                         +"\nSerial Number:"+i.getSerialNumber()+"\nModel:"+i.getModel()+"\nQantity:"+i.getQantity());
             
             break;
             }
         }
    }


    
    
}
