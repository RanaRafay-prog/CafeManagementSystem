/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.newpackage;

import java.sql.*;

/**
 *
 * @author USER
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cms";
            String username = "root";
            String password = "Maryam@069";
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (Exception e) {
            System.out.println("Error in Connection Provider" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
