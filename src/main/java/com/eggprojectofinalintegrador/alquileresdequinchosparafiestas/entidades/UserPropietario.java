/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.enumeraciones.Rol;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Leo
 */
@Entity
@PrimaryKeyJoinColumn(name = "propietario")//Herencia con Joined - mapeo
public class UserPropietario extends Usuario implements Serializable {        
             
    private int calificacion;

    public UserPropietario() { 
        
        super(); 
        
    }

    public UserPropietario(String id, String apellido, String nombre, String dni, String email, String telefono, String password, String passwordR, Rol rol, Imagen imagen, boolean alta, int calificacion) {
        
        super(id, apellido, nombre, dni, email, telefono, password, passwordR, rol, imagen, alta);     
        this.calificacion = calificacion;

    }      
    
    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
}
