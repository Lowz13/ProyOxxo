package fes.aragon.modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class SingletonProducto {
    private static SingletonProducto singlentonProducto;
    private ObservableList<Producto> lista;
    private SingletonProducto(){
        lista = FXCollections.observableArrayList();
    }
    public static SingletonProducto getInstance(){
        if (singlentonProducto == null){
            singlentonProducto = new SingletonProducto();
        }
        return singlentonProducto;
    }
    public ObservableList<Producto> getLista(){return lista; }
    public ArrayList<Producto> getConversion(){return new ArrayList<>(lista);}

}
