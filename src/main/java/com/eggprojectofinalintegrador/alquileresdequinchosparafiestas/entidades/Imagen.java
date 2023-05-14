/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Leo
 */
@Entity
public class Imagen {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    private String id;
    
    private String mime;
    
    private String nombre;
    
    @Lob @Basic(fetch=FetchType.LAZY)
    private byte[] contendido;

    //@ManyToOne
    //@JoinColumn(name="propiedadid")
    //private Propiedad propiedad;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "propiedad_id")
    //@JoinColumn(name="propiedad_id", nullable=false)
    //private Propiedad propiedad;
    
    public Imagen() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getContendido() {
        return contendido;
    }

    public void setContendido(byte[] contendido) {
        this.contendido = contendido;
    }
}
