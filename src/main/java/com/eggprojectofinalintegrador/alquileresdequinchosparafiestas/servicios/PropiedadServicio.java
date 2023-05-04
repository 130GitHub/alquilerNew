/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Imagen;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Propiedad;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.PropiedadDTO;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.excepciones.MiException;
import java.util.HashSet;
import java.util.Set;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Leo
 */
public class PropiedadServicio {
    
       public void registrarPropiedad(MultipartFile[] archivos, PropiedadDTO propiedadDTO) throws MiException {
        
        Propiedad p = new Propiedad();
        /*USUARIO*/
        p.setTitulo(propiedadDTO.getTitulo());
        p.setUbicacion(propiedadDTO.getUbicacion());
        p.setPrecio(propiedadDTO.getPrecio());
        p.setPropietario("1");
        
        /*Set<Servicio> servicios = new HashSet();

        for (int i = 0; i < 3; i++){
            servicios.add(propiedadDTO);
        }
        
        p.setServicios(servicios);*/
        
        //IMAGENES
        if (archivos != null) {
            try{
                
                Set<Imagen> imagenes = new HashSet();

                for (int i = 0; i < archivos.length-1; i++){

                    Imagen imagen = new Imagen();

                    imagen.setMime(archivos[i].getContentType());
                    imagen.setNombre(archivos[i].getName());
                    imagen.setContendido(archivos[i].getBytes());

                    imagenes.add(imagen);

                }
                
                p.setImagenes(imagenes);
                
            }catch (Exception ex) {
                
                System.err.println(">>" + ex.getMessage());
                
            }
        }else{
            
            System.out.println("archivo null");
            
        }
    }
       
}

