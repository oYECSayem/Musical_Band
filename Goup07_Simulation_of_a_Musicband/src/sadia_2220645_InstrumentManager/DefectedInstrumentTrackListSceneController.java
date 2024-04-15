/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static sadia_2220645_InstrumentManager.InstrumentManager.makeDefactedIntrumentList;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DefectedInstrumentTrackListSceneController implements Initializable {

   
    @FXML
    private TableView<DefectedInstrument> defectedInstrumentTableView;
    @FXML
    private TableColumn<DefectedInstrument, Integer> defectedInstrumentIdCol;
    @FXML
    private TableColumn<DefectedInstrument, String> defectedInstrumentnameCol;
    @FXML
    private TableColumn<DefectedInstrument, String> problemDescriptionCol;
    @FXML
    private TableColumn<DefectedInstrument, String> defectsCatagoryCol;
    private ComboBox<Integer> defectedInstumentIdComboBox;
    @FXML
    private RadioButton minorDefectRadioButton;
    @FXML
    private RadioButton majorDefectsRadioButton;
    @FXML
    private TextField defectedInstrumentNameTextField;
    @FXML
    private TextField defectedInstrumentIDTextField;
    @FXML
    private TextArea defectsDescriptionTextArea;
    
    

    ToggleGroup tg;
    
    
    Alert success=new Alert(Alert.AlertType.INFORMATION,"Successfully Added the product");
    Alert alert=new Alert(Alert.AlertType.WARNING," Instrument exixt Already!");
    
    
    ArrayList<DefectedInstrument> DefectedInstrumentList=new ArrayList<>();
    private TextArea defectedInstrumentDetailsTextArea;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tg = new ToggleGroup();
        minorDefectRadioButton.setToggleGroup(tg);
        majorDefectsRadioButton.setToggleGroup(tg);

        defectedInstrumentIdCol.setCellValueFactory(new PropertyValueFactory<DefectedInstrument, Integer>("defectedInstrumentId"));

        defectedInstrumentnameCol.setCellValueFactory(new PropertyValueFactory<DefectedInstrument, String>("defectedInstrumentName"));

        problemDescriptionCol.setCellValueFactory(new PropertyValueFactory<DefectedInstrument, String>("problemDescription"));

        defectsCatagoryCol.setCellValueFactory(new PropertyValueFactory<DefectedInstrument, String>("defectCatagory"));

    }

   /* private void instrumentIdButtonOnClicked(ActionEvent event) {
        Integer selecteddefectedInstrumentId=  defectedInstumentIdComboBox.getValue();
        for(DefectedInstrument di:DefectedInstrumentList){
            if (di.getDefectedInstrumentId()==selecteddefectedInstrumentId){
                defectedInstrumentDetailsTextArea.setText("DefectedInstrument ID:"+di.getDefectedInstrumentId()+"\n DefectedInstrument Name: "
                        +di.getDefectedInstrumentName()
                        +"\n Problem Description : "+di.getProblemDescription() +"\n Defect Catagory"+di.getDefectCatagory());
            break;
                
                
            }
        }
    }*/

    @FXML
    private void addDefectedInstrumentButtonOnClicked(ActionEvent event) {
        int defectedInstrumentId=Integer.parseUnsignedInt(defectedInstrumentIDTextField.getText());
        String defectedInstrumentName=defectedInstrumentNameTextField.getText();
        String problemDescription=defectsDescriptionTextArea.getText();
        
        DefectedInstrument i;
        
        String defectCatagory=" ";
        if(minorDefectRadioButton.isSelected()){
            defectCatagory="Minor Defects";
            
        }else if(majorDefectsRadioButton.isSelected()){
             defectCatagory="Major Defects";
        }
        
        i=new DefectedInstrument(defectedInstrumentId,defectedInstrumentName,problemDescription,defectCatagory);
        
         if(!DefectedInstrument.checkDefectedInstrumentExixtance(i)){
             makeDefactedIntrumentList(i);
        
               success.show();
         }else{
            alert.show();
         }
        
       
        
        success.show();
        DefectedInstrumentList.add(i);
        //defectedInstumentIdComboBox.getItems().add(defectedInstrumentId);
        
        defectedInstrumentIDTextField.clear();
        defectedInstrumentNameTextField.clear();
        defectsDescriptionTextArea.clear();
        
        minorDefectRadioButton.setSelected(false);
        majorDefectsRadioButton.setSelected(false);
        
    }

    @FXML
    private void viewDefectedInstrumentButtonOnClicked(ActionEvent event) {
         //defectedInstrumentTableView.getItems().addAll(DefectedInstrumentList);
         
         
        ObjectInputStream ois = null;
        ObservableList <DefectedInstrument> DefectedInstrumentInstrumentList = FXCollections.observableArrayList();
        try {
             DefectedInstrument i;
             ois = new ObjectInputStream(new FileInputStream("DefectedInstrument.bin"));
             
            while(true){
                i = (DefectedInstrument) ois.readObject();
                
               // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                
                 DefectedInstrumentInstrumentList.add(i);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }catch (EOFException e) {
            
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
          
          

        
       defectedInstrumentTableView.setItems( DefectedInstrumentInstrumentList);
       
        
    }

    @FXML
    private void maintananceAndRepairInfoScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MaintanaceAndRepairInfoScene.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene MaintanaceAndRepairInfoScene= new Scene(parent);

        currentStage.setScene(MaintanaceAndRepairInfoScene);
        currentStage.show();
        
    }

    @FXML
    private void homepageButtonOnClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InstrumentManagerDashboard.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene InstrumentManagerDashboard= new Scene(parent);

        currentStage.setScene(InstrumentManagerDashboard);
        currentStage.show();
        
    }
    
}
