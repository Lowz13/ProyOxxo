package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fes.aragon.modelo.Distribuidor;
import fes.aragon.modelo.Producto;
import fes.aragon.modelo.SingeltonProducto;
import fes.aragon.modelo.SingletonProveedor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DistribuidorController implements Initializable {
    @FXML
    private TableColumn<Distribuidor, String> cmlCorreo;

    @FXML
    private TableColumn<Distribuidor, String> cmlDireccion;

    @FXML
    private TableColumn<Distribuidor, String> cmlNombre;

    @FXML
    private TableColumn<Distribuidor, String> cmlOperaciones;

    @FXML
    private TableColumn<Distribuidor, String> cmlTelefono;

    @FXML
    private TableView<Distribuidor> tblDistribuidor;

    @FXML
    private FontAwesomeIconView iconAgregar;

    @FXML
    private FontAwesomeIconView iconSalvar;

    @FXML
    private FontAwesomeIconView iconAbrirDistribuidor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.cmlNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.cmlCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        this.cmlDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        this.cmlTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tblDistribuidor.setItems(SingletonProveedor.getInstance().getLista());
        Callback<TableColumn<Distribuidor, String>, TableCell<Distribuidor, String>>
                celda = (TableColumn<Distribuidor, String> parametros) -> {
            final TableCell<Distribuidor, String> cel = new TableCell<>() {
                @Override
                protected void updateItem(String s, boolean b) {
                    super.updateItem(s, b);
                    if (b) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        FontAwesomeIconView borrarIcono = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        borrarIcono.setGlyphStyle("-fx-cursor:hand;" + "-glyph-size:28px;" + "-fx-fill:#ff1744");

                        FontAwesomeIconView modificarIcono = new FontAwesomeIconView(FontAwesomeIcon.PENCIL);
                        modificarIcono.setGlyphStyle("-fx-cursor:hand;" + "-glyph-size:28px;" + "-fx-fill:#ff1744");
                        borrarIcono.setOnMouseClicked((MouseEvent evento) -> {
                            int indice = tblDistribuidor.getSelectionModel().getSelectedIndex();
                            SingletonProveedor.getInstance().getLista().remove(indice);
                        });
                        modificarIcono.setOnMouseClicked((MouseEvent evento) -> {
                            modificarDistribuidor(tblDistribuidor.getSelectionModel().getSelectedIndex());
                        });
                        HBox hBox = new HBox(modificarIcono, borrarIcono);
                        hBox.setStyle("-fx-alignment:center");
                        HBox.setMargin(modificarIcono, new Insets(2, 2, 0, 3));
                        HBox.setMargin(borrarIcono, new Insets(2, 2, 0, 3));
                        setGraphic(hBox);
                        setText(null);
                    }

                }
            };
            return cel;
        };
        this.cmlOperaciones.setCellFactory(celda);

    }

    private void modificarDistribuidor(int indice) {
        try {
            FXMLLoader modificar = new FXMLLoader(getClass().getResource("/fes/aragon/xml/agregarDistribuidor.fxml"));
            Parent parent = (Parent) modificar.load();
            ((NuevoDistribuidorController) modificar.getController()).indiceDistribuidor(indice);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void accionNuevoProveedor(MouseEvent event) {
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
                for (Distribuidor us : datos) {
                    System.out.println(us.getImagen());
                    SingletonProveedor.getInstance().getLista().add(us);
                }
            } catch (IOException | ClassNotFoundException e) { //+FileNotFound
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void accionSalvarProveedor(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        //     fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("FES", "*.fes"));
        File selectedFile = fileChooser.showOpenDialog(this.iconAbrirDistribuidor.getScene().getWindow());
        if(selectedFile!=null) {
            try {
                FileOutputStream fo = new FileOutputStream(selectedFile);
                ObjectOutputStream salida = new ObjectOutputStream(fo);
                ArrayList<Distribuidor> datos = SingletonProveedor.getInstance().getConversion();
                for (Distribuidor di : datos) {
                    System.out.println(di.getImagen());
                }
                salida.writeObject(datos);
                salida.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


