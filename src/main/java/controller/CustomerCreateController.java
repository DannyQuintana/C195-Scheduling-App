package controller;

import database.DBCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;

import java.sql.SQLException;

public class CustomerCreateController {

    @FXML private TextField nameField;
    @FXML private TextField addressField;
    @FXML private TextField postalCodeField;
    @FXML private TextField phoneField;

    public void submitCustomerBtn(ActionEvent actionEvent) throws SQLException {


    }
}
