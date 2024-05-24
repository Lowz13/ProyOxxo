package fes.aragon.modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class SingeltonProducto {
    private static SingeltonProducto singlentonProducto;
    private ObservableList<Producto> lista;
    private SingeltonProducto(){
        lista = FXCollections.observableArrayList();
    }
    public static SingeltonProducto getInstance(){
        if (singlentonProducto == null){
            singlentonProducto = new SingeltonProducto();
        }
        return singlentonProducto;
    }
    public ObservableList<Producto> getLista(){return lista; }
    public ArrayList<Producto> getConversion(){return new ArrayList<>(lista);}

}
