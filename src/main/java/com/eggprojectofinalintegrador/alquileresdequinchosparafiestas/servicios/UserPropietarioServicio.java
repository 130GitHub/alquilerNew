/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.servicios;

import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Imagen;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.UserPropietario;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.Usuario;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.entidades.UsuarioDTO;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.enumeraciones.Rol;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.excepciones.MiException;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.repositorios.UserPropietarioRepositorio;
import com.eggprojectofinalintegrador.alquileresdequinchosparafiestas.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Leo
 */
@Service
public class UserPropietarioServicio extends UsuarioServicio implements UserDetailsService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private UserPropietarioRepositorio userPropietarioRepositorio;

    @Autowired
    private ImagenServicio imagenServicio;
    
    @Transactional
    public void registrarUserPropietario(MultipartFile archivo, UsuarioDTO usuarioDTO) throws MiException{       
        
        validar(usuarioDTO.getPassword(), usuarioDTO.getPasswordR()); 
                
        UserPropietario uP=new UserPropietario();
        /*USUARIO*/
        uP.setApellido(usuarioDTO.getApellido());        
        uP.setNombre(usuarioDTO.getNombre());
        uP.setDni(usuarioDTO.getDni());
        uP.setEmail(usuarioDTO.getEmail());
        uP.setTelefono(usuarioDTO.getTelefono());
        uP.setPassword(new BCryptPasswordEncoder().encode(usuarioDTO.getPassword()));
        uP.setRol(Rol.PROPIETARIO);

        Imagen imagen=imagenServicio.guardar(archivo);
        uP.setImagen(imagen);

        uP.setAlta(true);
        /*PROPIETARIO*/
        uP.setCalificacion(0);        

        userPropietarioRepositorio.save(uP);         
        
    }   
    
    public UserPropietario getOne(String id){
        return userPropietarioRepositorio.getOne(id);
    }    
    
    private void validar(String password, String passwordR) throws MiException{         
        if(!password.equals(passwordR)){
            throw new MiException("Las contraseñas no son iguales");
        }
    }    

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
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
    }
}
