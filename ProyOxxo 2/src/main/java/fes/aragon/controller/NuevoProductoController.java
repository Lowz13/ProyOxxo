package fes.aragon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class NuevoProductoController {

    @FXML
    private Button btnEnviar;

    @FXML
    private Button btnGuardar;

    @FXML
    private ComboBox<?> cmbProvedor;

    @FXML
    private ImageView imgProducto;

    @FXML
    private TextField txtCaducidad;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtProducto;

    @FXML
    private TextField txtUnitario;

    @FXML
    private TextField txtVenta;
    @FXML
    void EnviarInfo(ActionEvent event) {

    }

    @FXML
    void GuardarImg(ActionEvent event) {

    }

}
