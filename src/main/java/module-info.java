module controllers.stock_managmnent {
    requires javafx.controls;
    requires javafx.fxml;


    opens controllers.stock_managmnent to javafx.fxml;
    exports controllers.stock_managmnent;
}