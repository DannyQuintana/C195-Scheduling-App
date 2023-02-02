package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DBCountry {

    //CRUD CREATE, READ UPDATE DELETE

    //CREATE
    public static int insert(String countryName, int countryId) throws SQLException {
        int rowsAffected;
        try {
            String sql = "INSERT INTO COUNTRIES (COUNTRY, COUNTRY_ID) VALUES(?, ?)";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, countryName);
            ps.setInt(2, countryId);

            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowsAffected;

    }
    //Read
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

    //Update
    public static int update(String countryName, int countryId) throws SQLException {
        String sql = "UPDATE COUNTRIES SET COUNTRY = ? WHERE COUNTRY_ID = ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, countryName);
        ps.setInt(2, countryId);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected;

    }

    //Delete
    public static int delete(int countryId) throws SQLException{
        String sql = "DELETE FROM COUNTRIES WHERE COUNTRY_ID = ? ";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, countryId);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
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
