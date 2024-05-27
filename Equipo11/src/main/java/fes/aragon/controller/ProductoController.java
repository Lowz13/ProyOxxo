package fes.aragon.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fes.aragon.controller.NuevoProductoController;
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

public class ProductoController implements Initializable {

    @FXML
    private TableColumn<Producto, String> cmlCaducidad;

    @FXML
    private TableColumn<Producto, String> cmlCantidad;

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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.cmlNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.cmlCaducidad.setCellValueFactory(new PropertyValueFactory<>("caducidad"));
        this.cmlCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        this.cmlPrecioUnitario.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));
        this.cmlPrecioVenta.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
        tblTabla.setItems(SingeltonProducto.getInstance().getLista());
        Callback<TableColumn<Producto, String>, TableCell<Producto, String>>
                celda = (TableColumn<Producto, String> parametros) -> {
            final TableCell<Producto, String> cel = new TableCell<>() {
                @Override
                protected void updateItem(String s, boolean b) {
                    super.updateItem(s, b);
                    if (b) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        FontAwesomeIconView irProveedor = new FontAwesomeIconView(FontAwesomeIcon.DROPBOX);
                        irProveedor.setGlyphStyle("-fx-cursor:hand;" + "-glyph-size:28px;" + "-fx-fill:#FF9E00");

                        FontAwesomeIconView borrarIcono = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        borrarIcono.setGlyphStyle("-fx-cursor:hand;" + "-glyph-size:28px;" + "-fx-fill:#ff1744");

                        FontAwesomeIconView modificarIcono = new FontAwesomeIconView(FontAwesomeIcon.PENCIL);
                        modificarIcono.setGlyphStyle("-fx-cursor:hand;" + "-glyph-size:28px;" + "-fx-fill:#ff1744");

                        borrarIcono.setOnMouseClicked((MouseEvent evento) -> {
                            int indice = tblTabla.getSelectionModel().getSelectedIndex();
                            SingeltonProducto.getInstance().getLista().remove(indice);
                        });

                        modificarIcono.setOnMouseClicked((MouseEvent evento) -> {
                            modificarProducto(tblTabla.getSelectionModel().getSelectedIndex());
                        });

                        irProveedor.setOnMouseClicked((MouseEvent evento) ->{
                            abrirInformacion(tblTabla.getSelectionModel().getSelectedIndex());

                        });

                        HBox hBox = new HBox(irProveedor,modificarIcono, borrarIcono);
                        hBox.setStyle("-fx-alignment:center");
                        HBox.setMargin(irProveedor, new Insets(2,2,0,3));
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

    private void modificarProducto(int indice) {
        try {
            FXMLLoader modificar = new FXMLLoader(getClass().getResource("/fes/aragon/xml/agregarProducto.fxml"));
            Parent parent = (Parent) modificar.load();
            ((NuevoProductoController) modificar.getController()).indiceProducto(indice);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void abrirInformacion(int indice) {
        try {
            FXMLLoader modificar = new FXMLLoader(getClass().getResource("/fes/aragon/xml/informacion.fxml"));
            Parent parent = (Parent) modificar.load();
            ((InformacionController) modificar.getController()).indiceProducto(indice);
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
    void accionAbrirProducto(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        //       fileChooser.getExtensionFilters().addAll(
        //               new FileChooser.ExtensionFilter("FES", "*.fes"));
        File selectedFile = fileChooser.showOpenDialog(this.iconCargarProducto.getScene().
                getWindow());
        if (selectedFile != null) {
            try {
                FileInputStream fo = new FileInputStream(selectedFile);
                ObjectInputStream entrada = new ObjectInputStream(fo);
                ArrayList<Producto> datos = (ArrayList<Producto>) entrada.readObject();
                SingeltonProducto.getInstance().getLista().clear();
                for (Producto di : datos) {
                    System.out.println(di.getImagen());
                    SingeltonProducto.getInstance().getLista().add(di);
                }
                ArrayList<Distribuidor> prove = (ArrayList<Distribuidor>) entrada.readObject();
                SingletonProveedor.getInstance().getLista().clear();
                for (Distribuidor pr : prove) {
                    System.out.println(pr.getImagen());
                    SingletonProveedor.getInstance().getLista().add(pr);
                }
            } catch (IOException | ClassNotFoundException e) { //+FileNotFound
                throw new RuntimeException(e);
            }
        }
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
    void accionSalvarProducto(MouseEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        //     fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("FES", "*.fes"));
        File selectedFile = fileChooser.showSaveDialog(this.iconCargarProducto.getScene().getWindow());
        if (selectedFile != null) {
            try {
                FileOutputStream fo = new FileOutputStream(selectedFile);
                ObjectOutputStream salida = new ObjectOutputStream(fo);
                ArrayList<Producto> productos = SingeltonProducto.getInstance().getConversion();
                for (Producto pr : productos) {
                    System.out.println(pr.getImagen());
                }
                ArrayList<Distribuidor> proveedores = SingletonProveedor.getInstance().getConversion();
                for (Distribuidor di : proveedores) {
                    System.out.println(di.getImagen());
                }
                salida.writeObject(productos);
                salida.writeObject(proveedores);
                salida.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}