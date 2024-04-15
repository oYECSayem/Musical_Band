/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fahim_2220440_EventOrganizer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author MOSTOFA FAHIM HASAN
 */
public class TicketPlatformViewOfEventOrganizerController implements Initializable {

    @FXML
    private ComboBox<?> concertName;
    @FXML
    private ComboBox<?> ticketCategory;
    @FXML
    private Button addMoreTicket;
    @FXML
    private TableView<?> tableViewOfInfoOfTicket;
    @FXML
    private TableColumn<?, ?> totalTicket;
    @FXML
    private TableColumn<?, ?> soldTicket;
    @FXML
    private TableColumn<?, ?> remainTicket;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
