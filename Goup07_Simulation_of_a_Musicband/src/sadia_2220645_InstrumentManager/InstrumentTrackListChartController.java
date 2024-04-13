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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class InstrumentTrackListChartController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private BarChart<String, Number> barchart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }  
   


    @FXML
    private void viewInstrumentTrackChartButtonOnClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MakeInstrumentTrackListScene.fxml"));
        Parent root = loader.load();
        MakeInstrumentTrackListSceneController controller = loader.getController();

        ObservableList<Instrument> newUpdatedInstrumentList = controller.getInstrumentList();

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (Instrument instrument : newUpdatedInstrumentList) {
            series.getData().add(new XYChart.Data<>(instrument.getName(), instrument.getQantity()));
        }
        series.setName("Instrument  track  chart");
        barchart.getData().add(series);
    }
}
    

