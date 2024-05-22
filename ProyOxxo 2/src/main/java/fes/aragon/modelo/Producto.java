package fes.aragon.modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private String nombre;
    private String caducidad;
    private String cantidad;
    private String precioUnitario;
    private String precioVenta;

    private Serializable imagen;

    public Producto() {
    }

    public Producto(String nombre, String caducidad, String cantidad, String precioUnitario, String precioVenta, Serializable imagen) {
        this.nombre = nombre;
        this.caducidad = caducidad;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioVenta = precioVenta;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Serializable getImagen() {
        return imagen;
    }

    public void setImagen(Serializable imagen) {
        this.imagen = imagen;
    }
    public String toString() {
        return "Nombre: " + nombre + ", Caducidad: " + caducidad + ", Cantidad: " + cantidad + "PrecioUnitario" + precioUnitario +"PrecioVenta" + precioVenta;
    }
}

