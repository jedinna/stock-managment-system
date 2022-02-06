package controllers.stock_managmnent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;

import java.io.IOException;
import java.sql.Connection;

public class Admin {

    @FXML
    private Label LoginMessageLabel;

    @FXML
    private Button cancelbutton;
    @FXML
    private Button loginbutton;
    @FXML
    private PasswordField passtextfield;

    @FXML
    private TextField usernametextfield;

    public void loginbuttonOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {


        if(usernametextfield.getText().isBlank()==false && passtextfield.getText().isBlank()==false) {
            LoginMessageLabel.setText("you try to connect");
            DbConnection();
        }else{
            LoginMessageLabel.setText("please enter user and password");

        }
    }

    public void cancelbuttonOnAction(ActionEvent event){
        Stage stage =(Stage) cancelbutton.getScene().getWindow();
       stage.close();
    }

    public void DbConnection() throws ClassNotFoundException, SQLException {
        DbConnection dbcon = new DbConnection();
        Connection con = dbcon.connMethod();
        String SQL = "select * from ADMIN"; //where NAME= ' " +usernametextfield.getText()+"  ' and PASSWORD= ' "+passtextfield.getText() +" ' ";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                if ((rs.getString(1).equals(usernametextfield.getText())) && (rs.getString(2).equals(passtextfield.getText()))) {

                    LoginMessageLabel.setText("congrates");
                } else {

                    LoginMessageLabel.setText("invalid user or password");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
