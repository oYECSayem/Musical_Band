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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static sadia_2220645_InstrumentManager.InstrumentManager.makeBudgetForIntrument;
import static sadia_2220645_InstrumentManager.InstrumentManager.makeNewUpdatedInstrumentPurchasePlan;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MakeNewUpdatedInstrumentListSceneController implements Initializable {

    @FXML
    private TextField newInstrumentNameTextField;
    @FXML
    private TextField modelTextField;
    
    @FXML
    private TextField brandNameTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TableView<Instrument> newUpdatedInstrumentTableView;
    @FXML
    private TableColumn<Instrument, String> newInstrumentNameCol;
    @FXML
    private TableColumn<Instrument, String> modelCol;
    @FXML
    private TableColumn<Instrument, String> brandNameCol;
    @FXML
    private TableColumn<Instrument, Integer> priceCol;

    //ArrayList<Instrument> newUpdatedInstumentList=new ArrayList<>();
    
    @FXML
    private TableColumn<Instrument, Integer> qauntityCol;
    @FXML
    private TextField qantityTextField;
    
    
    
    Alert success= new Alert(Alert.AlertType.INFORMATION,"New updated Instrument Added Successfully!");
    Alert warning= new Alert(Alert.AlertType.WARNING,"Already added!");
    Alert alert = new Alert(Alert.AlertType.WARNING, "No instruments selected.");
    Alert duplicate = new Alert(Alert.AlertType.WARNING, "Instrument Added Already!.");  
    
    
    @FXML
    private Label brandNameTe;
            
    //Alert success=new Alert(Alert.AlertType.INFORMATION,"Successfully Added the product");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           //Instrument(String name, String model, int price, String brandName)
        newInstrumentNameCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Instrument, Integer>("price"));
        modelCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("model"));
        brandNameCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("brandName"));
        qauntityCol.setCellValueFactory(new PropertyValueFactory<Instrument, Integer>("qantity"));

        
         
        
       
    } 
    
    

    @FXML
    private void addNewupdatedInstrumentButtonOnClicked(ActionEvent event) {
        String newInstrumentsName=newInstrumentNameTextField.getText();
        String newInstrumentsModel=modelTextField.getText();
        int price=Integer.parseInt(priceTextField.getText());
        String brandName=brandNameTextField.getText();
        int qantity=Integer.parseInt( qantityTextField.getText());
        
       
       
       //Instrument(String name, String model, int qantity, int price, String brandName)
        Instrument ni=new Instrument( newInstrumentsName,newInstrumentsModel,  qantity,price,brandName);
        
       
        
         if(!Instrument.checknewUpdatedInstrumentExistance(ni)){
            makeNewUpdatedInstrumentPurchasePlan(ni);
               success.show();
         }else{
            warning.show();
         }
         
       
        
        
        newInstrumentNameTextField.clear();
        modelTextField.clear();
        priceTextField.clear();
        brandNameTextField.clear();
        qantityTextField.clear();

                
    }

    @FXML
    private void showNewUpdatedInstrumentButtonOnClicked(ActionEvent event) {
        //newUpdatedInstrumentTableView.getItems().addAll( newUpdatedInstumentList);
        
        ObjectInputStream ois = null;
        ObservableList <Instrument> newUpdatedInstrumentList = FXCollections.observableArrayList();
        try {
             Instrument i;
             ois = new ObjectInputStream(new FileInputStream("NewUpdatedInstrument.bin"));
             
            while(true){
                i = (Instrument) ois.readObject();
                
                 newUpdatedInstrumentList.add(i);
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

        
       newUpdatedInstrumentTableView.setItems( newUpdatedInstrumentList);
       
      
         
    }

    

    @FXML
    private void nextSceneForInstrumentPurchaseBudgetPlanButtonOnClicked(ActionEvent event) throws IOException {
     // Get selected items from the table
    ObservableList<Instrument> selectedInstruments = newUpdatedInstrumentTableView.getSelectionModel().getSelectedItems();

    // Check if any instrument is selected
    /*if (selectedInstruments.isEmpty()) {
        alert.showAndWait();
        return;
    }*/
    
    for (Instrument instrument : selectedInstruments) {
        // Check if the instrument is already present in the table
        boolean isDuplicate = false;
        for (Instrument existingInstrument : newUpdatedInstrumentTableView.getItems()) {
            if (existingInstrument.equals(instrument)) {
                isDuplicate = true;
                break;
            }
        }

        if (!isDuplicate) {
           
            duplicate.showAndWait();
        } else {
            // Show alert for duplicate instrument
            Alert alert = new Alert(Alert.AlertType.WARNING, "Selected instrument is already added.");
            alert.showAndWait();
        }
    }


    FXMLLoader loader = new FXMLLoader(getClass().getResource("MakeInstrumentBudgetScene.fxml"));
    Parent root = loader.load();
    MakeInstrumentBudgetSceneController controller = loader.getController();

    // Pass selected items to the next controller
    controller.setSelectedInstruments(selectedInstruments);

    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();
        
      
    }

   

    @FXML
    private void viewChartButtonOnClicked(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("InstrumentTrackListChart.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setTitle(" Chart");
        stage.setScene(scene);
        stage.show();
    }
    
    
}
