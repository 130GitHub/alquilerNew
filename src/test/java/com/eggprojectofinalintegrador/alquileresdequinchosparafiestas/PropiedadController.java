/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Leo
 */
public class PropiedadController {
    
    public PropiedadController() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Servicio;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios.ServicioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/

/**
 *
 * @author Leo
 */

/*@RequestMapping("/servicio")
@RequiredArgsConstructor
@RestController
public class ServicioController {
    private final ServicioServicio servicioServicio;
    @GetMapping("/servicio/{idServicio}")
    public ResponseEntity<Servicio> getBookById(@PathVariable String idServicio) {
        return ResponseEntity.ok(servicioServicio.buscarPorId(idServicio));
    }

    @PostMapping("/servicio")
    public ResponseEntity<Servicio> saveBook(@RequestBody Servicio servicio) {
        Servicio save = servicioServicio.addServicio(servicio);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }*/
}
