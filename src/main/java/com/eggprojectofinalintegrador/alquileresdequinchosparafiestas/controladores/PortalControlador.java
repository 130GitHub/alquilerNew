/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.controladores;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios.UsuarioServicio;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Usuario;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.UsuarioDTO;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.excepciones.MiException;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios.UserPropietarioServicio;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UserPropietarioServicio userPropietarioServicio;

//*********************************************

    @GetMapping("/")
    public String index(ModelMap modelo){
                        
        return "index.html";        
        
    }

    @GetMapping("/galeriaAlquiler")
    public String inicioGaleria(ModelMap modelo){
        
        return "galeriaAlquiler.html";
        
    }

    @GetMapping("/carritoAlquiler")
    public String inicioApp(ModelMap modelo){
        
        return "carritoAlquiler.html";
    }

    @GetMapping("/registrarPropietario")
    public String registrar(){//la vista que vamos a renderizar
        
        return "registroPropietario.html";//formulario para registro
        
    }

    @PostMapping(value="/registroPropietario")            
    public String registroPropietario(@RequestParam(value = "archivo",required = false) MultipartFile archivo, @ModelAttribute UsuarioDTO usuarioDTO, ModelMap modelo) {
        
        try{            
            userPropietarioServicio.registrarUserPropietario(archivo, usuarioDTO);
            modelo.put("exito","Usuario registrado correctamente");
            
            return "index.html";
            
        }catch(MiException ex){
            
            modelo.put("error", ex.getMessage());
            
            return "registroPropietario.html";
            
        }
    } 

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo){
        
        if(error!=null){
            modelo.put("error", "Usuario o Contraseña invalidos!");
        }
        
        return "iniciarSesion.html";
        
    }      

    @PreAuthorize("hasAnyRole('ROLE_CLIENTE','ROLE_ADMIN','ROLE_PROPIETARIO')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session, ModelMap modelo){
        
        Usuario logeado=(Usuario) session.getAttribute("usuariosession");
        
        if(logeado.getRol().toString().equals("ADMIN")){
            
            return "redirect:/admin/dashboard";
            
        }else if(logeado.getRol().toString().equals("PROPIETARIO")){

            return "redirect:/adminPropietario/dashboard";

        }else{
            return "galeriaAlquiler.html";
        }
        
    }      
    
}
