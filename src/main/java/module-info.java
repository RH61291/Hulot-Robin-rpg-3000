module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens GUI to javafx.fxml;
    exports GUI;
}