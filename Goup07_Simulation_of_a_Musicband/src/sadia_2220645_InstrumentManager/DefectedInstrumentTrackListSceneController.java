/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    @FXML
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
    
    ArrayList<DefectedInstrument> DefectedInstrumentList=new ArrayList<>();
    @FXML
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

    @FXML
    private void instrumentIdButtonOnClicked(ActionEvent event) {
        Integer selecteddefectedInstrumentId=  defectedInstumentIdComboBox.getValue();
        for(DefectedInstrument di:DefectedInstrumentList){
            if (di.getDefectedInstrumentId()==selecteddefectedInstrumentId){
                defectedInstrumentDetailsTextArea.setText("DefectedInstrument ID:"+di.getDefectedInstrumentId()+"\n DefectedInstrument Name: "
                        +di.getDefectedInstrumentName()
                        +"\n Problem Description : "+di.getProblemDescription() +"\n Defect Catagory"+di.getDefectCatagory());
            break;
                
                
            }
        }
    }

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
        DefectedInstrumentList.add(i);
        defectedInstumentIdComboBox.getItems().add(defectedInstrumentId);
        
        
        
        
    }

    @FXML
    private void viewDefectedInstrumentButtonOnClicked(ActionEvent event) {
         defectedInstrumentTableView.getItems().addAll(DefectedInstrumentList);
        
    }

    @FXML
    private void maintananceAndRepairInfoScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MaintenanceAndRepairInformationScene.fxml"));
        Parent parent = loader.load();

        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene MaintenanceAndRepairInformationScene= new Scene(parent);

        currentStage.setScene(MaintenanceAndRepairInformationScene);
        currentStage.show();
        
    }
    
}
