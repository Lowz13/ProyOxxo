package fes.aragon.controller;

import fes.aragon.modelo.Producto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class NuevoProductoController {

    private Integer indice;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLogo;

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
    private ObservableList<Producto> listaGeneral;
    private File selectedFile;


    @FXML
    void accionAbrirLogo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("imagen", "*.png"));
        this.selectedFile= fileChooser.showOpenDialog(this.btnLogo.getScene().getWindow());
        if(selectedFile !=null){
            try{
                FileInputStream fo = new FileInputStream(selectedFile);
                Image imagen = new Image(fo);
                this.imgProducto.setImage(imagen);

            }catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @FXML
    void accionGuardarProducto(ActionEvent event) {

    }

}