package controllers.stock_managmnent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class login {
    @FXML
    private Button exitbtn;


    @FXML
    private Button adminbtn;

    @FXML
    private Button customerbtn;

  public void handlebtn1(ActionEvent ev) throws Exception{
      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin.fxml"));
Scene sc = new Scene(fxmlLoader.load(),600.,400);
Stage st = (Stage) ((Node)ev.getSource()).getScene().getWindow();
st.setScene(sc);
st.show();
  }

    public void exitbuttonOnAction(ActionEvent event){
        Stage stage =(Stage) exitbtn.getScene().getWindow();
        stage.close();
    }
}
