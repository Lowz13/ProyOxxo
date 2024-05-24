package fes.aragon.controller;

import fes.aragon.modelo.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NuevoDistribuidorController {
    private Integer indice;

    @FXML
    private Button btnGuardarDist;

    @FXML
    private Button btnImgDist;

    @FXML
    private ImageView imgLogoDist;

    @FXML
    private TextField txtCorreoDist;

    @FXML
    private TextField txtDireccionDist;

    @FXML
    private TextField txtNombreDist;

    @FXML
    private TextField txtTelefonoDist;

    private ObservableList<Distribuidor> listaGeneral;
    private File selectedFile;

    @FXML
    void BuscarLogoDist(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("imagen", "*.png"));
        this.selectedFile = fileChooser.showOpenDialog(this.btnImgDist.getScene().getWindow());
        if (selectedFile != null) {
            try {
                FileInputStream fo = new FileInputStream(selectedFile);
                Image imagen = new Image(fo);
                this.imgLogoDist.setImage(imagen);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @FXML
    void GuardarDistribuidor(ActionEvent event) {
        Distribuidor distribuidor= new Distribuidor();
        distribuidor.setNombre(txtNombreDist.getText());
        distribuidor.setCorreo(txtCorreoDist.getText());
        distribuidor.setDireccion(txtDireccionDist.getText());
        distribuidor.setTelefono(txtTelefonoDist.getText());
        if (selectedFile != null) {
            try {
                FileInputStream fo = new FileInputStream(selectedFile);
                Image imagen = new Image(fo);
                SerializableImage img = new SerializableImage();
                img.setImage(imagen);
                distribuidor.setImagen(img);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (indice == null) {
            SingletonProveedor.getInstance().getLista().add(distribuidor);
        } else {
            Image img = this.imgLogoDist.getImage();
            SerializableImage imgS = new SerializableImage();
            imgS.setImage(img);
            distribuidor.setImagen(imgS);
            SingletonProveedor.getInstance().getLista().set(indice,distribuidor);
            Stage stage = (Stage) this.btnGuardarDist.getScene().getWindow();
            stage.close();
        }
        txtNombreDist.clear();
        txtCorreoDist.clear();
        txtDireccionDist.clear();
        txtTelefonoDist.clear();
        this.imgLogoDist.setImage(null);


    }
    public void indiceDistribuidor (int indice){
        this.indice= indice;
        Distribuidor distribuidor =SingletonProveedor.getInstance().getLista().get(indice);
        txtNombreDist.setText(distribuidor.getNombre());
        txtCorreoDist.setText(distribuidor.getCorreo());
        txtDireccionDist.setText(distribuidor.getDireccion());
        txtTelefonoDist.setText(distribuidor.getTelefono());
        System.out.println(distribuidor.getImagen());
        imgLogoDist.setImage(distribuidor.getImagen().getImage());
    }

}
