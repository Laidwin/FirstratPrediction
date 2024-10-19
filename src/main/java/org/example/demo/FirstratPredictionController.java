package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

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
    protected void calculate() {
        int priceProduct1 = spinnerPriceProduct1.getValue();
        int quantityProduct1 = spinnerQuantityProduct1.getValue();
        int priceProduct2 = spinnerPriceProduct2.getValue();
        int quantityProduct2 = spinnerQuantityProduct2.getValue();
        int rawMaterials1 = spinnerRawMaterials1.getValue();
        int rawMaterials2 = spinnerRawMaterials2.getValue();
        int machine = spinnerMachine.getValue();

        FirstratPrediction firstratPrediction = new FirstratPrediction(priceProduct1, priceProduct2, quantityProduct1, quantityProduct2, rawMaterials1, rawMaterials2, machine);
        quantityProduct1 = firstratPrediction.predictQuantityProduct1();

        spinnerQuantityProduct1.getEditor().setText(String.valueOf(quantityProduct1));
    }
}