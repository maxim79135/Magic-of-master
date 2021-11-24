package lab.lab5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import library.RabinKarp;
import library.KMT;
import library.ZFunction;

import java.util.Arrays;

public class MainController {
    public Label resultText2;
    public TextField KMTText2;
    public TextField KMTText1;
    public Label resultText1;
    public TextField rabinKarpText1;
    public TextField rabinKarpText2;
    public TextField zFunctionText1;
    public Label resultText3;

    @FXML
    protected void onResult1ButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        switch (data) {
            case "rabinKarp":
                RabinKarp rabinKarp = new RabinKarp(rabinKarpText1.getText(), rabinKarpText2.getText(), 13);
                resultText1.setText(rabinKarp.search().toString());
                break;
            case "KMT":
                KMT kmt = new KMT(KMTText1.getText(), KMTText2.getText());
                resultText2.setText(kmt.search().toString());
                break;
            case "zFunction":
                ZFunction zFunction = new ZFunction(zFunctionText1.getText());
                resultText3.setText(Arrays.toString(zFunction.calculate()));
                break;

        }
    }
}