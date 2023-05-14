/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.controladores;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Imagen;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.UserPropietario;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios.ImagenServicio;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios.UserPropietarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Leo
 */
@Controller
@RequestMapping("/imagen")
public class ImagenControlador {
    @Autowired
    UserPropietarioServicio userPropietarioServicio;
    
    @Autowired
    ImagenServicio imagenServicio;
    
    @GetMapping("/perfil/{id}")
    public ResponseEntity<byte[]> imagenUsuario(@PathVariable String id){
        UserPropietario userPropietario=userPropietarioServicio.getOne(id);
        
        byte[] imagen=userPropietario.getImagen().getContendido();
        
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        
        return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
    }  
    
    @GetMapping("/propiedad/{id}")
    public ResponseEntity<byte[]> imagenPropiedad(@PathVariable String id){
        Imagen imagen=imagenServicio.getOne(id);
        
        byte[] imagenPropiedad=imagen.getContendido();
        
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        
        return new ResponseEntity<>(imagenPropiedad, headers, HttpStatus.OK);
    }     
    
}
