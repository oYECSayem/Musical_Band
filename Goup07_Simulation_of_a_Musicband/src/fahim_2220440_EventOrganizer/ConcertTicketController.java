/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fahim_2220440_EventOrganizer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author MOSTOFA FAHIM HASAN
 */
public class ConcertTicketController implements Initializable {

    @FXML
    private ComboBox<String> selectTicketQuantityComboBox;
    @FXML
    private RadioButton vipTicketRadioButton;
    @FXML
    private RadioButton nonVipTicketRadioButton;
    @FXML
    private TableView<ConcertTicket> concertTicketDetailsTableView;
    @FXML
    private TableColumn<ConcertTicket, String> ticketIdColumn;
    @FXML
    private TableColumn<ConcertTicket, String> concertDetailsColumn;
    @FXML
    private TableColumn<ConcertTicket, String> ticketTypeColumn;
    @FXML
    private TableColumn<ConcertTicket, String> ticketPriceColumn;
    @FXML
    private TableColumn<ConcertTicket, String> quantityColumn;
    @FXML
    private TableColumn<ConcertTicket, String> totalPriceColumn;
    @FXML
    private Button addYourConcertEventButton;
    @FXML
    private Button ticketPurchageNextProcessButton;
    
    
    ToggleGroup tg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tg= new ToggleGroup();
        vipTicketRadioButton.setToggleGroup(tg);
        nonVipTicketRadioButton.setToggleGroup(tg);
        
        selectTicketQuantityComboBox.getItems().add("ONE");
        selectTicketQuantityComboBox.getItems().add("TWO");
        selectTicketQuantityComboBox.getItems().add("Three");
        selectTicketQuantityComboBox.getItems().add("Four");
              
        ticketIdColumn.setCellValueFactory(new PropertyValueFactory<>("ticketID"));
        concertDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("concertDeatils"));
        ticketTypeColumn.setCellValueFactory(new PropertyValueFactory<>("ticketType"));
        ticketPriceColumn.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("ticketQuantity"));
       
        
    }    

    @FXML
    private void ticketPurchaseOnClick(ActionEvent event) {
        String ticketType="";
        if (vipTicketRadioButton.isSelected())
            ticketType="vipTicketRadioButton";
        else if(nonVipTicketRadioButton.isSelected())
            ticketType="nonVipTicketRadioButton";
        }   
                    
    }
    

