/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.enumeraciones.Rol;

/**
 *
 * @author Leo
 */
public class PropietarioDTO {
        
    private String apellido;
    private String nombre;    
    private String dni;
    private String email;
    private String telefono;
    private String password;
    private String passwordR;
    private Rol rol;
    private Imagen imagen; 
    
    private int calificacion;    
    
    public PropietarioDTO(String apellido, String nombre, String dni, String email, String telefono, String password, String passwordR, Rol rol, boolean alta, int calificacion){
        //super();
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.passwordR = passwordR;
        this.rol = rol;        
        /* */
        this.calificacion = calificacion;
        
    }   

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    /* */
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordR() {
        return passwordR;
    }

    public void setPasswordR(String passwordR) {
        this.passwordR = passwordR;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}
