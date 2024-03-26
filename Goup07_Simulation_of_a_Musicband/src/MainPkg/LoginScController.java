package MainPkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScController implements Initializable {

    @FXML
    private TextField userIdTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private Button login;
    @FXML
    private Button signupButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Fan", "Instrument Manager",
                "Chief Accountant Manager", "Instrument Manager", "Merchandise Manager",
                 "Band Promoter", "Event Organizer", "Operational Manager");
        //defaultIdpass
        userIdTextField.setText("admin");
        passwordTextField.setText("12345678");
    }

    @FXML
    private void forgotPasswordButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        String userType = userTypeComboBox.getValue();
        if (userType == null) {
            showErrorAlert("Error", "Please select a user type.");
            return;
        }

        String username = userIdTextField.getText();
        String password = passwordTextField.getText();

        boolean isValidLogin = SignUpFile.SignUpFileRead(userType, username, password);

        if (isValidLogin) {

            String userFullName = SignUpFile.FileRead_forUserName(userType, username, password);

            Stage currentStage = (Stage) login.getScene().getWindow();
            if (userType.equals("Band Member")) {
                //SceneChange newScene= new SceneChange();
                //newScene.Scenechanger(currentStage, "User_1_MainDashboard.fxml");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Band Member Dashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Band Promoter")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Band Promoter Dashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Chief accounting Officer")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Chief accounting Officer Dashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Event Organizer")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Event Organizer Dashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Fan")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Fan Dashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Instrument Manager")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Instrument Manager Dashboard.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            }
            if (userType.equals("Merchandise manager")) {
                SceneChange newScene = new SceneChange();
                newScene.Scenechanger(currentStage, "Merchandise manager Dashboard.fxml");
            }
            if (userType.equals("Operational Manager")) {
                SceneChange newScene = new SceneChange();
                newScene.Scenechanger(currentStage, "Operational Manager Dashboard.fxml");
            }
        } else {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Unable to Login");
            a.setContentText("UserID and Password is Invalid");
            a.showAndWait();

        }
    }

    @FXML
    private void signUpButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sign Up.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage currentStage = (Stage) signupButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
