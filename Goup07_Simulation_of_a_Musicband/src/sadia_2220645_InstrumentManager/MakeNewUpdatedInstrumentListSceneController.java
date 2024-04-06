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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    private Label brandNameTe;
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

    ArrayList<Instrument> newUpdatedInstumentList=new ArrayList<>();
    
    
    Alert success= new Alert(Alert.AlertType.INFORMATION,"New updated Instrument Added Successfully!");
            
    //Alert success=new Alert(Alert.AlertType.INFORMATION,"Successfully Added the product");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           //Instrument(String name, String model, int price, String brandName)
        newInstrumentNameCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Instrument, Integer>("price"));
        modelCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("model"));
        brandNameCol.setCellValueFactory(new PropertyValueFactory<Instrument, String>("brandName"));

        
         
        
       
    }    

    @FXML
    private void addNewupdatedInstrumentButtonOnClicked(ActionEvent event) {
        String newInstrumentsName=newInstrumentNameTextField.getText();
        String newInstrumentsModel=modelTextField.getText();
        int price=Integer.parseInt(priceTextField.getText());
        String brandName=brandNameTextField.getText();
        
        
        Instrument newUpdatedInstrument;
        newUpdatedInstrument=new Instrument( newInstrumentsName,newInstrumentsModel, price,brandName);
        
        newUpdatedInstumentList.add(newUpdatedInstrument);
        success.show();
        
        newInstrumentNameTextField.clear();
        modelTextField.clear();
        priceTextField.clear();
        brandNameTextField.clear();

                
    }

    @FXML
    private void showNewUpdatedInstrumentButtonOnClicked(ActionEvent event) {
        newUpdatedInstrumentTableView.getItems().addAll( newUpdatedInstumentList);
    }

    

    @FXML
    private void nextSceneForInstrumentPurchaseBudgetPlanButtonOnClicked(ActionEvent event) throws IOException {
        
        Parent root=FXMLLoader.load(getClass().getResource("MakeInstrumentBudgetScene.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setTitle(" Receive mgs scene");
        stage.setScene(scene);
        stage.show();
        
      
    }
    
}
