package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCustomer {
    public static int insert(int customerId, String customerName, String  address, String postalCode, String phone) throws SQLException {
        String sql = "INSERT INTO CUSTOMERS (Customer_ID, Customer_Name, Address, Postal_Code, Phone, Division_ID) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, customerId);
        ps.setString(2, customerName);
        ps.setString(3, address);
        ps.setString(4, postalCode);
        ps.setString(5, phone);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }
    //Read
    public static ObservableList<Customer> getAllCustomers(Connection connection){
        ObservableList<Customer>   customersList = FXCollections.observableArrayList();

        try{
            String sql = "SELECT * from customers";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int Id = rs.getInt("Customer_ID");
                String Name = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String postalCode = rs.getString("Postal_Code");
                String phone = rs.getString("Phone");
                int divisionId = rs.getInt("Division_ID");
                Customer c = new Customer(Id, Name, address, postalCode, phone, divisionId);
                customersList.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customersList;
    }


    //Update
    public static int update(String customerName, String address, String postalCode, String phone, int customerID) throws SQLException {
        String sql = "UPDATE Customers SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ? WHERE Customer_ID = ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, customerName);
        ps.setString(2, address);
        ps.setString(3, postalCode);
        ps.setString(4, phone);
        ps.setInt(5, customerID);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected;

    }

    //Delete
    public static int delete(int customerId) throws SQLException{
        String sql = "DELETE FROM Customers WHERE Customer_ID = ? ";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, customerId);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }
}
