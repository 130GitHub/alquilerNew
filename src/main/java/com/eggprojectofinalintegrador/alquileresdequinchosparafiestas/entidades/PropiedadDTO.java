/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades;

/**
 *
 * @author Leo
 */
public class PropiedadDTO {
    private String titulo;    
    private String ubicacion;    
    private double precio;
    
    private String checkbox_servicio1;
    private double input_precio1;
    private String checkbox_servicio2;
    private double input_precio2;
    private String checkbox_servicio3;
    private double input_precio3;

    public PropiedadDTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }     
    
    public double getInput_precio1() {
        return input_precio1;
    }

    public void setInput_precio1(double input_precio1) {
        this.input_precio1 = input_precio1;
    }
    
    public double getInput_precio2() {
        return input_precio2;
    }

    public void setInput_precio2(double input_precio2) {
        this.input_precio2 = input_precio2;
    }
    
    public double getInput_precio3() {
        return input_precio3;
    }

    public void setInput_precio3(double input_precio3) {
        this.input_precio3 = input_precio3;
    }

    public String getCheckbox_servicio1() {
        return checkbox_servicio1;
    }

    public void setCheckbox_servicio1(String checkbox_servicio1) {
        this.checkbox_servicio1 = checkbox_servicio1;
    }

    public String getCheckbox_servicio2() {
        return checkbox_servicio2;
    }

    public void setCheckbox_servicio2(String checkbox_servicio2) {
        this.checkbox_servicio2 = checkbox_servicio2;
    }

    public String getCheckbox_servicio3() {
        return checkbox_servicio3;
    }

    public void setCheckbox_servicio3(String checkbox_servicio3) {
        this.checkbox_servicio3 = checkbox_servicio3;
    }
    
}
