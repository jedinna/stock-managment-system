package controllers.stock_managmnent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

  public void handlebtn1() throws Exception{
      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin.fxml"));

      Stage stg = (Stage) adminbtn.getScene().getWindow();
      //Parent root = null;
      stg.setScene(new Scene(fxmlLoader.load()  ,750,500));
  }

    public void exitbuttonOnAction(ActionEvent event){
        Stage stage =(Stage) exitbtn.getScene().getWindow();
        stage.close();
    }
}
