module lab.lab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens lab.lab5 to javafx.fxml;
    exports lab.lab5;
}