package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fes.aragon.modelo.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

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

    }

    @FXML
    void accionSalvarProducto(MouseEvent event) {

    }

}
