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
    return false;
    }
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length() > 1 && nombre.length() <= 6);
    }
    public boolean verificarLongitudPassword (String password){
        return (password.length() >= 3 && password.length() <= 6);
    }
    
    public boolean verificarContraseña(String password1,String password2){
        if(password1 == password2){
        return true;
        }else{
            return false;
        }
    }
}
