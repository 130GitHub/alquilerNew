/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Imagen;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Propiedad;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.PropiedadDTO;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Servicio;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.ServicioDTO;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.UserPropietario;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.excepciones.MiException;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.repositorios.PropiedadRepositorio;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
    private ServicioServicio servicioServicio;
    
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
        
        /* Inicio Conjunto de objetos servicio */
        Set<Servicio> servicios = new HashSet();
        
        /* Inicio Objetos de la clase Servicio*/        
        ServicioDTO s1=new ServicioDTO();

        s1.setNombre(propiedadDTO.getOpcion1());
        s1.setPrecio(propiedadDTO.getPrecio1()); 
        
        servicios.add(servicioServicio.addServicio(s1));  
        
        ServicioDTO s2=new ServicioDTO();

        s2.setNombre(propiedadDTO.getOpcion2());
        s2.setPrecio(propiedadDTO.getPrecio2());
        
        servicios.add(servicioServicio.addServicio(s2));

        ServicioDTO s3=new ServicioDTO();

        s3.setNombre(propiedadDTO.getOpcion3());
        s3.setPrecio(propiedadDTO.getPrecio3()); 
        
        servicios.add(servicioServicio.addServicio(s3));      
        /* Fin Objetos de la clase Servicio*/         
         
        /* Fin Conjunto de objetos servicio */        
        
        p.setServicios(servicios);
        
        //IMAGENES
        Set<Imagen> imagenes = new HashSet();       
                
        for (int i=0; i<archivos.length; i++){
            if (archivos[i] != null) {
                try{                    
                    Imagen imagen=imagenServicio.guardar(archivos[i]);
                    imagenes.add(imagen);
                    
                }catch (Exception ex) {
                    System.err.println(">>" + ex.getMessage());
                }
            }
        } 
        
        p.setImagenes(imagenes);
        
        p.setAlta(true);
        
        propiedadRepositorio.save(p);
        
    }
    
    public List<Propiedad> listarPropiedades(String palabraClave){
        List<Propiedad> propiedades=new ArrayList();
        
        if (palabraClave != null) {
            propiedades = propiedadRepositorio.buscarPorPropietario(palabraClave);
        }

        return propiedades;
    }
       
}

