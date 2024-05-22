package fes.aragon.controller;

import fes.aragon.modelo.Producto;
import fes.aragon.modelo.SerializableImage;
import fes.aragon.modelo.SingletonProducto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private ComboBox<?> cmbProveedor;

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
        Producto producto= new Producto();
        producto.setNombre(txtProducto.getText());
        producto.setCaducidad(txtCaducidad.getText());
        producto.setCantidad(txtCantidad.getText());
        producto.setPrecioUnitario(txtUnitario.getText());
        producto.setPrecioVenta(txtVenta.getText());
        if(selectedFile!=null){
            try{
                FileInputStream fo=new FileInputStream(selectedFile);
                Image imagen=new Image(fo);
                SerializableImage img=new SerializableImage();
                img.setImage(imagen);
                producto.setImagen(img);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        if(indice==null){
            SingletonProducto.getInstance().getLista().add(producto);
        }else{
            Image img=this.imgProducto.getImage();
            SerializableImage imgS=new SerializableImage();
            imgS.setImage(img);
            producto.setImagen(imgS);
            SingletonProducto.getInstance().getLista().set(indice,producto);
            Stage stage=(Stage) this.btnGuardar.getScene().getWindow();
            stage.close();
        }
        txtProducto.clear();
        txtCaducidad.clear();
        txtCantidad.clear();
        txtUnitario.clear();
        txtVenta.clear();
        this.imgProducto.setImage(null);

    }
    public void indiceProducto (int indice){
        this.indice= indice;
        Producto producto=SingletonProducto.getInstance().getLista().get(indice);
        txtProducto.setText(producto.getNombre());
        txtCaducidad.setText(producto.getCaducidad());
        txtCantidad.setText(producto.getCantidad());
        txtUnitario.setText(producto.getPrecioUnitario());
        txtVenta.setText(producto.getPrecioVenta());
        System.out.println(producto.getImagen());
        imgProducto.setImage(producto.getImagen().getImage());
    }
    }

