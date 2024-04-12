/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import MainPkg.AppendableObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MaintanaceAndRepairInfoSceneController implements Initializable {

    @FXML
    private TableColumn<DefectedInstrument, Integer> repairInstrumentIDCol;
    @FXML
    private TableColumn<DefectedInstrument, String> defectCatagoryCol;
    @FXML
    private TableColumn<DefectedInstrument, String> problemDescriptionCol;
    @FXML
    private TableColumn<DefectedInstrument, Integer> repairCostCol;
    @FXML
    private TextArea expanceReciptTextArea;
    @FXML
    private TableView<DefectedInstrument> repairInstrumentsTableView;
    @FXML
    private TableColumn<DefectedInstrument, String> repairInstrumentNameCol;
    @FXML
    private TextField repairCostTextFiled;

    Alert success= new Alert(Alert.AlertType.INFORMATION,"Add successfully!");
    Alert alert = new Alert(Alert.AlertType.WARNING,"Please select an instrument from the table and enter the repair cost.");
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        repairInstrumentIDCol.setCellValueFactory(new PropertyValueFactory<DefectedInstrument, Integer>("defectedInstrumentId"));

        repairInstrumentNameCol.setCellValueFactory(new PropertyValueFactory<DefectedInstrument, String>("defectedInstrumentName"));

        problemDescriptionCol.setCellValueFactory(new PropertyValueFactory<DefectedInstrument, String>("problemDescription"));

        defectCatagoryCol.setCellValueFactory(new PropertyValueFactory<DefectedInstrument, String>("defectCatagory"));

      
    }    

    @FXML
    private void showRepairedInstrumentDetailsButtonOnClicked(ActionEvent event) {
         
          ObjectInputStream ois = null;
        ObservableList <DefectedInstrument> DefectedInstrumentInstrumentList = FXCollections.observableArrayList();
        try {
             DefectedInstrument i;
             ois = new ObjectInputStream(new FileInputStream("DefectedInstrument.bin"));
             
            while(true){
                i = (DefectedInstrument) ois.readObject();
                
                if(i.getDefectCatagory().equals("Minor Defects")){
                    DefectedInstrumentInstrumentList.add(i);
                }
               
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

        
       repairInstrumentsTableView.setItems( DefectedInstrumentInstrumentList);
       
        
        
    }

   
    

    @FXML
    private void goTopreviousSceneButtonOnClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DefectedInstrumentTrackListScene.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene DefectedInstrumentTrackListScene = new Scene(parent);

        currentStage.setScene(DefectedInstrumentTrackListScene);
        currentStage.show();
    }

    @FXML
    private void addRepairedInstrumentDetailsButtonOnClicked(ActionEvent event) {
         // Retrieve data from the selected TableView row
        DefectedInstrument selectedInstrument = repairInstrumentsTableView.getSelectionModel().getSelectedItem();
        
       // ObservableList<DefectedInstrument> selectedInstruments = repairInstrumentsTableView.getSelectionModel().getSelectedItems();

      
        // Retrieve data from the TextField
        int repairInstrumentCost = Integer.parseInt(repairCostTextFiled.getText());
        
       
        if (selectedInstrument == null || repairCostTextFiled.equals("null")) {

            alert.show();
            return; 
        }

        

        // Combine the retrieved data
        String combinedData = selectedInstrument.toString() + "\nRepair Cost:: " + repairInstrumentCost;

        
        
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("RepairedInstruments.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(combinedData);
            // Remove the selected row(s) from the data model
            repairInstrumentsTableView.getItems().removeAll(selectedInstrument);


        } catch (IOException ex) {
            
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
               // Logger.getLogger(Instrument.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       success.show();
    }

    @FXML
    private void showRepairedInstrumentExpanceButtonOnClicked(ActionEvent event) {
         StringBuilder data = new StringBuilder();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RepairedInstruments.bin"))) {
            while (true) {
                try {
                    String line = (String) ois.readObject();
                    data.append(line).append("\n");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        expanceReciptTextArea.setText(data.toString());
    }
        
    }
          
        




