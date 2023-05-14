/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Imagen;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.excepciones.MiException;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.repositorios.ImagenRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Leo
 */
@Service
public class ImagenServicio {

    @Autowired
    private ImagenRepositorio imagenRepositorio;

    public Imagen guardar(MultipartFile archivo) throws MiException {
        if (archivo != null) {
            try {              
                    Imagen imagen = new Imagen();                
                    
                    imagen.setMime(archivo.getContentType());
                    imagen.setNombre(archivo.getName());
                    imagen.setContendido(archivo.getBytes());

                    System.out.println("archivo no null");

                    return imagenRepositorio.save(imagen);            
                               
            } catch (Exception ex) {
                System.err.println(">>" + ex.getMessage());
            }
        } 

        return null;
    }
    
    /*public List<Imagen> listarImagenes(String palabraClave){
        List<Imagen> imagenes=new ArrayList();
        
        if (palabraClave != null) {
            imagenes = imagenRepositorio.findByPropiedad(palabraClave);
        } 

        return imagenes;
    }*/
    
     public Imagen getOne(String id){
        return imagenRepositorio.getOne(id);
    }  

    public Imagen actualizar(MultipartFile archivo, String IdImagen) throws MiException {
        if (archivo != null) {
            try {
                Imagen imagen = new Imagen();

                if (imagen.getId() != null) {
                    Optional<Imagen> respuesta = imagenRepositorio.findById(IdImagen);
                    if (respuesta.isPresent()) {
                        imagen = respuesta.get();
                    }
                }

                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContendido(archivo.getBytes());

                return imagenRepositorio.save(imagen);
            } catch (Exception ex) {
                System.err.println(">>" + ex.getMessage());
            }
        }

        return null;
    }
}
