package controllers.stock_managmnent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.jar.Attributes;

import static controllers.stock_managmnent.DbConnection.connMethod;
import static java.sql.DriverManager.getConnection;

public class itemsController implements Initializable {
    @FXML
    private TextField IdTextfield;
    @FXML
    private TextField NameTextfield;
    @FXML
    private Button addbtn;
    @FXML
    private TextField amountTextfield;
    @FXML
    private TextField pricetextfield;
    @FXML
    private Button removeBtn;
    @FXML
    private Button showtbl;
    @FXML
    void AddOnAction(ActionEvent event) throws ClassNotFoundException {
    }

    public void AddOnAction(javafx.event.ActionEvent event) throws ClassNotFoundException {
        DbConnection db = new DbConnection();
        Connection con = db.connMethod();
        String sql = "INSERT INTO ITEM_TBL(ID,NAME,AMOUNT,PRICE) VALUES ('" + IdTextfield.getText() + "','" + NameTextfield.getText() + "','" + amountTextfield.getText() + "','" + pricetextfield.getText() + "')";


        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "Data Inserted succsecfully");

            }

        } catch (SQLException ex) {

        }
    }
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle){
    }
    public void tshow(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("viewtable.fxml"));
        Scene sc = new Scene(fxmlLoader.load(),600.,400);
        Stage st = (Stage) ((Node)event.getSource()).getScene().getWindow();
        st.setScene(sc);
        st.show();
    }

    public void updatebtnOnAction(javafx.event.ActionEvent event) {


        DbConnection db = new DbConnection();
        try {
            Connection con = db.connMethod();
            String value1 = IdTextfield.getText();
            String value2 = NameTextfield.getText();
            String value3 = amountTextfield.getText();
            String value4 = pricetextfield.getText();


            String sql = "update ITEM_TBL set ID = '" + value1 + "', NAME = '" + value2 + "', AMOUNT= '" + value3 + "', PRICE= '" + value4 + "' where ID = '" + value1 + "' ";

            PreparedStatement
             pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }

    public void removeBtnONaction(javafx.event.ActionEvent event) {


        DbConnection db = new DbConnection();
        try {

           Connection con = db.connMethod();
            String sql = "delete from ITEM_TBL where ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,IdTextfield.getText()) ;
            pst.execute();

            JOptionPane.showMessageDialog(null, "Deleted!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}


