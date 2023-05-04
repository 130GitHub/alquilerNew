/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Leo
 */
//@Entity
public class Servicio {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String idServicio;
    
    private boolean disponible;
    private String nombre;
    private double precio;      
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPropiedad", nullable=false)
    private Propiedad propiedad;*/   

    public Servicio() {
    }

    public String getId() {
        return idServicio;
    }

    public void setId(String idServicio) {
        this.idServicio = idServicio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
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

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }
}
