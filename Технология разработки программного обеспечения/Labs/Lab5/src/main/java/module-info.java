module lab.lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires Lab1.lib;


    opens lab.lab5 to javafx.fxml;
    exports lab.lab5;
}