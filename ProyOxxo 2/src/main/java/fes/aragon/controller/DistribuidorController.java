package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class DistribuidorController {

    @FXML
    private FontAwesomeIconView iconAgregar;

    @FXML
    private FontAwesomeIconView iconAbrirDistribuidor;

    @FXML
    void eventoNuevoUsuario(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fes/aragon/xml/agregarDistribuidor.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void accionAbrirDistribuidor(MouseEvent event) {

    }

}
