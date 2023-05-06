/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Imagen;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Usuario;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.UsuarioDTO;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.enumeraciones.Rol;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.excepciones.MiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Leo
 */
@Service
public class UsuarioServicio {//  implements UserDetailsService
    
    //@Autowired
    //private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    private ImagenServicio imagenServicio;

    /*
    public Usuario registrarUsuario(MultipartFile archivo,Rol rol, String apellido, String nombre, String dni, String email, String telefono, String descripcion, String password, String passwordR) throws MiException{
    */     

    //@Transactional 
    public Usuario registrarUsuario(MultipartFile archivo, UsuarioDTO usuarioDTO) throws MiException{
            
        //validar(apellido, nombre, email, telefono, password, passwordR);
        
        Usuario usuario=new Usuario();
        
            usuario.setRol(null);            
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setDni(usuarioDTO.getDni());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setTelefono(usuarioDTO.getTelefono());

            usuario.setPassword(new BCryptPasswordEncoder().encode(usuarioDTO.getPassword()));

            usuario.setRol(Rol.PROPIETARIO);

            Imagen imagen=imagenServicio.guardar(archivo);

            usuario.setImagen(imagen);

            usuario.setAlta(true);            
        
        //usuarioRepositorio.save(usuario);   
        return usuario;
    }

    /*
    private void validar(String apellido, String nombre, String email, String telefono, String password, String passwordR) throws MiException{
        if(apellido.isEmpty() || apellido==null){
            throw new MiException("El nombre no puede ser nulo o estar vacio");
        }        
        if(nombre.isEmpty() || nombre==null){
            throw new MiException("El nombre no puede ser nulo o estar vacio");
        }
        if(email.isEmpty() || email==null){
            throw new MiException("El email no puede ser nulo o estar vacio");
        }
        if(telefono.isEmpty() || telefono==null){
            throw new MiException("El telefono no puede ser nulo o estar vacio");
        }
        if(password.isEmpty() || password==null || password.length()<=5){
            throw new MiException("La contraseña no puede ser nulo o estar vacio");
        }       
        if(!password.equals(passwordR)){
            throw new MiException("Las contraseñas no son iguales");
        }
    }
    */

    /*@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        Usuario usuario=usuarioRepositorio.buscarPorEmail(email);
        
        if(usuario!=null){
            
            List<GrantedAuthority> permisos=new ArrayList<>();
            
            GrantedAuthority p=new SimpleGrantedAuthority("ROLE_"+usuario.getRol().toString());
            
            permisos.add(p);
            
            ServletRequestAttributes attr=(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            
            HttpSession sesion=attr.getRequest().getSession(true);
            
            sesion.setAttribute("usuariosession", usuario);
            
            User user=new User(usuario.getEmail(), usuario.getPassword(), permisos);
            
            return user;            
            
        }else{
            return null;
        }
    }*/    

}
