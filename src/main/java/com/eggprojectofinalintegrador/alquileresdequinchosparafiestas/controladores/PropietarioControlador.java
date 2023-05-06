/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.controladores;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.PropiedadDTO;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.excepciones.MiException;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios.PropiedadServicio;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Leo
 */
@Controller
@RequestMapping("/adminPropietario")
public class PropietarioControlador {

    @Autowired
    private PropiedadServicio propiedadServicio;
    
    @GetMapping("/dashboard")
    public String panelPropietario() {
        
        return "perfilPropietario.html";
        
    }

    @PostMapping(value = "/registroPropiedad")
    public String registroPropiedad(HttpSession session, @RequestParam(value = "archivo", required = false) MultipartFile[] archivos, @ModelAttribute PropiedadDTO propiedadDTO, ModelMap modelo) {

        try {
            
            propiedadServicio.registrarPropiedad(session, archivos, propiedadDTO);
            modelo.put("exito","PROPIEDAD registrada correctamente");

            return "perfilPropietario.html";
            
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());

            return "perfilPropietario.html";
            
        }
    }
}
