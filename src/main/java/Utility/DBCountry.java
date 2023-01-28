package Utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DBCountry {

    public static ObservableList<Country> getAllCountries(){
        ObservableList<Country>   countryList = FXCollections.observableArrayList();

        try{
            String sql = "SELECT * from countries";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int countryId = rs.getInt("Country_ID");
                String country = rs.getString("Country");
                Country C =  new Country(countryId, country);
                countryList.add(C);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return countryList;
    }

    public static void checkDateConversion(){
        System.out.println("CREATE DATA TEST");
        String sql = "select Create_Data from countries";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Timestamp ts = rs.getTimestamp("Create_Data");
                System.out.println("CD: " + ts.toLocalDateTime().toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
