/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.repositorios;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Propiedad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leo
 */
@Repository
public interface PropiedadRepositorio extends JpaRepository<Propiedad, String> { 
    @Query("SELECT p FROM Propiedad p WHERE p.userPropietario.id = :user_propietario_propietario")
    public List<Propiedad> buscarPorPropietario(@Param("user_propietario_propietario")String user_propietario_propietario);
    
}
