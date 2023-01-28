package controller;

import DBUtility.DBCountry;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Country;

public class MainScreenController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        ObservableList<Country> cList = DBCountry.getAllCountries();
        for(Country C : cList){
            System.out.println("Country Id: " + C.getId() + " Country name: " + C.getName());
        }
    }
}