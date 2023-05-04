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
    private String propietario;
    private boolean checkbox1_servicio;
    private double input1_precio;
    private boolean checkbox2_servicio;
    private double input2_precio;
    private boolean checkbox3_servicio;
    private double input3_precio;

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

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public boolean isCheckbox1_servicio() {
        return checkbox1_servicio;
    }

    public void setCheckbox1_servicio(boolean checkbox1_servicio) {
        this.checkbox1_servicio = checkbox1_servicio;
    }

    public double getInput1_precio() {
        return input1_precio;
    }

    public void setInput1_precio(double input1_precio) {
        this.input1_precio = input1_precio;
    }

    public boolean isCheckbox2_servicio() {
        return checkbox2_servicio;
    }

    public void setCheckbox2_servicio(boolean checkbox2_servicio) {
        this.checkbox2_servicio = checkbox2_servicio;
    }

    public double getInput2_precio() {
        return input2_precio;
    }

    public void setInput2_precio(double input2_precio) {
        this.input2_precio = input2_precio;
    }

    public boolean isCheckbox3_servicio() {
        return checkbox3_servicio;
    }

    public void setCheckbox3_servicio(boolean checkbox3_servicio) {
        this.checkbox3_servicio = checkbox3_servicio;
    }

    public double getInput3_precio() {
        return input3_precio;
    }

    public void setInput3_precio(double input3_precio) {
        this.input3_precio = input3_precio;
    }
    
}
