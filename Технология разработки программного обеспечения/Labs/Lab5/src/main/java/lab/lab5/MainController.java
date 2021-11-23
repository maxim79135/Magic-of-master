package lab.lab5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import library.RabinKarp;

public class MainController {
    @FXML
    private Label resultText;
    @FXML
    private TextField rabinKarpText1;
    @FXML
    private TextField rabinKarpText2;

    @FXML
    protected void onResult1ButtonClick() {
        RabinKarp rabinKarp = new RabinKarp(rabinKarpText1.getText(), rabinKarpText2.getText(), 13);
        String result = rabinKarp.search().toString();
        resultText.setText(rabinKarp.search().toString());
    }
}