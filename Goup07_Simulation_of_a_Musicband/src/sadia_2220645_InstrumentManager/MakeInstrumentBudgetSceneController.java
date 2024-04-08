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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import static sadia_2220645_InstrumentManager.InstrumentManager.makeBudgetForIntrument;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MakeInstrumentBudgetSceneController implements Initializable {

    @FXML
    private TableView<Instrument> instrumentBudgetPlanTableView;
    @FXML
    private TableColumn<Instrument, String> newInstrumentNameCol;
    @FXML
    private TableColumn<Instrument, String> modelCol;
    @FXML
    private TableColumn<Instrument, String> brandNameCol;
    @FXML
    private TableColumn<Instrument, Integer> piceCol;
    @FXML
    private TableColumn<Instrument, Integer> qantityCol;
    @FXML
    private TableColumn<Instrument, Integer> totalPriceCol;
    
    private ObservableList<Instrument> selectedInstruments;
     Alert alert1 = new Alert(Alert.AlertType.WARNING, "No instruments selected.");
     Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Selected instruments added to the budget plan.");
    @FXML
    private TextArea detailstextArea;


    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Instrument(String name, String model, int qantity, int price, String brandName)
        newInstrumentNameCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("name"));
        modelCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("model"));
        brandNameCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("brandName"));
        piceCol.setCellValueFactory(new PropertyValueFactory<Instrument, Integer>("price"));
        qantityCol.setCellValueFactory(new PropertyValueFactory<Instrument, Integer>("qantity"));
        totalPriceCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPrice() * cellData.getValue().getQantity()).asObject());
        //totalPriceCol.setCellValueFactory(new PropertyValueFactory<Instrument, Integer>("totalPrice"));
    }

    // Method to set selected instruments
    public void setSelectedInstruments(ObservableList<Instrument> selectedInstruments) {
        this.selectedInstruments = selectedInstruments;
        
       //instrumentBudgetPlanTableView.getItems().addAll(selectedInstruments);
    }

    @FXML
    private void addInstrumentToTheBudjetPlanButtonOnClicked(ActionEvent event) {
        
        // Check if any instrument is selected
    if (selectedInstruments == null || selectedInstruments.isEmpty()) {
       
        alert1.showAndWait();
        return;
    }

    for (Instrument instrument : selectedInstruments) {
        // Check if the instrument is already present in the table
        boolean isDuplicate = false;
        for (Instrument existingInstrument : instrumentBudgetPlanTableView.getItems()) {
            if (existingInstrument.equals(instrument)) {
                isDuplicate = true;
                break;
            }
        }

        if (!isDuplicate) {
            // Save the instrument to the file
            makeBudgetForIntrument(instrument);

            // Clear the table view before adding new items
            instrumentBudgetPlanTableView.getItems().clear();

            // Add the selected instruments to the table view
            instrumentBudgetPlanTableView.getItems().addAll(selectedInstruments);
        } else {
            // Show alert for duplicate instrument
            Alert alert = new Alert(Alert.AlertType.WARNING, "Selected instrument is already added.");
            alert.showAndWait();
        }
    }

    alert2.showAndWait();

  
    }

    @FXML
    private void viewBudjetPlanButtonOnClicked(ActionEvent event) {
        
        ObjectInputStream ois = null;
        ObservableList <Instrument> instrumentbudgetplanlist = FXCollections.observableArrayList();
        try {
             Instrument i;
             ois = new ObjectInputStream(new FileInputStream("InstrumentBudgetPlan.bin"));
             
            while(true){
                i = (Instrument) ois.readObject();
                
               // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                
                  instrumentbudgetplanlist.add(i);
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

     // Clear the table view before adding new items
    instrumentBudgetPlanTableView.getItems().clear();
    
    // Add items to the table view
    instrumentBudgetPlanTableView.setItems(instrumentbudgetplanlist);
    }

    @FXML
    private void clearButtonOnClicked(ActionEvent event) {
        // Get the selected row(s)
    ObservableList<Instrument> selectedInstruments = instrumentBudgetPlanTableView.getSelectionModel().getSelectedItems();

    // Remove the selected row(s) from the data model
     instrumentBudgetPlanTableView.getItems().removeAll(selectedInstruments);
        
       
    }

    @FXML
    private void submitbudjetPlanButtonOnClicked(ActionEvent event) {
     
        // Get the selected instrument
        Instrument selectedInstrument = instrumentBudgetPlanTableView.getSelectionModel().getSelectedItem();
        if (selectedInstrument != null) {
            
            detailstextArea.setText("\nName" + selectedInstrument.getName()
                    + "\nModel" + selectedInstrument.getModel() + "\nPrice:" + selectedInstrument.getPrice()
                    + "\nQuantity:" + selectedInstrument.getQantity()
                    +"\nTotal Price:" +selectedInstrument.getPrice() * selectedInstrument.getQantity());
        } else {
            
            Alert alert = new Alert(Alert.AlertType.WARNING, "No instrument selected.");
            alert.showAndWait();
        }

    }
        
    
  
       

    
}