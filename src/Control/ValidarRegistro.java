/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;

/**
 *
 * @author Cisco
 */
public class ValidarRegistro {
    
    public ValidarRegistro() {
    }
    
    public String verificar(Usuario usuario, String validarPassword) {
        if(!verificarLongitufNombre(usuario.getNombre())) {
            return("Longitud nombre incorrecta");
        }
        
        if(!verificarLongitudPassword(usuario.getPassword())) {
            return("Longitud contraseña incorrecta");
        }
        
        if(!equalPasswords(usuario.getPassword(), validarPassword)) {
            return("Las contraseñas no coinciden");
        }
        
        if(equalUsernames(usuario.getNombre())) {
            return("El nombre de usuario ya existe");
        }
        
        else return("Registro exitoso");
    }
    
    public boolean verificarLongitufNombre(String nombre) {
        return(nombre.length() > 1 && nombre.length() <= 6);
    }
    
    public boolean verificarLongitudPassword(String password) {
        return(password.length() >= 3 && password.length() < 6);
    }
    
    public boolean equalPasswords(String password1, String password2) {
        return(password1.equals(password2));
    }
    
    public boolean equalUsernames(String username) { //equalUsernames retorna true si el username ya se encuentra registrado y false si está disponible
        for(Usuario u : sistema.getUsuarios()) {
            if(username.equals(u.getNombre())) return true;
        }
        
        return false;
    }
}
