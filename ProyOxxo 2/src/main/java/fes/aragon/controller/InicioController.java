package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
    private FontAwesomeIconView iconDistribuidor;

    @FXML
    private FontAwesomeIconView iconProducto;

    @FXML
    void AbrirDistribuidor(MouseEvent event) {
        ventana("/fes/aragon/xml/distribuidor.fxml");}
    @FXML
    void AbrirProducto(MouseEvent event) {
        ventana("/fes/aragon/xml/producto.fxml");}
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
