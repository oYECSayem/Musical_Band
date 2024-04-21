/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sadia_2220645_InstrumentManager;

import MainPkg.AppendableObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
      
     //ArrayList<Integer> InstrumentID=new ArrayList<>();
    @FXML
    private TextField instrumentIdTextField;
    private TextArea instrumentDetailsTextArea;
    @FXML
    private ComboBox<Integer> instrumentIdComboBox;
    
    Alert success = new Alert(Alert.AlertType.INFORMATION, "Successfully Added the product");
    Alert alert = new Alert(Alert.AlertType.WARNING, " Instrument exixt Already!");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Please fillup Everying!");

    Alert IDLength = new Alert(Alert.AlertType.WARNING, "ID must have 4 digits ");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid ID! ");
    Alert invalquantity = new Alert(Alert.AlertType.WARNING, "Invalid Quantity! ");
    @FXML
    private TextArea detailsTextArea;

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
       
        String name=instrumentNameTextField.getText();
        int  InstrumentID= Integer.parseInt(instrumentIdTextField.getText());
        String serialNumber=serialNumberTextField.getText();
         String model=modelTextField.getText();
         int qantity = Integer.parseInt(quantityTextField.getText());
        
        

        String IDtext = instrumentIdTextField.getText();
        String qantityText = quantityTextField.getText();

        if (instrumentNameTextField.getText().isEmpty() ||instrumentIdTextField.getText().isEmpty() || 
                serialNumberTextField.getText().isEmpty() || modelTextField.getText().isEmpty() || quantityTextField.getText().isEmpty()) {
            unfilled.show();
            
        }
        
        try {
            int instrumentId = Integer.parseInt(IDtext);
            int quantity = Integer.parseInt(qantityText);
            if (IDtext.length() != 4) {
                IDLength.show();
            } else if (quantity <= 0) {
                invalquantity.show();
            }
            if (instrumentNameTextField.getText().isEmpty() || instrumentIdTextField.getText().isEmpty()
                    || serialNumberTextField.getText().isEmpty() || modelTextField.getText().isEmpty() || quantityTextField.getText().isEmpty()) {
                unfilled.show();
            } else {

                Instrument instrument = new Instrument(name, serialNumber, model, instrumentId, quantity);

                if (!Instrument.checkInstrumentExixtance(instrument)) {
                    // Add the instrument if it doesn't already exist
                    addInstrument(instrument);
                    success.show();
                } else {
                    alert.show();
                }
            }
        } catch (NumberFormatException e) {

            invalid.show();
        }

        
        
        instrumentNameTextField.clear();
        instrumentIdTextField.clear();
        serialNumberTextField.clear();
        modelTextField.clear();
        quantityTextField.clear();
    }

        @FXML
    private void showInstrumentListButtonOnClicked(ActionEvent event ) {

        //instrumentListTableView.getItems().addAll(InstrumentList);
        ObjectInputStream ois = null;
        ObservableList<Instrument> InstrumentList = FXCollections.observableArrayList();
        try {
            Instrument i;
            ois = new ObjectInputStream(new FileInputStream("Instrument.bin"));

            while (true) {
                i = (Instrument) ois.readObject();

                // if(i.getInstrumentID()%2==0){
                //    InstrumentList.add(i);
                InstrumentList.add(i);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
            }
        }

            instrumentListTableView.setItems(InstrumentList);

    }

    @FXML
    private void intumentIdComboBoxButtonOnClicked(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
        
       //instrumentListTableView.getItems().addAll(InstrumentList);
        ObjectInputStream ois = null;
      
        ObservableList<Instrument> InstrumentList = FXCollections.observableArrayList();
        try {
            Instrument i;
            ois = new ObjectInputStream(new FileInputStream("Instrument.bin"));

            while (true) {
                i = (Instrument) ois.readObject();
                if(instrumentIdComboBox.getValue().equals(i.getInstrumentID())){
                     InstrumentList.add(i);
                }
               
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
            }
        }

            instrumentListTableView.setItems(InstrumentList);
            
            // Display feedback details in the TextArea
        StringBuilder Details = new StringBuilder();
        for (Instrument m : InstrumentList) {
            Details.append(m.toString()).append("\n");
        }

        detailsTextArea.setText(Details.toString());

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

     
     
     
     
     
     
     
     
    public ObservableList<Instrument> getInstrumentList() {
        ObservableList<Instrument> newUpdatedInstrumentList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Instrument.bin"))) {
            Instrument instrument;
            while ((instrument = (Instrument) ois.readObject()) != null) {
                newUpdatedInstrumentList.add(instrument);
            }
        } catch (EOFException eof) {
            // End of file reached, ignore
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newUpdatedInstrumentList;
    
    }

    @FXML
    private void addNewInstrumentIDButtonOnClicked(ActionEvent event) {
        //instrumentListTableView.getItems().addAll(InstrumentList);
        ObjectInputStream ois = null;
        ArrayList<Integer> InstrumentIDList=new ArrayList<>();
       
        try {
            Instrument i;
            ois = new ObjectInputStream(new FileInputStream("Instrument.bin"));

            while (true) {
                i = (Instrument) ois.readObject();

                InstrumentIDList.add(i.getInstrumentID());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
            }
        }
        
      instrumentIdComboBox.getItems().addAll(InstrumentIDList);
        
        
    }


    
    
}
