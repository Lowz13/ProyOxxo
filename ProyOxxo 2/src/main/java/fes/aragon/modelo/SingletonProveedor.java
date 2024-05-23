package fes.aragon.modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class SingletonProveedor {

    private static SingletonProveedor singletonProveedor;

    private ObservableList<Distribuidor> lista;

    private SingletonProveedor(){
        lista = FXCollections.observableArrayList();
    }

    public static SingletonProveedor getInstance(){
        if(singletonProveedor == null){
            singletonProveedor = new SingletonProveedor();
        }
        return singletonProveedor;
    }

    public ObservableList<Distribuidor> getLista(){
        return lista;
    }

    public ArrayList<Distribuidor> getConversion(){
        return new ArrayList<>(lista);
    }
}
