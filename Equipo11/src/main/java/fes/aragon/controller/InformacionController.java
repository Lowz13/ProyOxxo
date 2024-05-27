package fes.aragon.controller;

import fes.aragon.modelo.Producto;
import fes.aragon.modelo.SingeltonProducto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class InformacionController {
    private Integer indice;

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
    }

}