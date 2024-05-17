package fes.aragon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InicioController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}