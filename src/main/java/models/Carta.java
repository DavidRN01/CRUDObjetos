/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *
 * @author DavidRamosNavas
 */

@Entity
public class Carta implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private double precio;
    
    public Carta() {
    }

    public Carta(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
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

    @Override
    public String toString() {
        return "Carta{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
}
