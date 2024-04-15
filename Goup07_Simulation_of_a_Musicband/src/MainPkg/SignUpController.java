package MainPkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController implements Initializable {

    @FXML
    private TextField newUserNameTextField;
    @FXML
    private TextField newUserPhoneNumberTextField;
   
    @FXML
    private TextField newPasswordTextField;
    @FXML
    private TextField confirmPasswordTextField;
    @FXML
    private DatePicker newUserDob;
    @FXML
    private Button goback;
    @FXML
    private TextField newNameTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private Button signup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Fan", "Instrument Manager",
                "Chief Accountant Manager", "Band Member", "Merchandise Manager",
                 "Band Promoter", "Event Organizer", "Operational Manager");
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSc.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) goback.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            showAlert("Error", "Error Loading Scene", "An error occurred while loading the login scene.");
        }
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void createAccountButtonOnClick(ActionEvent event) {
        String fullName = newNameTextField.getText();
        String userName = newUserNameTextField.getText();
        String phoneNumber = newUserPhoneNumberTextField.getText();
        String password = newPasswordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();
        LocalDate dob = newUserDob.getValue();
        if (newNameTextField.getText().isEmpty()|| newUserNameTextField.getText().isEmpty()|| 
            newUserPhoneNumberTextField.getText().isEmpty()|| newPasswordTextField.getText().isEmpty()||
            confirmPasswordTextField.getText().isEmpty()||newUserDob.getValue()==null){
            Alert unfill = new Alert(Alert.AlertType.WARNING);
            unfill.setTitle("Warning");
            unfill.setHeaderText(null);
            unfill.setContentText("Please fill in all fields.");
            unfill.showAndWait();
            return;
        }
        

        
        if (!isValidPassword(password)) {
            showAlert("Error", "Invalid Password",
                    "Password must be 8 characters long and contain at least one letter and one number.");
            return; 
        }

        
        if (!isValidPhoneNumber(phoneNumber)) {
            showAlert("Error", "Invalid Phone Number",
                    "Phone number not valid");
            return; 
        }

        
        if (!password.equals(confirmPassword)) {
            showAlert("Error", "Password Mismatch", "Passwords do not match.");
            return; 
        }

        
        User newUser = new User(fullName, userName, phoneNumber, password, dob);
        Boolean success = SignUpFile.SignUpFileWrite(newUser, userTypeComboBox.getValue());
        if (success) {
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Confirmed");
            a.setContentText("SignUp is Complete");
            a.showAndWait();
        } else {
            showAlert("Error", "Sign Up Incomplete", "Your sign-up was unsuccessful. Please try again.");
        }

       
        newNameTextField.clear();
        newUserNameTextField.clear();
        newUserPhoneNumberTextField.clear();
        newPasswordTextField.clear();
        confirmPasswordTextField.clear();
        newUserDob.setValue(null);
    }

    private boolean isValidPassword(String password) {
        
        return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*[a-zA-Z].*");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        
        return phoneNumber.length() == 11 && Character.isDigit(phoneNumber.charAt(0)) &&
                Character.getNumericValue(phoneNumber.charAt(2)) >= 3 &&
                Character.getNumericValue(phoneNumber.charAt(2)) <= 9;
    }
}
