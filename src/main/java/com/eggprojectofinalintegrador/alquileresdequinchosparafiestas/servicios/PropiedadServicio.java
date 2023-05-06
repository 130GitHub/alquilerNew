/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Imagen;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Propiedad;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.PropiedadDTO;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Servicio;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.UserPropietario;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.excepciones.MiException;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.repositorios.PropiedadRepositorio;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Leo
 */
@Service
public class PropiedadServicio {
    
    @Autowired
    private ImagenServicio imagenServicio;
    
    @Autowired
    private PropiedadRepositorio propiedadRepositorio;

    public void registrarPropiedad(HttpSession session, MultipartFile[] archivos, PropiedadDTO propiedadDTO) throws MiException {
        
        UserPropietario logueado=(UserPropietario) session.getAttribute("usuariosession");             
        
        Propiedad p = new Propiedad();
        /*USUARIO*/
        p.setTitulo(propiedadDTO.getTitulo());
        p.setUbicacion(propiedadDTO.getUbicacion());
        p.setPrecio(propiedadDTO.getPrecio());
        
        p.setUserPropietario(logueado);      
        
        /* Objetos de la clase Servicio*/
        Servicio s1=new Servicio();

        s1.setNombre(propiedadDTO.getCheckbox_servicio1());
        s1.setPrecio(propiedadDTO.getInput_precio1());

        Servicio s2=new Servicio();

        s2.setNombre(propiedadDTO.getCheckbox_servicio2());
        s2.setPrecio(propiedadDTO.getInput_precio2());

        Servicio s3=new Servicio();

        s3.setNombre(propiedadDTO.getCheckbox_servicio3());
        s3.setPrecio(propiedadDTO.getInput_precio3());

        /* Conjunto de objetos servicio */
        Set<Servicio> servicios = new HashSet();

        servicios.add(s1);
        servicios.add(s2);
        servicios.add(s3);       
        
        p.setServicios(servicios);
        
        //IMAGENES
        Set<Imagen> imagenes = new HashSet<>();
        for (int i = 0; i < archivos.length-1; i++){
            imagenes.add(imagenServicio.guardar(archivos[i]));
        }        
        
        p.setImagenes(imagenes);
        
        p.setAlta(true);
        
        propiedadRepositorio.save(p);
        
    }
       
}

