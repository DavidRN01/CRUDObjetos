/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author DavidRamosNavas
 */

@Entity
public class Pedido implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private double precio;
    private Date fecha;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name="carta_id")
    private Carta producto;
    
    public Pedido() {
    }

    public Pedido(Long id, String nombre, double precio, Date fecha, String estado, Carta producto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
        this.estado = estado;
        this.producto = producto;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Carta getProducto() {
        return producto;
    }

    public void setProducto(Carta producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fecha=" + fecha + ", estado=" + estado + ", producto_id=" + producto + '}';
    }
    
}
