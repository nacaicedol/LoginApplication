/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;

/**
 *
 * @author usuario
 */
public class ValidarRegistro {

    private Sistema sistema = FramePrincipal.sistema;
    
    public ValidarRegistro() {
    }
 
    public boolean validarNombreRepetido(String nombre){
    for(Usuario u : sistema.getUsuarios()){
            if(u.getNombre().equals(nombre)){
                return false; // en caso de que el nombre este repetido    
            }
        }
    return true;
    }
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length() > 1 && nombre.length() <= 6);
    }
    public boolean verificarLongitudPassword (String password){
        return (password.length() >= 3 && password.length() < 6);
    }
    
    public boolean verificarContraseña(String password1,String password2){
        return(password1.equals(password2));
    }
    public String VerificarRegistro(Usuario usercach, String password2){
        if(!validarNombreRepetido(usercach.getNombre())){
            return("El nombre ya se encuentra ocupado");
        }
        if(!verificarLongitudNombre(usercach.getNombre())){
            return("No cumple con la Longitud del nombre el usuario"); 
        }
        if(!verificarLongitudPassword(usercach.getPassword())){
            return("No cumple con la longitud de la contraseña");
        }
        if(!verificarContraseña(usercach.getPassword(), password2)){
            return("Las contraseñas no son iguales");
        }
        return("Usuario registrado con exito");
    }
    public boolean ExitoRegistro(Usuario usercach, String password2){
        return(validarNombreRepetido(usercach.getNombre()) && verificarLongitudNombre(usercach.getNombre()) && verificarLongitudPassword(usercach.getPassword()) && verificarContraseña(usercach.getPassword(), password2));
    }
}
