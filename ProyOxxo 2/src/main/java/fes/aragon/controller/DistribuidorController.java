package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fes.aragon.modelo.Distribuidor;
import fes.aragon.modelo.SingletonProveedor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

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
        FileChooser fileChooser = new FileChooser();
        //       fileChooser.getExtensionFilters().addAll(
        //               new FileChooser.ExtensionFilter("FES", "*.fes"));
        File selectedFile = fileChooser.showOpenDialog(this.iconAbrirDistribuidor.getScene().
                getWindow());
        if (selectedFile != null) {
            try {
                FileInputStream fo = new FileInputStream(selectedFile);
                ObjectInputStream entrada = new ObjectInputStream(fo);
                ArrayList<Distribuidor> datos = (ArrayList<Distribuidor>) entrada.readObject();
                SingletonProveedor.getInstance().getLista().clear();
                for (Distribuidor us:datos) {
                    System.out.println(us.getImagen());
                    SingletonProveedor.getInstance().getLista().add(us);
                }
            }catch (IOException | ClassNotFoundException e) { //+FileNotFound
                throw new RuntimeException(e);
            }
        }
    }

}
