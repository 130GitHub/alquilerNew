/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.repositorios;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.UserPropietario;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leo
 */
@Repository
public interface UserPropietarioRepositorio extends JpaRepository<UserPropietario, String> {
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario buscarPorEmail(@Param("email")String email);
}
