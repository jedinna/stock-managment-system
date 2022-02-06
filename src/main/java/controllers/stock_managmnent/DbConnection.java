/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stock_managmnent;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yididya
 */
 public class DbConnection {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "stock";
    private static final String password = "1544";
    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    Connection con = null;
    public Connection connMethod() throws ClassNotFoundException {
        Class.forName(driver);


        try {
            con = DriverManager.getConnection(url, user, password);
//            JOptionPane.showMessageDialog(null, "connected");

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error: " + ex);
        }
        return con;
    }

}