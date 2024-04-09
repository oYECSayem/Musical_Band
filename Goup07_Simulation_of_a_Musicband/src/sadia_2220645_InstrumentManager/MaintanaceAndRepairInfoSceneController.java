/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

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

    /**
     * Initializes the controller class.
     */
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
    private void addRepairedInstrumentButtonOnClicked(ActionEvent event) {
    }
    
}
