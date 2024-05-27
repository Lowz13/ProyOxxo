package fes.aragon.controller;

import fes.aragon.modelo.Distribuidor;
import fes.aragon.modelo.Producto;
import fes.aragon.modelo.SingeltonProducto;
import fes.aragon.modelo.SingletonProveedor;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class InformacionController {
    private Integer indice;

    @FXML
    private ImageView imgInfoProv;
    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;


    @FXML
    private ImageView imgInfoProd;

    @FXML
    private TextField txtInfoCad;

    @FXML
    private TextField txtInfoCant;

    @FXML
    private TextField txtInfoPr;

    @FXML
    private TextField txtInfoPreU;

    @FXML
    private TextField txtInfoPreV;
    public void indiceProducto(int indice){
        this.indice= indice;
        Producto producto = SingeltonProducto.getInstance().getLista().get(indice);
        txtInfoPr.setText(producto.getNombre());
        txtInfoCad.setText(producto.getCaducidad());
        txtInfoCant.setText(producto.getCantidad());
        txtInfoPreU.setText(producto.getPrecioUnitario());
        txtInfoPreV.setText(producto.getPrecioVenta());
        System.out.println(producto.getImagen());
        imgInfoProd.setImage(producto.getImagen().getImage());

        Distribuidor distribuidor = SingletonProveedor.getInstance().getLista().get(indice);
        txtNombre.setText(distribuidor.getNombre());
        txtCorreo.setText(distribuidor.getCorreo());
        txtTelefono.setText(distribuidor.getTelefono());
        txtDireccion.setText(distribuidor.getDireccion());
        System.out.println(distribuidor.getImagen());
        imgInfoProv.setImage(distribuidor.getImagen().getImage());
    }


}