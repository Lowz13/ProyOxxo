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
    private Button bntProducto;

    @FXML
    private BorderPane btpPrincipal;

    @FXML
    void abrirDistribuidor(ActionEvent event) { ventana("/fes/aragon/xml/distribuidor.fxml");}
    @FXML
    void abrirProducto(ActionEvent event) { ventana("/fes/aragon/xml/producto.fxml");}

    private void ventana (String ruta){
        try {
            Contenido contenido = new Contenido(ruta);
            btpPrincipal.setCenter(contenido);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
