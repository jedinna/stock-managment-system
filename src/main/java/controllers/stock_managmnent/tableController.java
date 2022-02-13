package controllers.stock_managmnent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class tableController implements Initializable {
    @FXML
    private TableColumn<ITEM, Integer> ID_COL;

    @FXML
    private TableColumn<ITEM, String> NAME_COL;

    @FXML
    private TableColumn<ITEM, Integer> PRICE_COL;

    @FXML
        private TableColumn<ITEM, Integer> AMOUNT_COL;
    @FXML
        private TableView<ITEM> ITEMTBL;
    @FXML
    private Button load;
    private Connection con ;
    private DbConnection dbcon;
    ObservableList<ITEM> oblist ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
           dbcon=new DbConnection();
    }
    @FXML
    void loadOnAction(ActionEvent event) throws ClassNotFoundException, SQLException {


    }

    public void loadOnAction(javafx.event.ActionEvent event) {
        try {
            Connection con=dbcon.connMethod();
            oblist=FXCollections.observableArrayList();

            ResultSet set=con.createStatement().executeQuery("select * from ITEM_TBL");

            while(set.next()){
                oblist.add(new ITEM(Integer.parseInt(set.getString("id")),
                        Integer.parseInt(set.getString("PRICE")),
                                Integer.parseInt(set.getString("AMOUNT")),
                                        set.getString("NAME")));

                                       ;
            };
        }catch (SQLException | ClassNotFoundException exception){
            System.err.println("error"+exception);
        }
        ID_COL.setCellValueFactory(new PropertyValueFactory<>("ID"));
        NAME_COL.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        AMOUNT_COL.setCellValueFactory(new PropertyValueFactory<>("AMOUNT"));
        PRICE_COL.setCellValueFactory(new PropertyValueFactory<>("PRICE"));

        ITEMTBL.setItems(null);
        ITEMTBL.setItems(oblist);
    }

    public void backbtnOnAction(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Operation.fxml"));
        Scene sc = new Scene(fxmlLoader.load(),600.,400);
        Stage st = (Stage) ((Node)event.getSource()).getScene().getWindow();
        st.setScene(sc);
        st.show();

    }
}

