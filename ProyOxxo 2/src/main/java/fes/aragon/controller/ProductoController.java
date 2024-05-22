package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fes.aragon.modelo.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ProductoController {

    @FXML
    private TableColumn<Producto, Double> cmlCaducidad;

    @FXML
    private TableColumn<Producto, Double> cmlCantidad;

    @FXML
    private TableColumn<Producto, String> cmlOperaciones;

    @FXML
    private TableColumn<Producto, String> cmlPrecioUnitario;

    @FXML
    private TableColumn<Producto, String> cmlPrecioVenta;

    @FXML
    private TableColumn<Producto, String> cmlNombre;

    @FXML
    private TableView<Producto> tblTabla;

    @FXML
    private FontAwesomeIconView iconCargarProducto;

    @FXML
    private FontAwesomeIconView iconNuevoProducto;

    @FXML
    private FontAwesomeIconView iconSalvar;

    @FXML
    void accionAbrirProducto(MouseEvent event) {

    }

    @FXML
    void accionNuevoProducto(MouseEvent event) {
        try {
            Parent parent= FXMLLoader.load(getClass().getResource("/fes/aragon/xml/agregarProducto.fxml"));
            Scene scene= new Scene(parent);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();


        } catch (IOException e){
            throw new RuntimeException(e);
        }


    }

    @FXML
    void accionSalvarProducto(MouseEvent event) {

    }

}
