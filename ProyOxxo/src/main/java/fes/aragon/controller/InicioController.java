package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class InicioController {

    @FXML
    private Button bntDistribuidor;

    @FXML
    private BorderPane btpPrincipal;

    @FXML
    void abrirDistribuidor(ActionEvent event) {
        try {
            Contenido contenido= new Contenido("/fes/aragon/xml/distribuidor.fxml");
            btpPrincipal.setCenter(contenido);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
