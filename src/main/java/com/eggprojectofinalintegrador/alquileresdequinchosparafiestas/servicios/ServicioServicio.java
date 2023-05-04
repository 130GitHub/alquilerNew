/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.ServicioDTO;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Servicio;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.excepciones.MiException;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leo
 */
@Service
public class ServicioServicio {

    @Transactional
    public Servicio addServicio(ServicioDTO servicioDTO) throws MiException {
        
        Servicio servicio = new Servicio();

        servicio.setDisponible(servicioDTO.isDisponible());
        servicio.setNombre(servicioDTO.getNombre());
        servicio.setPrecio(servicioDTO.getPrecio());

        return servicio;

    }

}
