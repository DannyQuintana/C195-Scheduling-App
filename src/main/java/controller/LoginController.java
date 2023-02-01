package controller;

import database.DBConnection;
import database.DBUser;
import com.scheduleapp.c195task1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.User;


import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML private Label timeZoneField;
    @FXML private Label loginTitleLabel;
    @FXML private Label userNameLabel;
    @FXML private Label passwordLabel;
    @FXML private Button login;
    @FXML private Button resetButton;
    @FXML private TextField passWordField;
    @FXML private TextField userNameField;
    @FXML private Label timeZoneLabel;


    public void loginClicked(ActionEvent actionEvent) {
        try{
            String userName = userNameField.getText();
            String password = passWordField.getText();

            User user = DBUser.authorizeUser(DBConnection.getConnection(),userName, password);
            if(user != null){
                System.out.println("Access granted");
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/mainScreen.fxml"));
                Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
                stage.setTitle("Main Menu");
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid login credentials.");
                alert.showAndWait();
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void resetClicked(ActionEvent actionEvent) {
        userNameField.setText("");
        passWordField.setText("");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ResourceBundle bundle = ResourceBundle.getBundle("Login", Locale.getDefault());
        loginTitleLabel.setText(bundle.getString("title"));
        userNameLabel.setText(bundle.getString("userName"));
        passwordLabel.setText(bundle.getString("password"));
        login.setText(bundle.getString("login"));
        resetButton.setText(bundle.getString("resetButton"));
        timeZoneLabel.setText(bundle.getString("timeZone"));
        userNameField.setPromptText(bundle.getString("userNameField"));
        passWordField.setPromptText(bundle.getString("passWordField"));
    }


}
