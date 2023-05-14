/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.controladores;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Propiedad;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.PropiedadDTO;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Usuario;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.excepciones.MiException;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios.ImagenServicio;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios.PropiedadServicio;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    private ImagenServicio imagenServicio;
        
    @GetMapping("/dashboard")
    public String panelPropietario(HttpSession session, ModelMap modelo) {//HttpSession session, ModelMap modelo
        
        Usuario logeado=(Usuario) session.getAttribute("usuariosession");
        String palabraClave=logeado.getId();
        
        System.out.println(palabraClave);
        
        List<Propiedad> propiedades = propiedadServicio.listarPropiedades(palabraClave);        
        modelo.addAttribute("propiedades", propiedades);        
        
        return "perfilPropietario.html";
        
    }    
    
    @GetMapping("/logout")
    public String logout(){
        
        return "redirect:/carritoAlquiler";
        
    } 

    @PostMapping("/registroPropiedad")
    public String registroPropiedad(HttpSession session, @RequestParam(value = "file", required = false) MultipartFile[] archivos, @ModelAttribute PropiedadDTO propiedadDTO, ModelMap modelo) {

        try {
            
            propiedadServicio.registrarPropiedad(session, archivos, propiedadDTO);
            modelo.put("exito","PROPIEDAD registrada correctamente");

            return "perfilPropietario.html";
            
        } catch (MiException ex) {
            
            modelo.put("error", ex.getMessage());

            return "perfilPropietario.html";
            
        }
    }    
  
    /*
    @PreAuthorize("hasAnyRole('ROLE_PROPIETARIO'")
    @GetMapping("/perfil/{id}")
    public String actualizar(@PathVariable String id, ModelMap modelo){
        try{
            userPropietarioServicio.actualizar(id);
            modelo.put("exito","Usuario actualizado correctamente");
            
            return "inicio.html";
            
        }catch (Exception ex) {
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            
            return "usuario_modificar.html";
        }
    }*/
}
