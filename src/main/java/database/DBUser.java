package database;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUser {
    public static User authorizeUser(Connection connection, String userName, String password){

        try {
            String sql = "SELECT * FROM users WHERE User_Name=? AND Password=?";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            User user = null;
            if (rs.next()) {
                user = new User();
                user.name = rs.getString("User_Name");
                user.password = rs.getString("Password");
            }
            return user;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
