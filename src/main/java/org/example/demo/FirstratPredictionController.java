package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstratPredictionController {
    @FXML
    private Spinner<Integer> spinnerPriceProduct1;
    @FXML
    private Spinner<Integer> spinnerQuantityProduct1;
    @FXML
    private Spinner<Integer> spinnerPriceProduct2;
    @FXML
    private Spinner<Integer> spinnerQuantityProduct2;
    @FXML
    private Spinner<Integer> spinnerRawMaterials1;
    @FXML
    private Spinner<Integer> spinnerRawMaterials2;
    @FXML
    private Spinner<Integer> spinnerMachine;
    @FXML
    private Spinner<Integer> spinnerQuantityProduct1Result;
    @FXML
    private Spinner<Integer> spinnerQuantityProduct2Result;
    @FXML
    private Spinner<Integer> spinnerRawMaterials1Result;
    @FXML
    private Spinner<Integer> spinnerRawMaterials2Result;
    @FXML
    private GridPane gridpane;
    @FXML
    private HBox label;

    @FXML
    protected void PredictProduct1() {
        FirstratPrediction firstratPrediction = extract();
        int quantityProduct1 = firstratPrediction.predictQuantityProduct1();

        label.setVisible(true);
        gridpane.setVisible(true);
        spinnerQuantityProduct1Result.getEditor().setText(String.valueOf(quantityProduct1));
    }
    @FXML
    protected void PredictProduct2() {
        FirstratPrediction firstratPrediction = extract();
        int quantityProduct2 = firstratPrediction.predictQuantityProduct2();

        label.setVisible(true);
        gridpane.setVisible(true);
        spinnerQuantityProduct2Result.getEditor().setText(String.valueOf(quantityProduct2));
    }

    private FirstratPrediction extract(){
        int priceProduct1 = spinnerPriceProduct1.getValue();
        int quantityProduct1 = spinnerQuantityProduct1.getValue();
        int priceProduct2 = spinnerPriceProduct2.getValue();
        int quantityProduct2 = spinnerQuantityProduct2.getValue();
        int rawMaterials1 = spinnerRawMaterials1.getValue();
        int rawMaterials2 = spinnerRawMaterials2.getValue();
        int machine = spinnerMachine.getValue();

        return new FirstratPrediction(priceProduct1, priceProduct2, quantityProduct1, quantityProduct2, rawMaterials1, rawMaterials2, machine);
    }

    @FXML
    protected void maximizeProfit() {
        FirstratPrediction firstratPrediction = extract();
        int[] result = firstratPrediction.maximizeProfit();

        label.setVisible(true);
        gridpane.setVisible(true);
        spinnerQuantityProduct1Result.getEditor().setText(String.valueOf(result[0]));
        spinnerQuantityProduct2Result.getEditor().setText(String.valueOf(result[1]));
        spinnerRawMaterials1Result.getEditor().setText(String.valueOf(result[2]));
    }

    public void openParameters(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FirstratPredictionApplication.class.getResource("Parameters-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Firstrat Prediction");
        stage.setScene(scene);
        stage.show();
    }
}