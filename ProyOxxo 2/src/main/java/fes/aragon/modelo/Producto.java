package fes.aragon.modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private String Nombre;
    private Double Caducidad;
    private Double Cantidad;
    private String PrecioUnitario;
    private String PrecioVenta;

    private Serializable imagen;

    public Producto() {
    }

    public Producto(String nombre, Double caducidad, Double cantidad, String precioUnitario, String precioVenta) {
        Nombre = nombre;
        Caducidad = caducidad;
        Cantidad = cantidad;
        PrecioUnitario = precioUnitario;
        PrecioVenta = precioVenta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getCaducidad() {
        return Caducidad;
    }

    public void setCaducidad(Double caducidad) {
        Caducidad = caducidad;
    }

    public Double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Double cantidad) {
        Cantidad = cantidad;
    }

    public String getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        PrecioUnitario = precioUnitario;
    }

    public String getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        PrecioVenta = precioVenta;
    }
    public SerializableImage getImagen() {
        return imagen;
    }

    public void setImagen(SerializableImage imagen) {
        this.imagen = imagen;
    }

    public String toString() {
        return "Nombre: " + Nombre + ", Caducidad: " + Caducidad + ", Cantidad: " + Cantidad + ", PrecioUnitario" + PrecioUnitario + ", PrecioVenta" + PrecioVenta;
    }
}
}
